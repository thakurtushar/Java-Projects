

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LIbFun implements ActionListener{
	JFrame f;
    int i=0,j=0;
	JButton btnNewButton,btnNewButton_1,btnNewButton_2,btnNewButton_3,btnNewButton_4,btnLogout,button;
	public LIbFun() {
		f=new JFrame("LIB FUNCTION");
		f.getContentPane().setBackground(new Color(240, 255, 255));
		f.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 17));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 739, 493);
		f.getContentPane().setLayout(null);
		
		JLabel lblLetsDoSome = new JLabel("LET'S DO SOME WORK!!!");
		lblLetsDoSome.setBackground(Color.WHITE);
		lblLetsDoSome.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblLetsDoSome.setHorizontalAlignment(SwingConstants.LEFT);
		lblLetsDoSome.setBounds(10, 11, 270, 33);
		f.getContentPane().add(lblLetsDoSome);
		
		btnNewButton = new JButton("New button");
		JLabel l1=new JLabel(new ImageIcon("E://java Image/icon3.png"));
		btnNewButton.add(l1);
		btnNewButton.setBounds(63, 55, 150, 124);
		btnNewButton.addActionListener(this);
		f.getContentPane().add(btnNewButton);
		
		JLabel lblIssueBooks = new JLabel("ISSUE BOOKS");
		lblIssueBooks.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIssueBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssueBooks.setBounds(63, 197, 150, 22);
		f.getContentPane().add(lblIssueBooks);
		
		btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon("E:\\java Image\\icon4.png"));
		btnNewButton_1.setBounds(286, 55, 150, 124);
		btnNewButton_1.addActionListener(this);
		f.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton();
		btnNewButton_2.setBounds(514, 55, 150, 124);
		btnNewButton_2.setIcon(new ImageIcon("E://java Image/icon7.png"));
		btnNewButton_2.addActionListener(this);
		f.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton();
		btnNewButton_3.setIcon(new ImageIcon("E:\\java Image\\icon6.png"));
		btnNewButton_3.setBounds(63, 256, 150, 124);
		btnNewButton_3.addActionListener(this);
		f.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton();
		JLabel l2=new JLabel(new ImageIcon("E://java Image/icon5.png"));
		btnNewButton_4.add(l2);
		btnNewButton_4.setBounds(286, 256, 150, 124);
		btnNewButton_4.addActionListener(this);
		f.getContentPane().add(btnNewButton_4);
		
		JLabel lblRetrunBooks = new JLabel("RETRUN BOOKS");
		lblRetrunBooks.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRetrunBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetrunBooks.setBounds(286, 197, 150, 22);
		f.getContentPane().add(lblRetrunBooks);
		
		JLabel lblUpdateBooks = new JLabel("BOOKS DETAILS");
		lblUpdateBooks.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUpdateBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateBooks.setBounds(514, 197, 150, 22);
		f.getContentPane().add(lblUpdateBooks);
		
		JLabel lblAddBooks = new JLabel("ADD BOOKS");
		lblAddBooks.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBooks.setBounds(63, 391, 150, 22);
		f.getContentPane().add(lblAddBooks);
		
		JLabel lblDeleteBooks = new JLabel("DELETE BOOKS");
		lblDeleteBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteBooks.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDeleteBooks.setBounds(286, 391, 150, 22);
		f.getContentPane().add(lblDeleteBooks);
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogout.setBounds(613, 431, 110, 23);
		btnLogout.addActionListener(this);
		f.getContentPane().add(btnLogout);
		
		button = new JButton("");
		JLabel z1=new JLabel(new ImageIcon("E:\\java Image\\icon8.png"));
		button.addActionListener(this);
		button.add(z1);
		button.setBounds(514, 256, 150, 124);
		f.getContentPane().add(button);
		
		JLabel lblStudentDetails = new JLabel("STUDENT DETAILS");
		lblStudentDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStudentDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentDetails.setBounds(514, 391, 150, 22);
		f.getContentPane().add(lblStudentDetails);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnLogout)
		{
			f.dispose();
			new First();
		}
		if(arg0.getSource()==btnNewButton_3)
		{
			String str="Create table if not exists Book_Detail(book_id varchar(50),book_name varchar(100),author_name varchar(100),Edition varchar(10),publisher_name varchar(100),No_of_pages int,price int,publishing_year int)";
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				Statement st1=cn.createStatement();
				String str1="create database if not exists books";
				st1.executeUpdate(str1);
				st1.executeUpdate("use books");
				st1.executeUpdate(str);
				addBook a1=new addBook();
				String str2="select * from book_detail ";
				PreparedStatement st2=cn.prepareStatement(str2);
				ResultSet rs=st2.executeQuery();
				while(rs.next())
				{
					String s1=rs.getString(1);
					String s2=rs.getString(2);
					String s3=rs.getString(3);
					String s4=rs.getString(4);
					String s5=rs.getString(5);
					String s6=rs.getString(6);
					String s7=rs.getString(7);
					String s8=rs.getString(8);
					addBook.dm.addRow(new Object[] {s1,s2,s3,s4,s5,s6,s7,s8});
					addBook.table.setModel(addBook.dm);
					f.dispose();
				}
				cn.close();
				
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		}
		if(arg0.getSource()==btnNewButton_4)
		{
			new DelBook();
			f.dispose();
		}
		if(arg0.getSource()==btnNewButton)
		{
			String STR1="create table if not exists issue(s_id varchar(50),book_id varchar(50) PRIMARY KEY,book_name varchar(100),issue_date varchar(100) not null)";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
				Statement st=cn.createStatement();
				String str="create database if not exists issueBooks";
				st.executeUpdate(str);
				st.executeUpdate("use issueBooks");
				st.executeUpdate(STR1);
				new IssueBook();
				f.dispose();
				cn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		if(arg0.getSource()==button)
		{
			new LStuDetail();
			f.dispose();
		}
		if(arg0.getSource()==btnNewButton_1)
		{
			new Returnbook();
			f.dispose();
		}
		if(arg0.getSource()==btnNewButton_2)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/books", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="select * from book_detail";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					 i++;
				}
				cn.close();
			}
			catch(Exception e1)
			{
				e1.getMessage();
			}
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/issuebooks", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str1="select * from issue";
				PreparedStatement st=cn.prepareStatement(str1);
				ResultSet rs1=st.executeQuery();
				while(rs1.next())
				{
					j++;
				}
				cn.close();
			}
			catch(Exception E)
			{
				E.getMessage();
			}
			new LBookDetail();
			LBookDetail.textField.setText(i+"");
			LBookDetail.textField_1.setText(j+"");
			 f.dispose();
		}
	}
}
