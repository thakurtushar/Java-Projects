

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class DbConnection implements ActionListener{

	JFrame f;
	public static JTextField textField;
	JButton btnConnect,btnCancel;
	public static JPasswordField passwordField;
	public DbConnection() {
		f=new JFrame("DATBASE CONNECTION");
		f.getContentPane().setBackground(new Color(173, 255, 47));
		f.getContentPane().setLayout(null);
		
		JLabel lblDatabaseUsername = new JLabel("DATABASE USERNAME");
		lblDatabaseUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDatabaseUsername.setBounds(35, 28, 185, 34);
		f.getContentPane().add(lblDatabaseUsername);
		
		JLabel lblDatbasePassword = new JLabel("DATABASE PASSWORD");
		lblDatbasePassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDatbasePassword.setBounds(35, 93, 185, 34);
		f.getContentPane().add(lblDatbasePassword);
		
		textField = new JTextField();
		textField.setBounds(230, 33, 185, 26);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnConnect = new JButton("CONNECT");
		btnConnect.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnConnect.setBounds(102, 159, 134, 34);
		f.getContentPane().add(btnConnect);
		btnConnect.addActionListener(this);
		btnCancel = new JButton("CANCEL");
		
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(255, 159, 119, 34);
		f.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 101, 185, 26);
		f.getContentPane().add(passwordField);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 502, 264);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnCancel)
		{
			f.dispose();
		}
		if(arg0.getSource()==btnConnect)
		{
			try
			{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost", textField.getText(), passwordField.getText());
					cn.close();
					new First();
					f.dispose();
			}
			catch(Exception e)
			{
				javax.swing.JOptionPane.showMessageDialog(null, "Database Could Not Be Connected");
			}
		}
		
	}
}
