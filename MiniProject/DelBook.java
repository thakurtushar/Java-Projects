

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DelBook implements ActionListener {

	JFrame f;
	JButton btnSearch,btnCancel,btnBack;
	public static JTextField textField;
	public static String s;
	String s1,s2,s3,s4,s5;
	int s6,s7,s8;
	public static JTextField textField_1;
	public DelBook() {
		f=new JFrame("DELETE BOOKS");
		f.getContentPane().setBackground(new Color(255, 255, 224));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 531, 255);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		
		JLabel lblEnterBookId = new JLabel("BOOK ID");
		lblEnterBookId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterBookId.setForeground(new Color(0, 0, 0));
		lblEnterBookId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEnterBookId.setBounds(34, 47, 143, 35);
		f.getContentPane().add(lblEnterBookId);
		
		textField = new JTextField();
		textField.setBounds(228, 52, 233, 35);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(426, 193, 89, 23);
		f.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setBounds(125, 134, 106, 35);
		f.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(269, 134, 106, 35);
		f.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnBack)
		{
			new LIbFun();
			f.dispose();
		}
		if(arg0.getSource()==btnCancel)
		{
			textField.setText("");
		}
		if(arg0.getSource()==btnSearch)
		{
			s=textField.getText();
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/books", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="select * from book_detail where book_id=?";
				PreparedStatement st=cn.prepareStatement(str);
				{
					st.setString(1, s);
						ResultSet rs=st.executeQuery();
						while(rs.next())
						{
							s1=rs.getString(1);
							s2=rs.getString(2);
							s3=rs.getString(3);
							s4=rs.getString(4);
							s5=rs.getString(5);
							s6=rs.getInt(6);
							s7=rs.getInt(7);
							s8=rs.getInt(8);
							new DBDetail();
							DBDetail.textField.setText(s1);
							DBDetail.textField_2.setText(s2);
							DBDetail.textField_4.setText(s3);
							DBDetail.textField_6.setText(s4);
							DBDetail.textField_1.setText(s5);
							DBDetail.textField_5.setText(s6+"");
							DBDetail.textField_3.setText(s7+"");
							DBDetail.textField_7.setText(s8+"");
							f.dispose();
						}	
					}
				cn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn1=DriverManager.getConnection("jdbc:mysql://localhost/books", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str1="select * from book_detail";
				PreparedStatement st1=cn1.prepareStatement(str1);
				ResultSet rs1=st1.executeQuery();
				while(rs1.next())
				{
					String S1=rs1.getString(1);
					String S2=rs1.getString(2);
					String S3=rs1.getString(3);
					String S4=rs1.getString(4);
					String S5=rs1.getString(5);
					String S6=rs1.getString(6);
					String S7=rs1.getString(7);
					String S8=rs1.getString(8);
					DBDetail.dm.addRow(new Object[] {S1,S2,S3,S4,S5,S6,S7,S8});
					DBDetail.table.setModel(DBDetail.dm);
					f.dispose();
				}
				cn1.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		}
	}
}
