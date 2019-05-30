

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.*;

public class StuDetail implements ActionListener {

	JFrame f;
	private JTextField textField;
	JButton btnBack, btnSearch ;
	String value1;
	static String s;
	static byte[] b;
	public StuDetail() {
		f=new JFrame("Search Student");
		f.getContentPane().setBackground(new Color(238, 232, 170));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 516, 231);
		f.getContentPane().setLayout(null);
		
		JLabel lblEnterRegistrationNumber = new JLabel("REGISTRATION NUMBER");
		lblEnterRegistrationNumber.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEnterRegistrationNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterRegistrationNumber.setBounds(10, 35, 183, 33);
		f.getContentPane().add(lblEnterRegistrationNumber);
		
		textField = new JTextField();
		textField.setBounds(226, 36, 244, 33);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setBounds(109, 111, 115, 33);
		f.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);
		
		btnBack= new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(394, 159, 106, 33);
		f.getContentPane().add(btnBack);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(247, 111, 115, 33);
		f.getContentPane().add(btnCancel);
		btnBack.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnBack)
		{
			f.dispose();
			new ADMIN();
		}
		if(arg0.getSource()==btnSearch)
		{
			 s=textField.getText();
			{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/students",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
					String str="select Reg_no,s_name,s_password,s_branch,s_year,s_semester,s_Dob,s_address,s_category,s_facility,s_nationality,s_religion,s_fathername,s_mothername,s_familyincome,s_image,s_gender from stu_info where Reg_no=?";
					PreparedStatement st=cn.prepareStatement(str);
					{
						st.setString(1, s);
						ResultSet rs=st.executeQuery();
						while(rs.next())
						{
							value1=rs.getString(1);
							String value2=rs.getString(2);
							String value3=rs.getString(3);
							String value4=rs.getString(4);
							String value5=rs.getString(5);
							String value6=rs.getString(6);
							String value7=rs.getString(7);
							String value8=rs.getString(8);
							String value9=rs.getString(9);
							String value10=rs.getString(10);
							String value11=rs.getString(11);
							String value12=rs.getString(12);
							String value13=rs.getString(13);
							String value14=rs.getString(14);
							String value15=rs.getString(15);
							Blob blob=rs.getBlob(16);
							b=blob.getBytes(1,(int)blob.length());
							String value17=rs.getString(17);
							new StDetail();
							StDetail.textField_7.setText(value1);
							StDetail.textField.setText(value2);
							StDetail.textField_6.setText(value3);
							StDetail.textField_3.setText(value4);
							StDetail.textField_8.setText(value5);
							StDetail.textField_4.setText(value6);
							StDetail.textField_1.setText(value7);
							StDetail.textArea.setText(value8);
							StDetail.textField_15.setText(value9);
							StDetail.textField_9.setText(value10);
							StDetail.textField_2.setText(value11);
							StDetail.textField_14.setText(value12);
							StDetail.textField_10.setText(value13);
							StDetail.textField_11.setText(value14);
							StDetail.textField_12.setText(value15);
							ImageIcon ic=new ImageIcon(new ImageIcon(b).getImage().getScaledInstance(StDetail.label_1.getWidth(), StDetail.label_1.getHeight(), Image.SCALE_SMOOTH));
							StDetail.label_1.setIcon(ic);
							StDetail.textField_5.setText(value17);
							f.dispose();
						}
					}
					cn.close();
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
				}
				
			}
		}
		}
}
		

