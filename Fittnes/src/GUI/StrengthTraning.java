package GUI;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class StrengthTraning extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
	public StrengthTraning() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(24, 191, 462, 13);
		JButton btnNewButton = new JButton("Unesi");
		btnNewButton.setFont(new Font("Montserrat", Font.PLAIN, 13));
		btnNewButton.setBounds(257, 282, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(Integer.parseInt(textField_1.getText().toString())>31 || Integer.parseInt(textField_2.getText().toString())>12 || Integer.parseInt(textField_3.getText().toString())<2022)
						throw new Exception("Mesec ne moze biti veci od 12 ili dan veci od 31 i godina manja od 2022");
					if(textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty() || textField.getText().isEmpty()) 
						throw new Exception("Morate popuniti sva polja");
					double cal;
					cal=(float)(Integer.parseInt(textField.getText().toString())*2);
					lblNewLabel.setText("Potroseno je "+cal+" kalorija za "+textField.getText().toString()+" min");
					
					FileWriter l=new FileWriter("History"+PocetnaGUI.tempuser+".txt",true);
					PrintWriter izl=new PrintWriter(l);
					
					FileWriter ll=new FileWriter("Stat"+PocetnaGUI.tempuser+".txt",true);
					PrintWriter izll=new PrintWriter(ll);
					
					izl.println("StrengthTraning");
					izl.println(textField.getText().toString());
					izl.println(textField_1.getText());
					izl.println(textField_2.getText());
					izl.println(textField_3.getText());
					izl.println(cal);
					izl.flush(); 
					izl.close();					
					izll.println(0);
					izll.println(Integer.parseInt(textField.getText().toString()));
					izll.println(cal);
					izll.flush(); 
					izll.close();
					throw new Exception("Uneli ste novu aktivnost");

				} catch (Exception x) {
					JOptionPane.showMessageDialog(null, x.getMessage());
				}
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(25, 18, 589, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Unesite datum(Dan/Mesec/Godina):");
		lblNewLabel_1_1_2_1.setForeground(SystemColor.text);
		lblNewLabel_1_1_2_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblNewLabel_1_1_2_1.setBounds(24, 153, 226, 13);
		panel.add(lblNewLabel_1_1_2_1);
		textField = new JTextField();
		textField.setBounds(75, 105, 52, 19);
		panel.add(textField);
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 153, 96, 19);
		panel.add(textField_1);
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(347, 153, 96, 19);
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(453, 153, 96, 19);
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		panel.add(textField_3);
		


	
		
		JLabel lblSetCardioTrening = new JLabel("Postaviti Trening Snage");
		lblSetCardioTrening.setBounds(126, 10, 336, 32);
		panel.add(lblSetCardioTrening);
		lblSetCardioTrening.setForeground(SystemColor.text);
		lblSetCardioTrening.setFont(new Font("Montserrat Black", Font.PLAIN, 25));
		lblSetCardioTrening.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_2_2 = new JButton("Back");
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
		btnNewButton_2_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton_2_2.setBounds(0, 283, 85, 21);
		panel.add(btnNewButton_2_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vreme:");
		lblNewLabel_1_1.setBounds(24, 107, 61, 13);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("min");
		lblNewLabel_1_1_1.setBounds(128, 107, 81, 13);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		
		

		
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 21, 133));
		panel_1.setBounds(55, -26, 10, 386);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1.setBounds(524, -40, 10, 386);
		panel.add(panel_1_1);
	}

}
