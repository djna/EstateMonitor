package org.djna.asynch.estate.webapp;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.StreamPrintService;
import java.util.Collections;

@SpringBootApplication
public class HomeMonitorApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HomeMonitorApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8085"));
		System.setProperty("server.servlet.context-path", "/api/");
		//app.setDefaultProperties(Collections.singletonMap("logging.level.root", "DEBUG"));
		app.run(args);
	}

}
