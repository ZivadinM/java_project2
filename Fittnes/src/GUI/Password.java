package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KLASEE.Korisnik;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;

public class Password extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
	public static int tezinak;
	public Password() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Dobrodosili "+ PocetnaGUI.tempuser +"");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 10, 382, 30);
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblIzaberiteKorisinka = new JLabel("Sifra:");
		lblIzaberiteKorisinka.setForeground(SystemColor.menu);
		lblIzaberiteKorisinka.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzaberiteKorisinka.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblIzaberiteKorisinka.setBounds(25, 72, 382, 30);
		contentPane.add(lblIzaberiteKorisinka);
		
		JButton btnNewButton_2_2 = new JButton("Back");
		btnNewButton_2_2.addActionListener(new ActionListener() {
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
		
		textField = new JTextField();
		textField.setBounds(88, 115, 256, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_22 = new JButton("Nazad");
		btnNewButton_2_2.addActionListener(new ActionListener() {
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
		btnNewButton_22.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton_22.setBounds(10, 251, 96, 21);
		contentPane.add(btnNewButton_22);
		
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//prolazak kroz listu korsnika
					for(Korisnik k:PocetnaGUI.listkk) 
						//ukoliok se poklapaju selktovani user i user iz liste
						if(PocetnaGUI.tempuser.compareTo(k.Username)==0)
							//onda se ispituje da li se poklapaju sifre ako se ne poklapaju salje se izuzetak
							if(textField.getText().toString().compareTo(k.Password)==1) {
								throw new Exception("Pogresli ste sifru");}
							else {
								//pamtimu tezinu kao globalnu pormenjivu
								tezinak=k.Weight;
							}
					
					
					try {
						OdabirAktivnosti frame = new OdabirAktivnosti();
						frame.setVisible(true);
					} catch (Exception x) {
						x.printStackTrace();
					}	
								
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, a.getMessage());

				}
			}
		});
		btnNewButton.setFont(new Font("Montserrat", Font.PLAIN, 15));
		btnNewButton.setBounds(174, 155, 75, 30);
		contentPane.add(btnNewButton);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1.setBounds(373, -46, 10, 386);
		contentPane.add(panel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 21, 133));
		panel_1.setBounds(51, -25, 10, 386);
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(10, 58, 412, 144);
		contentPane.add(panel);
		

	}
}
