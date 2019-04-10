package com.assignment.test;

public class Patient 
{
	
	private String temperature;
	private String aches;
	private String soreThroat;
	private String tonsillitis;
	
	public Patient(String pTemp, String pAches, String pSoreThroat)
	{
		
		setTemperature(pTemp);
		setAches(pAches);
		setSoreThroat(pSoreThroat);
	}
	
	public Patient(String pTemp, String pAches, String pSoreThroat, String pTonsillitis)
	{
		
		setTemperature(pTemp);
		setAches(pAches);
		setSoreThroat(pSoreThroat);
		setTonsillitis(pTonsillitis);
	}
	
	
	public String toString()
	{
		String summary;
		summary = ("Temperature: " + getTemperature() + "\nAches: " + getAches()+ "\nSore Throat: " + getSoreThroat());
		return summary;
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

	public String getTonsillitis() {
		return tonsillitis;
	}

	public void setTonsillitis(String tonsillitis) {
		this.tonsillitis = tonsillitis;
	}
}