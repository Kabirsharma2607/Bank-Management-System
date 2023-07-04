import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{
	
	JLabel heading;
	JButton pinBtn,balanceEnquiryBtn,depositBtn,withdrawalBtn,exitBtn;
	
	public Transaction() {
		super("Transaction Type");
		setBounds(150,80,650,554);
		setLayout(null);
		
		//Heading
		heading = new JLabel("Please select your transaction type");
		heading.setBackground(Color.black);
		heading.setFont(new Font("Tahoma",1,21));
		heading.setForeground(Color.red);
		heading.setBounds(125, 40, 400, 40);
		add(heading);
		
		//PIN change button
		pinBtn = new JButton("PIN Change");
		pinBtn.setBackground(Color.black);
		pinBtn.setFont(new Font("Tahoma",1,16));
		pinBtn.setForeground(Color.white);
		pinBtn.setBounds(80,130,200,30);
		add(pinBtn);
		pinBtn.addActionListener(this);
		
		//Balance enquiry Button
		balanceEnquiryBtn = new JButton("Balance Enquiry");
		balanceEnquiryBtn.setBackground(Color.black);
		balanceEnquiryBtn.setFont(new Font("Tahoma",1,16));
		balanceEnquiryBtn.setForeground(Color.white);
		balanceEnquiryBtn.setBounds(310,130,210,30);
		add(balanceEnquiryBtn);
		balanceEnquiryBtn.addActionListener(this);

		//Deposit Button
		depositBtn = new JButton("Deposit");
		depositBtn.setBackground(Color.black);
		depositBtn.setFont(new Font("Tahoma",1,16));
		depositBtn.setForeground(Color.white);
		depositBtn.setBounds(80,210,200,30);
		add(depositBtn);
		depositBtn.addActionListener(this);

		//Cash Withdrawal Button
		withdrawalBtn = new JButton("Cash Withdrawal");
		withdrawalBtn.setBackground(Color.black);
		withdrawalBtn.setFont(new Font("Tahoma",1,16));
		withdrawalBtn.setForeground(Color.white);
		withdrawalBtn.setBounds(310,210,210,30);
		add(withdrawalBtn);
		withdrawalBtn.addActionListener(this);

		//Exit Button
		exitBtn = new JButton("Exit");
		exitBtn.setBackground(Color.black);
		exitBtn.setFont(new Font("Tahoma",1,16));
		exitBtn.setForeground(Color.white);
		exitBtn.setBounds(210,270,180,40);
		add(exitBtn);
		exitBtn.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if PIN change button is selected it calls pin change constructor
		if(e.getSource() == pinBtn) {
			setVisible(false);
			new changePin();
		}
		//If balance enquiry button is selected
		else if(e.getSource()==balanceEnquiryBtn) {
			try {
				String pin = JOptionPane.showInputDialog("Enter your pin");
				Connect cn = new Connect();
				String query = "select * from login where pin='"+pin+"';";
				ResultSet rs = cn.st.executeQuery(query);
				if(rs.next()) {
					int balance = rs.getInt(3);
					JOptionPane.showMessageDialog(null, "Your balance is: "+balance);
				}
				else {
					JOptionPane.showMessageDialog(null, "Your PIN is wrong");
				}
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}//If deposit button is selected
		if(e.getSource()==depositBtn) {
			setVisible(false);
			new deposit();
		}//If withdrawal Button is selected it calls withdrawal Constructor
		if(e.getSource()==withdrawalBtn) {
			setVisible(false);
			new withdrawal();
		}//If exit button is selected it closes the window 
		if(e.getSource()==exitBtn) {
			System.exit(0);
		}
	}

}
