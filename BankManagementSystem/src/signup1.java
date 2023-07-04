import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.*;

public class signup1 extends JFrame implements ActionListener {

	JLabel form, perosnalDetails, name, contact, gender, dob, email, address;
	JTextField nameText, contactText, emailText;
	JComboBox daysDropDown, monthsDropDown, yearsDropDown;
	JRadioButton male, female, r3;
	ButtonGroup bg;
	JTextArea addressText;
	JButton next, cancel;
	String day[] = new String[31];
	String year[] = new String[26];
	String month[] = new String[12];
	int form_no;
	long contactNumber;
	public signup1() {
		//Heading
		super("BANK MANAGEMENT SYSTEM");
		setBounds(150, 80, 687, 560);
		getContentPane().setBackground(Color.white);
		setResizable(true);
		setLayout(null);

		//To generate form number
		Random r = new Random();
		form_no = 1000 + r.nextInt(9999 - 1000);
		form = new JLabel("APPLICATION FORM NO." + form_no);
		form.setBackground(Color.white);
		form.setFont(new Font("Tahoma", 1, 21));
		form.setBounds(200, 10, 460, 50);
		add(form);

		//Heading of page
		perosnalDetails = new JLabel("Page 1 : Personal Details");
		perosnalDetails.setBackground(Color.white);
		perosnalDetails.setFont(new Font("Tahoma", 1, 16));
		perosnalDetails.setForeground(Color.BLUE);
		perosnalDetails.setBounds(240, 60, 210, 30);
		add(perosnalDetails);

		//Name label
		name = new JLabel("Name:");
		name.setBackground(Color.black);
		name.setFont(new Font("Tahoma", 1, 16));
		name.setForeground(Color.blue);
		name.setBounds(50, 130, 160, 30);
		add(name);

		//Name TextField
		nameText = new JTextField();
		nameText.setBackground(Color.white);
		nameText.setBounds(240, 130, 320, 30);
		add(nameText);
		
		//Contact number Label
		contact = new JLabel("Contact no");
		contact.setBackground(Color.black);
		contact.setFont(new Font("Tahoma", 1, 16));
		contact.setForeground(Color.BLUE);
		contact.setBounds(50, 180, 170, 30);
		add(contact);

		//contact Number TextField
		contactText = new JTextField();
		contactText.setBackground(Color.white);
		contactText.setBounds(240, 180, 320, 30);
		add(contactText);

		//Gender Label
		gender = new JLabel("Gender:");
		gender.setBackground(Color.black);
		gender.setFont(new Font("Tahoma", 1, 16));
		gender.setForeground(Color.BLUE);
		gender.setBounds(50, 230, 170, 30);
		add(gender);

		//Male Radio Button
		male = new JRadioButton("Male");
		male.setBackground(Color.white);
		male.setBounds(240, 230, 80, 30);
		add(male);

		//Female Radio Button
		female = new JRadioButton("Female");
		female.setBackground(Color.white);
		female.setBounds(300, 230, 80, 30);
		add(female);

		//To group buttons
		bg =new ButtonGroup();
		bg.add(male);
		bg.add(female);

		//DOB Label
		dob = new JLabel("Date of Birth:");
		dob.setBackground(Color.black);
		dob.setFont(new Font("Tahoma", 1, 16));
		dob.setForeground(Color.blue);
		dob.setBounds(50, 280, 170, 30);
		add(dob);

		//Generate number of days in a month
		for (int i = 1; i <= 31; i++) {
			day[i - 1] = String.valueOf(i);
		}
		
		//Combo box To choose the date 
		daysDropDown = new JComboBox<>(day);
		daysDropDown.setBounds(240, 280, 60, 30);
		add(daysDropDown);
		
		//Generates month number 
		for (int i = 1; i <= 12; i++) {
			month[i - 1] = String.valueOf(i);
		}
		
		//Combo box to chose month
		monthsDropDown = new JComboBox<>(month);
		monthsDropDown.setBounds(330, 280, 110, 30);
		add(monthsDropDown);
		
		//Generates year ranging from 1980-2015
		for (int i = 1980; i <= 2005; i++) {
			year[i - 1980] = String.valueOf(i);
		}

		//Combo box to chose year
		yearsDropDown = new JComboBox<>(year);
		yearsDropDown.setBounds(480, 280, 80, 30);
		add(yearsDropDown);

		//Email Label
		email = new JLabel("Email Address:");
		email.setBackground(Color.BLACK);
		email.setFont(new Font("Tahoma", 1, 16));
		email.setForeground(Color.blue);
		email.setBounds(50, 330, 170, 30);
		add(email);

		//Email TextField
		emailText = new JTextField();
		emailText.setBackground(Color.white);
		emailText.setBounds(240, 330, 320, 30);
		add(emailText);

		//Address Label
		address = new JLabel("Address:");
		address.setBackground(Color.BLACK);
		address.setFont(new Font("Tahoma", 1, 16));
		address.setForeground(Color.BLUE);
		address.setBounds(50, 380, 170, 30);
		add(address);

		//Address TextField
		addressText = new JTextArea();
		addressText.setBackground(Color.white);
		addressText.setBorder(BorderFactory.createLineBorder(Color.gray));
		addressText.setBounds(240, 380, 320, 50);
		add(addressText);

		//Next Button
		next = new JButton("NEXT");
		next.setBackground(Color.black);
		next.setFont(new Font("Arial", 1, 16));
		next.setForeground(Color.WHITE);
		next.setBounds(240, 450, 110, 30);
		add(next);
		next.addActionListener(this);

		//Cancel button
		cancel = new JButton("CANCEL");
		cancel.setBackground(Color.black);
		cancel.setFont(new Font("Arial", 1, 16));
		cancel.setForeground(Color.white);
		cancel.setBounds(380, 450, 110, 30);
		add(cancel);
		cancel.addActionListener(this);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name, contact, gender = "", dob = "", email, address;

		name = nameText.getText();

		contact = contactText.getText();
		
		//Checks if the contact number TextField contains digits only
			try {
				 contactNumber = Long.parseLong(contact);
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Contact number should contain digits only");
			}
		
		//To see which gender is selected
		if (male.isSelected())
			gender = "Male";
		else if (female.isSelected())
			gender = "Female";
		
		dob = String.valueOf(daysDropDown.getSelectedItem()) + "-" + String.valueOf(monthsDropDown.getSelectedItem())
				+ "-" + String.valueOf(yearsDropDown.getSelectedItem());

		email = emailText.getText();

		address = addressText.getText();

		//Checks that the details enter are valid or not
		if (e.getSource() == next) {
			if (name.equals("") || email.equals("") || address.equals(""))
				JOptionPane.showMessageDialog(null, "Fields should form_not be empty");
			else if (email.indexOf("@") < 1 || email.indexOf(".com") < 2)
				JOptionPane.showMessageDialog(null, "Enter a valid email address");
			 else if (contact.length() < 10 || contact.length() > 10) {
				JOptionPane.showMessageDialog(null, "Enter a valid Contact number");
			}
			 //If all the details are correct then they are stored into signup1 table
			 else {
				Connect cn = new Connect();
				String query = ("insert into signup1 values('" + form_no + "','" + name + "','" + contactNumber + "','"
						+ gender + "','" + dob + "','" + email + "','" + address + "');");
				try {
					int msg = cn.st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Data Saved successfully");
					setVisible(false);
					new signup2(form_no);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} //IF cancel button is selected redirected to login page
		else {
			setVisible(false);
			new login();
		}
	}

}
