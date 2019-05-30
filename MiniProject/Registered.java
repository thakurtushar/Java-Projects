
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Registered implements ActionListener{

	JFrame f;
	private JTextField textField;
	JButton btnBack,btnSearch,btnCancel;
	private JPasswordField passwordField;
	public static String value1;
	public Registered() {
		f=new JFrame("Registered Student");
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 553, 288);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		
		JLabel lblRegistrationId = new JLabel("REGISTRATION ID");
		lblRegistrationId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblRegistrationId.setBounds(65, 50, 139, 33);
		f.getContentPane().add(lblRegistrationId);
		
		textField = new JTextField();
		textField.setBounds(241, 50, 211, 33);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(65, 128, 123, 33);
		f.getContentPane().add(lblPassword);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setBounds(122, 191, 123, 33);
		f.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(279, 191, 121, 33);
		f.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(448, 226, 89, 23);
		f.getContentPane().add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(241, 129, 211, 33);
		f.getContentPane().add(passwordField);
		btnBack.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnBack)
		{
			f.dispose();
			new Student();
		}
		if(e.getSource()==btnSearch)
		{
			value1=textField.getText();
			String value2=String.valueOf(passwordField.getPassword());
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/Students", DbConnection.textField.getText(),DbConnection.passwordField.getText());
				String str="select * from stu_info where Reg_no='"+textField.getText()+"'";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					String s1=rs.getString("Reg_no");
					String s2=rs.getString("s_password");
					if(s1.equals(value1) && s2.equals(value2))
					{
							new StuInfo();
							String Value1=rs.getString("s_name");
							String Value2=rs.getString("s_branch");
							String value3=rs.getString("s_year");
							String value4=rs.getString("s_semester");
							String value5=rs.getString("s_category");
							String value6=rs.getString("s_facility");
							String value7=rs.getString("s_nationality");
							String value8=rs.getString("s_address");
							String value10=rs.getString("s_religion");
							String value11=rs.getString("s_fathername");
							String value12=rs.getString("s_mothername");
							String value13=rs.getString("s_familyincome");
							String value14=rs.getString("s_Dob");
							Blob blob=rs.getBlob("s_image");
							byte[] b=blob.getBytes(1,(int)blob.length());
							String value15=rs.getString("s_gender");
							StuInfo.textField.setText(Value1);
							StuInfo.textField_7.setText(s1);
							StuInfo.textField_6.setText(s2);
							StuInfo.textField_1.setText(value14);
							StuInfo.textField_5.setText(value15);
							StuInfo.textField_10.setText(value11);
							StuInfo.textField_11.setText(value12);
							StuInfo.textField_8.setText(value3);
							StuInfo.textField_3.setText(Value2);
							StuInfo.textField_4.setText(value4);
							StuInfo.textField_2.setText(value7);
							StuInfo.textField_12.setText(value13);
							StuInfo.textField_9.setText(value6);
							StuInfo.textArea.setText(value8);
							StuInfo.textField_14.setText(value10);
							StuInfo.textField_15.setText(value5);
							ImageIcon ic=new ImageIcon(new ImageIcon(b).getImage().getScaledInstance(StuInfo.label_1.getWidth(), StuInfo.label_1.getHeight(), Image.SCALE_SMOOTH));
							StuInfo.label_1.setIcon(ic);
							f.dispose();
					}
					else
					{
						javax.swing.JOptionPane.showMessageDialog(null,"UserId and Password Didn't Match!!!");
					}
				}
				
			}
			catch(Exception e1)
			{
				e1.getMessage();
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
						StuInfo.dm.addRow(new Object[] {value18,value20,value19});
						StuInfo.table.setModel(StuInfo.dm);
					}
				}
			}
			catch(Exception e2)
			{
				javax.swing.JOptionPane.showMessageDialog(null,e2.getMessage());
			}
		}
		if(e.getSource()==btnCancel)
		{
			textField.setText(null);
			passwordField.setText(null);
			int a=javax.swing.JOptionPane.showConfirmDialog(null,"Would You Like To Exit!!");
			if(a==0)
			{
				f.dispose();
				new First();
			}
		}
	}
}
