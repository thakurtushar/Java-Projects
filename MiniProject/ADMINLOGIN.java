

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ADMINLOGIN implements ActionListener {
	JFrame f;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnSave;
	JButton button;
	JButton btnCancel;
	String str1,str2,str3;
	private JRadioButton rdbtnRegisteredUser,rdbtnNewAdmin;
	
	public ADMINLOGIN() {
		f=new JFrame("Admin Login");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 528, 310);
		
		btnSave = new JButton("LOGIN");
		btnSave.setBounds(105, 209, 113, 35);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.addActionListener(this);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(270, 209, 113, 35);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.addActionListener(this);
		
		button = new JButton("BACK");
		button.setBounds(423, 248, 89, 23);
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setForeground(Color.BLACK);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(225, 73, 226, 29);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setBounds(225, 135, 226, 29);
		button.addActionListener(this);
		f.getContentPane().setLayout(null);
		f.getContentPane().add(btnSave);
		f.getContentPane().add(btnCancel);
		f.getContentPane().add(button);
		f.getContentPane().add(textField);
		f.getContentPane().add(passwordField);
		
		rdbtnRegisteredUser = new JRadioButton("REGISTERED USER");
		rdbtnRegisteredUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnRegisteredUser.setBounds(256, 18, 176, 23);
		f.getContentPane().add(rdbtnRegisteredUser);
		rdbtnRegisteredUser.addActionListener(this);
		
		rdbtnNewAdmin = new JRadioButton("NEW ADMIN");
		rdbtnNewAdmin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnNewAdmin.setForeground(new Color(0, 0, 0));
		rdbtnNewAdmin.setBounds(92, 18, 126, 23);
		f.getContentPane().add(rdbtnNewAdmin);
		rdbtnNewAdmin.addActionListener(this);
		
		ButtonGroup g1=new ButtonGroup();
		g1.add(rdbtnRegisteredUser);
		g1.add(rdbtnNewAdmin);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		f.getContentPane().add(lblPassword);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(69, 134, 103, 29);
		
		JLabel lblAdminId = new JLabel("ADMIN ID");
		f.getContentPane().add(lblAdminId);
		lblAdminId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAdminId.setBounds(69, 72, 103, 29);
		
		JLabel l=new JLabel(new ImageIcon("E:\\java image\\4.jpg"));
		l.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l.setBackground(new Color(0, 0, 0));
		l.setBounds(0, 0, 512, 271);
		f.getContentPane().add(l); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{
			f.dispose();
			new First();
			
		}
		if(e.getSource()== btnSave)
		{
			int i=0;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/admin",DbConnection.textField.getText(),DbConnection.passwordField.getText());
				String str="select a_id,a_pswd from a_info";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
				    str1=rs.getString(1);
					str2=rs.getString(2);
					str3=textField.getText();
					String str4=String.valueOf(passwordField.getPassword());
					if(str1.equals(str3) && str2.equals(str4))
					{
						i++;
					}
				}
				if(i!=0)
				{
					new ADMIN();
					f.dispose();
				}
				else
				{
					
					javax.swing.JOptionPane.showMessageDialog(null, "PLEASE ENTER ID & PASSWORD AGAIN");
					textField.setText(null);
					passwordField.setText(null);
				}
				 cn.close();
			}
			catch(Exception e1)
			{
				javax.swing.JOptionPane.showMessageDialog(null, "NO CONNECTION FROM DATABASE!!");
			}
		}
		if(e.getSource()==btnCancel)
		{
			textField.setText("");
			passwordField.setText("");
		}
		if(rdbtnRegisteredUser.isSelected())
		{
			textField.setEditable(true);
			passwordField.setEditable(true);
		}
		if(rdbtnNewAdmin.isSelected())
		{
			String str1="create table if not exists a_info(a_name varchar(100) not null,a_id varchar(50) not null,a_pswd varchar(50),date varchar(200) not null, a_address varchar(200) not null,a_image longblob not null)";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="create database if not exists admin";
				Statement st=cn.createStatement();
				st.executeUpdate(str);
				st.executeUpdate("use admin");
				st.executeUpdate(str1);
				new AdminRegistration();
				f.dispose();
				cn.close();
			}
			catch(Exception E1)
			{
				E1.getMessage();
			}
		}
}
}
