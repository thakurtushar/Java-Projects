

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Returnbook implements ActionListener{

	JFrame f;
	JButton btnSearch,btnBack,btnBookDetails;
	JLabel label,label_1;
	private JTextField textField;
	private JLabel lblName;
	private JTextField textField_1;
	private JLabel lblBranch;
	private JTextField textField_2;
	private JLabel lblYear;
	private JTextField textField_3;
	private JTable table;
	DefaultTableModel dm;
	private JButton btnDelete;
	public Returnbook() {
		f=new JFrame("RETURN BOOKS");
		f.getContentPane().setBackground(new Color(204, 204, 153));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 633, 464);
		f.getContentPane().setLayout(null);
		
		JLabel lblStudentIs = new JLabel("STUDENT ID");
		lblStudentIs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStudentIs.setBounds(37, 24, 124, 32);
		f.getContentPane().add(lblStudentIs);
		
		textField = new JTextField();
		textField.setBounds(178, 29, 211, 25);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		label_1 = new JLabel("");
		label_1.setBounds(448, 44, 118, 109);
		f.getContentPane().add(label_1);
		
		label = new JLabel(new ImageIcon("E://java Image/image.png"));
		label.setBounds(428, 24, 158, 148);
		f.getContentPane().add(label);
		label.setVisible(false);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setBounds(294, 65, 95, 23);
		f.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);
		
		lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBounds(40, 101, 82, 23);
		f.getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(37, 135, 136, 23);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblBranch = new JLabel("BRANCH");
		lblBranch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBranch.setBounds(183, 101, 73, 23);
		f.getContentPane().add(lblBranch);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 135, 136, 22);
		f.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblYear = new JLabel("YEAR");
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblYear.setBounds(329, 100, 65, 25);
		f.getContentPane().add(lblYear);
		
		textField_3 = new JTextField();
		textField_3.setBounds(329, 136, 65, 20);
		f.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnBookDetails = new JButton("BOOK DETAILS");
		btnBookDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBookDetails.setBounds(37, 183, 149, 32);
		f.getContentPane().add(btnBookDetails);
		btnBookDetails.addActionListener(this);
		
		dm=new DefaultTableModel(new String[] {"BOOK ID","BOOK NAME","DATE AND TIME OF ISSUE"},0);
		table = new JTable();
		JScrollPane js=new JScrollPane(table);
		js.setBounds(37, 238, 549, 139);
		f.getContentPane().add(js);
		
		btnBack = new JButton("CANCEL");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(324, 388, 100, 26);
		f.getContentPane().add(btnBack);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(this);	
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.setBounds(191, 388, 100, 26);
		f.getContentPane().add(btnDelete);
		btnBack.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
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
				}
				
				cn.close();
			}
			catch(Exception e)
			{
				javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		if(arg0.getSource()==btnBack)
		{
			f.dispose();
			new LIbFun();
		}
		if(arg0.getSource()==btnBookDetails)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/issuebooks", DbConnection.textField.getText(),DbConnection.passwordField.getText());
				String str="select book_id,book_name,issue_date from issue where s_id='"+textField.getText()+"'";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					String b_id=rs.getString(1);
					String b_name=rs.getString(2);
					String i_time=rs.getString(3);
					dm.addRow(new Object[] {b_id,b_name,i_time});
					table.setModel(dm);
				}
				cn.close();
			}
			catch(Exception e1)
			{
				e1.getMessage();
			}
		}
		if(arg0.getSource()==btnDelete)
		{
			try {
				int selectedRow=table.getSelectedRow();
				String b_id = (table.getValueAt(selectedRow, 0)).toString();
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn1=DriverManager.getConnection("jdbc:mysql://localhost/issuebooks", DbConnection.textField.getText(),DbConnection.passwordField.getText());
				String str1="Delete From issue where book_id='"+b_id+"'";
				PreparedStatement st1=cn1.prepareStatement(str1);
				st1.executeUpdate();
				dm.removeRow(selectedRow);
				javax.swing.JOptionPane.showMessageDialog(null, "BOOK RETURNED");
				cn1.close();	
			}
			catch(Exception e)
			{
				e.getMessage();
			}
		}
		
	}
}
