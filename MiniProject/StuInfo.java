
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class StuInfo implements ActionListener{

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
	private JButton btnBack;
	public static JTextArea textArea;
	public static JLabel label_2;
	public static JTable table;
	public static DefaultTableModel dm;
	public StuInfo() {
		f=new JFrame("Student Column");
		f.getContentPane().setBackground(new Color(255, 240, 245));
		f.getContentPane().setForeground(new Color(255, 240, 245));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 872, 722);
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
		btnBack.setIcon(null);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(749, 651, 107, 32);
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
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane js=new JScrollPane(textArea);
		js.setBounds(220, 355, 184, 25);
		f.getContentPane().add(js);
		
		label_2 = new JLabel("");
		label_2.setBounds(651, 260, 164, 25);
		f.getContentPane().add(label_2);
		
		dm=new DefaultTableModel(new String[] {"BOOk ID","BOOK NAME","ISSUE DATE AND TIME"},0);
		table = new JTable();
		table.setEnabled(false);
		JScrollPane JS=new JScrollPane(table);
		JS.setBounds(10, 516, 696, 135);
		f.getContentPane().add(JS);
		
		JLabel lblIssuedBookDetails = new JLabel("ISSUED BOOK DETAILS :");
		lblIssuedBookDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblIssuedBookDetails.setBounds(10, 473, 238, 32);
		f.getContentPane().add(lblIssuedBookDetails);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnBack)
		{
			f.dispose();
			new First();
		}
	}
}
