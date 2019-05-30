
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class LBookDetail  implements ActionListener{
	JFrame f;
	public static JTextField textField;
	public static DefaultTableModel dm,dm1;
	public static JTextField textField_1;
	public static JTable table,table1;
	JButton btnBack;
	JScrollPane js,js1;
	private JButton btnTotalBooks;
	private JButton btnIssuedBooksDetails;
	public LBookDetail() {
		f=new JFrame("Book Details");
		f.getContentPane().setBackground(new Color(204, 255, 153));
		f.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 102, 51));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText(DateFormat.getDateTimeInstance().format(new Date()));
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label.setBounds(447, 28, 219, 31);
		f.getContentPane().add(label);
		
		JLabel lblTotalNoOf = new JLabel("TOTAL NO. OF BOOKS IN LIBRARY");
		lblTotalNoOf.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalNoOf.setBounds(39, 66, 276, 31);
		f.getContentPane().add(lblTotalNoOf);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(356, 72, 164, 20);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalNoOf_1 = new JLabel("TOTAL NO. OF BOOKS ISSUED");
		lblTotalNoOf_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalNoOf_1.setBounds(39, 128, 276, 31);
		f.getContentPane().add(lblTotalNoOf_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(356, 134, 164, 20);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		dm=new DefaultTableModel(new String[] {"BOOK ID","BOK NAME","AUTHOR NAME","EDITION","PUBLICATION","PRICE","NO OF PAGES","PUBLISHING YEAR"},0);
		table = new JTable();
		js=new JScrollPane(table);
		js.setVisible(false);
		table.setEnabled(false);
		js.setBounds(39, 227, 627, 134);
		f.getContentPane().add(js);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(601, 548, 89, 23);
		f.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		
		dm1=new DefaultTableModel(new String[] {"ISSUED TO","BOOK ID","BOK NAME","DATE AND TIME OF ISSUE"},0);
		table1 = new JTable();
		js1=new JScrollPane(table1);
		js1.setVisible(false);
		table1.setEnabled(false);
		js1.setBounds(39, 399, 627, 134);
		f.getContentPane().add(js1);
		
		btnTotalBooks = new JButton("TOTAL BOOKS DETAILS");
		btnTotalBooks.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnTotalBooks.setBounds(41, 193, 233, 23);
		f.getContentPane().add(btnTotalBooks);
		btnTotalBooks.addActionListener(this);
		
		btnIssuedBooksDetails = new JButton("ISSUED BOOKS DETAILS");
		btnIssuedBooksDetails.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnIssuedBooksDetails.setBounds(39, 372, 235, 23);
		f.getContentPane().add(btnIssuedBooksDetails);
		btnIssuedBooksDetails.addActionListener(this);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 706, 610);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnBack)
		{
			f.dispose();
			new First();
		}
		if(e.getSource()==btnTotalBooks)
		{
			js.setVisible(true);
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/books", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="select * from book_detail";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					 String value1=rs.getString("book_id");
					 String value2=rs.getString("book_name");
					 String value3=rs.getString("author_name");
					 String value4=rs.getString("Edition");
					 String value5=rs.getString("publisher_name");
					 String value6=rs.getString("No_of_pages");
					 String value7=rs.getString("price");
					 String value8=rs.getString("publishing_year");
					 dm.addRow(new Object[] {value1,value2,value3,value4,value5,value7,value6,value8});
					 table.setModel(dm);
				}
			}
			catch(Exception e1)
			{
				e1.getMessage();
			}
			
		}
		if(e.getSource()==btnIssuedBooksDetails)
		{
			js1.setVisible(true);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/issuebooks", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str1="select * from issue";
				PreparedStatement st=cn.prepareStatement(str1);
				ResultSet rs1=st.executeQuery();
				while(rs1.next())
				{
					String s1=rs1.getString("s_id");
					String s2=rs1.getString("book_id");
					String s3=rs1.getString("book_name");
					String s4=rs1.getString("issue_date");
					dm1.addRow(new Object[] {s1,s2,s3,s4});
					table1.setModel(dm1);
				}
				cn.close();
			}
			catch(Exception E)
			{
				E.getMessage();
			}
		}
	}

	

}
