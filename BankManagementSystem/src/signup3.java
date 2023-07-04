import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.*;

public class signup3 extends JFrame implements ActionListener {
	JLabel form,heading,accountType,cardNo,cardNoGenrated,pinLabel,pinHidden,servicesRequired;
	JTextField formTxt;
	JRadioButton savingsAccRB,fixedDepositAccRB,currentAccRB,recurringDepositAccRB;
	ButtonGroup bg;
	JCheckBox atmCard,internetBanking,mobileBanking,emailAlert,chequeBook,eStatement;
	JButton submit,cancel;
	Random PIN,first4digits,second4digits,third4digits,forth4digits;
	int n1,n2,n3,n4,pin;
	String form_no,card;
		
	public signup3(String x) {
		super("Account Details");
		form_no = x;
		setBounds(150,80,680,580);
		setLayout(null);
		setResizable(true);
		
		//Form number Label
		form = new JLabel("Form No:");
		form.setBackground(Color.black);
		form.setFont(new Font("Tahoma",1,13));
		form.setForeground(Color.blue);
		form.setBounds(470, 10, 60, 20);
		add(form);
		
		//Form number TextField
		formTxt = new JTextField(form_no);
		formTxt.setBounds(530, 10, 70, 20);
		add(formTxt);
		
		//heading of page
		heading = new JLabel("Page 3: Account Details");
		heading.setBackground(Color.black);
		heading.setFont(new Font("Tahoma",1,18));
		heading.setForeground(Color.red);
		heading.setBounds(220, 30, 220, 40);
		add(heading);
		
		//Account type Label
		accountType = new JLabel("Account type:");
		accountType.setBackground(Color.black);
		accountType.setFont(new Font("Tahoma",1,16));
		accountType.setForeground(Color.blue);
		accountType.setBounds(80,70,120,30);
		add(accountType);
		
		//Saving Account Radio Button
		savingsAccRB = new JRadioButton("Saving Account");
		savingsAccRB.setBackground(Color.black);
		savingsAccRB.setFont(new Font("Tahoma",1,12));
		savingsAccRB.setForeground(Color.white);
		savingsAccRB.setBounds(180,110,130,30);
		add(savingsAccRB);
		
		//FD Account Radio Button
		fixedDepositAccRB = new JRadioButton("Fixed Deposit Account");
		fixedDepositAccRB.setBackground(Color.black);
		fixedDepositAccRB.setFont(new Font("Tahoma",1,12));
		fixedDepositAccRB.setForeground(Color.white);
		fixedDepositAccRB.setBounds(340,110,190,30);
		add(fixedDepositAccRB);
		
		//Current Account Radio Button
		currentAccRB = new JRadioButton("Current Account");
		currentAccRB.setBackground(Color.black);
		currentAccRB.setFont(new Font("Tahoma",1,12));
		currentAccRB.setForeground(Color.white);
		currentAccRB.setBounds(180,160,130,30);
		add(currentAccRB);
		
		//Recurring Deposit Account Radio Button
		recurringDepositAccRB = new JRadioButton("Recuring Deposit Account");
		recurringDepositAccRB.setBackground(Color.black);
		recurringDepositAccRB.setFont(new Font("Tahoma",1,11));
		recurringDepositAccRB.setForeground(Color.white);
		recurringDepositAccRB.setBounds(340,160,190,30);
		add(recurringDepositAccRB);
		
		//To group the buttons
		bg = new ButtonGroup();
		bg.add(savingsAccRB);
		bg.add(fixedDepositAccRB);
		bg.add(currentAccRB);
		bg.add(recurringDepositAccRB);
		
		//Card Number Label
		cardNo = new JLabel("Card Number:");
		cardNo.setBackground(Color.black);
		cardNo.setFont(new Font("Tahoma",1,16));
		cardNo.setForeground(Color.blue);
		cardNo.setBounds(80,220,120,30);
		add(cardNo);
		
		//Generates last 4 digits of card Number
		forth4digits = new Random();
		n4 = 1000 + forth4digits.nextInt(9999-1000);
			
		//CardNumber Label that hides what isthe card number assigned to you except for last 4 digits
		cardNoGenrated = new JLabel("XXXX-XXXX-XXXX-" + n4);
		cardNoGenrated.setBackground(Color.black);
		cardNoGenrated.setFont(new Font("Tahoma",1,16));
		cardNoGenrated.setForeground(Color.blue);
		cardNoGenrated.setBounds(240,220,210,30);
		add(cardNoGenrated);
		
		//PIN Label
		pinLabel = new JLabel("PIN:");
		pinLabel.setBackground(Color.black);
		pinLabel.setFont(new Font("Tahoma",1,16));
		pinLabel.setForeground(Color.blue);
		pinLabel.setBounds(80,260,120,30);
		add(pinLabel);
		
		//PIN label but pin is hidden
		pinHidden = new JLabel("XXXX");
		pinHidden.setBackground(Color.black);
		pinHidden.setFont(new Font("Tahoma",1,16));
		pinHidden.setForeground(Color.blue);
		pinHidden.setBounds(240,260,230,30);
		add(pinHidden);
		
		//Services Required Label
		servicesRequired = new JLabel("Services Required:");
		servicesRequired.setBackground(Color.black);
		servicesRequired.setFont(new Font("Tahoma",1,16));
		servicesRequired.setForeground(Color.blue);
		servicesRequired.setBounds(80, 170, 160, 300);
		add(servicesRequired);
		
		//ATM Card CheckBox
		atmCard = new JCheckBox("ATM Card");
		atmCard.setBackground(Color.black);
		atmCard.setFont(new Font("Tahoma",1,12));
		atmCard.setForeground(Color.white);
		atmCard.setBounds(190,350,120,23);
		add(atmCard);
		
		//Internet Banking Check Box
		internetBanking = new JCheckBox("Internet Banking");
		internetBanking.setBackground(Color.black);
		internetBanking.setFont(new Font("Tahoma",1,12));
		internetBanking.setForeground(Color.white);
		internetBanking.setBounds(340,350,140,23);
		add(internetBanking);
		
		//Mobile Banking Check Box
		mobileBanking = new JCheckBox("Mobile Banking");
		mobileBanking.setBackground(Color.black);
		mobileBanking.setFont(new Font("Tahoma",1,12));
		mobileBanking.setForeground(Color.white);
		mobileBanking.setBounds(190,390,120,23);
		add(mobileBanking);

		//Email alerts Check Box
		emailAlert = new JCheckBox("Email Alerts");
		emailAlert.setBackground(Color.black);
		emailAlert.setFont(new Font("Tahoma",1,12));
		emailAlert.setForeground(Color.white);
		emailAlert.setBounds(340,390,140,23);
		add(emailAlert);
		
		//Cheque book Check Box
		chequeBook = new JCheckBox("Cheque Book");
		chequeBook.setBackground(Color.black);
		chequeBook.setFont(new Font("Tahoma",1,12));
		chequeBook.setForeground(Color.white);
		chequeBook.setBounds(190,430,120,23);
		add(chequeBook);
		
		//E-statement CheckBox
		eStatement = new JCheckBox("E-Statement");
		eStatement.setBackground(Color.black);
		eStatement.setFont(new Font("Tahoma",1,12));
		eStatement.setForeground(Color.white);
		eStatement.setBounds(340,430,140,23);
		add(eStatement);
		
		//Submit Button
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setFont(new Font("Tahoma",1,16));
		submit.setForeground(Color.white);
		submit.setBounds(200,490,110,30);
		add(submit);
		submit.addActionListener(this);

		//Cancel Button
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setFont(new Font("Tahoma",1,16));
		cancel.setForeground(Color.white);
		cancel.setBounds(340,490,110,30);
		add(cancel);
		cancel.addActionListener(this);
		
		//Generates PIN
		PIN = new Random();
		pin = 1000 + PIN.nextInt(9999-1000);
		
		//Generates first 4 digits of your card number
		first4digits = new Random();
		n1 = 1000 + first4digits.nextInt(9999-1000);
		
		//Generates next 4 digits of your card number
		second4digits = new Random();
		n2 = 1000 + second4digits.nextInt(9999-1000);
		
		//Generates next 4 digits of your card number
		third4digits = new Random();
		n3 = 1000 + third4digits.nextInt(9999-1000);
		
		card = String.valueOf(n1) + "-" + String.valueOf(n2) + "-" + String.valueOf(n3) + "-" + String.valueOf(n4);
		
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String account = "", services="";
		
		//To check which type of account user wants
		if(savingsAccRB.isSelected()) {
			account = "Saving Account";
		}else if(fixedDepositAccRB.isSelected()) {
			account = "Fixed Deposit Account";
		}else if(currentAccRB.isSelected()) {
			account = "Current Account";
		}else if(recurringDepositAccRB.isSelected()) {
			account = "Reccuring Deposit Account";
		}
		
		//Sees which of the services are selected
		if(atmCard.isSelected()) {
			services="ATM Card ,";
		}
		
		if(internetBanking.isSelected()) {
			services = services + "Internet Banking ,";
		}
		
		if(mobileBanking.isSelected()) {
			services = services + "Mobile Banking ,";
		}
		
		if(emailAlert.isSelected()) {
			services = services + "Email Alert ,";
		}
		
		if(chequeBook.isSelected()) {
			services = services + "Cheque Book ,";
		}
		
		if(eStatement.isSelected()) {
			services = services + "E-Statement";
		}
		
		Connect cn =  new Connect();
		if(e.getSource() == submit) {
			if(form_no.equals(formTxt.getText())) {
				//Stores card number, PIN, account type, Services choosed into table signup3
				try {
					String query = "INSERT INTO signup3 VALUES ('" + form_no + "','" + card + "','" + pin + "','" + account + "','" + services + "');";
					cn.st.executeUpdate(query);
					int bal = 0;
					//Stores card,pin and balance to table login
					String query2 = "insert into login (card,pin,balance) values ('"+card+"','" +pin+"','" +bal+"');";
					cn.st.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Your card number is: " + card + "\n Your PIN is: " +pin);
					setVisible(false);
					new Transaction();
					
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}//Error if form number is incorrect
			else {
				JOptionPane.showMessageDialog(null, "Check Your Form No");
			}
		}//If user chooses cancel button all the data stored in table signup1 and signup2 gets removed
		else {
			try {
				String query = "delete from signup1 where if = '"+form_no+"';";
				String query2 = "delete from signup2 where if = '"+form_no+"';";
				cn.st.executeUpdate(query);
				cn.st.executeUpdate(query2);
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Form number is wrong...");
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
