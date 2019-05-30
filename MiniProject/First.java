

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.sql.*;

public class First implements ActionListener{

	JFrame f;
	JLabel l;
	JButton btnNewButton,btnNewButton_1,btnNewButton_2;
	JMenu mnHelp,mnContactUs,mnExit,mnCalculator;
	JMenuItem mntmT_books,mntmT_students,mntmLibrarianDetails;
	JMenuBar menuBar;
	JMenuItem m1,mntmExit,mntmFineCalculator;
	String value1,value2,value3,value4,value5,value6,value7,value8;
	int i=0,j=0,k=0,L=0;
	public First() {
		f=new JFrame();
		f.getContentPane().setBackground(new Color(255, 240, 245));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 673, 368);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.getContentPane().setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		f.getContentPane().add(lblAdminLogin);
		lblAdminLogin.setForeground(new Color(255, 255, 255));
		lblAdminLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setBounds(56, 268, 143, 33);
		
		btnNewButton_1 = new JButton("");
		f.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon("E:\\java Image\\icon1.png"));
		btnNewButton_1.setBounds(56, 115, 143, 142);
		btnNewButton_1.addActionListener(this);
		
		JLabel lblLibrarianLogin = new JLabel("LIBRARIAN LOGIN");
		f.getContentPane().add(lblLibrarianLogin);
		lblLibrarianLogin.setForeground(new Color(255, 255, 255));
		lblLibrarianLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLibrarianLogin.setBounds(250, 268, 148, 33);
		
		btnNewButton_2 = new JButton("");
		f.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon("E:\\java Image\\icon2.png"));
		btnNewButton_2.setBounds(255, 115, 143, 142);
		btnNewButton_2.addActionListener(this);
		
		
		JLabel lblStudentLogin = new JLabel("STUDENT LOGIN");
		f.getContentPane().add(lblStudentLogin);
		lblStudentLogin.setForeground(new Color(0, 0, 0));
		lblStudentLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStudentLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentLogin.setBounds(448, 268, 143, 33);
		
		btnNewButton =new JButton();
		f.getContentPane().add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("E:\\java Image\\icon.png"));
		btnNewButton.setBounds(448, 115, 143, 142);
		btnNewButton.addActionListener(this);
		
		JLabel lblWelcomeToLibrary = new JLabel("WELCOME TO LIBRARY MANAGEMENT SYSTEM");
		lblWelcomeToLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		f.getContentPane().add(lblWelcomeToLibrary);
		lblWelcomeToLibrary.setForeground(new Color(144, 238, 144));
		lblWelcomeToLibrary.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblWelcomeToLibrary.setBackground(new Color(255, 0, 0));
		lblWelcomeToLibrary.setBounds(56, 48, 535, 41);
		
		l=new JLabel(new ImageIcon("E:\\java image\\Login.jpg"));
		l.setBounds(0,21,661,308);
		f.getContentPane().add(l);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 657, 21);
		f.getContentPane().add(menuBar);
		
		mnHelp = new JMenu("QUICK START");
		mnHelp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnHelp);
		
		mntmT_books = new JMenuItem("TOTAL NO. OF BOOKS");
		mnHelp.add(mntmT_books);
		mntmT_books.addActionListener(this);
		
		mntmT_students = new JMenuItem("TOTAL NO. OF STUDENTS");
		mnHelp.add(mntmT_students);
		mntmT_students.addActionListener(this);
		
		mntmLibrarianDetails = new JMenuItem("LIBRARIAN DETAILS");
		mnHelp.add(mntmLibrarianDetails);
		mntmLibrarianDetails.addActionListener(this);
		
		mnContactUs = new JMenu("TEAM MEMBERS");
		mnContactUs.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnContactUs);
		m1=new JMenuItem("DETAILS");
		mnContactUs.add(m1);
		m1.addActionListener(this);
		
		mntmFineCalculator = new JMenuItem("FINE CALCULATOR");
		mntmFineCalculator.setFont(new Font("Times New Roman", Font.BOLD, 15));
		menuBar.add(mntmFineCalculator);
		mntmFineCalculator.addActionListener(this);
		
		mntmExit = new JMenuItem("EXIT");
		mntmExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mntmExit);
		mntmExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnNewButton_1)
		{
			new ADMINLOGIN();
			f.dispose();
		}
		
		if(e.getSource()== btnNewButton_2)
		{
			new Librarian();
			f.dispose();
		}
			
	    if(e.getSource()== btnNewButton)
	    {
	    	new Student();
	    	f.dispose();
	    }
	    if(e.getSource()==m1)
	    {
	    	new TeamMembers();
	    	f.dispose();
	    }
	    if(e.getSource()==mntmExit)
	    {
	    	int a=javax.swing.JOptionPane.showConfirmDialog(null, "Would You Like To Exit",null, JOptionPane.YES_NO_OPTION);
	    	if(a==0)
	    	{
	    		f.dispose();
	    	}
	    }
	    if(e.getSource()==mntmFineCalculator)
	    {
	    	new FineCalculator();
	    	f.dispose();
	    }
		if(e.getSource()==mntmT_books)
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
			new Tbooks();
			Tbooks.textField.setText(i+"");
			Tbooks.textField_1.setText(j+"");
			 f.dispose();
		}
		if(e.getSource()==mntmLibrarianDetails)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/librarian", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String Str="select lib_name,lib_id,lib_gender,lib_phoneno,lib_address,lib_DOJoin from lib_info";
				PreparedStatement st=cn.prepareStatement(Str);
				ResultSet Rs=st.executeQuery();
				new TLib();
				while(Rs.next())
				{
					k++;
					String s1=Rs.getString("lib_name");
					String s2=Rs.getString("lib_id");
					String s3=Rs.getString("lib_gender");
					String s4=Rs.getString("lib_phoneno");
					String s5=Rs.getString("lib_address");
					String s6=Rs.getString("lib_DOJoin");
					TLib.dm.addRow(new Object[] {s1,s2,s3,s4,s5,s6});
					TLib.table.setModel(TLib.dm);
					f.dispose();
				}
				TLib.textField.setText(k+"");
				cn.close();
			}
			catch(Exception exc)
			{
				exc.getMessage();
			}
		}
		if(e.getSource()==mntmT_students)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/students", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="select Reg_date,Reg_no,s_name,s_branch,s_year,s_semester,s_Dob,s_facility,s_gender,s_fathername,s_mothername from stu_info";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				new TStu();
				while(rs.next())
				{
					L++;
					String val1=rs.getString("Reg_date");
					String val2=rs.getString("Reg_no");
					String val3=rs.getString("s_name");
					String val4=rs.getString("s_branch");
					String val5=rs.getString("s_year");
					String val6=rs.getString("s_semester");
					String val7=rs.getString("s_Dob");
					String val8=rs.getString("s_facility");
					String val9=rs.getString("s_gender");
					String val10=rs.getString("s_fathername");
					String val11=rs.getString("s_mothername");
					TStu.dm.addRow(new Object[] {val1,val2,val3,val4,val5,val6,val7,val8,val9,val10,val11});
					TStu.table.setModel(TStu.dm);
					f.dispose();
				}
				TStu.textField.setText(L+"");
				cn.close();
			}
			catch(Exception exc)
			{
				exc.getMessage();
			}
			
		}
	}	
}
