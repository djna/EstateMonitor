package org.djna.asynch.estate.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ThermostatReading {

    @JsonProperty("date")
    private Date received;

    @JsonProperty("temperature")
    private Integer temperature;

    @JsonProperty("location")
    private String location;

    public ThermostatReading() {

    }

    public Date getReceived() {
        return received;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }
}
