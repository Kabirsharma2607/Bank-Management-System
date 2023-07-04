import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class deposit extends JFrame implements ActionListener{
	JLabel pinLabel,amountLabel,l3;
	JTextField pinTextfield,amountTextfield,t3;
	JButton depositBtn,cancelBtn,exitBtn;
	int bal;
	
	public deposit() {
		super("DEPOSIT");
		setBounds(150, 80, 680, 554);
		setLayout(null);
		
		//Enter PIN Label
		pinLabel = new JLabel("Enter PIN:");
		pinLabel.setBackground(Color.black);
		pinLabel.setFont(new Font("Tahoma",1,13));
		pinLabel.setForeground(Color.red);
		pinLabel.setBounds(460, 10, 90, 20);
		add(pinLabel);
		
		//PIN TextField
		pinTextfield = new JTextField();
		pinTextfield.setBounds(530, 10, 70, 20);
		add(pinTextfield);
		
		//Enter amount Label
		amountLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT:");
		amountLabel.setBackground(Color.black);
		amountLabel.setFont(new Font("Tahoma",1,16));
		amountLabel.setForeground(Color.blue);
		amountLabel.setBounds(150,40,400,40);
		add(amountLabel);
		
		//Enter Amount TextField
		amountTextfield = new JTextField();
		amountTextfield.setBounds(180, 130, 280, 40);
		add(amountTextfield);
		
		//Deposit Button
		depositBtn = new JButton("DEPOSIT");
		depositBtn.setBackground(Color.black);
		depositBtn.setFont(new Font("Tahoma",1,16));
		depositBtn.setForeground(Color.white);
		depositBtn.setBounds(180,220,120,30);
		add(depositBtn);
		depositBtn.addActionListener(this);
		
		//Cancel Button
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setBackground(Color.black);
		cancelBtn.setFont(new Font("Tahoma",1,16));
		cancelBtn.setForeground(Color.white);
		cancelBtn.setBounds(330,220,130,30);
		add(cancelBtn);
		cancelBtn.addActionListener(this);
		
		//Exit Button
		exitBtn = new JButton("EXIT");
		exitBtn.setBackground(Color.black);
		exitBtn.setFont(new Font("Tahoma",1,16));
		exitBtn.setForeground(Color.white);
		exitBtn.setBounds(250,290,130,30);
		add(exitBtn);
		exitBtn.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			Connect cn = new Connect();
			//Checks if deposit button is selected
			if(e.getSource()==depositBtn) {
				//Check that amount and pin should not be empty 
				if(pinTextfield.getText().equals("") || amountTextfield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field should not be empty");
				}//Executes if the fields are not empty
				else {
					bal= Integer.valueOf(amountTextfield.getText());
					String query = "update login set balance='" +bal+"'where pin ='" + pinTextfield.getText()+ "';";
					int result = cn.st.executeUpdate(query);
					//If correct pin is entered
					if(result == 1) {
						JOptionPane.showMessageDialog(null, "Amount Deposited Successfully");
						pinTextfield.setText("");
						amountTextfield.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Please check your pin");
					}
				}
			}//Checks if cancel button is selected it goes back to the transaction page by calling Transaction constructor
			else if(e.getSource()==cancelBtn) {
				setVisible(false);
				new Transaction();
			}//Checks if exit button is selected it closes the window
			else if(e.getSource()==exitBtn) {
				System.exit(0);
			}
			
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}

}
