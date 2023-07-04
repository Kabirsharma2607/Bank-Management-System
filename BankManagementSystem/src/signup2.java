import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class signup2 extends JFrame implements ActionListener{
	JLabel formNo,additionalDetails,religion,category,occupation,education,aadhar,pan;
	JTextField formNoTxt,aadharTxt,panTxt;
	@SuppressWarnings("rawtypes")
	JComboBox religionCb,categoryCb,occupationCb,educationCb;
	JButton next,exit;
	String form_no;
	
	
	@SuppressWarnings("unchecked")
	public signup2(int x) {
		super("Additional Details");
		
		form_no = String.valueOf(x);
		
		setBounds(150,80,710,527);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		//Form no. Label
		formNo = new JLabel("Form No:");
		formNo.setBackground(Color.black);
		formNo.setFont(new Font("Tahoma",1,16));
		formNo.setForeground(Color.blue);
		formNo.setBounds(520, 10, 150, 20);
		add(formNo);
		
		//Form number TextField
		formNoTxt = new JTextField(form_no);
		formNoTxt.setBounds(600, 10, 70, 20);
		add(formNoTxt);
		
		//Address Label
		additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setBackground(Color.black);
		additionalDetails.setFont(new Font("Tahoma",1,16));
		additionalDetails.setForeground(Color.blue);
		additionalDetails.setBounds(150, 50, 240, 40);
		add(additionalDetails);
		
		//Religion label
		religion = new JLabel("Religion:");
		religion.setBackground(Color.black);
		religion.setFont(new Font("Tahoma",1,16));
		religion.setForeground(Color.blue);
		religion.setBounds(50, 130, 160, 30);
		add(religion);
		
		//Predefined religions
		String religion[] = {"Hindu","Sikh","Christan","Other"};
		
		//Combo box to choose religion
		religionCb = new JComboBox(religion);
		religionCb.setBounds(240,130,250,30);
		add(religionCb);
		
		//Category Label
		category = new JLabel("Category:");
		category.setBackground(Color.black);
		category.setFont(new Font("Tahoma",1,16));
		category.setForeground(Color.blue);
		category.setBounds(50, 180, 160, 30);
		add(category);
		
		//Predefined categories
		String category[] = {"General","OBC","SC","ST","Other"};
		
		//Combo box to choose category
		categoryCb = new JComboBox(category);
		categoryCb.setBounds(240, 180, 250, 30);
		add(categoryCb);
		
		//Occupation Label
		occupation = new JLabel("Occupation:");
		occupation.setBackground(Color.black);
		occupation.setFont(new Font("Tahoma",1,16));
		occupation.setForeground(Color.blue);
		occupation.setBounds(50,230,170,30);
		add(occupation);
		
		//Predefined occupations
		String occupation[] = {"Job","Self-Employed","Business","Student","Retired"};
		
		//Combo box to choose occupation
		occupationCb = new JComboBox(occupation);
		occupationCb.setBounds(240, 230, 250, 30);
		add(occupationCb);
		
		//Education Label
		education = new JLabel("Education:");
		education.setBackground(Color.black);
		education.setFont(new Font("Tahoma",1,16));
		education.setForeground(Color.blue);
		education.setBounds(50, 280, 170, 30);
		add(education);
		
		////Predefined education qualifications
		String education[] = {"Senior Secondary","Gradute","Post-Graduate","Phd"};
		
		//Combo box to choose education
		educationCb = new JComboBox(education);
		educationCb.setBounds(240, 280, 250, 30);
		add(educationCb);
		
		//Aadhar Number Label
		aadhar = new JLabel("Aadhar Number:");
		aadhar.setBackground(Color.black);
		aadhar.setFont(new Font("Tahoma",1,16));
		aadhar.setForeground(Color.blue);
		aadhar.setBounds(50, 330, 170, 30);
		add(aadhar);
		
		//Aadhar number TextField
		aadharTxt = new JTextField();
		aadharTxt.setBounds(240, 330, 320, 30);
		add(aadharTxt);
		
		//PAN number Label
		pan = new JLabel("PAN Number:");
		pan.setBackground(Color.black);
		pan.setFont(new Font("Tahoma",1,16));
		pan.setForeground(Color.blue);
		pan.setBounds(50,380,170,30);
		add(pan);
		
		//PAN number TextField
		panTxt = new JTextField();
		panTxt.setBounds(240, 380, 320, 30);
		add(panTxt);
		
		//Next Button
		next = new JButton("NEXT");
		next.setBackground(Color.black);
		next.setFont(new Font("Tahoma",1,16));
		next.setForeground(Color.white);
		next.setBounds(240, 450, 110, 30);
		add(next);
		next.addActionListener(this);
		
		//Exit Button
		exit = new JButton("EXIT");
		exit.setBackground(Color.black);
		exit.setFont(new Font("Tahoma",1,16));
		exit.setForeground(Color.white);
		exit.setBounds(400, 450, 110, 30);
		add(exit);
		exit.addActionListener(this);
		
		
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String form, religion,category,occupation,education, aadhar, panNo;
		
		religion = (String) religionCb.getSelectedItem();
		category = (String) categoryCb.getSelectedItem();
		occupation = (String) occupationCb.getSelectedItem();
		education = (String) educationCb.getSelectedItem();
		
		aadhar = aadharTxt.getText();
		panNo = panTxt.getText();
		
		Connect cn = new Connect();
		form = formNoTxt.getText();
		
		//If next button is clicked
		if(e.getSource() == next) {
			if(form_no.equals(form)) {
				//Checks if any field is empty
				if(formNoTxt.getText().equals("") || aadharTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please check all input fields");
				}//If no field is empty values are stored to table signup2
				else {
					try {
						String query = "INSERT INTO signup2 VALUES ('" + form_no + "','" + religion + "','" + category + "','" + occupation + "','" + education + "','" + aadhar + "','" + panNo + "');";

						int result = cn.st.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Data Saved Successfully");
						setVisible(false);
						new signup3(form_no);
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		}//If exit button is selected the data stored in signup1 w.r.t that form number is deleted
		else {
			try {
				String query = "DELETE FROM signup1 WHERE ID = " + form_no + ";";

				cn.st.executeUpdate(query);
				setVisible(false);
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
 