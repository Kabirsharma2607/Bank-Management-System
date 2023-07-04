import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class login extends JFrame implements ActionListener {
	JLabel heading, cardNumber, pin;
	JTextField cardNumberTxt, pinTxt, t3;
	JButton signIn, clear, signUp;
	ResultSet rs;

	public login() {
		super("BANK MANAGEMENT SYSTEM");
		setBounds(150, 120, 860, 484);
		setLayout(null);

		// HEADING Label
		heading = new JLabel("WELCOME TO NK BANK");
		heading.setBackground(Color.black);
		heading.setFont(new Font("Tahoma", 1, 22));
		heading.setForeground(Color.BLACK);
		heading.setBounds(330, 30, 460, 50);
		add(heading);

		// Card number Label
		cardNumber = new JLabel("Card NO.");
		cardNumber.setBackground(Color.black);
		cardNumber.setFont(new Font("Tahoma", 1, 16));
		cardNumber.setForeground(Color.blue);
		cardNumber.setBounds(230, 130, 100, 30);
		add(cardNumber);

		// Card number TextField
		cardNumberTxt = new JTextField();
		cardNumberTxt.setBounds(370, 130, 290, 30);
		add(cardNumberTxt);

		// PIN NO. Label
		pin = new JLabel("PIN NO.");
		pin.setBackground(Color.black);
		pin.setFont(new Font("Tahoma", 1, 16));
		pin.setForeground(Color.blue);
		pin.setBounds(230, 210, 100, 30);
		add(pin);

		// PIN No. TextField
		pinTxt = new JTextField();
		pinTxt.setBounds(370, 210, 290, 30);
		add(pinTxt);

		// SIGN IN button
		signIn = new JButton("SIGN IN");
		signIn.setBackground(Color.black);
		signIn.setFont(new Font("Tahoma", 1, 16));
		signIn.setForeground(Color.white);
		signIn.setBounds(290, 290, 110, 30);
		add(signIn);
		signIn.addActionListener(this);

		// CLEAR BUTTON
		clear = new JButton("CLEAR");
		clear.setBackground(Color.black);
		clear.setFont(new Font("Tahoma", 1, 16));
		clear.setForeground(Color.white);
		clear.setBounds(450, 290, 110, 30);
		add(clear);
		clear.addActionListener(this);

		// SIGN UP BUTTON
		signUp = new JButton("SIGN UP");
		signUp.setBackground(Color.black);
		signUp.setFont(new Font("Tahoma", 1, 16));
		signUp.setForeground(Color.white);
		signUp.setBounds(290, 340, 280, 40);
		add(signUp);
		signUp.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Connect cn = new Connect();
		if (e.getSource() == signIn) {
			try {
				String query = "select * from signup3 where cardNo='" + cardNumberTxt.getText() + "' and pin='" + pinTxt.getText()
						+ "';";
				rs = cn.st.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transaction();
				} else {
					JOptionPane.showMessageDialog(null, "Your Card No. or PIN is incorrect");
					cardNumberTxt.setText("");
					pinTxt.setText("");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource() == clear) {
			cardNumberTxt.setText("");
			pinTxt.setText("");
		} else if (e.getSource() == signUp) {
			setVisible(false);
			new signup1();
		}

	}
}
