import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class YoneticiFormu extends JFrame {

	private JPanel contentPane;
	static YoneticiFormu frame = new YoneticiFormu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public YoneticiFormu() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u00C7\u0131k\u0131\u015F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fonksiyonlar.UygulamaCikisYap();
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\ABRA\\Desktop\\gorseller\\cikis_24_kirmizi.png"));
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(360, 13, 110, 41);
		contentPane.add(button);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 97, 386, 2);
		contentPane.add(separator);
		
		JLabel lblMesaj = new JLabel("");
		lblMesaj.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesaj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMesaj.setBounds(50, 67, 386, 28);
		contentPane.add(lblMesaj);
	
		
		
		JButton button_1 = new JButton("Otel \u0130\u015Flemleri");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OtelIslemleriFormu otelIslemleriFormu = new OtelIslemleriFormu();
				otelIslemleriFormu.setVisible(true);
				frame.setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(100, 178, 289, 46);
		contentPane.add(button_1);
		
		JButton btnMudurIslemleri = new JButton("M\u00FCd\u00FCr\u0130\u015Flemleri");
		btnMudurIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MudurIslemleriFormu mudur_formu = new MudurIslemleriFormu();
				mudur_formu.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnMudurIslemleri.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMudurIslemleri.setBounds(100, 112, 289, 46);
		contentPane.add(btnMudurIslemleri);
		
		JButton button_3 = new JButton("Gelir \u0130\u015Flemleri");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YoneticiGelirIslemleri yg = new YoneticiGelirIslemleri();
				yg.setVisible(true);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBounds(100, 244, 289, 46);
		contentPane.add(button_3);
		
		
		
 //YONETÝCÝ FORMU ACILDIGINDA YAPILACAK ÝÞLEMLER		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {	
				
				// HOÞGELDINIZ MESAJI YAZDIRDIK
				//Fonksiyonlar.GirisYapanKullanicininAdSoyadCek(lblMesaj);
				
				Fonksiyonlar.GirisYapanKullanicininAdiniSoyadiniCek(lblMesaj);
			}

			
		});
	}

}
