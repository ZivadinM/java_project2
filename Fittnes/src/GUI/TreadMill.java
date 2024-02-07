package GUI;

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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class TreadMill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
	public TreadMill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblNewLabel.setBounds(24, 190, 462, 13);
		JButton btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(Integer.parseInt(textField_2.getText().toString())>31 || Integer.parseInt(textField_3.getText().toString())>12 || Integer.parseInt(textField_4.getText().toString())<2022)
						throw new Exception("Mesec ne moze biti veci od 12 ili dan veci od 31 i godina manja od 2022");
					
					if(textField.getText().isEmpty() ||textField_4.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty() || textField_1.getText().isEmpty()) 
						throw new Exception("Morate popuniti sva polja");
					
					double cal;
					cal=Math.round(((0.1*(Integer.parseInt(textField.getText().toString())*16.67))+3.5)*55*(Integer.parseInt(textField_1.getText().toString()))/200);
					
					double vreme=((Integer.parseInt(textField.getText().toString()))*((Double.parseDouble(textField_1.getText().toString())/60)));
					lblNewLabel.setText("Potroseno je "+cal+" kalorija za "+textField.getText().toString()+" Presli ste "+Math.round(vreme)+" km");
					
					
						FileWriter l=new FileWriter("History"+PocetnaGUI.tempuser+".txt",true);
						PrintWriter izl=new PrintWriter(l);
						
						FileWriter ll=new FileWriter("Stat"+PocetnaGUI.tempuser+".txt",true);
						PrintWriter izll=new PrintWriter(ll);
						
						izl.println("TreadMill");
						izl.println(textField_1.getText().toString());
						izl.println(textField_2.getText());
						izl.println(textField_3.getText());
						izl.println(textField_4.getText());
						izl.println(cal);
						izl.flush(); 
						izl.close();
						izll.println(Math.round(vreme));
						izll.println(Integer.parseInt(textField_1.getText().toString()));
						izll.println(cal);
						izll.flush(); 
						izll.close();
						throw new Exception("Uneli ste novu aktivnost");
					}

				 catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());


			}}});
		btnNewButton.setFont(new Font("Montserrat", Font.PLAIN, 13));
		btnNewButton.setBounds(257, 282, 85, 21);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(25, 18, 609, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.add(lblNewLabel);

		
		JLabel lblSetCardioTrening = new JLabel("Unesite Trening Na Traci");
		lblSetCardioTrening.setBounds(75, 10, 399, 32);
		panel.add(lblSetCardioTrening);
		lblSetCardioTrening.setForeground(SystemColor.text);
		lblSetCardioTrening.setFont(new Font("Montserrat Black", Font.PLAIN, 25));
		lblSetCardioTrening.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		btnNewButton_2_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton_2_2.setBounds(0, 283, 85, 21);
		panel.add(btnNewButton_2_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Unesite datum(Dan/Mesec/Godina):");
		lblNewLabel_1_1_2.setBounds(24, 151, 226, 13);
		panel.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(SystemColor.text);
		lblNewLabel_1_1_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Brzina:");
		lblNewLabel_1.setBounds(24, 65, 41, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1 = new JLabel("Vreme:");
		lblNewLabel_1_1.setBounds(24, 107, 61, 13);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("min");
		lblNewLabel_1_1_1.setBounds(126, 107, 81, 13);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("km/h");
		lblNewLabel_1_1_1_1.setBounds(126, 65, 81, 13);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1_1_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setBounds(68, 63, 51, 19);
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
		textField_1.setColumns(10);
		textField_1.setBounds(68, 105, 51, 19);
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(239, 149, 96, 19);
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(345, 151, 96, 19);
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		textField_4.setBounds(451, 151, 96, 19);
		panel.add(textField_4);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1.setBounds(95, -111, 10, 651);
		panel.add(panel_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1_1_1.setBounds(443, -122, 10, 651);
		panel.add(panel_1_1_1_1);
		

	}
}
