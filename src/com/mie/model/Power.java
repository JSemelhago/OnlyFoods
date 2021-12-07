package com.mie.model;

public class Power extends Part {
	
/*
 * This stores and provides access to attributes of each part entry
 */
	
	//Attributes
	private int powerId;
	private String name;
	private String series;
	private String form;
	private String efficiency;
	private int watts;
	private String modular;
	private float price;
	private String manufacturer;
	private int fanless;
	
	//Setters and getters
	public int getPowerId() {
		return powerId;
	}

	public void setPowerId(int powerId) {
		this.powerId = powerId;
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
	
	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
	
	public String getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(String efficiency) {
		this.efficiency = efficiency;
	}
	
	public int getWatts() {
		return watts;
	}

	public void setWatts(int watts) {
		this.watts = watts;
	}
	
	public String getModular() {
		return modular;
	}

	public void setModular(String modular) {
		this.modular = modular;
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