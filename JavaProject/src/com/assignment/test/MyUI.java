package com.assignment.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/*
 * UI class that allows a user to enter their symptoms and recieve a percentage chance of having tonsilitis
 */
public class MyUI extends JFrame implements ActionListener
{
	//patient object which will be accessed by control
	Patient p1;
	//boolean used to determine whether a submission has been made
	private boolean submissionMade;
	
	//panels
	
	JPanel patientPanel = new JPanel();
	JPanel namePanel = new JPanel();
	JPanel tempPanel = new JPanel();
	JPanel achesPanel = new JPanel();
	JPanel stPanel = new JPanel();
	JPanel submitPanel = new JPanel();
	
	//name components
	JLabel nameLabel = new JLabel("Name:");
	JTextField nameField = new JTextField();
	
	
	//Temperature components
	ButtonGroup temperatureGroup = new ButtonGroup();
	JRadioButton coolButton = new JRadioButton("cool"); 
	JRadioButton normalButton = new JRadioButton("normal");
	JRadioButton hotButton = new JRadioButton("hot");
	JLabel tempLabel = new JLabel("Temperature:");
	
	
	//Aches components
	JLabel achesLabel = new JLabel("Aches:");
	ButtonGroup achesGroup = new ButtonGroup();
	JRadioButton aYes = new JRadioButton("Yes");
	JRadioButton aNo = new JRadioButton("No");
	
	
	
	//Sore Throat components
	JLabel stLabel = new JLabel("Sore Throat:");
	ButtonGroup stGroup = new ButtonGroup();
	JRadioButton stYes = new JRadioButton("Yes");
	JRadioButton stNo = new JRadioButton("No");
	
	JButton submit = new JButton("Submit");
	JButton test = new JButton("Test Data");
	public MyUI()
	{
		submissionMade = false;
		
		
		//patient panel start
		patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.Y_AXIS));
		
		nameField.setColumns(20);
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		patientPanel.add(namePanel);
		
		temperatureGroup.add(coolButton);
		
		coolButton.setActionCommand("cool");
		temperatureGroup.add(normalButton);
		normalButton.setActionCommand("normal");
		temperatureGroup.add(hotButton);
		hotButton.setActionCommand("hot");
		
		//coolButton.setSelected(true);
		
		tempPanel.add(tempLabel);
		tempPanel.add(coolButton);
		tempPanel.add(normalButton);
		tempPanel.add(hotButton);
		patientPanel.add(tempPanel);
		
		achesGroup.add(aYes);
		aYes.setActionCommand("yes");
		achesGroup.add(aNo);
		aNo.setActionCommand("no");
		achesPanel.add(achesLabel);
		achesPanel.add(aYes);
		achesPanel.add(aNo);
		patientPanel.add(achesPanel);
		
		//aYes.setSelected(true);
		
		stPanel.add(stLabel);
		stGroup.add(stYes);
		stYes.setActionCommand("yes");
		stGroup.add(stNo);
		stNo.setActionCommand("no");
		stPanel.add(stYes);
		stPanel.add(stNo);
		patientPanel.add(stPanel);
		
		//stYes.setSelected(true);
		
		submitPanel.add(submit);
		submitPanel.add(test);
		submit.addActionListener(this);
		test.addActionListener(this);
		
		patientPanel.add(submitPanel);
		
		
		
		patientPanel.setPreferredSize(new Dimension(200,50));
		add(patientPanel);
		
		//patient panel end
		
		
		
		setVisible(true);
		setSize(500,200);
		setLocation(500,500);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String pName;
		String pTemp;
		String pAches;
		String pSoreThroat;
		Calculation calc1 = new Calculation();
		ArrayList<Patient> pList = new ArrayList<Patient>();
		FileProcessor testProcessor = new FileProcessor();
		String testDataName = "src\\testData.csv";
		String trainingDataName = "src\\trainingData.csv";
		
		if(e.getSource() == submit)
		{
			if(nameField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please enter a name.");
			}
			//check to see if a button for each symptom has been pressed
			else if(( (coolButton.isSelected() == false) &&  (normalButton.isSelected() == false) &&  (hotButton.isSelected() == false)) || ((aYes.isSelected() == false) && (aNo.isSelected() == false)) || (stYes.isSelected() == false) && (stNo.isSelected() == false))
			{
				JOptionPane.showMessageDialog(null,"Please enter Your values.");
			}
			else
			{	
				pName = nameField.getText();                
				pTemp = getSelectedButton(temperatureGroup);
				pAches = getSelectedButton(achesGroup);     
				pSoreThroat = getSelectedButton(stGroup);   
				
				//submissionMade = true;
				
				p1 = new Patient(pTemp, pAches, pSoreThroat);
				JOptionPane.showMessageDialog(null,"There is a " + calc1.naiveBayesProb(p1) + "% chance that you have tonsilitis");
			}
			
		}
		else if(e.getSource() == test)
		{
			JOptionPane.showMessageDialog(null,"Data is approximately " + calc1.testData(trainingDataName, testDataName) + "% accurate");
			
			
		}
	}
	
	public String getSelectedButton(ButtonGroup bg)
	{
		return bg.getSelection().getActionCommand();
	}

	public boolean isSubmissionMade() {
		return submissionMade;
	}

	public void setSubmissionMade(boolean submissionMade) {
		this.submissionMade = submissionMade;
	}
}
