
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

public class DelLib implements ActionListener{

	JFrame f;
	private JTextField textField;
	JButton btnNewButton_1,btnNewButton;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    static String s;
    private JButton btnBack;
    static byte b[];
    static Blob blob;
	public DelLib(){
		f=new JFrame("DELETE LIBRARIAN");
		f.getContentPane().setBackground(new Color(0, 255, 127));
		f.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 484, 244);
		f.getContentPane().setLayout(null);
		
		JLabel lblEnterLibrarianId = new JLabel("LIBRARIAN ID ");
		lblEnterLibrarianId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEnterLibrarianId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterLibrarianId.setBounds(10, 50, 157, 24);
		f.getContentPane().add(lblEnterLibrarianId);
		
		textField = new JTextField();
		textField.setBounds(177, 44, 258, 38);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("GO");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(92, 123, 110, 38);
		f.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_1= new JButton("CANCEL");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(252, 123, 110, 38);
		f.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(379, 182, 89, 23);
		f.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnNewButton_1)
		{
			javax.swing.JOptionPane.showMessageDialog(null,"NOTHING SAVED!!!");
			textField.setText(null);
		}
		if(arg0.getSource()==btnNewButton)
		{
			s=textField.getText();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/librarian",  DbConnection.textField.getText(), DbConnection.passwordField.getText());
				String str="select lib_name,lib_id,lib_password,lib_gender,lib_phoneno,lib_address,lib_DOJoin,lib_image from lib_info";
				PreparedStatement st=cn.prepareStatement(str);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					s1=rs.getString(1);
					s2=rs.getString(2);
					s3=rs.getString(3);
					s4=rs.getString(4);
					s5=rs.getString(5);
					s6=rs.getString(6);
					s7=rs.getString(7);
					blob=rs.getBlob(8);
					b=blob.getBytes(1,(int)blob.length());
					if(s2.equals(s))
					{
							new LibDetail();
							LibDetail.textField.setText(s1);
							LibDetail.textField_1.setText(s2);
							LibDetail.textField_5.setText(s3);
							LibDetail.textField_4.setText(s4);
							LibDetail.textField_2.setText(s5);
							LibDetail.textPane.setText(s6);
							LibDetail.textField_3.setText(s7);
							ImageIcon ic=new ImageIcon(new ImageIcon(b).getImage().getScaledInstance(LibDetail.label.getWidth(), LibDetail.label.getHeight(), Image.SCALE_SMOOTH));
							LibDetail.label.setIcon(ic);
							f.dispose();
					}
				}
				
				cn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		if(arg0.getSource()==btnBack)
		{
			
			new ADMIN();
			f.dispose();
		}
		
	}
}
