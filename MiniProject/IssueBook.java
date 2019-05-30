

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;

public class IssueBook implements ActionListener {

	JFrame f;
	private JTextField textField;
	private JLabel label_1,label,label_2,lblDateOfIssue ;
	JButton btnSearch,btnAddBook;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JLabel lblName,lblBranch,lblYear;
	private JLabel lblBookId;
	private JTextField textField_4;
	private JButton btnSearch_1;
	private JLabel lblBookName;
	private JTextField textField_5;
	private JButton btnSave;
	private JButton btnCancel,btnBack;
	String value3;
	public IssueBook() {
		f=new JFrame("ISSUE BOOKS");
		f.getContentPane().setBackground(new Color(204, 255, 153));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 674, 438);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JLabel lblStudentId = new JLabel("REGISTRATION NUMBER");
		lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStudentId.setBounds(10, 34, 197, 27);
		f.getContentPane().add(lblStudentId);
		
		label_1 = new JLabel("");
		label_1.setBounds(480, 53, 120, 109);
		f.getContentPane().add(label_1);
		
		label = new JLabel(new ImageIcon("E://java Image/image.png"));
		label.setBounds(463, 34, 158, 148);
		f.getContentPane().add(label);
		label.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(217, 34, 210, 28);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setHideActionText(true);
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setBounds(315, 73, 112, 27);
		f.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);
		
		lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setVisible(false);
		lblName.setBounds(24, 103, 65, 27);
		f.getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setVisible(false);
		textField_1.setBounds(22, 141, 158, 27);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblBranch = new JLabel("BRANCH");
		lblBranch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBranch.setVisible(false);
		lblBranch.setBounds(190, 103, 74, 27);
		f.getContentPane().add(lblBranch);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setVisible(false);
		textField_2.setBounds(190, 141, 158, 27);
		f.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblYear = new JLabel("YEAR");
		lblYear.setVisible(false);
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblYear.setBounds(358, 103, 57, 27);
		f.getContentPane().add(lblYear);
		
		textField_3 = new JTextField();
		textField_3.setVisible(false);
		textField_3.setEditable(false);
		textField_3.setBounds(358, 141, 80, 27);
		f.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnAddBook = new JButton("ADD BOOK");
		btnAddBook.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddBook.setVisible(false);
		btnAddBook.setBounds(24, 186, 120, 21);
		f.getContentPane().add(btnAddBook);
		btnAddBook.addActionListener(this);
		
		lblBookId = new JLabel("BOOK ID");
		lblBookId.setVisible(false);
		lblBookId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBookId.setBounds(24, 231, 74, 27);
		f.getContentPane().add(lblBookId);
		
		textField_4 = new JTextField();
		textField_4.setVisible(false);
		textField_4.setBounds(108, 231, 156, 27);
		f.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnSearch_1 = new JButton("SEARCH");
		btnSearch_1.setVisible(false);
		btnSearch_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch_1.setBounds(23, 269, 101, 23);
		f.getContentPane().add(btnSearch_1);
		btnSearch_1.addActionListener(this);
		
		lblBookName = new JLabel("BOOK NAME");
		lblBookName.setVisible(false);
		lblBookName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBookName.setBounds(289, 231, 112, 27);
		f.getContentPane().add(lblBookName);
		
		textField_5 = new JTextField();
		textField_5.setVisible(false);
		textField_5.setBounds(411, 231, 178, 27);
		f.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		btnSave = new JButton("ISSUE BOOK");
		btnSave.setVisible(false);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.setBounds(24, 342, 138, 33);
		f.getContentPane().add(btnSave);
		btnSave.addActionListener(this);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setVisible(false);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(190, 342, 105, 33);
		f.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		lblDateOfIssue = new JLabel("DATE OF ISSUE");
		lblDateOfIssue.setVisible(false);
		lblDateOfIssue.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDateOfIssue.setBounds(24, 303, 120, 28);
		f.getContentPane().add(lblDateOfIssue);
		
		label_2 = new JLabel("");
		label_2.setVisible(false);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_2.setBounds(175, 303, 210, 33);
		f.getContentPane().add(label_2);
		label_2.setText(DateFormat.getDateTimeInstance().format(new Date()));
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(569, 376, 89, 23);
		f.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnSearch)
		{
			String s=textField.getText();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/Students",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="select s_name,s_branch,s_year ,s_image from stu_info where Reg_no='"+s+"'";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					String value1=rs.getString(1);
					String value2=rs.getString(2);
					String value3=rs.getString(3);
					Blob blob=rs.getBlob(4);
					byte[] b=blob.getBytes(1, (int)blob.length());
					label.setVisible(true);
					ImageIcon ic=new ImageIcon(new ImageIcon(b).getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH));
					label_1.setIcon(ic);
					lblBranch.setVisible(true);
					lblYear.setVisible(true);
					lblName.setVisible(true);
					textField_1.setVisible(true);
					textField_2.setVisible(true);
					textField_3.setVisible(true);
					textField_1.setText(value1);
					textField_2.setText(value2);
					textField_3.setText(value3);
					btnAddBook.setVisible(true);
				}
				
				cn.close();
			}
			catch(Exception e)
			{
				javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		if(arg0.getSource()==btnAddBook)
		{
			lblBookId.setVisible(true);
			textField_4.setVisible(true);
			btnSearch_1.setVisible(true);
			textField_4.setText(null);
			textField_5.setText(null);
			lblDateOfIssue.setVisible(true);
			label_2.setVisible(true);
		}
		if(arg0.getSource()==btnSearch_1)
		{
			String value1=textField_4.getText();
			int i=0,j=0;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/issueBooks", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="select book_id from issue";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					String str1=rs.getString("book_id");
					if(str1.equals(value1))
					{
						i++;
					}
							
				}
				cn.close();
			}
				
				catch(Exception e)
				{
					 e.getMessage();
				}
			
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn1=DriverManager.getConnection("jdbc:mysql://localhost/Books",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
					String str1="select BOOK_ID,book_name from book_detail";
					PreparedStatement st1=cn1.prepareStatement(str1);
					ResultSet RS=st1.executeQuery();
					while(RS.next())
					{
						String value2=RS.getString("book_id");
						value3=RS.getString("book_name");
						if(value2.equals(value1)) 
						{
							j++;
							textField_5.setText(value3);
						}
						
					}
					if(i!=0 )
					{
						javax.swing.JOptionPane.showMessageDialog(null,"BOOK ALREADY ISSUED!!!");
						lblBookName.setVisible(true);
						textField_5.setVisible(true);
					}
					else if(j==0)
					{
						javax.swing.JOptionPane.showMessageDialog(null,"INVALID ID!!!");
						lblBookName.setVisible(true);
						textField_5.setVisible(true);
						textField_5.setText(null);
					}
					else if(i==0 || j!=0)
					{
							javax.swing.JOptionPane.showMessageDialog(null,"BOOK AVAILABLE");
							btnSave.setVisible(true);
							btnCancel.setVisible(true);	
							lblBookName.setVisible(true);
							textField_5.setVisible(true);
					}
				}
				catch(Exception E1)
				{
					System.out.println(E1.getMessage());
				}
					
			}
		if(arg0.getSource()==btnSave)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/issueBooks", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String STR="insert into issue values(?,?,?,?)";
				PreparedStatement st=cn.prepareStatement(STR);
				st.setString(1, textField.getText());
				st.setString(2, textField_4.getText());
				st.setString(3, textField_5.getText());
				st.setString(4, label_2.getText());
				st.executeUpdate();
				javax.swing.JOptionPane.showMessageDialog(null, "BOOK ISSUED");
				cn.close();
			}
			catch(Exception e)
			{
				javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
		if(arg0.getSource()==btnCancel)
		{
			f.dispose();
			new LIbFun();
		}
		if(arg0.getSource()==btnBack)
		{
			f.dispose();
			new LIbFun();
		}
	}
}
