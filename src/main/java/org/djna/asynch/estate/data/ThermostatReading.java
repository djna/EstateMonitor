package org.djna.asynch.estate.data;

import java.util.ArrayList;
import java.util.Date;

public class ThermostatReading {
    // add data such temperature here
    // "date":1633362327823,"temperature":17,"location":"hall"
    String property;
    Date date;
    int temperature;
    String location;

    public ThermostatReading(String property, Date date, int temperature, String location) {
        this.property = property;
        this.date = date;
        this.temperature = temperature;
        this.location = location;
    }

    public String getProperty() {
        return property;
    }

    public Date getDate() {
        return date;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "ThermostatReading{" +
                "property='" + property + '\'' +
                ", date='" + date + '\'' +
                ", temperature=" + temperature +
                ", location='" + location + '\'' +
                '}';
    }
}
