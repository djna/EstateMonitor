package org.djna.asynch.estate.data;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private String address;
    private List<Thermostat> thermostats = new ArrayList<>();

    public Property(String initAddress) {
        address = initAddress;
    }

    public String getAddress() {
        return address;
    }

    public List<Thermostat> getThermostats() {
        return thermostats;
    }

    public void addThermostat(Thermostat t) {
        thermostats.add(t);
    }

}
