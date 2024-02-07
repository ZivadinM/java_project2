package GUI;

import java.awt.EventQueue;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KLASEE.Datee;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class HistoryA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Scanner ss=null;

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
	 */
	public HistoryA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Montserrat", Font.PLAIN, 13));
		textArea.setBounds(39, 48, 558, 253);
		try {
			ss=new Scanner(new File("History"+PocetnaGUI.tempuser+".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			 System.exit(1);
		}
		//citanje iz fajla
		textArea.setText("Naziv Aktivnosti \t Vreme \t Calorije\t Datum\n");
		String line="";
		String naziv;
		int vreme;
		int dan;
		int mesec;
		int godina;
		double cal;
		while(ss.hasNext()) {
			line=ss.nextLine().trim();
			naziv=line;
			
			line=ss.nextLine().trim();
			vreme=Integer.valueOf(line);
			
			line=ss.nextLine().trim();
			dan=Integer.valueOf(line);
			
			line=ss.nextLine().trim();
			mesec=Integer.valueOf(line);

			line=ss.nextLine().trim();
			godina=Integer.valueOf(line);
			
			line=ss.nextLine().trim();
			cal=Double.valueOf(line);
			//kreiranje objekata date
			Datee x=new Datee(dan,mesec,godina);
			if(naziv.compareTo("TreadMill")==0 || naziv.compareTo("Cardio")==0 )
			textArea.append("\n"+naziv+"\t\t"+vreme+"\t"+cal+"\t"+x.toString()+"\n");
			else
				textArea.append("\n"+naziv+"\t"+vreme+"\t"+cal+"\t"+x.toString()+"\n");
		}
		contentPane.add(textArea);
		
		JLabel lblHistorz = new JLabel("ACTIVATION HISTORY");
		lblHistorz.setBounds(190, 10, 256, 28);
		lblHistorz.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistorz.setFont(new Font("Montserrat", Font.PLAIN, 22));
		contentPane.add(lblHistorz);
		JButton btnNewButton_2_2 = new JButton("Nazad");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					OdabirAktivnosti frame = new OdabirAktivnosti();
					frame.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		btnNewButton_2_2.setBounds(267, 306, 101, 21);
		btnNewButton_2_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		contentPane.add(btnNewButton_2_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1.setBounds(463, -60, 10, 651);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(199, 21, 133));
		panel_1_3.setBounds(141, -39, 10, 630);
		contentPane.add(panel_1_3);

	}
}
