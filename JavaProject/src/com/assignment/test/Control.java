package com.assignment.test;

import javax.swing.JOptionPane;

public class Control {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String fName = "src\\trainingData.csv";
		//FileProcessor fp = new FileProcessor();
		//int i = 0;
		//fp.printCol("src\\trainingData.csv");
		MyUI ui1 = new MyUI();
		//System.out.println(fp.countCol(fName, 2, "yes"));
		//System.out.println(fp.countLines(fName));
		while(ui1.isSubmissionMade() == false)
		{
			ui1.isSubmissionMade();
		}
		
		JOptionPane.showMessageDialog(null,(ui1.p1));
	}

}
