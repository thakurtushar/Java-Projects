

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class TLib implements ActionListener  {

	JFrame f;
	public static JTextField textField;
	public static JTable table;
	JButton btnBack;
	public static DefaultTableModel dm;
	public TLib() {
		f=new JFrame("Librarian Details");
		f.getContentPane().setBackground(new Color(255, 153, 255));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 621, 374);
		f.getContentPane().setLayout(null);
		
		JLabel lblTotalNoOf = new JLabel("TOTAL NO. OF LIBRARIAN");
		lblTotalNoOf.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalNoOf.setBounds(22, 69, 238, 31);
		f.getContentPane().add(lblTotalNoOf);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Times New Roman", Font.BOLD, 17));
		label.setBounds(327, 11, 239, 22);
		f.getContentPane().add(label);
		label.setText(DateFormat.getDateTimeInstance().format(new Date()));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(328, 74, 238, 22);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		dm=new DefaultTableModel(new String[] {"LIBRARIAN NAME","LIBRARIAN ID","LIBRARIAN GENDER","LIBRARIAN CONTACT","LIBRARIAN ADDRESS","DATE OF JOIN"},0);
		table = new JTable();
		JScrollPane js=new JScrollPane(table);
		js.setBounds(24, 129, 542, 158);
		f.getContentPane().add(js);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(516, 312, 89, 23);
		f.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
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
