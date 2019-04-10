package com.assignment.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
		//System.out.println(probTonYes);
		//patient symptoms
		String patientTemp = p1.getTemperature();
		String patientAches = p1.getAches();
		String patientSoreThroat = p1.getSoreThroat();
		//need probability of each symptom while tonsilitis occurs
		float probTemp =(float)fp.countColYes(fName, 0, patientTemp, "yes")/tonYes; 
		//System.out.println("temp:"+probTemp);
		float probAches =(float) fp.countColYes(fName, 1, patientAches, "yes") / tonYes; 
		//System.out.println("Aches:"+probAches);
		float probSoreThroat =(float) fp.countColYes(fName, 2, patientSoreThroat, "yes") / tonYes; 
		//System.out.println("ST:"+probSoreThroat);
		//need probability of each symptom while tonsilitis does not occur
		float noProbTemp =(float)fp.countColYes(fName, 0, patientTemp, "no")/tonNo; 
		float noProbAches =(float) fp.countColYes(fName, 1, patientAches, "no") / tonNo; 
		float noProbSoreThroat =(float) fp.countColYes(fName, 2, patientSoreThroat, "no") / tonNo; 
		
		
		
		float yesSide = probTemp * probAches * probSoreThroat * probTonYes;
		
		float noSide = noProbTemp * noProbAches * noProbSoreThroat * probTonNo;
		
		float sumSide = yesSide + noSide;
		//System.out.println(yesSide);
		//System.out.println(noSide);
		float finYes = yesSide/sumSide;
		float finNo = noSide/sumSide;
		
		
		
		float percent = finYes * 100;
		return percent;
	}
	
	//passes in 2 strings which are paths to files, 1 for training data, the other for data to be used to test the training data. returns the accuracy of the training data as a percent
	//An estimation is assumed to be correct if it returns above 50% when outcome is yes or below or equal to 50% when outcome is no
	public float testData(String training, String testing)
	{
		ArrayList<Patient> testPatients;
		FileProcessor fp = new FileProcessor();
		testPatients = fp.rowsToPatients(testing);
		int score = 0;
		
		for(int i = 0; i < testPatients.size(); i++)
		{
			//System.out.println(( testPatients.get(i).getTonsillitis().equals("yes") && (naiveBayesProb(testPatients.get(i)) > 50.0)  ));
			//System.out.println(testPatients.get(i).getTonsillitis().equals("no") && (naiveBayesProb(testPatients.get(i)) <= 50));
			//System.out.println( (testPatients.get(i).getTonsillitis().equals("yes") && (naiveBayesProb(testPatients.get(i)) > 50.0)  )  || (testPatients.get(i).getTonsillitis().equals("no") && (naiveBayesProb(testPatients.get(i)) <= 50)));
			
			if(testPatients.get(i).getTonsillitis().equals("yes"))
			{
				if(naiveBayesProb(testPatients.get(i)) > 50.0)
				{
					System.out.println(testPatients.get(i));
					//System.out.println(naiveBayesProb(testPatients.get(i)));
					//System.out.println(testPatients.get(i).getTonsillitis());
					//System.out.println(naiveBayesProb(testPatients.get(i)) <= 50.0);
					System.out.println("\n");
					score++;
				}
			}
			else if(testPatients.get(i).getTonsillitis().equals("no"))
			{
				if(naiveBayesProb(testPatients.get(i)) <= 50.0)
				{
					System.out.println(testPatients.get(i));
					//System.out.println(naiveBayesProb(testPatients.get(i)));
					//System.out.println(testPatients.get(i).getTonsillitis());
					//System.out.println(naiveBayesProb(testPatients.get(i)) <= 50.0);
					System.out.println("\n");
					score++;
				}
			}
		}
		System.out.println("score:"+score);
		return (float)score/testPatients.size()*100;
	}
}
