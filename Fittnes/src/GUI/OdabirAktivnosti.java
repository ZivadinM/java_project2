package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KLASEE.Goal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;

public class OdabirAktivnosti extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdabirAktivnosti frame = new OdabirAktivnosti();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OdabirAktivnosti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dobrodoslja nazad "+PocetnaGUI.tempuser);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblNewLabel.setBounds(131, 24, 267, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unesite Cilj:");
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(28, 163, 203, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unesite Aktivnost:");
		lblNewLabel_2.setForeground(SystemColor.control);
		lblNewLabel_2.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(28, 90, 203, 24);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(34, 57, 470, 4);
		contentPane.add(panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Cardio", "Strength Trening", "TreadMill"}));
		comboBox.setBounds(171, 94, 137, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Unesite Cilj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					dispose();
					SetGoal frame = new SetGoal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton.setBounds(131, 161, 127, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unesi");
		btnNewButton_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//klikom na odredjeni item taj se item otvara
				if(comboBox.getSelectedItem().toString()=="Cardio") {
					try {
						dispose();
						Cardio frame = new Cardio();
						frame.setVisible(true);
					} catch (Exception x) {
						x.printStackTrace();
					}
				}

				if(comboBox.getSelectedItem().toString()=="Strength Trening") {
					try {
						dispose();
						StrengthTraning frame = new StrengthTraning();
						frame.setVisible(true);
					} catch (Exception x) {
						x.printStackTrace();
					}
				}
				if(comboBox.getSelectedItem().toString()=="TreadMill") {
					try {
						dispose();
						TreadMill frame = new TreadMill();
						frame.setVisible(true);
					} catch (Exception x) {
						x.printStackTrace();
					}
				}

				}
			
		});
		btnNewButton_1.setBounds(318, 88, 105, 32);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 149, 546, 57);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(Color.BLACK);
		panel_1_1.setBackground(SystemColor.textHighlight);
		panel_1_1.setBounds(0, 71, 546, 57);
		contentPane.add(panel_1_1);
		
		JButton btnNewButton_2 = new JButton("Statistika");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Statistic frame = new Statistic();
					frame.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton_2.setBounds(424, 326, 105, 22);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Odjavi se");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					PocetnaGUI frame = new PocetnaGUI();
					frame.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			
			}
		});
		btnNewButton_2_1.setBounds(0, 326, 92, 23);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		JButton btnSeeHistory = new JButton("Istorija");
		btnSeeHistory.setBounds(191, 306, 146, 32);
		contentPane.add(btnSeeHistory);
		btnSeeHistory.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
 
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setForeground(Color.BLACK);
		panel_1_2.setBackground(SystemColor.textHighlight);
		panel_1_2.setBounds(-33, 294, 595, 137);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(199, 21, 133));
		panel_1_3.setBounds(102, -10, 10, 436);
		contentPane.add(panel_1_3);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1.setBounds(424, -31, 10, 457);
		contentPane.add(panel_1_1_1);
		btnSeeHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					HistoryA frame = new HistoryA();
					frame.setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
	}
}
