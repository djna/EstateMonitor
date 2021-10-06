package org.djna.asynch.estate.webapp;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.tomcat.util.json.JSONParser;
import org.djna.asynch.estate.data.Property;
import org.djna.asynch.estate.data.Thermostat;
import org.djna.asynch.estate.data.ThermostatReading;
import org.djna.asynch.estate.data.User;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.StreamPrintService;
import java.util.Collections;
import javax.jms.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HomeMonitorApplication {

	public static List<User> userList;

	public static void main(String[] args) {
		userList = new ArrayList<>();
		User testUser = new User("test", "password");
		Property prop1 = new Property("101");
		prop1.addThermostat(new Thermostat("Hall"));
		testUser.addProperty(prop1);
		Property prop2 = new Property("42");
		prop2.addThermostat(new Thermostat("Entrance"));
		testUser.addProperty(prop2);
		userList.add(testUser);

		SpringApplication app = new SpringApplication(HomeMonitorApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8085"));
		System.setProperty("server.servlet.context-path", "/api/");
		//app.setDefaultProperties(Collections.singletonMap("logging.level.root", "DEBUG"));
		app.run(args);

		thread(new GetProperties(), false);

	}

	public static void thread(Runnable runnable, boolean daemon) {
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}

	private static class GetProperties implements Runnable, ExceptionListener {
		public boolean stopping = false;
		public void run() {

			List<String> destinations = new ArrayList<>();

			try {
				ActiveMQConnectionFactory connectionFactory
						= new ActiveMQConnectionFactory("tcp://activemq:61616");
				Connection connection = connectionFactory.createConnection();
				connection.setClientID("EstateMonitor");
				connection.start();
				connection.setExceptionListener(this);
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				// subscribe to all thermostats
				Topic destination = session.createTopic("home.thermostats.>");
				MessageConsumer consumer = session.createDurableSubscriber(destination, "Thermostats");
				ObjectMapper mapper = new ObjectMapper();

				System.out.println("Subscribed: " + destination);

				while ( ! stopping ) {

					Message message = consumer.receive(120 * 1000);
					ObjectMapper m = new ObjectMapper();

					// expecting only Text Message
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						String text = textMessage.getText();
						ThermostatReading r = m.readValue(text, ThermostatReading.class);
						System.out.println("Received: " + text);
						ThermostatReading current = r;
						// Add business logic here

					} else {
						// but handle the unexpected
						System.out.println("Received: " + message);
					}

				}

				consumer.close();
				session.close();
				connection.close();
			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}

		public synchronized void onException(JMSException ex) {
			System.out.println("JMS Exception occured.  Shutting down client.");
		}
	}

}
