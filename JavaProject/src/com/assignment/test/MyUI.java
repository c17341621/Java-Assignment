package com.assignment.test;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MyUI extends JFrame
{
	JPanel panel1 = new JPanel();
	JPanel tempPanel = new JPanel();
	JPanel achesPanel = new JPanel();
	JPanel stPanel = new JPanel();
	JPanel submitPanel = new JPanel();
	
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
	
	public MyUI()
	{
		temperatureGroup.add(coolButton);
		temperatureGroup.add(normalButton);
		temperatureGroup.add(hotButton);
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		tempPanel.add(tempLabel);
		tempPanel.add(coolButton);
		tempPanel.add(normalButton);
		tempPanel.add(hotButton);
		panel1.add(tempPanel);
		achesPanel.add(achesLabel);
		achesPanel.add(aYes);
		achesPanel.add(aNo);
		panel1.add(achesPanel);
		
		stPanel.add(stLabel);
		stPanel.add(stYes);
		stPanel.add(stNo);
		panel1.add(stPanel);
		
		submitPanel.add(submit);
		
		panel1.add(submitPanel);
		
		
		coolButton.setBorderPainted(true);
		normalButton.setBorderPainted(true);
		hotButton.setBorderPainted(true);
		panel1.setPreferredSize(new Dimension(200,50));
		add(panel1);
		setVisible(true);
		setSize(400,200);
	}
}
