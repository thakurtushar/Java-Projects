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

public class addBook implements ActionListener  {

	JFrame f;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	JButton btnSave,btnAdd,btnExit;
	static public JTable table;
	public static DefaultTableModel dm;
	String s,s1,s2,s3,s4,s5;
	int s8=0;
	int s7=0;
	int s6=0;
	public addBook() {
		f=new JFrame("ADD BOOKS");
		f.getContentPane().setBackground(new Color(188, 143, 143));
		f.setForeground(Color.WHITE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 813, 498);
		f.getContentPane().setLayout(null);
		
		JLabel lblBookId = new JLabel("BOOK ID");
		lblBookId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBookId.setBounds(29, 37, 98, 29);
		f.getContentPane().add(lblBookId);
		
		textField = new JTextField();
		textField.setBounds(176, 38, 175, 29);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBookName = new JLabel("BOOK NAME");
		lblBookName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBookName.setBounds(29, 99, 98, 29);
		f.getContentPane().add(lblBookName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 100, 175, 29);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAuthorName = new JLabel("AUTHOR NAME");
		lblAuthorName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAuthorName.setBounds(29, 156, 98, 29);
		f.getContentPane().add(lblAuthorName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 157, 175, 29);
		f.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPublisherName = new JLabel("PUBLISHER NAME");
		lblPublisherName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPublisherName.setBounds(405, 37, 115, 29);
		f.getContentPane().add(lblPublisherName);
		
		textField_3 = new JTextField();
		textField_3.setBounds(562, 38, 208, 29);
		f.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNoOfPages = new JLabel("NO. OF PAGES");
		lblNoOfPages.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNoOfPages.setBounds(405, 99, 115, 29);
		f.getContentPane().add(lblNoOfPages);
		
		textField_4 = new JTextField();
		textField_4.setBounds(562, 100, 208, 29);
		f.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPrice.setBounds(405, 156, 98, 29);
		f.getContentPane().add(lblPrice);
		
		textField_5 = new JTextField();
		textField_5.setBounds(562, 157, 208, 29);
		f.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEdition = new JLabel("EDITION");
		lblEdition.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEdition.setBounds(29, 213, 98, 29);
		f.getContentPane().add(lblEdition);
		
		textField_6 = new JTextField();
		textField_6.setBounds(176, 214, 175, 29);
		f.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblYearOfPublishing = new JLabel("YEAR OF PUBLISHING");
		lblYearOfPublishing.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblYearOfPublishing.setBounds(405, 213, 146, 29);
		f.getContentPane().add(lblYearOfPublishing);
		
		textField_7 = new JTextField();
		textField_7.setBounds(562, 214, 208, 29);
		f.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		btnAdd = new JButton("ADD BOOK");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBounds(236, 425, 115, 23);
		f.getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSave.setBounds(393, 425, 98, 23);
		f.getContentPane().add(btnSave);
		btnSave.addActionListener(this);
		
		btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExit.setBounds(531, 425, 89, 23);
		f.getContentPane().add(btnExit);
		btnExit.addActionListener(this);
		
		dm=new DefaultTableModel(new String[] {"BOOK ID","BOOK NAME","AUTHOR NAME","EDITION","PUBLICATION","NO OF PAGES","PRICE","YEAR OF PUBLISHING"},0);
		table = new JTable();
		table.setEnabled(false);
		JScrollPane js=new JScrollPane(table);
		js.setBounds(29, 270, 741, 145);
		f.getContentPane().add(js);
		f.setLocationRelativeTo(null);		
		f.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnSave)
		{
			s=textField.getText();
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/books", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="insert into book_detail values(?,?,?,?,?,?,?,?)";
				PreparedStatement st=cn.prepareStatement(str);
				st.setString(1,textField.getText());
				st.setString(2,textField_1.getText() );
				st.setString(3, textField_2.getText());
				st.setString(4, textField_6.getText());
				st.setString(5, textField_3.getText());
				st.setInt(6,Integer.parseInt(textField_4.getText()));
				st.setInt(7, Integer.parseInt(textField_5.getText()));
				st.setInt(8, Integer.parseInt(textField_7.getText()));
				st.executeUpdate();
				javax.swing.JOptionPane.showMessageDialog(null,"DATA STORED!!!");
				String str1="select * from book_detail where book_id=?";
				PreparedStatement st1=cn.prepareStatement(str1);
				{
					st1.setString(1, s);
					ResultSet rs=st1.executeQuery();
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
						if(s1.equals(s))
						{
							dm.addRow(new Object[] {s1,s2,s3,s4,s5,s6,s7,s8});
							table.setModel(dm);
						}
					}
				}
				cn.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		}
		if(e.getSource()==btnExit)
		{
			f.dispose();
			new LIbFun();
		}
		if(e.getSource()==btnAdd)
		{
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
		}
	}
}
