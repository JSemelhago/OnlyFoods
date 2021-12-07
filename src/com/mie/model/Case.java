package com.mie.model;

public class Case extends Part {
	
/*
 * This stores and provides access to attributes of each part entry
 */
	
	//Attributes
	private int caseId;
	private String name;
	private String type;
	private int extFiveQuarter;
	private int intThreeHalf;
	private String powerSupply;
	private float price;
	private String manufacturer;
	private int sidePanelWindow;
	private int frontPanelUsb3;

	//Setters and getters
	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getExtFiveQuarter() {
		return extFiveQuarter;
	}

	public void setExtFiveQuarter(int extFiveQuarter) {
		this.extFiveQuarter = extFiveQuarter;
	}
	
	public int getIntThreeHalf() {
		return intThreeHalf;
	}

	public void setIntThreeHalf(int intThreeHalf ) {
		this.intThreeHalf = intThreeHalf;
	}
	
	public String getPowerSupply() {
		return powerSupply;
	}

	public void setPowerSupply(String powerSupply) {
		this.powerSupply = powerSupply;
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
	
	public int getSidePanelWindow() {
		return sidePanelWindow;
	}

	public void setSidePanelWindow(int sidePanelWindow ) {
		this.sidePanelWindow = sidePanelWindow;
	}
	
	public int getFrontPanelUsb3() {
		return frontPanelUsb3;
	}

	public void setFrontPanelUsb3(int frontPanelUsb3) {
		this.frontPanelUsb3 = frontPanelUsb3;
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