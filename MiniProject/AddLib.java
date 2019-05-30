import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class AddLib implements ActionListener{

	JFrame f;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	JButton btnSave;
	JButton btnCancel,btnBack;
	JComboBox comboBox;
	JTextPane textPane;
	JComboBox comboBox_3;
	JComboBox comboBox_2;
	String gender,Date ;
	ButtonGroup g1;
	ImageIcon ic;
	JRadioButton rdbtnMale,rdbtnFemale,rdbtnOther;
	JButton btnChooseImage;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	byte[] p_image=null;
	public AddLib() {
		f=new JFrame("ADD LIBRARIAN");
		f.getContentPane().setBackground(new Color(245, 255, 250));
		f.getContentPane().setForeground(Color.WHITE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 629, 522);
		f.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(24, 33, 107, 30);
		f.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(191, 38, 200, 23);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblLibrarianId = new JLabel("LIBRARIAN ID");
		lblLibrarianId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLibrarianId.setHorizontalAlignment(SwingConstants.LEFT);
		lblLibrarianId.setBounds(24, 86, 117, 30);
		f.getContentPane().add(lblLibrarianId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 91, 200, 23);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(24, 146, 111, 30);
		f.getContentPane().add(lblPassword);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setBounds(24, 197, 111, 30);
		f.getContentPane().add(lblGender);
		
		rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setBounds(191, 198, 75, 23);
		f.getContentPane().add(rdbtnMale);
		
	    rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setBounds(264, 198, 81, 23);
		f.getContentPane().add(rdbtnFemale);
		
		rdbtnOther = new JRadioButton("OTHER");
		rdbtnOther.setBounds(348, 198, 75, 23);
		f.getContentPane().add(rdbtnOther);
		
		g1=new ButtonGroup();
		g1.add(rdbtnMale);
		g1.add(rdbtnFemale);
		g1.add(rdbtnOther);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPhoneNo.setBounds(24, 239, 101, 30);
		f.getContentPane().add(lblPhoneNo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 244, 200, 23);
		f.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setBounds(24, 292, 91, 30);
		f.getContentPane().add(lblAddress);
		
		textPane = new JTextPane();
		textPane.setBounds(191, 291, 200, 62);
		f.getContentPane().add(textPane);
		
		JLabel lblJoiningDate = new JLabel("JOINING DATE");
		lblJoiningDate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblJoiningDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblJoiningDate.setBounds(24, 376, 117, 30);
		f.getContentPane().add(lblJoiningDate);
		
		comboBox = new JComboBox();
		comboBox.addItem("Day");
        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");
        comboBox.addItem("4");
        comboBox.addItem("5");
        comboBox.addItem("6");
        comboBox.addItem("7");
        comboBox.addItem("8");
        comboBox.addItem("9");
        comboBox.addItem("10");
        comboBox.addItem("11");
        comboBox.addItem("12");
        comboBox.addItem("13");
        comboBox.addItem("14");
        comboBox.addItem("15");
        comboBox.addItem("16");
        comboBox.addItem("17");
        comboBox.addItem("18");
        comboBox.addItem("19");
        comboBox.addItem("20");
        comboBox.addItem("21");
        comboBox.addItem("22");
        comboBox.addItem("23");
        comboBox.addItem("24");
        comboBox.addItem("25");
        comboBox.addItem("26");
        comboBox.addItem("27");
        comboBox.addItem("28");
        comboBox.addItem("29");
        comboBox.addItem("30");
        comboBox.addItem("31");
		comboBox.setBounds(191, 382, 52, 20);
		f.getContentPane().add(comboBox);
		
		comboBox_2 = new JComboBox();
        comboBox_2.addItem("Month");
        comboBox_2.addItem("January");
        comboBox_2.addItem("February");
        comboBox_2.addItem("March");
        comboBox_2.addItem("April");
        comboBox_2.addItem("May");
        comboBox_2.addItem("June");
        comboBox_2.addItem("July");
        comboBox_2.addItem("August");
        comboBox_2.addItem("September");
        comboBox_2.addItem("October");
        comboBox_2.addItem("November");
        comboBox_2.addItem("December");
		comboBox_2.setBounds(242, 382, 75, 20);
		f.getContentPane().add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.addItem("Year");
		comboBox_3.addItem("2019");
        comboBox_3.addItem("2018");
        comboBox_3.addItem("2017");
        comboBox_3.addItem("2016");
        comboBox_3.addItem("2015");
        comboBox_3.addItem("2014");
        comboBox_3.addItem("2013");
        comboBox_3.addItem("2012");
        comboBox_3.addItem("2011");
        comboBox_3.addItem("2010"); 
        comboBox_3.addItem("2009");
        comboBox_3.addItem("2008");
        comboBox_3.addItem("2007");
        comboBox_3.addItem("2006");
       	comboBox_3.addItem("2005");
        comboBox_3.addItem("2004");
        comboBox_3.addItem("2003");
        comboBox_3.addItem("2002");
        comboBox_3.addItem("2001");
        comboBox_3.addItem("2000");
        comboBox_3.addItem("1999");
        comboBox_3.addItem("1998");
        comboBox_3.addItem("1997");
        comboBox_3.addItem("1996");
        comboBox_3.addItem("1995");
        comboBox_3.setBounds(316, 382, 75, 20);
		f.getContentPane().add(comboBox_3);
		
		btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.setBounds(160, 428, 117, 30);
		f.getContentPane().add(btnSave);
		btnSave.addActionListener(this);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(301, 428, 100, 30);
		f.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 146, 200, 23);
		f.getContentPane().add(passwordField);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(524, 460, 89, 23);
		f.getContentPane().add(btnBack);
		
		btnChooseImage = new JButton("CHOOSE IMAGE");
		btnChooseImage.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		btnChooseImage.setBounds(432, 221, 158, 23);
		btnChooseImage.addActionListener(this);
		f.getContentPane().add(btnChooseImage);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(452, 72, 117, 110);
		f.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("E:\\java Image\\image.png"));
		lblNewLabel_1.setBounds(432, 42, 158, 168);
		f.getContentPane().add(lblNewLabel_1);
		
		btnBack.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancel)
		{
			javax.swing.JOptionPane.showMessageDialog(null, "NOTHING SAVED!!!");
			textField.setText(null);
			textField_1.setText(null);
			passwordField.setText(null);
			textField_3.setText(null);
			textPane.setText(null);
			comboBox.setSelectedIndex(0);
			comboBox_2.setSelectedIndex(0);
			comboBox_3.setSelectedIndex(0);
			lblNewLabel_2.setIcon(null);
		}
		if(e.getSource()==btnSave)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/librarian",DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="insert into lib_info values(?,?,?,?,?,?,?,?)";
				PreparedStatement st=cn.prepareStatement(str);
				if(rdbtnMale.isSelected())
				gender	= "Male";
				else if(rdbtnFemale.isSelected())
				gender="Feamale";
				else
				gender="Other";
				String str1=textField.getText();
				Date=comboBox.getSelectedItem().toString()+"/"+comboBox_2.getSelectedItem().toString()+"/"+comboBox_3.getSelectedItem().toString();
				st.setString(1, str1);
				st.setString(2, textField_1.getText());
				st.setString(3, String.valueOf(passwordField.getPassword()));
				st.setString(4, gender);
				st.setString(5, textField_3.getText());
				st.setString(6, textPane.getText());
				st.setString(7, Date);
				st.setBytes(8, p_image);
				st.executeUpdate();
				cn.close();
				javax.swing.JOptionPane.showMessageDialog(null, "DATA SAVED!!!");
				textField.setText(null);
				textField_1.setText(null);
				passwordField.setText(null);
				textField_3.setText(null);
				textPane.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				lblNewLabel_2.setIcon(null);
				g1.clearSelection();
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		}
		if(e.getSource()==btnBack)
		{
			f.dispose();
			new ADMIN();
		}
		if(e.getSource()== btnChooseImage)
		{
			String Path=null;
			JFileChooser jc=new JFileChooser();
			jc.showOpenDialog(null);
			File f=jc.getSelectedFile();
			Path=f.getAbsolutePath();
			ic=new ImageIcon(new ImageIcon(Path).getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH));
			lblNewLabel_2.setIcon(ic);
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
