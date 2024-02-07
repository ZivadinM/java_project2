package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KLASEE.Datee;
import KLASEE.History;
import KLASEE.Korisnik;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;


public class PocetnaGUI extends JFrame {
	//kreiramo listu imena korisnika,korisnika i izdvajamo ime korsnika kojeg smo selektovali
	public static String tempuser;
	public static ArrayList<String> listk=new ArrayList<>();
	public static ArrayList<Korisnik> listkk=new ArrayList<>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	//deklarisemo fajl
	public static Scanner sc=null;
	private final JPanel panel_1 = new JPanel();
	//funkcija
	public static void PodaciOkorisnicima() {
	try {
	// inicijalizacija fajla korisnici, citamo iz nje
		sc=new Scanner(new File("Korisnici.txt"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		 System.exit(1);
	}
	listk.add("Korisnik");
	listk.add("Dodaj Korisnika...");
	//deklarisanje promenjivih
	String username;
	String password;
	int tezina;
	String line="";
	int i=0;
	//citanje fajla
	while(sc.hasNext()) {
		line=sc.nextLine().trim();
		username=line;
		//dodavanje korisnika u liste
		listk.add(line);
		
		line=sc.nextLine().trim();
		password=line;
		
		line=sc.nextLine().trim();
		tezina=Integer.valueOf(line);
		//kreiranje objekta korisnik
		Korisnik a=new Korisnik(username,password,tezina);
		//dodavalje korsnika u listu
		listkk.add(a);
	}
	}

	
	//funkcija za pretvaranje list u niz, za kombobox
	public static String[] retition(ArrayList a){
	    Set<String> set = new LinkedHashSet<>(a);
	    List<String> templista = new ArrayList<>(set);
	    String[] arraym = templista.toArray(new String[0]);
	    return arraym;
	    
	}

	public PocetnaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dobrodosli na Fitness aplikaciju");
		lblNewLabel.setBounds(5, 10, 422, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblIzaberiteKorisinka = new JLabel("Izaberite korisinka:");
		lblIzaberiteKorisinka.setBounds(25, 72, 382, 30);
		lblIzaberiteKorisinka.setForeground(SystemColor.window);
		lblIzaberiteKorisinka.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzaberiteKorisinka.setFont(new Font("Montserrat", Font.PLAIN, 16));
		contentPane.add(lblIzaberiteKorisinka);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(67, 122, 293, 44);
		comboBox.setForeground(new Color(199, 21, 133));
		comboBox.setBackground(SystemColor.inactiveCaptionBorder);
		comboBox.setFont(new Font("Montserrat", Font.BOLD, 18));
		PodaciOkorisnicima();
		comboBox.setModel(new DefaultComboBoxModel(retition(listk)));
		comboBox.setToolTipText("");
		contentPane.add(comboBox);
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setForeground(new Color(199, 21, 133));
		btnNewButton.setBounds(149, 178, 133, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ako se seliktuje Dodaj Korisnika otvara se novi frame
				if(comboBox.getSelectedItem()=="Dodaj Korisnika...") {
					dispose();
					AddUser frame = new AddUser();
					frame.setVisible(true);
				}
				else
				{
					//ukoliko se klikne na nesto drugo,na ime korisnika, otvaramo prozor za unosenje sifre
					dispose();
					tempuser=comboBox.getSelectedItem().toString();
					Password frame = new Password();
					frame.setVisible(true);
				}
			}
			
		});
		btnNewButton.setFont(new Font("Montserrat", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(17, 10, 397, 251);
		panel.setBackground(SystemColor.textHighlight);
		contentPane.add(panel);
		panel.setLayout(null);
		panel_1.setBackground(new Color(199, 21, 133));
		panel_1.setBounds(74, -48, 10, 386);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(199, 21, 133));
		panel_1_1.setBounds(320, -60, 10, 386);
		panel.add(panel_1_1);
	}
}
