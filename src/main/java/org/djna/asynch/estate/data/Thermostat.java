package org.djna.asynch.estate.data;

public class Thermostat {

    private final String location;

    private Integer temperature;

    public Thermostat(String initLocation) {
        location = initLocation;
        temperature = 0;
    }

    public String getLocation() {
        return location;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

}
