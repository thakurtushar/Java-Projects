

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Splash {

	JFrame f;
	private JLabel label;
	private JProgressBar progressBar;
	private JLabel lblLoading;
	public Splash() {
		f=new JFrame("WELCOME...");
		f.getContentPane().setBackground(new Color(216, 191, 216));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 517, 373);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(247, 0, 253, 28);
		lblNewLabel_1.setText(DateFormat.getDateTimeInstance().format(new Date()));
		f.getContentPane().add(lblNewLabel_1);
		
		lblLoading = new JLabel("LOADING!!!");
		lblLoading.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblLoading.setForeground(new Color(0, 0, 0));
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setBounds(0, 313, 99, 21);
		f.getContentPane().add(lblLoading);
		
		label = new JLabel("");
		label.setForeground(new Color(139, 0, 139));
		label.setBounds(0, 24, 500, 286);
		f.getContentPane().add(label);
		ImageIcon ic=new ImageIcon("E:\\java Image\\GIPHY1.gif");
		label.setIcon(ic);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(-10, 313, 510, 21);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		f.getContentPane().add(progressBar);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		try {
			int i=0;
			while(i<=100)
			{
				
				progressBar.setValue(i+10);
				Thread.sleep(1000);
				if(i==100)
				{
					f.dispose();
					new DbConnection();
				}
				i+=20;
				
		}}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String ar[])
	{
		new Splash();
	}
}

