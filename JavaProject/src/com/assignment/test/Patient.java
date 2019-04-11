package com.assignment.test;
/*
 * A Patient class
 * Author: Stephen Healy
 * 
 * 
 */


public class Patient 
{
	//attributes
	private String temperature;
	private String aches;
	private String soreThroat;
	private String tonsillitis;
	
	//constructors
	
	//used when user inputs symptoms
	public Patient(String pTemp, String pAches, String pSoreThroat)
	{
		
		setTemperature(pTemp);
		setAches(pAches);
		setSoreThroat(pSoreThroat);
	}
	
	//used when reading data from file
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

	
	//setters and getters
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