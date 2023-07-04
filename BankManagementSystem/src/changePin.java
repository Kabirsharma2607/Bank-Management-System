import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class changePin extends JFrame implements ActionListener{
	
	JLabel heading,oldPINLabel,newPINLabel,reEnterNewPINLabel;
	JTextField enterOldPINTxt,enterNewPINTxt,reEnterNewPINTxt;
	JButton changeBtn,cancelBtn;

	public changePin() {
		super("CHANGE PIN");
		setBounds(150,80,680,554);
		setLayout(null);
		
		//Heading
		heading = new JLabel("CHANGE THE PIN");
		heading.setBackground(Color.black);
		heading.setFont(new Font("Tahoma",1,16));
		heading.setForeground(Color.blue);
		heading.setBounds(190,50,230,40);
		add(heading);
		
		//Old PIN label
		oldPINLabel = new JLabel("Enter old PIN:");
		oldPINLabel.setBackground(Color.black);
		oldPINLabel.setFont(new Font("Tahoma",1,16));
		oldPINLabel.setForeground(Color.blue);
		oldPINLabel.setBounds(120,130,160,30);
		add(oldPINLabel);
		
		//Old PIN TextField
		enterOldPINTxt = new JTextField();
		enterOldPINTxt.setBounds(290, 130, 220, 30);
		add(enterOldPINTxt);
		
		//New PIN Label
		newPINLabel = new JLabel("Enter new PIN:");
		newPINLabel.setBackground(Color.black);
		newPINLabel.setFont(new Font("Tahoma",1,16));
		newPINLabel.setForeground(Color.blue);
		newPINLabel.setBounds(120,180,230,40);
		add(newPINLabel);
		
		//New PIN TextField
		enterNewPINTxt = new JTextField();
		enterNewPINTxt.setBounds(290, 190, 220, 30);
		add(enterNewPINTxt);
		
		//re-Enter new PIN Label
		reEnterNewPINLabel = new JLabel("Re-Enter New PIN:");
		reEnterNewPINLabel.setBackground(Color.black);
		reEnterNewPINLabel.setFont(new Font("Tahoma",1,16));
		reEnterNewPINLabel.setForeground(Color.blue);
		reEnterNewPINLabel.setBounds(120,250,160,30);
		add(reEnterNewPINLabel);
		
		//Re-Enter new PIN TextField
		reEnterNewPINTxt = new JTextField();
		reEnterNewPINTxt.setBounds(290, 250, 220, 30);
		add(reEnterNewPINTxt);
		
		//Change Button
		changeBtn = new JButton("CHANGE");
		changeBtn.setBackground(Color.black);
		changeBtn.setFont(new Font("Tahoma",1,16));
		changeBtn.setForeground(Color.white);
		changeBtn.setBounds(140,320,110,30);
		add(changeBtn);
		changeBtn.addActionListener(this);

		//Cancel Button
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setBackground(Color.black);
		cancelBtn.setFont(new Font("Tahoma",1,16));
		cancelBtn.setForeground(Color.white);
		cancelBtn.setBounds(280,320,110,30);
		add(cancelBtn);
		cancelBtn.addActionListener(this);
		
	
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Connect cn = new Connect();
			String query = "select * from signup3 where pin='" + enterOldPINTxt.getText()+"';";
			ResultSet rs = cn.st.executeQuery(query);
			//If change button is selected
			if(e.getSource()==changeBtn) {
				if(rs.next()) {
					//The length of PIN should be 4 digits only
					if(enterNewPINTxt.getText().length()==4) {
						//If new PIN and Re-Enter new PIN matches
						if(enterNewPINTxt.getText().equals(reEnterNewPINTxt.getText())) {
							//Updates pin in signup3 table
							String query1 = "update signup3 set pin='" +enterNewPINTxt.getText()+"' where pin='"+enterOldPINTxt.getText()+"';";
							cn.st.executeUpdate(query1);
							
							//Updates pin in login table
							String query2 = "update login set pin='" +enterNewPINTxt.getText()+"' where pin='"+enterOldPINTxt.getText()+"';";
							cn.st.executeUpdate(query2);
							JOptionPane.showMessageDialog(null, "PIN changed successfully");
							enterOldPINTxt.setText("");
							enterNewPINTxt.setText("");
							reEnterNewPINTxt.setText("");
							setVisible(false);
							new Transaction();
						}//If new PIN and Re-Entered new PINs doesn't match
						else {
							JOptionPane.showMessageDialog(null, "PIN Doesn't match");
						}
					}//Checks that length of PIN should be 4
					else {
						JOptionPane.showMessageDialog(null, "Check your PIN length");
					}
				}//If wrong old PIN is enteref
				else {
					JOptionPane.showMessageDialog(null, "You have entered wrong PIN");
				}
			}//If cancel button is selected it redirects to Transaction page by calling Transaction Constructor
			else if(e.getSource()==cancelBtn) {
				setVisible(false);
				new Transaction();
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}
