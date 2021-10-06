package org.djna.asynch.estate.data;

public class House {

    private int houseNumber;
    private int temperature;

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getTemperature() {
        return temperature;
    }

    public House(int initHouseNumber, int initTemperature){
        houseNumber = initHouseNumber;
        temperature = initTemperature;

    }

    @Override
    public String toString() {
        return "House{" +
                "houseNumber=" + houseNumber +
                ", temperature=" + temperature +
                '}';
    }
}
