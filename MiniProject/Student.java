

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Student implements ActionListener {

	JFrame f;
	JButton btnNewUser;
	JButton btnRegisteredStudent;
	private JButton btnBack;
	public Student() {
		f=new JFrame("Student Login");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 533, 300);
		f.getContentPane().setLayout(null);
		
		btnNewUser = new JButton("");
		btnNewUser.setIcon(new ImageIcon("E:\\java Image\\student_add-128.png"));
		btnNewUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewUser.setBounds(280, 56, 153, 138);
		f.getContentPane().add(btnNewUser);
		btnNewUser.addActionListener(this);
		
		btnRegisteredStudent = new JButton("");
		btnRegisteredStudent.setIcon(new ImageIcon("E:\\java Image\\iconfinder_Student-3_379383.png"));
		btnRegisteredStudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnRegisteredStudent.setBounds(75, 56, 153, 138);
		f.getContentPane().add(btnRegisteredStudent);
		btnRegisteredStudent.addActionListener(this);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(412, 238, 105, 23);
		f.getContentPane().add(btnBack);
		
		JLabel lblRegisteredStudent = new JLabel("REGISTERED STUDENT");
		lblRegisteredStudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRegisteredStudent.setForeground(new Color(0, 255, 0));
		lblRegisteredStudent.setBounds(67, 205, 180, 25);
		f.getContentPane().add(lblRegisteredStudent);
		
		JLabel lblNewStudent = new JLabel("NEW STUDENT");
		lblNewStudent.setForeground(Color.GREEN);
		lblNewStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewStudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewStudent.setBounds(280, 204, 153, 23);
		f.getContentPane().add(lblNewStudent);
		JLabel l=new JLabel(new ImageIcon("E:\\java image\\3.jpg"));
		l.setBounds(0, 0, 517, 261);
		f.getContentPane().add(l);
		btnBack.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnNewUser)
		{
			String str1="create table if not exists stu_info (Reg_date varchar(100) not null, Reg_no varchar(20) not null primary key,s_name varchar(50) not null,s_password varchar(30) not null,s_branch varchar(50) not null,s_year varchar(10) not null,s_semester varchar(20) not null,s_Dob varchar(20) not null,s_address varchar(100) not null,s_category varchar(50) not null,s_facility varchar(20) not null,s_nationality varchar(20) not null,s_religion varchar(20) not null,s_fathername varchar(50) not null,s_mothername varchar(50) not null,s_familyincome varchar(20) not null,s_image LONGBLOB NOT NULL,s_gender varchar(10) not null )";
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
				Statement st=cn.createStatement();
				String str="create database if not exists students";
				st.executeUpdate(str);
				st.executeUpdate("use students");
				st.executeUpdate(str1);
				
			}
			catch(Exception e1)
			{
				javax.swing.JOptionPane.showMessageDialog(null, "NO CONNECTION FROM DATABASE");
			}
			new Form();
			f.setVisible(false);
		}
		if(e.getSource()==btnRegisteredStudent)
		{
			new Registered();
			f.setVisible(false);
		}
		if(e.getSource()== btnBack)
		{
			f.dispose();
			new First();
		}
			
	}
}
