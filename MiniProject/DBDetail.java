

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DBDetail implements ActionListener {
		
	JFrame f;
	public static JTextField textField;
	public static JTextField textField_1;
	private JLabel lblBookName;
	public static JTextField textField_2;
	private JLabel lblPrice;
	public static JTextField textField_3;
	private JLabel lblAuthorName;
	public static JTextField textField_4;
	private JLabel lblNoOfPages;
	public static JTextField textField_5;
	private JLabel lblEdition;
	public static JTextField textField_6;
	private JLabel lblYearOfPublication;
	public static JTextField textField_7;
	public static JTable table;
	JButton btnBack,btnCancel,btnDelete,btnEdit;
	public static JScrollPane js;
	public static DefaultTableModel dm;
	int i=0;
	public  DBDetail() {
		f=new JFrame("DELETE BOOKS");
		f.getContentPane().setBackground(new Color(219, 112, 147));
		f.getContentPane().setLayout(null);
		
		JLabel lblBookId = new JLabel("BOOK ID");
		lblBookId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBookId.setBounds(45, 35, 108, 33);
		f.getContentPane().add(lblBookId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(176, 36, 191, 33);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPublication = new JLabel("PUBLICATION");
		lblPublication.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPublication.setBounds(426, 35, 108, 33);
		f.getContentPane().add(lblPublication);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(599, 36, 191, 33);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblBookName = new JLabel("BOOK NAME");
		lblBookName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBookName.setBounds(45, 107, 108, 33);
		f.getContentPane().add(lblBookName);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(176, 108, 191, 33);
		f.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPrice.setBounds(426, 107, 85, 33);
		f.getContentPane().add(lblPrice);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(599, 108, 191, 33);
		f.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblAuthorName = new JLabel("AUTHOR NAME");
		lblAuthorName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAuthorName.setBounds(45, 181, 123, 33);
		f.getContentPane().add(lblAuthorName);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(176, 182, 191, 33);
		f.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblNoOfPages = new JLabel("NO OF PAGES");
		lblNoOfPages.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNoOfPages.setBounds(426, 181, 128, 33);
		f.getContentPane().add(lblNoOfPages);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(599, 182, 191, 33);
		f.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		lblEdition = new JLabel("EDITION");
		lblEdition.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEdition.setBounds(45, 250, 85, 33);
		f.getContentPane().add(lblEdition);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(176, 251, 191, 33);
		f.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		lblYearOfPublication = new JLabel("YEAR OF PUBLICATION");
		lblYearOfPublication.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblYearOfPublication.setBounds(426, 250, 178, 33);
		f.getContentPane().add(lblYearOfPublication);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(599, 251, 191, 33);
		f.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		dm=new DefaultTableModel(new String[] {"BOOK ID","BOOK NAME","AUTHOR NAME","EDITION","PUBLICATION","NO OF PAGES","PRICE","PUBLISHING YEAR"},0);
		table = new JTable();
		table.setEnabled(false);
		js=new JScrollPane(table);
		js.setBounds(45, 307, 745, 150);
		f.getContentPane().add(js);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.setBounds(218, 480, 108, 34);
		f.getContentPane().add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnCancel = new JButton("UPDATE");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(492, 480, 108, 34);
		f.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(760, 502, 85, 23);
		f.getContentPane().add(btnBack);
		
		btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEdit.setBounds(350, 480, 108, 34);
		f.getContentPane().add(btnEdit);
		btnEdit.addActionListener(this);
		btnBack.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setBounds(10,10,861,564);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnBack)
		{
			new DelBook();
			f.dispose();
		}
		if(arg0.getSource()==btnCancel)
		{
			try 
			{
				String value1=textField.getText();
				String value2=textField_1.getText();
				String value3=textField_2.getText();
				int value4=Integer.parseInt(textField_3.getText());
				String value5=textField_4.getText();
				int value6=Integer.parseInt(textField_5.getText());
				String value7=textField_6.getText();
				int value8=Integer.parseInt(textField_7.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost/books", DbConnection.textField.getText(),DbConnection.passwordField.getText());
				String STR="update book_detail SET book_id='"+value1+"',book_name='"+value3+"',author_name='"+value5+"',Edition='"+value7+"',publisher_name='"+value2+"',No_of_pages='"+value6+"',price='"+value4+"',publishing_year='"+value8+"' WHERE book_id='"+DelBook.s+"'";
				PreparedStatement ST=c1.prepareStatement(STR);
				ST.executeUpdate();
				dm.setRowCount(0);
				String str1="select * from book_detail ";
				PreparedStatement st1=c1.prepareStatement(str1);
				{
					//st1.setString(1, s);
					ResultSet rs=st1.executeQuery();
					while(rs.next())
					{
						String s1=rs.getString(1);
						String s2=rs.getString(2);
						String s3=rs.getString(3);
						String s4=rs.getString(4);
						String s5=rs.getString(5);
						int s6=rs.getInt(6);
						int s7=rs.getInt(7);
						int s8=rs.getInt(8);
							dm.addRow(new Object[] {s1,s2,s3,s4,s5,s6,s7,s8});
							table.setModel(dm);
					}
				}
				c1.close();
				javax.swing.JOptionPane.showMessageDialog(null, "Data Updated!!!");
				textField.setEditable(false);
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				textField_4.setEditable(false);
				textField_5.setEditable(false);
				textField_6.setEditable(false);
				textField_7.setEditable(false);
			} 
			catch (Exception E) 
			{
				System.out.print(E.getMessage());
			} 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn1=DriverManager.getConnection("jdbc:mysql://localhost/issueBooks", DbConnection.textField.getText(),DbConnection.passwordField.getText());
				String Str1="update issue set book_id=?,book_name=? where book_id='"+DelBook.s+"'";
				PreparedStatement st1=cn1.prepareStatement(Str1);
				st1.setString(1, textField.getText());
				st1.setString(2, textField_2.getText());
				st1.executeUpdate();
				cn1.close();
			}
			catch(Exception EXC)
			{
				EXC.getMessage();
			}
			
		}
		if(arg0.getSource()==btnDelete)
		{
			String S=DelBook.textField.getText();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/issuebooks", "root", "tushar@123");
				String str="select book_id from issue where book_id='"+S+"'";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					String value=rs.getString("book_id");
					if(value.equals(S))
					{
						i++;
					}
				}
				if(i==0)
				{
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn1=DriverManager.getConnection("jdbc:mysql://localhost/books", "root", "tushar@123");
					String str1="delete from book_detail where book_id=?";
					PreparedStatement st1=cn1.prepareStatement(str1);
					{
						st1.setString(1, S);
						st1.executeUpdate();
					}
					javax.swing.JOptionPane.showMessageDialog(null,"Data Deleted!!!!");
					f.dispose();
					new DelBook();
				}
					catch(Exception e)
					{
						javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
					}}
				else
					javax.swing.JOptionPane.showMessageDialog(null,"Book Cannot be Deleted!!!!");
				cn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		if(arg0.getSource()==btnEdit)
		{
			textField.setEditable(true);
			textField_1.setEditable(true);
			textField_2.setEditable(true);
			textField_3.setEditable(true);
			textField_4.setEditable(true);
			textField_5.setEditable(true);
			textField_6.setEditable(true);
			textField_7.setEditable(true);
		}
	}
}
