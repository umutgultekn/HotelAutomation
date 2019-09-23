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

public class ResepsiyonistFormu extends JFrame {

	private JPanel contentPane;
static ResepsiyonistFormu frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ResepsiyonistFormu();
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
	public ResepsiyonistFormu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 97, 386, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Ho\u015Fgeldiniz ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(38, 67, 386, 28);
		contentPane.add(label);
		
		JButton button = new JButton("\u00C7\u0131k\u0131\u015F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fonksiyonlar.UygulamaCikisYap();

			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\ABRA\\Desktop\\gorseller\\cikis_24_kirmizi.png"));
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(348, 13, 110, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Oda \u0130\u015Flemleri");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OdaIslemleriFormu OIF = new OdaIslemleriFormu();
				OIF.setVisible(true);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(253, 116, 171, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Fatura \u0130\u015Flemleri");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(253, 248, 171, 41);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Rezervasyon \u0130\u015Flemleri");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RezervasyonIslemleriFormu rI = new RezervasyonIslemleriFormu();
				rI.setVisible(true);
				//frame.setVisible(false);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBounds(36, 183, 171, 41);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Gelir \u0130\u015Flemleri");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBounds(253, 183, 171, 41);
		contentPane.add(button_4);
		
		JButton button_6 = new JButton("Geri Bildirim \u0130\u015Flemleri");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GeriBildirimIslemleriFormu gbýf = new 	GeriBildirimIslemleriFormu();
				gbýf.setVisible(true);
				
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_6.setBounds(36, 249, 171, 41);
		contentPane.add(button_6);
		
		JButton btnMusteri = new JButton("M\u00FC\u015Fteri \u0130\u015Flemleri");
		btnMusteri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MusteriIslemleriFormu mf = new MusteriIslemleriFormu();
				mf.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnMusteri.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMusteri.setBounds(38, 116, 171, 41);
		contentPane.add(btnMusteri);
	}
}
