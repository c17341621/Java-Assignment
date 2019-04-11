package com.assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * A class for reading and manipulating the data in the csv file "trainingData.csv"
 */

public class FileProcessor 
{
	
	
	
	
	public FileProcessor()
	{
		
	}
	
	//passes a string and checks returns whether that file exists or not
	public boolean fileExists(String fileName)
	{
		File f1 = new File(fileName);
		Scanner fileScanner;
		try
		{
			fileScanner = new Scanner(f1);
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Training data not found");
			return false;
		}
		
		
			
			System.out.println("Training data found");
			fileScanner.close();
			return true;
		
	}
	
	//prints the contents of a file
	public void printAll(String fileName)
	{
		File f1 = new File(fileName);
		Scanner fileScanner;
		String line;
		Scanner lineScanner;
		try
		{
			fileScanner = new Scanner(f1);
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Training data not found");
			return;
		}
		
			while(fileScanner.hasNext())
			{
				System.out.println(fileScanner.next());
			}
			
			System.out.println("Training data found");
			fileScanner.close();
			
	}
	
	//prints a single column of a file
	public void printCol(String fileName)
	{
		File f1 = new File(fileName);
		Scanner fileScanner;
		String line;
		Scanner lineScanner;
		try
		{
			fileScanner = new Scanner(f1);
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Training data not found");
			return;
		}
		
			while(fileScanner.hasNextLine())
			{
				line = fileScanner.nextLine();
				lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");
				System.out.println(lineScanner.next());
				
			}
			
			System.out.println("Training data found");
			fileScanner.close();
			
	}
	
	
	//passes a column number and string and returns the number of times that string appears in the given column
	public int countCol(String fileName, int column, String value)
	{
		File f1 = new File(fileName);
		Scanner fileScanner;
		String line;
		Scanner lineScanner;
		int counter = 0;
		String colValue;
		
		try
		{
			fileScanner = new Scanner(f1);
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Training data not found");
			return 0;
		}
		
		while(fileScanner.hasNextLine())
		{
			line = fileScanner.nextLine();
			lineScanner = new Scanner(line);
			lineScanner.useDelimiter(",");
			for(int i = 0; i < column; i++)
			{
				lineScanner.next();
				//System.out.println(i);
			}
			colValue = lineScanner.next();
			
			if(colValue.equals(value))
			{
				counter++;
				
				
			}
		}
		fileScanner.close();
		return counter;
	}
	
	//returns the number of lines in a file
	public int countLines(String fileName)
	{
		File f1 = new File(fileName);
		Scanner fileScanner;
		
		int counter = 0;
		
		
		try
		{
			fileScanner = new Scanner(f1);
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Training data not found");
			return 0;
		}
		
		while(fileScanner.hasNextLine())
		{	
			counter++;
			
			fileScanner.nextLine();
		}
		fileScanner.close();
		return counter;
	}
	
	//returns the number of times a value occurs in a given column while the last column in the same row is "yes"
	public int countColYes(String fileName, int column, String value, String yesOrNo)
	{
		boolean hasValue;//used to tell us if a specific value has appeared
		int colCounter;
		File f1 = new File(fileName);
		Scanner fileScanner;
		String line;
		Scanner lineScanner;
		int counter;
		String colValue = "";
		
		counter = 0;
		
		
		
		try
		{
			fileScanner = new Scanner(f1);
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Training data not found");
			return 0;
		}
		
		while(fileScanner.hasNextLine())
		{
			colCounter = 0;
			hasValue = false;
			line = fileScanner.nextLine();
			lineScanner = new Scanner(line);
			lineScanner.useDelimiter(",");
			
			
			while(lineScanner.hasNext())
			{
				colValue = lineScanner.next();
				if(colCounter == column)//checks to see if we are looking at correct column
				{
					//System.out.println("colCounter: " + colCounter);
					if(value.equals(colValue))
					{
						hasValue = true;//this is set to true if the correct value is in this row
						
					}
				}
				//System.out.println(colValue);
				colCounter++;
			}
			//System.out.println(colValue);
			if((hasValue == true) && colValue.equals(yesOrNo))//increments counter if value exists in correct place and last value in column is "yes"
			{
				counter++;
				
				
			}
			//fileScanner.nextLine();
			
		}
		
		fileScanner.close();
		return counter;
	}
	public ArrayList<Patient> rowsToPatients(String fileName)
	{
		File f1 = new File(fileName);
		Scanner fileScanner;
		String line;
		String words[];
		ArrayList<Patient> patients = new ArrayList<Patient>();
		
		try
		{
			fileScanner = new Scanner(f1);
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Training data not found");
			return null;
		}
		
		while(fileScanner.hasNext())
		{
			line = fileScanner.next();
			words = line.split(",");
			patients.add(new Patient(words[0], words[1], words[2], words[3]));
		}
		fileScanner.close();
		return patients;
	}
	
	
}
