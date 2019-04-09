package com.assignment.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculation 
{
	public float naiveBayesProb(Patient p1)
	{
		
		//training data path
		String fName = "src\\trainingData.csv";
		FileProcessor fp = new FileProcessor(); 
		//total number of lines
		int rows = fp.countLines(fName);
		//total number of yes in final column
		int tonYes = fp.countCol(fName, 3, "yes");
		int tonNo = fp.countCol(fName, 3, "no");
		//overall probabilities of each outcome for tonsilitis
		float probTonYes = (float)tonYes/rows;
		float probTonNo = (float)tonNo/rows;
		System.out.println(probTonYes);
		//patient symptoms
		String patientTemp = p1.getTemperature();
		String patientAches = p1.getAches();
		String patientSoreThroat = p1.getSoreThroat();
		//need probability of each symptom while tonsilitis occurs
		float probTemp =(float)fp.countColYes(fName, 0, patientTemp, "yes")/tonYes; 
		System.out.println("temp:"+probTemp);
		float probAches =(float) fp.countColYes(fName, 1, patientAches, "yes") / tonYes; 
		System.out.println("Aches:"+probAches);
		float probSoreThroat =(float) fp.countColYes(fName, 2, patientSoreThroat, "yes") / tonYes; 
		System.out.println("ST:"+probSoreThroat);
		//need probability of each symptom while tonsilitis does not occur
		float noProbTemp =(float)fp.countColYes(fName, 0, patientTemp, "no")/tonNo; 
		float noProbAches =(float) fp.countColYes(fName, 1, patientAches, "no") / tonNo; 
		float noProbSoreThroat =(float) fp.countColYes(fName, 2, patientSoreThroat, "no") / tonNo; 
		
		
		
		float yesSide = probTemp * probAches * probSoreThroat * probTonYes;
		
		float noSide = noProbTemp * noProbAches * noProbSoreThroat * probTonNo;
		
		float sumSide = yesSide + noSide;
		System.out.println(yesSide);
		System.out.println(noSide);
		float finYes = yesSide/sumSide;
		float finNo = noSide/sumSide;
		
		
		
		float percent = finYes * 100;
		return percent;
	}
	private static double round(double value, int places) //taken from https://www.baeldung.com/java-round-decimal-number
	{
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.floatValue();
	}
}
