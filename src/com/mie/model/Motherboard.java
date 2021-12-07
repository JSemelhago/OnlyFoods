package com.mie.model;

public class Motherboard {
	
/*
 * This stores and provides access to attributes of each part entry
 */
	
	//Attributes
	private int motherboardId;
	private String name;
	private String cpuSocketType;
	private String form;
	private int ramSlots;
	private int maxRam;
	private float price;
	private String manufacturer;
	
	//Setters and getters
	public int getMotherboardId() {
		return motherboardId;
	}

	public void setMotherboardId(int motherboardId) {
		this.motherboardId = motherboardId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpuSocketType() {
		return cpuSocketType;
	}

	public void setCpuSocketType(String cpuSocketType) {
		this. cpuSocketType = cpuSocketType;
	}
	
	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
	
	public int getRamSlots() {
		return ramSlots;
	}

	public void setRamSlots(int ramSlots ) {
		this.ramSlots = ramSlots;
	}
	
	public int getMaxRam() {
		return maxRam;
	}

	public void setMaxRam(int maxRam) {
		this.maxRam = maxRam;
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

	
	/*
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + "]";
	}
	*/
}