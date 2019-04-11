package com.assignment.test;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
/*
 * UI class that allows a user to enter their symptoms and recieve a percentage chance of having tonsillitis 
 * Includes access to a second menu which allows user to select the data that they use for the algorithms
 * 
 * Author: Stephen Healy
 */
public class MyUI extends JFrame implements ActionListener
{
	//patient object which will be accessed by control
	Patient p1;
	//boolean used to determine whether a submission has been made
	private boolean submissionMade;
	
	//panels
	
	private JPanel patientPanel = new JPanel();
	private JPanel namePanel = new JPanel();
	private JPanel tempPanel = new JPanel();
	private JPanel achesPanel = new JPanel();
	private JPanel stPanel = new JPanel();
	private JPanel submitPanel = new JPanel();
	
	private JPanel filePanel = new JPanel();
	
	//name components
	private JLabel nameLabel = new JLabel("Name:");
	private JTextField nameField = new JTextField();
	
	
	//Temperature components
	private ButtonGroup temperatureGroup = new ButtonGroup();
	private JRadioButton coolButton = new JRadioButton("cool"); 
	private JRadioButton normalButton = new JRadioButton("normal");
	private JRadioButton hotButton = new JRadioButton("hot");
	private JLabel tempLabel = new JLabel("Temperature:");
	
	
	//Aches components
	private JLabel achesLabel = new JLabel("Aches:");
	private ButtonGroup achesGroup = new ButtonGroup();
	private JRadioButton aYes = new JRadioButton("Yes");
	private JRadioButton aNo = new JRadioButton("No");
	
	
	
	//Sore Throat components
	private JLabel stLabel = new JLabel("Sore Throat:");
	private ButtonGroup stGroup = new ButtonGroup();
	private JRadioButton stYes = new JRadioButton("Yes");
	private JRadioButton stNo = new JRadioButton("No");
	
	//buttons
	private JButton submit = new JButton("Submit");
	private JButton test = new JButton("Test Data");
	
	JButton fMenuButton = new JButton("Select data files");
	
	//file menu buttons
	private JButton selectTrainData = new JButton("Select Training Data");
	private JButton selectTestData = new JButton("Select Test Data");
	private JButton returnToMain = new JButton("Return to Main Menu");
	
	private String testDataName = "src\\testData.csv";
	private String trainingDataName = "src\\trainingData.csv";
	
	//constructor
	public MyUI(String title)
	{
		super(title);
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
		submitPanel.add(fMenuButton);
		submit.addActionListener(this);
		test.addActionListener(this);
		fMenuButton.addActionListener(this);
		
		
		patientPanel.add(submitPanel);
		
		
		
		patientPanel.setPreferredSize(new Dimension(200,50));
		add(patientPanel);
		
		//patient panel end
		filePanel.setVisible(false);
		filePanel.add(selectTrainData);
		selectTrainData.addActionListener(this);
		filePanel.add(selectTestData);
		selectTestData.addActionListener(this);
		filePanel.add(returnToMain);
		returnToMain.addActionListener(this);
		patientPanel.add(filePanel);
		
		
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
		String backUp; //acts as a backup in case a user does not select a correct file
		
		//submit buton is pressed
		if(e.getSource() == submit)
		{
			if(nameField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please enter a name.");
			}
			//check to see if a button for each symptom has been pressed
			else if(( (coolButton.isSelected() == false) &&  (normalButton.isSelected() == false) &&  (hotButton.isSelected() == false)) || ((aYes.isSelected() == false) && (aNo.isSelected() == false)) || (stYes.isSelected() == false) && (stNo.isSelected() == false))
			{
				JOptionPane.showMessageDialog(null,"Please enter your values.");
			}
			else
			{	
				pName = nameField.getText();                
				pTemp = getSelectedButton(temperatureGroup);
				pAches = getSelectedButton(achesGroup);     
				pSoreThroat = getSelectedButton(stGroup);   
				
				//submissionMade = true;
				
				p1 = new Patient(pTemp, pAches, pSoreThroat);
				JOptionPane.showMessageDialog(null,"There is a " + calc1.naiveBayesProb(p1, trainingDataName) + "% chance that you have tonsilitis");
			}
			
		}
		//test button is pressed
		else if(e.getSource() == test)
		{
			JOptionPane.showMessageDialog(null,"Data is approximately " + calc1.testData(trainingDataName, testDataName) + "% accurate");
			
			
		}
		//file menu button is pressed
		else if(e.getSource() == fMenuButton)
		{
			fileMenuOn();
		}
		//return to main menu button is pressed
		else if(e.getSource() == returnToMain)
		{
			fileMenuOff();
		}
		//select test data button is pressed
		else if(e.getSource() == selectTestData)
		{
			backUp = testDataName;
			testDataName = chooseFile();
			if(testDataName == null)
			{
				testDataName = backUp;
			}
		}
		//select training data button is pressed
		else if(e.getSource() == selectTrainData)
		{
			backUp = trainingDataName;
			trainingDataName = chooseFile();
			if(trainingDataName == null)
			{
				trainingDataName = backUp;
			}
		}
	}
	
	//passes a button group and returns the selected value of that group
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
	
	//displays the file menu by setting all main menu panels to invisible and setting the file menu panel to visible
	private void fileMenuOn()
	{
		namePanel.setVisible(false);
		tempPanel.setVisible(false);
		achesPanel.setVisible(false);
		stPanel.setVisible(false);
		submitPanel.setVisible(false);
		
		filePanel.setVisible(true);
	}
	//displays the main menu by setting all main menu panels to visible and setting the file menu panel to invisible
	private void fileMenuOff()
	{
		namePanel.setVisible(true);
		tempPanel.setVisible(true);
		achesPanel.setVisible(true);
		stPanel.setVisible(true);
		submitPanel.setVisible(true);
		
		filePanel.setVisible(false);
	}
	
	
	//allows the user to select a file using a jfilechooser and returns the path of that file as a string. 
	//returns null if no file is selected or if a file other than a .csv file is selected
	public String chooseFile()
	{
		JFileChooser myFile = new JFileChooser("src");
		String ext;
		myFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		myFile.setFileFilter(new FileNameExtensionFilter("CSV", "csv"));
		//myFile.setCurrentDirectory("src");
		System.out.println(myFile.getSelectedFile());
		int val = myFile.showOpenDialog(MyUI.this);
		myFile.setVisible(true);
		if(myFile.getSelectedFile() != null)
		{
			ext = myFile.getSelectedFile().toString().substring(myFile.getSelectedFile().toString().length() - 4);
			System.out.println(ext);
			if(ext.equals(".csv") == false)
			{
				JOptionPane.showMessageDialog(null,"You must select a csv file. Reverting to previous file");
				return null;
			}
			//System.out.println(myFile.getSelectedFile());
			return myFile.getSelectedFile().toString();
		}
		return null;
	}
}
