

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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class LibDetail implements ActionListener {
	JFrame f;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextPane textPane;
	String s,value2;
	JButton btnNewButton,btnNewButton_1,btnEdit,btnUpdate;
	static JLabel label;
	private JLabel lblGender;
	public static JTextField textField_4;
	public static JTextField textField_5;
	private JButton btnChooseImage;
	static byte[] p_image=DelLib.b;
	public LibDetail() {
		f=new JFrame("LIBRARIAN DETAILS");
		f.getContentPane().setBackground(new Color(100, 149, 237));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 650, 499);
		f.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 26, 59, 28);
		f.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(181, 27, 201, 27);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblLibrarianId = new JLabel("LIBRARIAN ID");
		lblLibrarianId.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrarianId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLibrarianId.setBounds(10, 82, 99, 28);
		f.getContentPane().add(lblLibrarianId);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(181, 83, 201, 28);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(0, 236, 102, 28);
		f.getContentPane().add(lblAddress);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(181, 236, 201, 67);
		f.getContentPane().add(textPane);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneNo.setBounds(0, 310, 109, 35);
		f.getContentPane().add(lblPhoneNo);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(181, 314, 201, 28);
		f.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDateOfJoin = new JLabel("DATE OF JOIN");
		lblDateOfJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfJoin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfJoin.setBounds(10, 356, 109, 35);
		f.getContentPane().add(lblDateOfJoin);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(181, 360, 201, 28);
		f.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("DELETE");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(88, 414, 102, 35);
		f.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(537, 432, 97, 28);
		f.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		label = new JLabel("");
		label.setBounds(452, 56, 118, 111);
		f.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("E:\\java Image\\image.png"));
		lblNewLabel_1.setBounds(432, 26, 158, 168);
		f.getContentPane().add(lblNewLabel_1);
		
		lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setBounds(23, 185, 85, 28);
		f.getContentPane().add(lblGender);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(181, 186, 201, 28);
		f.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(23, 136, 110, 28);
		f.getContentPane().add(lblPassword);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(181, 134, 201, 35);
		f.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdate.setBounds(347, 414, 102, 35);
		f.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEdit.addActionListener(this);
		btnEdit.setBounds(218, 414, 102, 35);
		f.getContentPane().add(btnEdit);
		
		btnChooseImage = new JButton("CHOOSE IMAGE");
		btnChooseImage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnChooseImage.setBounds(432, 189, 158, 23);
		f.getContentPane().add(btnChooseImage);
		btnChooseImage.addActionListener(this);
		f.setLocationRelativeTo(null);		
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnNewButton)
		{
			s=textField_1.getText();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/librarian",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="Delete from lib_info where lib_name=? or lib_id=?";
				PreparedStatement  st=cn.prepareStatement(str);
				{
					st.setString(1, null);
					st.setString(2, s);
					st.executeUpdate();
				}
				cn.close();
				javax.swing.JOptionPane.showMessageDialog(null, "Data Deleted");
				textField.setText(null);
				textField_1.setText(null);
				textPane.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				label.setIcon(null);
				new DelLib();
				f.dispose();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		if(arg0.getSource()==btnNewButton_1)
		{
			f.dispose();
			new DelLib();
		}
		if(arg0.getSource()==btnEdit)
		{
			textField.setEditable(true);
			textField_1.setEditable(true);
			textPane.setEditable(true);
			textField_2.setEditable(true);
			textField_3.setEditable(true);
			textField_4.setEditable(true);
			textField_5.setEditable(true);
		}
		if(arg0.getSource()==btnUpdate)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/librarian",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str1="update lib_info set lib_name=?,lib_id=?,lib_password=?,lib_gender=?,lib_phoneno=?,lib_address=?,lib_DOJoin=?,lib_image=? where lib_id='"+DelLib.s+"'";
				PreparedStatement st=cn.prepareStatement(str1);
				st.setString(1,textField.getText());
				st.setString(2,textField_1.getText());
				st.setString(3, textField_5.getText());
				st.setString(4, textField_4.getText());
				st.setString(5,textField_2.getText());
				st.setString(6, textPane.getText());
				st.setString(7, textField_3.getText());
				st.setBytes(8, p_image);
				st.executeUpdate();
				cn.close();
				javax.swing.JOptionPane.showMessageDialog(null,"DATA UPDATED!!");
			} 
			catch (Exception e)
			{
				javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
			}
			
		}
		if(arg0.getSource()== btnChooseImage)
		{
			
			String Path=null;
			JFileChooser jc=new JFileChooser();
			jc.showOpenDialog(null);
			File f=jc.getSelectedFile();
			Path=f.getAbsolutePath();
			ImageIcon ic=new ImageIcon(new ImageIcon(Path).getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH));
			label.setIcon(ic);
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
