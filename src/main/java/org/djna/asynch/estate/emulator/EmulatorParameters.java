package org.djna.asynch.estate.emulator;

public class EmulatorParameters {
	private String property;
	private String location;
	private int frequency;

	public EmulatorParameters() {
		property = System.getenv("PROPERTY");
		location = System.getenv("LOCATION");
		try {
			frequency = Integer.parseInt(System.getenv("FREQUENCY"));
		}
		catch (Exception e) {
			frequency = 10;
		}
	}

	public String getProperty() {
		return property;
	}

	public String getLocation() {
		return location;
	}

	public int getFrequency() {
		return frequency;
	}
}
