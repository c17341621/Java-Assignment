package com.assignment.test;

public class Calculation 
{
	public float naiveBayesProb(Patient p1)
	{
		FileProcessor fp = new FileProcessor();
		
		String fName = "src\\trainingData.csv";
		int numLines = fp.countLines(fName);
		System.out.println(numLines);
		int yesCount = fp.countCol(fName, 3, "yes");
		System.out.println(yesCount);
		float pYes = (float)yesCount/numLines;
		float pNo = 1 - pYes;
		
		int tempYes;
		
		int achesYes;
		
		int stYes;
		//number of times each of the patient's entries have appeared along side Yes in the tonilitis column 
		tempYes = fp.countColYes(fName, 0, p1.getTemperature());
		
		achesYes = fp.countColYes(fName, 1, p1.getAches());
		
		stYes = fp.countColYes(fName, 2, p1.getSoreThroat());
		
		
		System.out.println(stYes);
		//need amount of times each outcome occurs while there is tonsilitis ie. cool -> tonsilitis, normal -> tonsilitis
		return 1;
	}
}
