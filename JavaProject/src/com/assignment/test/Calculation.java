package com.assignment.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculation 
{
	public String naiveBayesProb(Patient p1)
	{
		FileProcessor fp = new FileProcessor();
		DecimalFormat df = new DecimalFormat("#.########");
		String fName = "src\\trainingData.csv";
		int numLines = fp.countLines(fName);
		System.out.println(numLines);
		int yesCount = fp.countCol(fName, 3, "yes");//number of times yes appeared in final column
		int noCount = numLines - yesCount;
		System.out.println(yesCount);
		double pYes = (float)yesCount/numLines;//probability of yes
		double pNo = 1 - pYes;//probability of no
		double tonYes;
		double tonNo;
		String sTonYes;
		String sTonNo;
		
		System.out.println(pYes);
		System.out.println(pNo);
		
		
		double tempYes;
		double tempNo;
		
		double achesYes;
		double achesNo;
		
		double stYes;
		double stNo;
		
		double temp = fp.countCol(fName, 0, p1.getTemperature());
		double aches = fp.countCol(fName, 1, p1.getAches());
		double st = fp.countCol(fName, 2, p1.getSoreThroat());
		
		
		//number of times each of the patient's entries have appeared along side Yes in the tonilitis column 
		tempYes = (double)fp.countColYes(fName, 0, p1.getTemperature(), "yes") / (double)yesCount;
		tempNo = (double)fp.countColYes(fName, 0, p1.getTemperature(), "no") / (double)noCount;
		
		achesYes = (double)fp.countColYes(fName, 1, p1.getAches(), "yes") / (double)yesCount;;
		achesNo = (double)fp.countColYes(fName, 1, p1.getAches(), "no") / (double)noCount;;
		
		stYes =(double) fp.countColYes(fName, 2, p1.getSoreThroat(), "yes") / (double)yesCount;;
		stNo = (double)fp.countColYes(fName, 2, p1.getSoreThroat(), "no") / (double)noCount;;
		
		tonYes = ((double)((tempYes * achesYes * stYes) * (pYes)));
		tonNo = ((double)(tempNo * achesNo * stNo) * pNo);
		
		//need amount of times each outcome occurs while there is tonsilitis ie. cool -> tonsilitis, normal -> tonsilitis
		
		System.out.println(tonYes);
		System.out.println(tonNo);
		System.out.println (temp * aches * st);
		tonYes = tonYes / (temp * aches * st);
		tonNo = tonNo / (temp * aches * st);
		
		sTonYes = df.format(tonYes);
		sTonNo = df.format(tonNo);
		
		System.out.println(tonYes);
		System.out.println(tonNo);
		if(tonYes > tonNo)
		{
			return sTonYes;
		}
		else
		{
			return sTonNo;
		}
	}
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
