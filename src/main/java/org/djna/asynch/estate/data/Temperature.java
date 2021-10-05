package org.djna.asynch.estate.data;

import java.util.ArrayList;

public class Temperature {
    ArrayList<String> thermostatReadings = new ArrayList<>();


    public static void main(String[] args) {

        ArrayList<String> thermostatReadings= new ArrayList<>();
        thermostatReadings.add("1");
        thermostatReadings.add("10");
        thermostatReadings.add("10");
        thermostatReadings.add("10");
        thermostatReadings.add("10");
        thermostatReadings.add("10");
        thermostatReadings.add("30");
        thermostatReadings.add("No_Reading");

    }

    public ArrayList<String> getThermostatReadings() {
        return thermostatReadings;
    }

    public void setThermostatReadings(ArrayList<String> thermostatReadings) {
        this.thermostatReadings = thermostatReadings;
    }

    @Override
    public String toString() {
        return "ThermostatArrayList{" +
                "thermostatReadings=" + thermostatReadings +
                '}';
    }


}



