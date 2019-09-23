import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.StringUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GirisFormu extends JFrame {

	/*
	 EXIT_ON_CLOSE // tüm programý kapat
 
	DISPOSE // Sadece ilgili pencereyi kapat
 
	HIDE // pencereyi gizle
 
	DO_NOTHING // hiç birþey yapma
	 */
	
	
	
	private JPanel contentPane;
	private JPasswordField txSifre;
	private JTextField txKullaniciAdi;
	static GirisFormu frame = new GirisFormu();
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
	public GirisFormu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Giri\u015F Ekran\u0131");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(186, 46, 165, 28);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(45, 84, 386, 2);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 ");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(45, 111, 110, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u015Eifre");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(45, 166, 110, 28);
		contentPane.add(label_2);
		
		txSifre = new JPasswordField();
		txSifre.setBounds(216, 169, 215, 25);
		contentPane.add(txSifre);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				KullaniciGirisIslemleri.AlanlariTemizle(txKullaniciAdi, txSifre);
				
			}
		});
		btnTemizle.setIcon(new ImageIcon("C:\\Users\\ABRA\\Desktop\\gorseller\\cop_kovasi_24.png"));
		btnTemizle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTemizle.setBounds(287, 222, 144, 55);
		contentPane.add(btnTemizle);
		
		JButton btnGirisYap = new JButton("Giris Yap");
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
		
				if(KullaniciGirisIslemleri.BosAlanKontrolu(txKullaniciAdi.getText(),txSifre.getText()))
				{
					
						if(Fonksiyonlar.StringMi(txKullaniciAdi.getText().toString())==true && Fonksiyonlar.StringMi(txSifre.getText().toString())==true)
						{
				           
							if(KullaniciGirisIslemleri.GirisveYetkilendirme(txKullaniciAdi.getText().toString(),txSifre.getText().toString()))
							{
								frame.setVisible(false);
							}
							else
							{
								KullaniciGirisIslemleri.AlanlariTemizle(txKullaniciAdi, txSifre);

							}
							
							
						}
						else
						{
							KullaniciGirisIslemleri.AlanlariTemizle(txKullaniciAdi, txSifre);

						}
					
				}
				else
				{
					KullaniciGirisIslemleri.AlanlariTemizle(txKullaniciAdi, txSifre);

				}
				
				
				
				
		
			}
		});
		btnGirisYap.setIcon(new ImageIcon("C:\\Users\\ABRA\\Desktop\\gorseller\\login_24.png"));
		btnGirisYap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGirisYap.setBounds(45, 222, 144, 55);
		contentPane.add(btnGirisYap);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Fonksiyonlar.UygulamaCikisYap();
				
			}
		});
		btnCikis.setIcon(new ImageIcon("C:\\Users\\ABRA\\Desktop\\gorseller\\cikis_24_kirmizi.png"));
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCikis.setBounds(363, 7, 110, 41);
		contentPane.add(btnCikis);
		
		txKullaniciAdi = new JTextField();
		txKullaniciAdi.setBounds(216, 115, 215, 22);
		contentPane.add(txKullaniciAdi);
		txKullaniciAdi.setColumns(10);
	}
}
