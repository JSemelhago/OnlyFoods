package com.mie.model;

public class Graphics extends Part {
	
/*
 * This stores and provides access to attributes of each part entry
 */
	
	//Attributes
	private int graphicsId;
	private String name;
	private String series;
	private String chipset;
	private String memoryGB;
	private String clockGhz;
	private float price;
	private String manufacturer;
	private int fanless;

	//Setters and getters
	public int getGraphicsId() {
		return graphicsId;
	}

	public void setGraphicsId(int graphicsId) {
		this.graphicsId = graphicsId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}
	
	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	
	public String getMemoryGB() {
		return memoryGB;
	}

	public void setMemoryGB(String memoryGB ) {
		this.memoryGB = memoryGB;
	}
	
	public String getClockGhz() {
		return clockGhz;
	}

	public void setClockGhz(String clockGhz ) {
		this.clockGhz = clockGhz;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getFanless() {
		return fanless;
	}

	public void setFanless(int fanless) {
		this.fanless = fanless;
	}
	
	/*
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + "]";
	}
	*/
}