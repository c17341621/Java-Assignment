package com.assignment.test;

public class Patient 
{
	private String patientName;
	private String temperature;
	private String aches;
	private String soreThroat;
	
	public Patient(String pName, String pTemp, String pAches, String pSoreThroat)
	{
		patientName = pName;
		temperature = pTemp;
		aches = pAches;
		soreThroat = pSoreThroat;
	}
	
	public String toString()
	{
		String summary;
		summary = ("Name: " + patientName + "\nTemperature: " + temperature + "\nAches: " + aches+ "\nSore Throat: " + soreThroat);
		return summary;
	}
}