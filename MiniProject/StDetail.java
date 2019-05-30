

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StDetail implements ActionListener {

	JFrame f;
	public static JLabel label_1;
	public static JTextField textField;
	public static JTextField textField_3;
	public static JTextField textField_6;
	public static JTextField textField_7;
	public static JTextField textField_2;
	private JLabel lblNationality;
	public static JTextField textField_1;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_8;
	public static JTextField textField_9;
	private JLabel lblFathersName;
	public static JTextField textField_10;
	private JLabel lblMothersName;
	public static JTextField textField_11;
	private JLabel lblAnnualIncome;
	public static JTextField textField_12;
	private JLabel lblAddress;
	private JLabel lblReligion;
	public static JTextField textField_14;
	private JLabel lblReligion_1;
	private JLabel lblFeesStatus;
	private JLabel lblAttendance;
	public static JTextField textField_15;
	public static JTextField textField_16;
	public static JTextField textField_17;
	private JButton btnDelete,btnSave,btnCancel,btnBack;
	public static JTextArea textArea;
	private JButton btnChooseImage;
	public static JLabel label_2;
	byte[] p_image=StuDetail.b;
	public StDetail() {
		f=new JFrame("Student Column");
		f.getContentPane().setBackground(new Color(255, 240, 245));
		f.getContentPane().setForeground(new Color(255, 240, 245));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 872, 580);
		f.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(30, 31, 78, 25);
		f.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 67, 173, 25);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDateOfBirth.setBounds(30, 103, 139, 25);
		f.getContentPane().add(lblDateOfBirth);
		
		JLabel lblBranch = new JLabel("BRANCH");
		lblBranch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBranch.setHorizontalAlignment(SwingConstants.LEFT);
		lblBranch.setBounds(62, 175, 67, 25);
		f.getContentPane().add(lblBranch);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblYear.setBounds(273, 175, 78, 25);
		f.getContentPane().add(lblYear);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(10, 211, 173, 25);
		f.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAttandancePercentage = new JLabel("SEMESTER");
		lblAttandancePercentage.setHorizontalAlignment(SwingConstants.LEFT);
		lblAttandancePercentage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAttandancePercentage.setBounds(62, 247, 107, 25);
		f.getContentPane().add(lblAttandancePercentage);
		
		JLabel lblFeeStatus = new JLabel("PASSWORD");
		lblFeeStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblFeeStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFeeStatus.setBounds(487, 31, 112, 25);
		f.getContentPane().add(lblFeeStatus);
		
		JLabel lblFactilityAvail = new JLabel("FACTILITY AVAIL");
		lblFactilityAvail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFactilityAvail.setHorizontalAlignment(SwingConstants.LEFT);
		lblFactilityAvail.setBounds(30, 319, 139, 25);
		f.getContentPane().add(lblFactilityAvail);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(442, 67, 184, 25);
		f.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		btnSave =new JButton("EDIT");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.setBounds(320, 492, 107, 38);
		f.getContentPane().add(btnSave);
		btnSave.addActionListener(this);
		
		btnCancel = new JButton("UPDATE");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.addActionListener(this);
		btnCancel.setBounds(459, 492, 107, 38);
		f.getContentPane().add(btnCancel);
		
		JLabel lblRegistrationNumber = new JLabel("REGISTRATION NUMBER");
		lblRegistrationNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistrationNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRegistrationNumber.setBounds(220, 31, 196, 25);
		f.getContentPane().add(lblRegistrationNumber);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(220, 67, 184, 25);
		f.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(767, 518, 89, 23);
		f.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGender.setBounds(273, 103, 78, 25);
		f.getContentPane().add(lblGender);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(220, 283, 184, 25);
		f.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblNationality = new JLabel("NATIONALITY");
		lblNationality.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNationality.setBounds(254, 247, 115, 25);
		f.getContentPane().add(lblNationality);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(10, 144, 173, 25);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(10, 283, 173, 25);
		f.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(220, 144, 184, 25);
		f.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(220, 211, 184, 25);
		f.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(10, 355, 173, 25);
		f.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		lblFathersName = new JLabel("FATHER'S NAME");
		lblFathersName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFathersName.setBounds(473, 103, 126, 25);
		f.getContentPane().add(lblFathersName);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBounds(442, 144, 184, 25);
		f.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		lblMothersName = new JLabel("MOTHER'S NAME");
		lblMothersName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMothersName.setBounds(473, 175, 139, 25);
		f.getContentPane().add(lblMothersName);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setBounds(442, 211, 184, 25);
		f.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		lblAnnualIncome = new JLabel("ANNUAL INCOME");
		lblAnnualIncome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAnnualIncome.setBounds(459, 247, 140, 25);
		f.getContentPane().add(lblAnnualIncome);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setBounds(442, 283, 184, 25);
		f.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		label_1 = new JLabel("");
		label_1.setBounds(674, 80, 117, 109);
		f.getContentPane().add(label_1);
		
		JLabel label = new JLabel(new ImageIcon("E:\\java Image\\image.png"));
		label.setBounds(651, 59, 164, 151);
		f.getContentPane().add(label);
		
		lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddress.setBounds(272, 319, 97, 25);
		f.getContentPane().add(lblAddress);
		
		lblReligion = new JLabel("RELIGION");
		lblReligion.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblReligion.setBounds(492, 319, 107, 25);
		f.getContentPane().add(lblReligion);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setBounds(442, 355, 184, 25);
		f.getContentPane().add(textField_14);
		textField_14.setColumns(10);
		
		lblReligion_1 = new JLabel("CATEGORY");
		lblReligion_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblReligion_1.setBounds(62, 391, 89, 25);
		f.getContentPane().add(lblReligion_1);
		
		lblFeesStatus = new JLabel("FEES STATUS");
		lblFeesStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFeesStatus.setBounds(275, 391, 107, 25);
		f.getContentPane().add(lblFeesStatus);
		
		lblAttendance = new JLabel("ATTENDANCE");
		lblAttendance.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAttendance.setBounds(484, 393, 115, 20);
		f.getContentPane().add(lblAttendance);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setBounds(10, 427, 173, 25);
		f.getContentPane().add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setBounds(221, 427, 183, 25);
		f.getContentPane().add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setBounds(442, 424, 184, 25);
		f.getContentPane().add(textField_17);
		textField_17.setColumns(10);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.setBounds(176, 492, 115, 38);
		f.getContentPane().add(btnDelete);
		btnDelete.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane js=new JScrollPane(textArea);
		js.setBounds(220, 355, 184, 25);
		f.getContentPane().add(js);
		
		label_2 = new JLabel("");
		label_2.setBounds(651, 260, 164, 25);
		f.getContentPane().add(label_2);
		
		btnChooseImage = new JButton("CHOOSE IMAGE");
		btnChooseImage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnChooseImage.setBounds(651, 226, 164, 23);
		f.getContentPane().add(btnChooseImage);
		btnChooseImage.addActionListener(this);
		f.setLocationRelativeTo(null);		
		f.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnDelete)
		{
			String s=textField_7.getText();
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/students",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="delete from stu_info where Reg_no=?";
				PreparedStatement st=cn.prepareStatement(str);
				st.setString(1, s);
				st.executeUpdate();
				javax.swing.JOptionPane.showMessageDialog(null, "Data Deleted!!!");
				cn.close();
				f.dispose();
				new StuDetail();
			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		if(arg0.getSource()==btnSave)
		{
			textField.setEditable(true);
			textField_7.setEditable(true);
			textField_6.setEditable(true);
			textField_1.setEditable(true);
			textField_5.setEditable(true);
			textField_10.setEditable(true);
			textField_3.setEditable(true);
			textField_8.setEditable(true);
			textField_11.setEditable(true);
			textField_4.setEditable(true);
			textField_2.setEditable(true);
			textField_12.setEditable(true);
			textField_9.setEditable(true);
			textField_14.setEditable(true);
			textField_15.setEditable(true);
			textField_16.setEditable(true);
			textField_17.setEditable(true);
			textArea.setEditable(true);
			
		}
		if(arg0.getSource()==btnCancel)
		{
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/students",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
					String str="update stu_info set s_name=?,Reg_no=?,s_password=?,s_Dob=?,s_gender=?,s_fathername=?,s_branch=?,s_year=?,s_mothername=?,s_semester=?,s_nationality=?,s_familyincome=?,s_facility=?,s_religion=?,s_category=?,s_address=?,s_image=? WHERE Reg_no='"+StuDetail.s+"'";
					PreparedStatement st=cn.prepareStatement(str);
					st.setString(1, textField.getText());
					st.setString(2, textField_7.getText());
					st.setString(3, textField_6.getText());
					st.setString(4, textField_1.getText());
					st.setString(5, textField_5.getText());
					st.setString(6, textField_10.getText());
					st.setString(7, textField_3.getText());
					st.setString(8, textField_8.getText());
					st.setString(9, textField_11.getText());
					st.setString(10, textField_4.getText());
					st.setString(11, textField_2.getText());
					st.setString(12, textField_12.getText());
					st.setString(13, textField_9.getText());
					st.setString(14, textField_14.getText());
					st.setString(15, textField_15.getText());
					st.setString(16, textArea.getText());
					st.setBytes(17, p_image);
					st.executeUpdate();
					cn.close();
					javax.swing.JOptionPane.showMessageDialog(null, "Data Updated!!");
					f.dispose();
					new StuDetail();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		if(arg0.getSource()==btnBack)
		{
			f.dispose();
			new StuDetail();
		}
		if(arg0.getSource()==btnChooseImage)
		{
					String Path=null;
					JFileChooser jc=new JFileChooser();
					jc.showOpenDialog(null);
					File f=jc.getSelectedFile();
					Path=f.getAbsolutePath();
					ImageIcon ic=new ImageIcon(new ImageIcon(Path).getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight(),Image.SCALE_SMOOTH));
					label_1.setIcon(ic);
					try {
						File F=new File(Path);
						FileInputStream fis=new FileInputStream(F);
						ByteArrayOutputStream bos=new ByteArrayOutputStream();
						byte[] buf=new byte[1024];
						for(int readNum;(readNum=fis.read(buf))!=-1;) {
							bos.write(buf,0,readNum);
						}
						p_image=bos.toByteArray();
					}
					catch(Exception e1)
					{
						System.out.println(e1.getMessage());
					}
		}
	}
}
