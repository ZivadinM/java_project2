package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Cardio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
	 */
	public Cardio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Walk", "Joging", "Running"}));
		comboBox.setBounds(126, 85, 116, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Tip hodanja:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblNewLabel.setBounds(48, 88, 81, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vreme:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(48, 130, 81, 13);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(24, 186, 462, 13);
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Integer.parseInt(textField_2.getText().toString())>31 || Integer.parseInt(textField_3.getText().toString())>12 || Integer.parseInt(textField_4.getText().toString())<2022)
						throw new Exception("Mesec ne moze biti veci od 12 ili dan veci od 31 i godina manja od 2022");
					
					if(textField_4.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty() || textField.getText().isEmpty()) 
						throw new Exception("Morate popuniti sva polja");
					float cal=0;
					double brzina=0;
					if(comboBox.getSelectedItem().toString().compareTo("Walk")==0) {
					cal=(float)(Integer.parseInt(textField.getText().toString())*40);
					brzina=4*(Integer.parseInt(textField.getText().toString()))/60;
					lblNewLabel_2.setText("Potroseno je "+cal/40+" kalorija za "+textField.getText().toString()+" minuta.");}
					
					if(comboBox.getSelectedItem().toString().compareTo("Joging")==0) {
					cal=(float)(Integer.parseInt(textField.getText().toString())*60);
					brzina=6*(Integer.parseInt(textField.getText().toString()))/60;
					lblNewLabel_2.setText("Potroseno je "+cal/40+" kalorija za "+textField.getText().toString()+" minuta.");}
					
					if(comboBox.getSelectedItem().toString().compareTo("Running")==0) {
					cal=(float)(Integer.parseInt(textField.getText().toString())*70);
					brzina=10*(Integer.parseInt(textField.getText().toString()))/60;
					lblNewLabel_2.setText("Potroseno je "+cal/40+" kalorija za "+textField.getText().toString()+" minuta.");}
					
					FileWriter l=new FileWriter("History"+PocetnaGUI.tempuser+".txt",true);
					PrintWriter izl=new PrintWriter(l);
					
					FileWriter ll=new FileWriter("Stat"+PocetnaGUI.tempuser+".txt",true);
					PrintWriter izll=new PrintWriter(ll);
					
					izl.println("Cardio");
					izl.println(textField.getText().toString());
					izl.println(textField_2.getText());
					izl.println(textField_3.getText());
					izl.println(textField_4.getText());
					izl.println(cal/40);
					izl.flush(); 
					izl.close();
					izll.println(brzina);
					izll.println(Integer.parseInt(textField.getText().toString()));
					izll.println(cal/40);
					izll.flush(); 
					izll.close();
					throw new Exception("Uneli ste novu aktivnost");

				} catch (Exception x) {
					JOptionPane.showMessageDialog(null, x.getMessage());
				}
				
			}
		});
		btnNewButton.setFont(new Font("Montserrat", Font.PLAIN, 13));
		btnNewButton.setBounds(257, 282, 85, 21);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(25, 18, 582, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSetCardioTrening = new JLabel("Unesite Cardio Trening");
		lblSetCardioTrening.setBounds(139, 10, 271, 32);
		panel.add(lblSetCardioTrening);
		lblSetCardioTrening.setForeground(SystemColor.text);
		lblSetCardioTrening.setFont(new Font("Montserrat Black", Font.PLAIN, 25));
		lblSetCardioTrening.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_2_2 = new JButton("Back");
		btnNewButton_2_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton_2_2.setBounds(0, 283, 85, 21);
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
		panel.add(btnNewButton_2_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Unesite Datum(Dan/Mesec/Godina):");
		lblNewLabel_1_1_2.setBounds(24, 148, 225, 13);
		panel.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(SystemColor.text);
		lblNewLabel_1_1_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setBounds(249, 148, 96, 19);
		panel.add(textField_2);
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(351, 148, 96, 19);
		panel.add(textField_3);
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(453, 148, 96, 19);
		panel.add(textField_4);
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		textField_4.setColumns(10);
		
	
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(72, 112, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("min");
		lblNewLabel_1_1_1_1.setBounds(168, 114, 81, 13);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1.setBounds(93, -121, 10, 651);
		panel.add(panel_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1_1.setBounds(482, -121, 10, 651);
		panel.add(panel_1_1_1_1);
	}

}
