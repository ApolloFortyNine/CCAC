/*
	FileName:GradeCalculator
	Name: Ryan Quinn
	Date: October 30, 2011
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*; // import statement for borders
import javax.swing.event.*; // import statement for JSlider
import java.text.*;

public class GradeCalculator extends JFrame {
	
	//Colors
	Color black = new Color(0, 0, 0);
	Color white = new Color(255, 255, 255);
	
	JLabel gradeJLabel;
	JTextField gradeJTextField;
	
	JLabel enterStartJLabel;
	
	JButton enterJButton;
	JButton clearJButton;
	
	int numberOfScores;
	String scoreAmount;
	
	public GradeCalculator() {
		createUserInterface();
	}
	
	private void createUserInterface() {
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);
		
		gradeJLabel = new JLabel();
		gradeJLabel.setBounds(50, 50, 120, 20);
		gradeJLabel.setFont(new Font("Default", Font.PLAIN, 12));
		gradeJLabel.setText("Grade:");
		gradeJLabel.setForeground(black);
		gradeJLabel.setHorizontalAlignment(JLabel.LEFT);
		contentPane.add(gradeJLabel);
		
		gradeJTextField = new JTextField();
		gradeJTextField.setBounds(150, 50, 100, 20);
		gradeJTextField.setFont(new Font("Default", Font.PLAIN, 12));
		gradeJTextField.setHorizontalAlignment(JTextField.CENTER);
		gradeJTextField.setForeground(black);
		gradeJTextField.setBackground(white);
		gradeJTextField.setEditable(false);
		contentPane.add(gradeJTextField);
		
		enterStartJLabel = new JLabel();
		enterStartJLabel.setBounds(150, 250, 120, 20);
		enterStartJLabel.setFont(new Font("Default", Font.PLAIN, 12));
		enterStartJLabel.setText("Click enter to start!");
		enterStartJLabel.setForeground(black);
		enterStartJLabel.setHorizontalAlignment(JLabel.LEFT);
		contentPane.add(enterStartJLabel);
		
		enterJButton = new JButton();
		enterJButton.setBounds(175, 300, 300, 20);
		enterJButton.setFont(new Font("Default", Font.PLAIN, 9));
		enterJButton.setText("Enter");
		enterJButton.setForeground(black);
		enterJButton.setBackground(white);
		contentPane.add(enterJButton);
		enterJButton.addActionListener(
		
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					enterJButtonActionPerformed(event);
				}
			}
		);
		
		clearJButton = new JButton();
		clearJButton.setBounds(225, 300, 100, 20);
		clearJButton.setFont(new Font("Default", Font.PLAIN, 9));
		clearJButton.setText("Clear");
		clearJButton.setForeground(black);
		clearJButton.setBackground(white);
		contentPane.add(clearJButton);
		clearJButton.addActionListener(
		
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					clearJButtonActionPerformed(event);
				}
			}
		);
		
		setTitle("Grade Calculator");
		setSize( 400, 400 );
		setVisible(true);
	}

	
	
}
