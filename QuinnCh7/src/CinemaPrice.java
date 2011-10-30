/*
	FileName:Cinema Price
	Name: Ryan Quinn
	Date: October 23, 2011
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*; // import statement for borders
import javax.swing.event.*; // import statement for JSlider
import java.text.*;

public class CinemaPrice extends JFrame {
	//Declarations
		Color black = new Color(0, 0, 0);
		Color white = new Color(255, 255, 255);
		
		JLabel patronAgeJLabel;
		JTextField patronAgeJTextField;
		
		JLabel ticketPriceJLabel;
		JTextField ticketPriceJTextField;
		
		JLabel admissionJLabel;
		JTextField admissionJTextField;
		
		JButton enterJButton;
		JButton clearJButton;
		
		int patronAge;
		double ticketPrice;
		String admission = "";
		DecimalFormat currencyForDollars = new DecimalFormat("$0.00");
		
		public CinemaPrice()
	   	{
	      	createUserInterface();
	   	}
		
		private void createUserInterface() 
		{
			Container contentPane = getContentPane();
			contentPane.setBackground(Color.white);
			contentPane.setLayout(null);
			
			patronAgeJLabel = new JLabel();
			patronAgeJLabel.setBounds(50, 50, 120, 20);
			patronAgeJLabel.setFont(new Font("Default", Font.PLAIN, 9));
			patronAgeJLabel.setText("Patron Age:");
			patronAgeJLabel.setForeground(black);
			patronAgeJLabel.setHorizontalAlignment(JLabel.LEFT);
			contentPane.add(patronAgeJLabel);
			
			patronAgeJTextField = new JTextField();
			patronAgeJTextField.setBounds(225, 50, 100, 20);
			patronAgeJTextField.setFont(new Font("Default", Font.PLAIN, 9));
			patronAgeJTextField.setHorizontalAlignment(JTextField.CENTER);
			patronAgeJTextField.setForeground(black);
			patronAgeJTextField.setBackground(white);
			patronAgeJTextField.setEditable(true);
			contentPane.add(patronAgeJTextField);
			
			ticketPriceJLabel = new JLabel();
			ticketPriceJLabel.setBounds(50, 100, 120, 20);
			ticketPriceJLabel.setFont(new Font("Default", Font.PLAIN, 9));
			ticketPriceJLabel.setText("Ticket Price:");
			ticketPriceJLabel.setForeground(black);
			ticketPriceJLabel.setHorizontalAlignment(JLabel.LEFT);
			contentPane.add(ticketPriceJLabel);
			
			ticketPriceJTextField = new JTextField();
			ticketPriceJTextField.setBounds(225, 100, 100, 20);
			ticketPriceJTextField.setFont(new Font("Default", Font.PLAIN, 9));
			ticketPriceJTextField.setHorizontalAlignment(JTextField.CENTER);
			ticketPriceJTextField.setForeground(black);
			ticketPriceJTextField.setBackground(white);
			ticketPriceJTextField.setEditable(false);
			contentPane.add(ticketPriceJTextField);
			
			admissionJLabel = new JLabel();
			admissionJLabel.setBounds(50, 120, 120, 20);
			admissionJLabel.setFont(new Font("Default", Font.PLAIN, 9));
			admissionJLabel.setText("Admission:");
			admissionJLabel.setForeground(black);
			admissionJLabel.setHorizontalAlignment(JLabel.LEFT);
			contentPane.add(admissionJLabel);
			
			admissionJTextField = new JTextField();
			admissionJTextField.setBounds(225, 120, 100, 20);
			admissionJTextField.setFont(new Font("Default", Font.PLAIN, 9));
			admissionJTextField.setHorizontalAlignment(JTextField.CENTER);
			admissionJTextField.setForeground(black);
			admissionJTextField.setBackground(white);
			admissionJTextField.setEditable(false);
			contentPane.add(admissionJTextField);
			
			enterJButton = new JButton();
			enterJButton.setBounds(50, 150, 100, 20);
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
			clearJButton.setBounds(200, 150, 100, 20);
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
			
			setTitle("Cinema Price");
			setSize( 400, 400 );
			setVisible(true);
		}	
		
		public static void main(String[] args)
		{
	      	CinemaPrice application = new CinemaPrice();
	      	application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	   	public void enterJButtonActionPerformed(ActionEvent event)
		{
	   		patronAge = getPatronAge();
   			admission = determineAdmissionStatus();
   			ticketPrice = determineTicketPrice();
   			
   			ticketPriceJTextField.setText("" + currencyForDollars.format(ticketPrice));
   			admissionJTextField.setText("" + admission);
   			
   			
		}
	   	
	   	public int getPatronAge() {
	   		
	   		try {
	   			patronAge = Integer.parseInt(patronAgeJTextField.getText());
	   		}
	   		catch(NumberFormatException exception) {
	        	JOptionPane.showMessageDialog(this,
	                	"That is not a number.",
	                	"Number Format Error", JOptionPane.ERROR_MESSAGE );
	                	patronAgeJTextField.setText("");
	                	patronAgeJTextField.requestFocusInWindow();
	                	
	                	//This is so that when someone enters a letter, it doesn't also
	                	//tell them not to put in 0
	                	patronAge = -1;
	   		}
	   		return patronAge;
	   	}
	   	
	   	public String determineAdmissionStatus()
	   	{
	   		if(patronAge == 0) {
	        	JOptionPane.showMessageDialog(this,
	                	"You are not 0. Please try again",
	                	"You do not exist", JOptionPane.ERROR_MESSAGE );
	                	patronAgeJTextField.setText("");
	                	patronAgeJTextField.requestFocusInWindow();
	   		}
	   		
	   		else if(patronAge == -1) {
	   			
	   		}
   			
   			else if(patronAge < 5) {
   				ticketPrice = 0;
   				admission = "Free";
   			}
   			
   			else if(patronAge < 13) {
   				ticketPrice = 5.29;
   				admission = "Child";
   			}
   			
   			else if(patronAge < 55) {
   				ticketPrice = 6.95;
   				admission = "Adult";
   			}
   			
   			else if(patronAge >= 55) {
   				ticketPrice = 0;
   				admission = "Free";
   			}
	   		
   			else {
	   			JOptionPane.showMessageDialog(this,
	                	"Please enter an age",
	                	"Failure to read", JOptionPane.ERROR_MESSAGE );
	                	patronAgeJTextField.setText("");
	                	patronAgeJTextField.requestFocusInWindow();
	   		}
	   		
	   		return admission;
	   	}
	   	
	   	public double determineTicketPrice() {
	   		if(patronAge == 0) {
	   		}
   			
   			else if(patronAge < 5) {
   				ticketPrice = 0;
   				admission = "Free";
   			}
   			
   			else if(patronAge < 13) {
   				ticketPrice = 5.29;
   				admission = "Child";
   			}
   			
   			else if(patronAge < 55) {
   				ticketPrice = 6.95;
   				admission = "Adult";
   			}
   			
   			else if(patronAge >= 55) {
   				ticketPrice = 0;
   				admission = "Free";
   			}
	   		
   			else {
	   		}
	   		
	   		return ticketPrice;
	   	}
	   	
		public void clearJButtonActionPerformed(ActionEvent event)
		{
			patronAgeJTextField.setText("");
			patronAgeJTextField.requestFocusInWindow();
			admissionJTextField.setText("");
			ticketPriceJTextField.setText("");
		}	
		
}
