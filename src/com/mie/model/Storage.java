package com.mie.model;

public class Storage extends Part {
	
/*
 * This stores and provides access to attributes of each part entry
 */
	
	//Attributes
	private int storageId;
	private String name;
	private String series;
	private String form;
	private String type;
	private String capacity;
	private String cache;
	private float price;
	private String manufacturer;
	
	//Setters and getters
	public int getStorageId() {
		return storageId;
	}

	public void setStorageId(int storageId) {
		this.storageId = storageId;
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
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