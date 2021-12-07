package com.mie.model;

public class Memory extends Part {
	
/*
 * This stores and provides access to attributes of each part entry
 */
	
	//Attributes
	private int memoryId;
	private String name;
	private String speed;
	private String type;
	private int cas;
	private String modules;
	private int sizeGB;
	private float price;
	private String manufacturer;
	private int heatSpreader;

	//Setters and getters
	public int getMemoryId() {
		return memoryId;
	}

	public void setMemoryId(int memoryId ) {
		this.memoryId = memoryId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getCas() {
		return cas;
	}

	public void setCas(int cas ) {
		this.cas = cas;
	}
	
	public String getModules() {
		return modules;
	}

	public void setModules(String modules) {
		this.modules = modules;
	}
	
	public int getSizeGB() {
		return sizeGB;
	}

	public void setSizeGB(int sizeGB) {
		this.sizeGB = sizeGB;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price ) {
		this.price = price;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getHeatSpreader() {
		return heatSpreader;
	}

	public void setHeatSpreader(int heatSpreader) {
		this.heatSpreader = heatSpreader;
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