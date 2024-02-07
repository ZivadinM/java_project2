package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KLASEE.History;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SetGoal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static ArrayList <Statistic> stats=new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetGoal frame = new SetGoal();
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
	public SetGoal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(109, 128, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(17, 18, 297, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSetCardioTrening = new JLabel("Postavljanje Cilja");
		lblSetCardioTrening.setBounds(23, 10, 250, 32);
		panel.add(lblSetCardioTrening);
		lblSetCardioTrening.setForeground(SystemColor.text);
		lblSetCardioTrening.setFont(new Font("Montserrat Black", Font.PLAIN, 25));
		lblSetCardioTrening.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("min");
		lblNewLabel_1_1_1.setBounds(199, 159, 81, 13);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 157, 47, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vreme Aktivnosti:");
		lblNewLabel_1_1.setBounds(24, 159, 111, 13);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 197, 96, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("cal");
		lblNewLabel_1_1_1_2.setForeground(SystemColor.text);
		lblNewLabel_1_1_1_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2.setBounds(192, 196, 81, 19);
		panel.add(lblNewLabel_1_1_1_2);
		
		JButton btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
										
					FileWriter l=new FileWriter("Goal"+PocetnaGUI.tempuser+".txt",true);
					PrintWriter izl=new PrintWriter(l);
					
					izl.println(textField.getText().toString());
					izl.println(textField_1.getText());
					izl.println(textField_2.getText());
					izl.flush(); 
					izl.close();
					
					throw new Exception("Uneliste novi cilj");
					
				} catch (Exception x) {
					JOptionPane.showMessageDialog(null, x.getMessage());
				}
			}
		});
		btnNewButton.setBounds(100, 239, 96, 21);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Montserrat", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Sagoreno:");
		lblNewLabel_1_1_2.setBounds(23, 199, 65, 13);
		panel.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(SystemColor.text);
		lblNewLabel_1_1_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Distanca:");
		lblNewLabel_1.setBounds(23, 114, 81, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("km");
		lblNewLabel_1_1_1_1.setBounds(192, 114, 81, 13);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
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
		btnNewButton_2_2.setBounds(100, 273, 96, 21);
		panel.add(btnNewButton_2_2);
		btnNewButton_2_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1.setBounds(237, -130, 10, 651);
		panel.add(panel_1_1_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(199, 21, 133));
		panel_1_3.setBounds(-77, -111, 10, 630);
		panel.add(panel_1_3);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1_1.setBounds(49, -111, 10, 651);
		panel.add(panel_1_1_1_1);
	}
}
