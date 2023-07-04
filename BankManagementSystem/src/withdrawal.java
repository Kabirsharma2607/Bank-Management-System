import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class withdrawal extends JFrame implements ActionListener {
	JLabel heading,pinLabel,amountLabel,l4;
	JTextField pinTxt,amountTxt,t3;
	JButton withdrawalBtn,cancelBtn;
	int amount;
	
	public withdrawal() {
		super("WITHDRAWAL");
		setBounds(150,80,680,554);
		setLayout(null);
		
		//Heading
		heading = new JLabel("WITHDRAWAL MONEY");
		heading.setBackground(Color.black);
		heading.setFont(new Font("Tahoma",1,16));
		heading.setForeground(Color.red);
		heading.setBounds(230,50,230,40);
		add(heading);
		
		//ENTER PIN LABEL
		pinLabel = new JLabel("Enter PIN");
		pinLabel.setBackground(Color.black);
		pinLabel.setFont(new Font("Tahoma",1,16));
		pinLabel.setForeground(Color.blue);
		pinLabel.setBounds(110,130,160,30);
		add(pinLabel);
		
		//ENTER PIN TEXTFIELD
		pinTxt = new JTextField();
		pinTxt.setBounds(290, 130, 220, 30);
		add(pinTxt);
		
		//Enter Amount LABEL
		amountLabel = new JLabel("Enter Amount");
		amountLabel.setBackground(Color.black);
		amountLabel.setFont(new Font("Tahoma",1,16));
		amountLabel.setForeground(Color.blue);
		amountLabel.setBounds(110,190,160,30);
		add(amountLabel);
		
		//Enter Amount TextField
		amountTxt= new JTextField();
		amountTxt.setBounds(290, 190, 220, 30);
		add(amountTxt);
		
		//Withdrawal BUTTON
		withdrawalBtn = new JButton("WITHDRAWAL");
		withdrawalBtn.setBackground(Color.black);
		withdrawalBtn.setFont(new Font("Tahoma",1,14));
		withdrawalBtn.setForeground(Color.white);
		withdrawalBtn.setBounds(140,270,150,30);
		add(withdrawalBtn);
		withdrawalBtn.addActionListener(this);
		
		//Cancel BUTTON
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setBackground(Color.black);
		cancelBtn.setFont(new Font("Tahoma",1,14));
		cancelBtn.setForeground(Color.white);
		cancelBtn.setBounds(320,270,150,30);
		add(cancelBtn);
		cancelBtn.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//If withdrawal button is selected
		if(e.getSource()==withdrawalBtn) {
			try {
				Connect cn = new Connect();
				String query = "select * from login where pin='"+pinTxt.getText()+"'";
				ResultSet rs = cn.st.executeQuery(query);
				if(rs.next()) {
					int bal = rs.getInt(3);
					//Updates amount if amount field is not empty
					if(!amountTxt.getText().isEmpty()) {
						amount = Integer.valueOf(amountTxt.getText());
					}else {
						JOptionPane.showMessageDialog(null, "Amount cannot be empty");
					}
					int rem_amt = bal-amount;
					//The amount you want to withdrawal cannot be greater than the current amount in you account
					if(bal>amount) {
						//Updates balance in login table
						String query1 = "update login set balance='"+rem_amt+"' where pin='"+pinTxt.getText()+"';";
						cn.st.executeUpdate(query1);
						
						JOptionPane.showMessageDialog(null, "Money Withdrawaled Succsessfully");
						pinTxt.setText("");
						amountTxt.setText("");
					}//When you try to withdrawal the amount which is greater than the current funds in your account
					else {
						JOptionPane.showMessageDialog(null, "Insufficient Funds");
					}
				}//If you have entered wrong PIN
				else {
					JOptionPane.showMessageDialog(null, "PIN is wrong");
				}
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}//If cancel button is selected it redirects to Transaction window by calling Transaction constructor
		else{
			setVisible(false);
			new Transaction();
		}

	}

}
