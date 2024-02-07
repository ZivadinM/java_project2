package GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KLASEE.Datee;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class Statistic extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocetnaGUI frame = new PocetnaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */	public static Scanner ss=null;
	 	public static Scanner sss=null;

	public Statistic() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetCardioTrening = new JLabel("Statistika");
		lblSetCardioTrening.setBounds(214, 10, 307, 32);
		lblSetCardioTrening.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetCardioTrening.setForeground(SystemColor.textHighlight);
		lblSetCardioTrening.setFont(new Font("Montserrat Black", Font.PLAIN, 25));
		contentPane.add(lblSetCardioTrening);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Montserrat", Font.BOLD, 13));
		textArea.setBounds(20, 152, 278, 323);
		contentPane.add(textArea);
		try {
			ss=new Scanner(new File("Goal"+PocetnaGUI.tempuser+".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			 System.exit(1);
		}
		String line="";
		double distanca;
		int vreme;
		double cal=0;
		double cal1=0;
		while(ss.hasNext()) {
			line=ss.nextLine().trim();
			distanca=Double.valueOf(line);
			
			line=ss.nextLine().trim();
			vreme=Integer.valueOf(line);
			
			line=ss.nextLine().trim();
			cal=Double.valueOf(line);
			
			textArea.setText("Distanca \t Vreme \t Calorije\n\n"+distanca+"\t"+vreme+"\t  "+cal+"\n");
			
		}
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Montserrat", Font.BOLD, 13));
		textArea_1.setBounds(441, 152, 284, 323);
		contentPane.add(textArea_1);
		try {
			sss=new Scanner(new File("Stat"+PocetnaGUI.tempuser+".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			 System.exit(1);
		}
		distanca=0;
		vreme=0;
		cal1=0;

		while(sss.hasNext()) {
			line=sss.nextLine().trim();
			distanca+=Double.valueOf(line);
			
			line=sss.nextLine().trim();
			vreme+=Integer.valueOf(line);
			
			line=sss.nextLine().trim();
			cal1+=Double.valueOf(line);
			
			
			
		}
		double procenat=100*cal1/cal;
		textArea_1.setText("Distanca \t Vreme \t Calorije\n\n"+distanca+"\t"+vreme+"\t   "+cal1+"\n");
		JLabel lblGoal = new JLabel("Cilj");
		lblGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoal.setForeground(SystemColor.textHighlight);
		lblGoal.setFont(new Font("Montserrat Black", Font.PLAIN, 25));
		lblGoal.setBounds(20, 120, 279, 32);
		contentPane.add(lblGoal);
		
		JLabel lblSetCardioTrening_1_1 = new JLabel("Tvoje aktivnosti");
		lblSetCardioTrening_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetCardioTrening_1_1.setForeground(SystemColor.textHighlight);
		lblSetCardioTrening_1_1.setFont(new Font("Montserrat Black", Font.PLAIN, 25));
		lblSetCardioTrening_1_1.setBounds(441, 120, 284, 32);
		contentPane.add(lblSetCardioTrening_1_1);
		
		JLabel lblGoal_1 = new JLabel("Kalorije %");
		lblGoal_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoal_1.setForeground(SystemColor.textHighlight);
		lblGoal_1.setFont(new Font("Montserrat Black", Font.PLAIN, 20));
		lblGoal_1.setBounds(285, 195, 164, 21);
		contentPane.add(lblGoal_1);
		
		JLabel lblGoal_1_1 = new JLabel(Double.toString(procenat));
		lblGoal_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoal_1_1.setForeground(SystemColor.textHighlight);
		lblGoal_1_1.setFont(new Font("Montserrat Black", Font.PLAIN, 19));
		lblGoal_1_1.setBounds(315, 226, 105, 21);
		contentPane.add(lblGoal_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1.setBounds(516, -26, 10, 651);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(199, 21, 133));
		panel_1_3.setBounds(194, -5, 10, 630);
		contentPane.add(panel_1_3);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1_1.setBounds(647, 0, 10, 651);
		contentPane.add(panel_1_1_1_1);
		
		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setBackground(new Color(199, 21, 133));
		panel_1_3_1.setBounds(71, -5, 10, 630);
		contentPane.add(panel_1_3_1);
		
		JButton btnNewButton_2_2 = new JButton("Back");
		btnNewButton_2_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton_2_2.setBounds(325, 454, 85, 21);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					OdabirAktivnosti frame = new OdabirAktivnosti();
					frame.setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_2_2);
	}
}
