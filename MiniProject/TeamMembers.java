
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TeamMembers implements ActionListener {

	JFrame f;
	JButton btnBack;
	public TeamMembers() {
		f=new JFrame("");
		f.getContentPane().setBackground(new Color(169, 169, 169));
		f.getContentPane().setLayout(null);
		
		JLabel lblTeamLeader = new JLabel("DEVELOPER'S TEAM : ");
		lblTeamLeader.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTeamLeader.setBounds(10, 57, 258, 40);
		f.getContentPane().add(lblTeamLeader);
		
		JLabel lblRishabhGangwar = new JLabel("1.) RISHABH GANGWAR ");
		lblRishabhGangwar.setForeground(new Color(255, 0, 0));
		lblRishabhGangwar.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblRishabhGangwar.setBounds(10, 97, 240, 31);
		f.getContentPane().add(lblRishabhGangwar);
		
		JLabel lblNewLabel = new JLabel("2.) TUSHAR SINGH");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 145, 240, 31);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblAnmolSaxena = new JLabel("3.) ANMOL  SAXENA");
		lblAnmolSaxena.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAnmolSaxena.setForeground(new Color(255, 0, 0));
		lblAnmolSaxena.setBounds(10, 190, 240, 31);
		f.getContentPane().add(lblAnmolSaxena);
		
		JLabel lblPiyushChauhan = new JLabel("4.) PIYUSH CHAUHAN");
		lblPiyushChauhan.setForeground(new Color(255, 0, 0));
		lblPiyushChauhan.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblPiyushChauhan.setBounds(10, 232, 240, 31);
		f.getContentPane().add(lblPiyushChauhan);
		
		JLabel lblteamLeader = new JLabel("[TEAM LEADER]");
		lblteamLeader.setForeground(new Color(148, 0, 211));
		lblteamLeader.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblteamLeader.setBounds(260, 97, 171, 31);
		f.getContentPane().add(lblteamLeader);
		
		JLabel lblcleader = new JLabel("[C0-LEADER]");
		lblcleader.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblcleader.setForeground(new Color(148, 0, 211));
		lblcleader.setBounds(260, 145, 171, 31);
		f.getContentPane().add(lblcleader);
		
		JLabel lblseniorConsultant = new JLabel("[SENIOR CONSULTANT]");
		lblseniorConsultant.setForeground(new Color(148, 0, 211));
		lblseniorConsultant.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblseniorConsultant.setBounds(260, 190, 230, 31);
		f.getContentPane().add(lblseniorConsultant);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(494, 258, 89, 23);
		f.getContentPane().add(btnBack);
		
		JLabel lblFutureInstituteOf = new JLabel("FUTURE INSTITUTE OF ENGINEERING AND TECHNOLOGY");
		lblFutureInstituteOf.setForeground(new Color(0, 0, 0));
		lblFutureInstituteOf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblFutureInstituteOf.setBounds(10, 11, 480, 23);
		f.getContentPane().add(lblFutureInstituteOf);
		
		JLabel lblBachelorOfTechnolgy = new JLabel("B.TECH (3RD YEAR)");
		lblBachelorOfTechnolgy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBachelorOfTechnolgy.setBounds(10, 36, 171, 23);
		f.getContentPane().add(lblBachelorOfTechnolgy);
		btnBack.addActionListener(this);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 599, 320);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnBack)
		{
			f.dispose();
			new First();
		}
	}
}
