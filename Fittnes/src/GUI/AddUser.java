package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDfsdf;
	private JTextField textField_1;
	private JTextField textField_2;

    public static boolean
    //funkcija za validaciju sifre
    isValidPassword(String password)
    {
         String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);
 
        if (password == null) {
            return false;
        }
 
        Matcher m = p.matcher(password);

        return m.matches();
    }

   
	
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
	public AddUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dodavanje Korisnika");
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 10, 292, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(10, 54, 389, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel_1_1 = new JLabel("Sifra:");
		lblNewLabel_1_1.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 45, 168, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter New Username:");
		lblNewLabel_1.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_1.setBounds(10, 10, 168, 25);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 15));
		
		txtDfsdf = new JTextField();
		txtDfsdf.setToolTipText("");
		txtDfsdf.setFont(new Font("Montserrat", Font.BOLD, 10));
		txtDfsdf.setBounds(185, 13, 194, 24);
		panel.add(txtDfsdf);
		txtDfsdf.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			//ako je sifra validna onda je zelen ako ne crvena
			public void keyPressed(KeyEvent e) {
						if(isValidPassword(textField_1.getText())==false) {
						textField_1.setForeground(new Color(255, 0, 0));
						
					}
					else
					{
						textField_1.setForeground(new Color(0, 255, 0));

					}
				}
			});
		textField_1.setColumns(10);
		textField_1.setBounds(49, 46, 194, 24);
		textField_1.setFont(new Font("Montserrat", Font.BOLD, 21));
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Weight:");
		lblNewLabel_1_2.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_1_2.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 80, 60, 25);
		panel.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(71, 83, 41, 24);
		panel.add(textField_2);
		textField_2.addKeyListener(new KeyAdapter() {
			//obezbedjivanje unosa samo brojeva
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		
		JLabel lblNewLabel_1_2_1 = new JLabel("kg");
		lblNewLabel_1_2_1.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_1_2_1.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(115, 82, 33, 25);
		panel.add(lblNewLabel_1_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 21, 133));
		panel_1.setBounds(71, -96, 10, 386);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1.setBounds(317, -108, 10, 386);
		panel.add(panel_1_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//deklarisanje i inicijalizacija fajla za mogucnost unosa iako vec nesto postoji nesto u njemu
					FileWriter a=new FileWriter("Korisnici.txt",true);
					PrintWriter izl=new PrintWriter(a);
					//mora se svaki textbox popuniti
					if(txtDfsdf.getText().isEmpty() || textField_2.getText().isEmpty() || textField_1.getText().isEmpty() || isValidPassword(textField_1.getText())==false) 
						throw new Exception("Morate popuniti sva polja ili vas password nije u redu");
					//prolazak kroz listu
					for(String ime:PocetnaGUI.listk) {
						//ako se poklapaju textbox i lista ako se poklopi onda taj user vec postoji
						if(txtDfsdf.getText().toString().compareTo(ime)==0)
							throw new Exception("Ovaj Username vec postoji probajete niki drugi");
					}
					//unos u file korisnik, i kriranje fajl history
					izl.println(txtDfsdf.getText());
					izl.println(textField_1.getText());
					izl.println(textField_2.getText());
					FileWriter l=new FileWriter("History"+txtDfsdf.getText()+".txt",true);
					izl.flush(); 
					izl.close();
					dispose();
					
					PocetnaGUI frame = new PocetnaGUI();
					frame.setVisible(true);
					throw new Exception("Uneli ste novog korisnika");

				}
				
		catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
			}
		});
		btnNewButton.setFont(new Font("Montserrat", Font.PLAIN, 15));
		btnNewButton.setBounds(156, 245, 96, 30);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_2_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnNewButton_2_2.setBounds(10, 251, 85, 21);
		contentPane.add(btnNewButton_2_2);
		
		JLabel lblNewLabel_2 = new JLabel("Username treba da ima prvo veliko pocetno slovo, i jedan broj");
		lblNewLabel_2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 146, 389, 90);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password mora biri duzi od 8 slova, da ima jendo veliko slovo i jedan broj");
		lblNewLabel_2_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(10, 168, 389, 90);
		contentPane.add(lblNewLabel_2_1);
	}
}
