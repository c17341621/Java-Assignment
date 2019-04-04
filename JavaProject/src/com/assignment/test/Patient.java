package com.assignment.test;

public class Patient 
{
	private String patientName;
	private String temperature;
	private String aches;
	private String soreThroat;
	
	public Patient(String pName, String pTemp, String pAches, String pSoreThroat)
	{
		setPatientName(pName);
		setTemperature(pTemp);
		setAches(pAches);
		setSoreThroat(pSoreThroat);
	}
	
	public String toString()
	{
		String summary;
		summary = ("Name: " + getPatientName() + "\nTemperature: " + getTemperature() + "\nAches: " + getAches()+ "\nSore Throat: " + getSoreThroat());
		return summary;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getAches() {
		return aches;
	}

	public void setAches(String aches) {
		this.aches = aches;
	}

	public String getSoreThroat() {
		return soreThroat;
	}

	public void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}
}