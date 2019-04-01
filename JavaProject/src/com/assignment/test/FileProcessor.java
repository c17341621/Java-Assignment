package com.assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor 
{
	public FileProcessor()
	{
		
	}
	
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
}
