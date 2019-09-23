import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MudurFormu extends JFrame {

	private JPanel contentPane;
	static MudurFormu frame ;
	static JLabel lblMesaj;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MudurFormu();
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
	public MudurFormu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Fonksiyonlar.GirisYapanKullanicininAdiniSoyadiniCek(lblMesaj);

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 97, 386, 2);
		contentPane.add(separator);
		
		 lblMesaj = new JLabel("Ho\u015Fgeldiniz ");
		lblMesaj.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesaj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMesaj.setBounds(50, 67, 386, 28);
		contentPane.add(lblMesaj);
		
		JButton button = new JButton("\u00C7\u0131k\u0131\u015F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fonksiyonlar.UygulamaCikisYap();

			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\ABRA\\Desktop\\gorseller\\cikis_24_kirmizi.png"));
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(360, 13, 110, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Oda \u0130\u015Flemleri");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OdaIslemleriFormu oda_islemleri_formu = new OdaIslemleriFormu();
				
				oda_islemleri_formu.setVisible(true);
				frame.setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(265, 116, 171, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Personel \u0130\u015Flemleri");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonelIslemleriFormu personel_islemleri_formu = new PersonelIslemleriFormu();
				personel_islemleri_formu.setVisible(true);
			//	frame.setVisible(false);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(48, 116, 171, 41);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Rezervasyon \u0130\u015Flemleri");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RezervasyonIslemleriFormu rIF = new RezervasyonIslemleriFormu();
				rIF.setVisible(true);
				
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBounds(48, 183, 171, 41);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("M\u00FC\u015Fteri \u0130\u015Flemleri");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriIslemleriFormu mIF = new MusteriIslemleriFormu();
				mIF.setVisible(true);
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBounds(265, 183, 171, 41);
		contentPane.add(button_4);
		
		JButton button_6 = new JButton("Geri Bildirim \u0130\u015Flemleri");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeriBildirimIslemleriFormu GBIF = new GeriBildirimIslemleriFormu();
				GBIF.setVisible(true);
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_6.setBounds(48, 249, 171, 41);
		contentPane.add(button_6);
		
		JButton btnGelirgiderilemleri = new JButton("Gelir-Gider\u0130\u015Flemleri");
		btnGelirgiderilemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MudurGelirIslemleriFormu mg=new MudurGelirIslemleriFormu();
				mg.setVisible(true);
			}
		});
		btnGelirgiderilemleri.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGelirgiderilemleri.setBounds(265, 249, 171, 41);
		contentPane.add(btnGelirgiderilemleri);
	}

}
