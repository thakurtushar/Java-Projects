

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JTextPane;

public class Form  implements ActionListener{
		JFrame f;
		JTextField textField;
		JTextField textField_1;
		JTextField textField_2;
		JTextField textField_4;
		JTextField textField_5;
		JTextField textField_6;
		JTextField textField_7;
		ButtonGroup g1,g2;
		JTextArea textArea;
		byte[] p_image=null;
		JRadioButton rdbtnBus,rdbtnHostel,rdbtnIHerebyDeclare ,rdbtnMale,rdbtnFemale,rdbtnOther;
		JButton btnCancel,btnSave,btnChooseImage,btnBack;
		JComboBox comboBox,comboBox_1,comboBox_2,comboBox_3,comboBox_4,comboBox_8,comboBox_9;
		JLabel label_1;
		String s2,s3;
		private JPasswordField passwordField;
		private JPasswordField passwordField_1;
		private JLabel label_2;
		public Form() 
		{
			f = new JFrame("REGISTRATION FORM");
			f.getContentPane().setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			f.setLocationRelativeTo(null);
			f.setBounds(10,10,862, 846);
			
			JLabel lblStudentName = new JLabel("STUDENT NAME");
			lblStudentName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblStudentName.setBounds(41, 189, 165, 27);
			f.getContentPane().add(lblStudentName);
			
			textField = new JTextField();
			textField.setBounds(425, 192, 203, 20);
			f.getContentPane().add(textField);
			
			JLabel lblBranch = new JLabel("BRANCH ");
			lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblBranch.setBounds(41, 227, 108, 27);
			f.getContentPane().add(lblBranch);
			
			textField_1 = new JTextField();
			textField_1.setBounds(425, 234, 203, 20);
			f.getContentPane().add(textField_1);
			
			JLabel lblYearAndSemester = new JLabel("YEAR AND SEMESTER");
			lblYearAndSemester.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblYearAndSemester.setBounds(41, 265, 193, 27);
			f.getContentPane().add(lblYearAndSemester);
			
			comboBox = new JComboBox();
	        comboBox.addItem("Year");
	        comboBox.addItem("1st");
	        comboBox.addItem("2nd");
	        comboBox.addItem("3rd");
	        comboBox.addItem("4th");
			comboBox.setBounds(425, 268, 102, 20);
			f.getContentPane().add(comboBox);
			
			comboBox_1 = new JComboBox();
	        comboBox_1.addItem("Semester");
	        comboBox_1.addItem("1st");
	        comboBox_1.addItem("2nd");
	        comboBox_1.addItem("3rd");
	        comboBox_1.addItem("4th");
	        comboBox_1.addItem("5th");
	        comboBox_1.addItem("6th");
	        comboBox_1.addItem("7th");
	        comboBox_1.addItem("8th");
			comboBox_1.setBounds(527, 268, 101, 20);
			f.getContentPane().add(comboBox_1);
			
			JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH");
			lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblDateOfBirth.setBounds(41, 310, 108, 27);
			f.getContentPane().add(lblDateOfBirth);
			
			comboBox_2 = new JComboBox();
	                                   comboBox_2.addItem("Day");
	                                   comboBox_2.addItem("1");
	                                   comboBox_2.addItem("2");
	                                   comboBox_2.addItem("3");
	                                   comboBox_2.addItem("4");
	                                   comboBox_2.addItem("5");
	                                   comboBox_2.addItem("6");
	                                   comboBox_2.addItem("7");
	                                   comboBox_2.addItem("8");
	                                   comboBox_2.addItem("9");
	                                   comboBox_2.addItem("10");
	                                   comboBox_2.addItem("11");
	                                   comboBox_2.addItem("12");
	                                   comboBox_2.addItem("13");
	                                   comboBox_2.addItem("14");
	                                   comboBox_2.addItem("15");
	                                   comboBox_2.addItem("16");
	                                   comboBox_2.addItem("17");
	                                   comboBox_2.addItem("18");
	                                   comboBox_2.addItem("19");
	                                   comboBox_2.addItem("20");
	                                   comboBox_2.addItem("21");
	                                   comboBox_2.addItem("22");
	                                   comboBox_2.addItem("23");
	                                   comboBox_2.addItem("24");
	                                   comboBox_2.addItem("25");
	                                   comboBox_2.addItem("26");
	                                   comboBox_2.addItem("27");
	                                   comboBox_2.addItem("28");
	                                   comboBox_2.addItem("29");
	                                   comboBox_2.addItem("30");
	                                   comboBox_2.addItem("31");
			comboBox_2.setBounds(425, 313, 50, 20);
			f.getContentPane().add(comboBox_2);
			
			comboBox_3=new JComboBox();
	                                   comboBox_3.addItem("Month");
	                                   comboBox_3.addItem("January");
	                                   comboBox_3.addItem("February");
	                                   comboBox_3.addItem("March");
	                                   comboBox_3.addItem("April");
	                                   comboBox_3.addItem("May");
	                                   comboBox_3.addItem("June");
	                                   comboBox_3.addItem("July");
	                                   comboBox_3.addItem("August");
	                                   comboBox_3.addItem("September");
	                                   comboBox_3.addItem("October");
	                                   comboBox_3.addItem("November");
	                                   comboBox_3.addItem("December");
			comboBox_3.setBounds(475, 313, 94, 20);
			f.getContentPane().add(comboBox_3);
			
			comboBox_4 = new JComboBox();
	                                   comboBox_4.addItem("Year");
	                                   comboBox_4.addItem("2019");
	                                   comboBox_4.addItem("2018");
	                                   comboBox_4.addItem("2017");
	                                   comboBox_4.addItem("2016");
	                                   comboBox_4.addItem("2015");
	                                   comboBox_4.addItem("2014");
	                                   comboBox_4.addItem("2013");
	                                   comboBox_4.addItem("2012");
	                                   comboBox_4.addItem("2011");
	                                   comboBox_4.addItem("2010"); 
	                                   comboBox_4.addItem("2009");
	                                   comboBox_4.addItem("2008");
	                                   comboBox_4.addItem("2007");
	                                   comboBox_4.addItem("2006");
	                                   comboBox_4.addItem("2005");
	                                   comboBox_4.addItem("2004");
	                                   comboBox_4.addItem("2003");
	                                   comboBox_4.addItem("2002");
	                                   comboBox_4.addItem("2001");
	                                   comboBox_4.addItem("2000");
	                                   comboBox_4.addItem("1999");
	                                   comboBox_4.addItem("1998");
	                                   comboBox_4.addItem("1997");
	                                   comboBox_4.addItem("1996");
	                                   comboBox_4.addItem("1995");
			comboBox_4.setBounds(569, 313, 59, 20);
			f.getContentPane().add(comboBox_4);
			
			
			JLabel lblAddress = new JLabel("ADDRESS");
			lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblAddress.setBounds(41, 359, 111, 27);
			f.getContentPane().add(lblAddress);
			
			JLabel lblFathersName = new JLabel("FATHER'S NAME");
			lblFathersName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblFathersName.setBounds(41, 571, 108, 27);
			f.getContentPane().add(lblFathersName);
			
			textField_2 = new JTextField();
			textField_2.setBounds(425, 574, 203, 20);
			f.getContentPane().add(textField_2);
			
			JLabel lblDate = new JLabel("DATE");
			lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblDate.setBounds(42, 26, 59, 27);
			f.getContentPane().add(lblDate);
			
			JLabel lblRegistrationNumber = new JLabel("REGISTRATION NUMBER");
			lblRegistrationNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblRegistrationNumber.setBounds(42, 68, 192, 28);
			f.getContentPane().add(lblRegistrationNumber);
			
			textField_4 = new JTextField();
			textField_4.setBounds(425, 72, 203, 20);
			f.getContentPane().add(textField_4);
				
			JLabel lblCategory = new JLabel("CATEGORY");
			lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblCategory.setBounds(41, 432, 76, 27);
			f.getContentPane().add(lblCategory);
			
			comboBox_8 = new JComboBox();
	                                   comboBox_8.addItem("Select");
	                                   comboBox_8.addItem("General");
	                                   comboBox_8.addItem("OBC");
	                                   comboBox_8.addItem("SC");
	                                   comboBox_8.addItem("ST");
			comboBox_8.addItem("Others");
			comboBox_8.setBounds(425, 435, 203, 20);
			f.getContentPane().add(comboBox_8);
			
			JLabel lblNationality = new JLabel("NATIONALITY");
			lblNationality.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNationality.setBounds(41, 504, 94, 27);
			f.getContentPane().add(lblNationality);
			
			textField_5 = new JTextField();
			textField_5.setBounds(425, 507, 203, 20);
			f.getContentPane().add(textField_5);
				
			JLabel lblReligion = new JLabel("RELIGION");
			lblReligion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblReligion.setBounds(41, 541, 76, 19);
			f.getContentPane().add(lblReligion);
			
			comboBox_9 = new JComboBox();
			comboBox_9.addItem("Select");
	                                   comboBox_9.addItem("Hinduism");
	                                   comboBox_9.addItem("Muslim");
	                                   comboBox_9.addItem("Sikhsm");
	                                   comboBox_9.addItem("Christian");
	                                   comboBox_9.addItem("Buddhism");
	                                   comboBox_9.addItem("Other");
			comboBox_9.setBounds(425, 543, 203, 20);
			f.getContentPane().add(comboBox_9);
			
			JLabel lblMothrsName = new JLabel("MOTHR'S NAME");
			lblMothrsName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblMothrsName.setBounds(41, 609, 108, 27);
			f.getContentPane().add(lblMothrsName);
			
			textField_6 = new JTextField();
			textField_6.setBounds(425, 612, 203, 20);
			f.getContentPane().add(textField_6);
				
			JLabel lblAnnualIncome = new JLabel("ANNUAL INCOME");
			lblAnnualIncome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblAnnualIncome.setBounds(41, 647, 128, 27);
			f.getContentPane().add(lblAnnualIncome);
			
			textField_7 = new JTextField();
			textField_7.setBounds(425, 650, 203, 20);
			f.getContentPane().add(textField_7);
				
			rdbtnIHerebyDeclare = new JRadioButton("I hereby declare that above-mentioned information is correct to the best of my knowledge and belief");
			rdbtnIHerebyDeclare.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			rdbtnIHerebyDeclare.setBounds(44, 679, 585, 21);
			f.getContentPane().add(rdbtnIHerebyDeclare);
			
			btnSave = new JButton("SAVE");
			btnSave.addActionListener(this);
				
			btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnSave.setBounds(229, 707, 117, 23);
			f.getContentPane().add(btnSave);
			
			btnCancel = new JButton("CANCEL");
			btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnCancel.setBounds(367, 707, 108, 23);
			f.getContentPane().add(btnCancel);
			btnCancel.addActionListener(this);
			
			JLabel lblPassword = new JLabel("PASSWORD");
			lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblPassword.setBounds(42, 107, 96, 27);
			f.getContentPane().add(lblPassword);
			
			JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
			lblConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblConfirmPassword.setBounds(42, 145, 164, 27);
			f.getContentPane().add(lblConfirmPassword);
			
			JLabel lblSelect = new JLabel("SELECT");
			lblSelect.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblSelect.setBounds(41, 466, 76, 27);
			f.getContentPane().add(lblSelect);
			
			rdbtnBus = new JRadioButton("BUS");
			rdbtnBus.setBounds(425, 468, 76, 23);
			f.getContentPane().add(rdbtnBus);
			
			rdbtnHostel = new JRadioButton("HOSTEL");
			rdbtnHostel.setBounds(519, 468, 109, 23);
			f.getContentPane().add(rdbtnHostel);

			g1=new ButtonGroup();
			g1.add(rdbtnBus);
			g1.add(rdbtnHostel);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(425, 110, 203, 20);
			f.getContentPane().add(passwordField);
			
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(425, 148, 203, 20);
			f.getContentPane().add(passwordField_1);
			
			label_1 = new JLabel("");
			label_1.setBounds(675, 53, 117, 109);
			f.getContentPane().add(label_1);
			
			JLabel label = new JLabel(new ImageIcon("E:\\java Image\\image.png"));
			label.setBounds(650, 33, 164, 151);
			f.getContentPane().add(label);
			
			btnChooseImage = new JButton("CHOOSE IMAGE");
			btnChooseImage.setFont(new Font("Times New Roman", Font.ITALIC, 13));
			btnChooseImage.setBounds(650, 192, 164, 23);
			f.getContentPane().add(btnChooseImage);
			btnChooseImage.addActionListener(this);
			
			JLabel lblGender = new JLabel("GENDER");
			lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblGender.setBounds(41, 397, 94, 27);
			f.getContentPane().add(lblGender);
			
			textArea = new JTextArea();
			JScrollPane js=new JScrollPane(textArea);
			js.setBounds(425, 361, 203, 25);
			f.getContentPane().add(js);
			
			rdbtnMale = new JRadioButton("MALE");
			rdbtnMale.setBounds(425, 400, 59, 23);
			f.getContentPane().add(rdbtnMale);
			
			rdbtnFemale = new JRadioButton("FEMALE");
			rdbtnFemale.setBounds(486, 400, 76, 23);
			f.getContentPane().add(rdbtnFemale);
			
			rdbtnOther = new JRadioButton("OTHER");
			rdbtnOther.setBounds(564, 400, 66, 23);
			f.getContentPane().add(rdbtnOther);
			
			g2=new ButtonGroup();
			g2.add(rdbtnMale);
			g2.add(rdbtnFemale);
			g2.add(rdbtnOther);
			
			btnBack = new JButton("BACK");
			btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnBack.setBounds(757, 718, 89, 23);
			btnBack.addActionListener(this);
			f.getContentPane().add(btnBack);
			
			label_2 = new JLabel("");
			label_2.setBounds(424, 33, 193, 28);
			f.getContentPane().add(label_2);
			label_2.setText(DateFormat.getDateTimeInstance().format(new Date()));
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==btnBack)
			{
				f.dispose();
				new Student();
			}
			if(arg0.getSource()==btnSave)
			{
				String s=String.valueOf(passwordField.getPassword());
				String s1=String.valueOf(passwordField_1.getPassword());
				if(rdbtnBus.isSelected())
					s2="Bus";
				else
				s2="Hostel";
				if(rdbtnMale.isSelected())
					s3="Male";
				else if(rdbtnFemale.isSelected())
					s3="Female";
				else
					s3="Other";
				if(s1.equals(s))
				{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/students", DbConnection.textField.getText(), DbConnection.passwordField.getText());
					String str="insert into stu_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement st=cn.prepareStatement(str);
					String DOB=comboBox_2.getSelectedItem().toString()+"/"+comboBox_3.getSelectedItem().toString()+"/"+comboBox_4.getSelectedItem().toString();;
					st.setString(1, label_2.getText());
					st.setString(2, textField_4.getText());
					st.setString(3, textField.getText());
					st.setString(4, s);
					st.setString(5, textField_1.getText());
					st.setString(6, comboBox.getSelectedItem().toString() );
					st.setString(7, comboBox_1.getSelectedItem().toString());
					st.setString(8, DOB);
					st.setString(9, textArea.getText());
					st.setString(10, comboBox_8.getSelectedItem().toString() );
					st.setString(11, s2);
					st.setString(12, textField_5.getText());
					st.setString(13, comboBox_9.getSelectedItem().toString());
					st.setString(14, textField_2.getText() );
					st.setString(15, textField_6.getText());
					st.setString(16, textField_7.getText());
					st.setBytes(17, p_image);
					st.setString(18, s3);
					if(rdbtnIHerebyDeclare.isSelected())
					{
						st.executeUpdate();
						javax.swing.JOptionPane.showMessageDialog(null, "DATA SAVED!!!");
					}
					else {
						javax.swing.JOptionPane.showMessageDialog(null,"Please Accept The Declaration");
					}
					cn.close();
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					textField_7.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					comboBox_4.setSelectedIndex(0);
					label_2.setText(DateFormat.getDateTimeInstance().format(new Date()));
					comboBox_8.setSelectedIndex(0);
					comboBox_9.setSelectedIndex(0);
					g1.clearSelection();
					g2.clearSelection();
					passwordField.setText(null);
					passwordField_1.setText(null);
					label_1.setIcon(null);
					textArea.setText(null);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
				else
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Password Didn't Match!!!");
				}
			}
			if(arg0.getSource()== btnChooseImage)
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
			if(arg0.getSource()==btnCancel)
			{
				int ans=javax.swing.JOptionPane.showConfirmDialog(null, "You Would Loose All The Data",null, JOptionPane.YES_NO_OPTION);
				if(ans==0)
				{
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					textField_7.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					comboBox_4.setSelectedIndex(0);
					label_2.setText(DateFormat.getDateTimeInstance().format(new Date()));
					comboBox_8.setSelectedIndex(0);
					comboBox_9.setSelectedIndex(0);
					g1.clearSelection();
					g2.clearSelection();
					passwordField.setText(null);
					passwordField_1.setText(null);
					label_1.setIcon(null);
					textArea.setText(null);
				}
			}
			
		}
	}
	
