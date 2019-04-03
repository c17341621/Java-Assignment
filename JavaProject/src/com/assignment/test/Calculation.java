package com.assignment.test;

public class Calculation 
{
	public float naiveBayesProb()
	{
		FileProcessor fp = new FileProcessor();
		String fName = "src\\trainingData.csv";
		int numLines = fp.countLines(fName);
		int yesCount = fp.countCol("yes", 3, "src\\trainingData.csv");
		float pYes = (float)yesCount/numLines;
		float pNo = 1 - pYes;
		
		//need amount of times each outcome occurs while there is tonsilitis
	}
}
