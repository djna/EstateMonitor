package org.djna.asynch.estate.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Thermostat {

    private final String location;
    private Date lastUpdated;
    private Integer currentTemperature;
    private List<ThermostatReading> readingHistory = new LinkedList<>();

    public Thermostat(String initLocation) {
        location = initLocation;
        currentTemperature = 0;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date time) {
        this.lastUpdated = time;
    }

    public String getLocation() {
        return location;
    }

    public Integer getTemperature() {
        return currentTemperature;
    }

    public void setTemperature(ThermostatReading t) {

        this.currentTemperature = t.getTemperature();
        readingHistory.add(t);

    }

}
