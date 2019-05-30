

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
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class AdminRegistration implements ActionListener{

	JFrame f;
	ImageIcon ic;
	private JTextField textField;
	JLabel label,label_1;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	JTextPane textPane;
	byte[] p_image=null;
	JButton btnCancel,btnSave,btnChooseImage;
	public AdminRegistration() {
		f=new JFrame("ADMIN REGISTRATION");
		f.getContentPane().setBackground(new Color(230, 230, 250));
		f.getContentPane().setForeground(new Color(0, 204, 204));
		f.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblName.setBounds(37, 56, 67, 24);
		f.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(147, 57, 195, 24);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 565, 379);
		
		label = new JLabel("");
		label.setBounds(384, 41, 118, 111);
		f.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("E:\\java Image\\image.png"));
		lblNewLabel_1.setBounds(363, 23, 158, 144);
		f.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("ADMIN ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 104, 81, 24);
		f.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 105, 195, 24);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(37, 156, 91, 25);
		f.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 157, 195, 24);
		f.getContentPane().add(passwordField);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAddress.setBounds(37, 211, 81, 24);
		f.getContentPane().add(lblAddress);
		
		textPane = new JTextPane();
		textPane.setBounds(147, 212, 195, 51);
		f.getContentPane().add(textPane);
		
		JLabel lblDateTime = new JLabel("DATE & TIME");
		lblDateTime.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDateTime.setBounds(37, 23, 107, 22);
		f.getContentPane().add(lblDateTime);
		
		label_1 = new JLabel("");
		label_1.setBounds(147, 23, 195, 23);
		label_1.setText(DateFormat.getDateTimeInstance().format(new Date()));
		f.getContentPane().add(label_1);
		
		btnChooseImage = new JButton("CHOOSE IMAGE");
		btnChooseImage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnChooseImage.setBounds(363, 189, 158, 23);
		f.getContentPane().add(btnChooseImage);
		btnChooseImage.addActionListener(this);
		
		btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.setBounds(119, 293, 122, 36);
		f.getContentPane().add(btnSave);
		btnSave.addActionListener(this);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(251, 294, 107, 35);
		f.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnCancel)
		{
			f.dispose();
			new ADMINLOGIN();
		}
		if(arg0.getSource()== btnChooseImage)
		{
			String Path=null;
			JFileChooser jc=new JFileChooser();
			jc.showOpenDialog(null);
			File f=jc.getSelectedFile();
			Path=f.getAbsolutePath();
			ic=new ImageIcon(new ImageIcon(Path).getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH));
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
				e1.getMessage();
			}
			
		}
		if(arg0.getSource()==btnSave)
		{
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/Admin", DbConnection.textField.getText(), DbConnection.passwordField.getText());
					String str="insert into a_info values(?,?,?,?,?,?)";
					PreparedStatement st=cn.prepareStatement(str);
					st.setString(1, textField.getText());
					st.setString(2, textField_1.getText());
					st.setString(3, passwordField.getText());
					st.setString(4, label_1.getText());
					st.setString(5, textPane.getText());
					st.setBytes(6, p_image);
					st.executeUpdate();
					javax.swing.JOptionPane.showMessageDialog(null, "DATA SAVED!!");
					cn.close();
			}
			catch(Exception e)
			{

				System.out.println(e.getMessage());
				//javax.swing.JOptionPane.showMessageDialog(null,"Someerror has occured...");
			}

		}
	}
}
