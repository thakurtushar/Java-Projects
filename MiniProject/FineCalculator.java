import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FineCalculator implements ActionListener{
	
	JFrame f;
	JButton btnBack,btnCalculate;
	private JTextField textField;
	JDateChooser dateChooser;
	JDateChooser dateChooser_1;
	private JTextField textField_1;
	public FineCalculator() {
		f=new JFrame("Calculator");
		f.getContentPane().setBackground(new Color(204, 204, 153));
		f.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 22));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 483, 327);
		f.getContentPane().setLayout(null);
		
		btnBack = new JButton("BACK");
		btnBack.setBounds(378, 265, 89, 23);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		f.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		
		
		JLabel lblDateOfIssue = new JLabel("DUE DATE");
		lblDateOfIssue.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDateOfIssue.setBounds(32, 34, 126, 23);
		f.getContentPane().add(lblDateOfIssue);
		
		
		JLabel lblTodaysDate = new JLabel("TODAY'S DATE");
		lblTodaysDate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTodaysDate.setBounds(32, 85, 126, 23);
		f.getContentPane().add(lblTodaysDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(205, 85, 200, 20);
		f.getContentPane().add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(205, 37, 200, 20);
		f.getContentPane().add(dateChooser_1);
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblPerDayFine = new JLabel("PER DAY FINE ");
		lblPerDayFine.setForeground(new Color(51, 51, 204));
		lblPerDayFine.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPerDayFine.setBounds(32, 129, 115, 23);
		f.getContentPane().add(lblPerDayFine);
		
		textField = new JTextField();
		textField.setBounds(205, 131, 200, 21);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnCalculate = new JButton("CALCULATE");
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCalculate.setBounds(139, 228, 162, 34);
		f.getContentPane().add(btnCalculate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 181, 200, 23);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTotalFine = new JLabel("TOTAL FINE");
		lblTotalFine.setForeground(Color.RED);
		lblTotalFine.setBackground(Color.RED);
		lblTotalFine.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalFine.setBounds(32, 178, 115, 27);
		f.getContentPane().add(lblTotalFine);
		btnCalculate.addActionListener(this);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBack)
		{
			new First();
			f.dispose();
		}
		if(e.getSource()==btnCalculate)
		{
			LocalDateTime due_date=LocalDateTime.ofInstant(dateChooser_1.getDate().toInstant(), ZoneId.systemDefault());
			LocalDateTime today_date=LocalDateTime.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault());
			
			Duration d=Duration.between(due_date, today_date);
			double value=d.toDays();
			double value1=Double.parseDouble(textField.getText());
			double total_fine=value*value1;
			textField_1.setText("RS."+total_fine);
			}
	}
}
