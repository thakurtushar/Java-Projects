import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.SwingConstants;

public class ADMIN implements ActionListener {
JFrame f;
JButton btnBack;
JButton btnAddNewLibrarian;
JButton btnDeleteLibrarian,btnStudentDetails;
private JLabel lblAddLibrarian;
	
	public ADMIN() {
		f=new JFrame("Admin Login");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 692, 376);
		f.getContentPane().setLayout(null);
	    
	    btnAddNewLibrarian= new JButton();
	    btnAddNewLibrarian.setBounds(46, 69, 166, 152);
	    f.getContentPane().add(btnAddNewLibrarian);
	    btnAddNewLibrarian.addActionListener(this);
		
	    btnDeleteLibrarian = new JButton("");
	    btnDeleteLibrarian.setIcon(new ImageIcon("E:\\java Image\\icon9.png"));
	    btnDeleteLibrarian.setBounds(257, 69, 166, 152);
		f.getContentPane().add(btnDeleteLibrarian);
		btnDeleteLibrarian.addActionListener(this);
		
		btnStudentDetails = new JButton("");
		btnStudentDetails.setIcon(new ImageIcon("E:\\java Image\\icon10.png"));
		btnStudentDetails.setBounds(474, 69, 166, 152);
		f.getContentPane().add(btnStudentDetails);
		btnStudentDetails.addActionListener(this);
		
		btnBack = new JButton("LOGOUT");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBounds(531, 308, 145, 29);
		f.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel label = new JLabel(new ImageIcon("E:\\java Image\\add-user.png"));
		label.setBounds(62, 69, 150, 131);
		btnAddNewLibrarian.add(label);
		
		lblAddLibrarian = new JLabel("ADD LIBRARIAN");
		lblAddLibrarian.setForeground(Color.RED);
		lblAddLibrarian.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddLibrarian.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddLibrarian.setBounds(46, 247, 160, 29);
		f.getContentPane().add(lblAddLibrarian);
		
		JLabel lblDeleteLibrarian = new JLabel("DELETE LIBRARIAN");
		lblDeleteLibrarian.setForeground(new Color(255, 0, 0));
		lblDeleteLibrarian.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDeleteLibrarian.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteLibrarian.setBounds(257, 247, 166, 29);
		f.getContentPane().add(lblDeleteLibrarian);
		
		JLabel lblViewUpdate = new JLabel("STUDENT DETAILS");
		lblViewUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblViewUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewUpdate.setForeground(new Color(255, 0, 0));
		lblViewUpdate.setBounds(474, 247, 160, 29);
		f.getContentPane().add(lblViewUpdate);
		
		JLabel l=new JLabel(new ImageIcon("E:\\java image\\1.jpg"));
		l.setBounds(0,0,683,337);
		f.getContentPane().add(l);
		f.setLocationRelativeTo(null);		
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnBack)
		{
			f.dispose();
			new First();
		}
		if(e.getSource()==btnAddNewLibrarian)
		{
			String Str1="CREATE TABLE IF NOT EXISTS lib_info(lib_name varchar(50) not null,lib_id varchar(20) not null,lib_password varchar(25) not null,lib_gender varchar(10) not null,lib_phoneno varchar(20) not null,lib_address varchar(50) not null,lib_DOJoin varchar(20) not null,lib_image LONGBLOB NOT NULL)";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/",DbConnection.textField.getText(),DbConnection.passwordField.getText());
				Statement st=cn.createStatement();
				String str="create database IF NOT EXISTS librarian";
				st.executeUpdate(str);
				st.executeUpdate("use librarian");
				st.executeUpdate(Str1);
				new AddLib();
				f.dispose();
				cn.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
			
		}
		if(e.getSource()==btnDeleteLibrarian)
		{
			new DelLib();
			f.dispose();
		}
		if(e.getSource()==btnStudentDetails)
		{
			new StuDetail();
			f.dispose();
		}
	}
}
