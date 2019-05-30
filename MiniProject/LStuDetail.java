

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LStuDetail implements ActionListener{

	JFrame f;
	private JTextField textField;
	JButton btnBack, btnSearch ;
	String value1;
	public static String s;
	static byte[] b;
	public LStuDetail() {
		f=new JFrame("Search Student");
		f.getContentPane().setBackground(new Color(51, 204, 204));
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
		btnBack.setSelectedIcon(null);
		btnBack.setIcon(new ImageIcon("E:\\java Image\\reply.png"));
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
			new LIbFun();
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
							new LStDetail();
							LStDetail.textField_7.setText(value1);
							LStDetail.textField.setText(value2);
							LStDetail.textField_6.setText(value3);
							LStDetail.textField_3.setText(value4);
							LStDetail.textField_8.setText(value5);
							LStDetail.textField_4.setText(value6);
							LStDetail.textField_1.setText(value7);
							LStDetail.textArea.setText(value8);
							LStDetail.textField_15.setText(value9);
							LStDetail.textField_9.setText(value10);
							LStDetail.textField_2.setText(value11);
							LStDetail.textField_14.setText(value12);
							LStDetail.textField_10.setText(value13);
							LStDetail.textField_11.setText(value14);
							LStDetail.textField_12.setText(value15);
							ImageIcon ic=new ImageIcon(new ImageIcon(b).getImage().getScaledInstance(LStDetail.label_1.getWidth(), LStDetail.label_1.getHeight(), Image.SCALE_SMOOTH));
							LStDetail.label_1.setIcon(ic);
							LStDetail.textField_5.setText(value17);
							f.dispose();
						}
					}
					cn.close();
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn1=DriverManager.getConnection("jdbc:mysql://localhost/issueBooks", DbConnection.textField.getText(), DbConnection.passwordField.getText());
					String str1="Select book_id,book_name,issue_date from issue where s_id='"+textField.getText()+"'";
					PreparedStatement st1=cn1.prepareStatement(str1);
					ResultSet rs1=st1.executeQuery();
					while(rs1.next())
					{
						String value18=rs1.getString(1);
						String value20=rs1.getString(2);
						String value19=rs1.getString(3);
						{
							LStDetail.dm.addRow(new Object[] {value18,value20,value19});
							LStDetail.table.setModel(LStDetail.dm);
						}
					}
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
				}
				
			}
		}
		}
}
