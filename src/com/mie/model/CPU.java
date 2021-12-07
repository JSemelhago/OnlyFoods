package com.mie.model;

public class CPU extends Part {
	
/*
 * This stores and provides access to attributes of each part entry
 */
	
	//Attributes
	private int cpuid;
	private String cPUName;
	private float speed;
	private int cores;
	private float price;
	private float rating;
	private String manufacturer;
	private String series;
	private int simultanueousMultithreading;
	private int supportsECC;

	//Setters and getters
	public int getCpuid() {
		return cpuid;
	}

	public void setCPUid(int cpuid) {
		this.cpuid = cpuid;
	}

	public String getCPUName() {
		return cPUName;
	}

	public void setCPUName(String cPUName) {
		this.cPUName = cPUName;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}
	
	public int getSimultanueousMultithreading() {
		return simultanueousMultithreading;
	}

	public void setSimultanueousMultithreading(int simultanueousMultithreading) {
		this.simultanueousMultithreading = simultanueousMultithreading;
	}
	
	public int getSupportsECC() {
		return supportsECC;
	}

	public void setSupportsECC (int supportsECC) {
		this.supportsECC = supportsECC;
	}
	
	
	@Override
	public String toString() {
		return "CPU" + cPUName;
	}
	
}