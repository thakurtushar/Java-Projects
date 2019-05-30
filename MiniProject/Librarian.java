
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.SwingConstants;

public class Librarian implements ActionListener  {
	JFrame f;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnCancel;
	private JButton btnBack,btnSave;
	String str1,str3,str4;

	
	public Librarian() {
		f=new JFrame("Librarian Login");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 541, 301);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(227, 42, 226, 34);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 118, 226, 34);
		f.getContentPane().add(passwordField);
		
		btnSave = new JButton("LOGIN");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.setBounds(135, 198, 108, 34);
		f.getContentPane().add(btnSave);
		btnSave.addActionListener(this);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(276, 198, 108, 34);
		f.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(436, 239, 89, 23);
		f.getContentPane().add(btnBack);
		
		JLabel lblLibrarianId = new JLabel("LIBRARIAN ID");
		lblLibrarianId.setHorizontalAlignment(SwingConstants.LEFT);
		lblLibrarianId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLibrarianId.setBounds(59, 42, 127, 34);
		f.getContentPane().add(lblLibrarianId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(59, 117, 127, 34);
		f.getContentPane().add(lblPassword);
		
		JLabel l=new JLabel(new ImageIcon("E:\\java image\\2.jpg"));
		l.setBounds(0, 0, 525, 262);
		f.getContentPane().add(l);
		
		btnBack.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if(arg0.getSource()==btnBack)
		{
			f.dispose();
			new First();
		}
		if(arg0.getSource()==btnCancel)
		{
			
			textField.setText(null);
			passwordField.setText(null);
			javax.swing.JOptionPane.showMessageDialog(null,"NOTHING SAVED!!!GO BACK");
		}
		if(arg0.getSource()==btnSave)
		{
			int i=0;
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/librarian", DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="select lib_id,lib_password from lib_info";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					 str3=rs.getString(1);
					 str4=rs.getString(2);
					 str1=textField.getText();
					String str2=String.valueOf(passwordField.getPassword());
					if(str3.equals(str1) && str4.equals(str2))
					{
						i++;
					}
				}
				if(i!=0)
				{
					new LIbFun();
					f.dispose();
				}
				else
				{
					javax.swing.JOptionPane.showMessageDialog(null, "PLEASE ENTER ID & PASSWORD AGAIN");
					textField.setText(null);
					passwordField.setText(null);
				}
				cn.close();
			} 
			
			catch(Exception e)
			{
				javax.swing.JOptionPane.showMessageDialog(null, "NO CONNECTION FROM DATABASE");
			}
		}
	}
}
