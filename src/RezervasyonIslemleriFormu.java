import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RezervasyonIslemleriFormu extends JFrame {

	private JPanel contentPane;
	static DefaultTableModel dm ;
	private JTable table;
	private JTable table_1;
	JComboBox cbOdaGunlukFiyat;
	JComboBox cbOdaSinifi;
	JComboBox cbOdaDurumu;
	String tablo_secilen_oda_id,tablo_secilen_oda_numarasi,tablo_secilen_oda_sinifi,tablo_secilen_oda_durum,tablo_secilen_oda_fiyati="";
	JDateChooser dtRezKayitBaslangicTarihi,dtRezKayitBitisTarihi;
	JLabel lblTutarSonuc ;
	LocalDate localDate = LocalDate.now();
	JDateChooser dtRezAramaBasTarihi,dtRezAramaBitTarihi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervasyonIslemleriFormu frame = new RezervasyonIslemleriFormu();
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
	public RezervasyonIslemleriFormu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0)
			{
				RezervasyonIslemleri.OdaKayitlariCek(dm, table_1);
				RezervasyonIslemleri.OdaAramaCbFiyatYukle(cbOdaGunlukFiyat);
				RezervasyonIslemleri.OdaAramaCbSinifYukle(cbOdaSinifi);
				RezervasyonIslemleri.OdaAramaCbDurumYukle(cbOdaDurumu);
				
				RezervasyonIslemleri.RezervasyonKayitlariCek(dm, table);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rezervasyon \u0130\u015Flemleri");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(273, 13, 432, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblRezervasyonlar = new JLabel("Rezervasyonlar");
		lblRezervasyonlar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRezervasyonlar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRezervasyonlar.setBounds(740, 48, 152, 16);
		contentPane.add(lblRezervasyonlar);
		
		JSeparator sp1 = new JSeparator();
		sp1.setOrientation(SwingConstants.VERTICAL);
		sp1.setBackground(new Color(0, 153, 204));
		sp1.setBounds(322, 107, 13, 519);
		contentPane.add(sp1);
		
		JLabel lblRezervasyonKayt = new JLabel("Rezervasyon  Kay\u0131t");
		lblRezervasyonKayt.setHorizontalAlignment(SwingConstants.CENTER);
		lblRezervasyonKayt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRezervasyonKayt.setBounds(411, 82, 169, 22);
		contentPane.add(lblRezervasyonKayt);
		
		JLabel lblRezervasyonArama = new JLabel("Rezervasyon Arama");
		lblRezervasyonArama.setHorizontalAlignment(SwingConstants.CENTER);
		lblRezervasyonArama.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRezervasyonArama.setBounds(373, 460, 238, 16);
		contentPane.add(lblRezervasyonArama);
		
		JLabel lblRezAramaBasTar = new JLabel("Ba\u015Flang\u0131\u00E7 Tarihi");
		lblRezAramaBasTar.setHorizontalAlignment(SwingConstants.LEFT);
		lblRezAramaBasTar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRezAramaBasTar.setBounds(360, 510, 108, 16);
		contentPane.add(lblRezAramaBasTar);
		
		JLabel lblRezAramaBitTarih = new JLabel("Biti\u015F Tarihi");
		lblRezAramaBitTarih.setHorizontalAlignment(SwingConstants.LEFT);
		lblRezAramaBitTarih.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRezAramaBitTarih.setBounds(360, 541, 108, 16);
		contentPane.add(lblRezAramaBitTarih);
		
		JButton btnRezervasyonAra = new JButton("Ara");
		btnRezervasyonAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Date date = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				RezervasyonIslemleri.RezervasyonAramaKayitlariCek(dm, table, df.format(dtRezAramaBasTarihi.getDate()), df.format(dtRezAramaBitTarihi.getDate()));
			}
		});
		btnRezervasyonAra.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRezervasyonAra.setBackground(new Color(102, 153, 204));
		btnRezervasyonAra.setBounds(360, 570, 117, 33);
		contentPane.add(btnRezervasyonAra);
		
		JButton btnRezervasyonAraTemizle = new JButton("Temizle");
		btnRezervasyonAraTemizle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRezervasyonAraTemizle.setBackground(new Color(102, 153, 204));
		btnRezervasyonAraTemizle.setBounds(514, 570, 117, 33);
		contentPane.add(btnRezervasyonAraTemizle);
		
		JLabel lblRezervasyonBasTar = new JLabel("Ba\u015Flang\u0131\u00E7 Tarihi");
		lblRezervasyonBasTar.setHorizontalAlignment(SwingConstants.LEFT);
		lblRezervasyonBasTar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRezervasyonBasTar.setBounds(360, 116, 108, 16);
		contentPane.add(lblRezervasyonBasTar);
		
		JLabel lblRezervasyonBitTar = new JLabel("Biti\u015F Tarihi");
		lblRezervasyonBitTar.setHorizontalAlignment(SwingConstants.LEFT);
		lblRezervasyonBitTar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRezervasyonBitTar.setBounds(360, 147, 108, 16);
		contentPane.add(lblRezervasyonBitTar);
		
		JLabel lblMusteriAdSoyad = new JLabel("M\u00FC\u015Fteri Telefon Numaras\u0131");
		lblMusteriAdSoyad.setHorizontalAlignment(SwingConstants.LEFT);
		lblMusteriAdSoyad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMusteriAdSoyad.setBounds(411, 299, 169, 16);
		contentPane.add(lblMusteriAdSoyad);
		
		JTextField txMusteriTel = new JTextField();
		txMusteriTel.setBounds(389, 328, 212, 22);
		contentPane.add(txMusteriTel);
		txMusteriTel.setColumns(10);
		
		JSeparator sp2 = new JSeparator();
		sp2.setBackground(new Color(0, 153, 204));
		sp2.setBounds(360, 423, 271, 2);
		contentPane.add(sp2);
		
		JButton btnKaydet = new JButton("Rez. Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Fonksiyonlar.BosDegilse(txMusteriTel.getText()))
				{
					if(Fonksiyonlar.SayisalMi(txMusteriTel.getText(),"Müþteri Telefonu" ))
					{
						String [] musteri_id = new String[1];
						MusteriIslemleri.MusteriTelDenIdCek(txMusteriTel.getText(),musteri_id);
						 	Date date = new Date();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							
						
						RezervasyonIslemleri.RezervasyonKaydet(
								tablo_secilen_oda_id, 
								musteri_id[0],
								df.format(dtRezKayitBaslangicTarihi.getDate()),
								df.format(dtRezKayitBitisTarihi.getDate()), 
								lblTutarSonuc.getText(), 
								"1");
						RezervasyonIslemleri.RezervasyonKayitlariCek(dm, table);

						
					}
					else
					{
						txMusteriTel.setText(null);
					}
				}
				else
				{
					txMusteriTel.setText(null);

				}
				
			}
		});
		btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKaydet.setBackground(new Color(102, 153, 204));
		btnKaydet.setBounds(360, 363, 124, 47);
		contentPane.add(btnKaydet);
		
		JLabel lblTutar = new JLabel("Tutar :");
		lblTutar.setHorizontalAlignment(SwingConstants.LEFT);
		lblTutar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTutar.setBounds(360, 258, 108, 16);
		contentPane.add(lblTutar);
		
		JLabel lblToplamGunSayisi = new JLabel("Toplam G\u00FCn Say\u0131s\u0131 :");
		lblToplamGunSayisi.setHorizontalAlignment(SwingConstants.LEFT);
		lblToplamGunSayisi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblToplamGunSayisi.setBounds(360, 229, 130, 16);
		contentPane.add(lblToplamGunSayisi);
		
		JLabel lblToplamGunSayisiSonuc = new JLabel("");
		lblToplamGunSayisiSonuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblToplamGunSayisiSonuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblToplamGunSayisiSonuc.setBounds(514, 229, 117, 16);
		contentPane.add(lblToplamGunSayisiSonuc);
		
		lblTutarSonuc = new JLabel("");
		lblTutarSonuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTutarSonuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTutarSonuc.setBounds(514, 258, 117, 16);
		contentPane.add(lblTutarSonuc);
		
		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
					int[] gunSayisi = new int[1];			
					
						Fonksiyonlar.daysBetween(dtRezKayitBaslangicTarihi.getDate(),dtRezKayitBitisTarihi.getDate(),gunSayisi);	
						if(!(gunSayisi[0]<=0))
						{
							lblToplamGunSayisiSonuc.setText(Integer.toString(gunSayisi[0])+" Gün");
							
							if(!tablo_secilen_oda_fiyati.isEmpty())
							{
								lblTutarSonuc.setText(
										Integer.toString(
												RezervasyonIslemleri.RezervasyonTutarHesapla(
																								gunSayisi[0],Integer.parseInt(tablo_secilen_oda_fiyati)
																							)
														).toString()+" TL"
													);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Lütfen Tablodan Oda Seçiniz !");
								

							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Lütfen Baþlangýç ve Bitiþ Tarihlerini Seçiniz !");
						}
					
					
					
					
					
			}
		});
		btnHesapla.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHesapla.setBackground(new Color(102, 153, 204));
		btnHesapla.setBounds(444, 183, 117, 33);
		contentPane.add(btnHesapla);
		
		dtRezKayitBaslangicTarihi = new JDateChooser();
		dtRezKayitBaslangicTarihi.setBounds(514, 117, 117, 22);
		contentPane.add(dtRezKayitBaslangicTarihi);
		
		dtRezKayitBitisTarihi = new JDateChooser();
		dtRezKayitBitisTarihi.setBounds(514, 147, 117, 22);
		contentPane.add(dtRezKayitBitisTarihi);
		
		 dtRezAramaBasTarihi = new JDateChooser();
		dtRezAramaBasTarihi.setBounds(514, 505, 117, 22);
		contentPane.add(dtRezAramaBasTarihi);
		
		 dtRezAramaBitTarihi = new JDateChooser();
		dtRezAramaBitTarihi.setBounds(514, 535, 117, 22);
		contentPane.add(dtRezAramaBitTarihi);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(662, 112, 308, 514);
		contentPane.add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(29, 300, 271, 323);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				tablo_secilen_oda_numarasi = table_1.getValueAt(table_1.getSelectedRow(),1).toString();
				tablo_secilen_oda_sinifi = table_1.getValueAt(table_1.getSelectedRow(),2).toString();
				tablo_secilen_oda_durum = table_1.getValueAt(table_1.getSelectedRow(),3).toString();
				 tablo_secilen_oda_fiyati = table_1.getValueAt(table_1.getSelectedRow(),4).toString();
				 tablo_secilen_oda_id = table_1.getValueAt(table_1.getSelectedRow(),5).toString();
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblGunlukFiyat = new JLabel("G\u00FCnl\u00FCk Fiyat\u0131");
		lblGunlukFiyat.setHorizontalAlignment(SwingConstants.LEFT);
		lblGunlukFiyat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGunlukFiyat.setBounds(29, 130, 108, 16);
		contentPane.add(lblGunlukFiyat);
		
		JLabel lblSinif = new JLabel("S\u0131n\u0131f\u0131");
		lblSinif.setHorizontalAlignment(SwingConstants.LEFT);
		lblSinif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinif.setBounds(29, 161, 108, 16);
		contentPane.add(lblSinif);
		
		JLabel lblDurumu = new JLabel("Durumu");
		lblDurumu.setHorizontalAlignment(SwingConstants.LEFT);
		lblDurumu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDurumu.setBounds(29, 192, 108, 16);
		contentPane.add(lblDurumu);
		
		JButton button = new JButton("Ara");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				RezervasyonIslemleri.OdaArama(dm,table_1,cbOdaGunlukFiyat, cbOdaSinifi, cbOdaDurumu);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(102, 153, 204));
		button.setBounds(29, 225, 117, 33);
		contentPane.add(button);
		
		JLabel label_7 = new JLabel("Odalar");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_7.setBounds(102, 271, 98, 16);
		contentPane.add(label_7);
		
		JButton button_5 = new JButton("Temizle");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				RezervasyonIslemleri.OdaAramaTemizle(cbOdaGunlukFiyat, cbOdaSinifi, cbOdaDurumu);
				RezervasyonIslemleri.OdaKayitlariCek(dm, table_1);
				
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5.setBackground(new Color(102, 153, 204));
		button_5.setBounds(183, 225, 117, 33);
		contentPane.add(button_5);
		
		 cbOdaDurumu = new JComboBox();
		cbOdaDurumu.setBounds(183, 190, 117, 22);
		contentPane.add(cbOdaDurumu);
		
		cbOdaSinifi = new JComboBox();
		cbOdaSinifi.setBounds(183, 159, 117, 22);
		contentPane.add(cbOdaSinifi);
		
		 cbOdaGunlukFiyat = new JComboBox();
		cbOdaGunlukFiyat.setBounds(183, 128, 117, 22);
		contentPane.add(cbOdaGunlukFiyat);
		
		JLabel lblOdaBaslik = new JLabel("Oda Arama");
		lblOdaBaslik.setHorizontalAlignment(SwingConstants.CENTER);
		lblOdaBaslik.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOdaBaslik.setBounds(102, 99, 108, 16);
		contentPane.add(lblOdaBaslik);
		
		JButton btnMteriIlemleri = new JButton("M\u00FC\u015F. \u0130\u015Fl.");
		btnMteriIlemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriIslemleriFormu mIF = new MusteriIslemleriFormu();
				mIF.setVisible(true);
			}
		});
		btnMteriIlemleri.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMteriIlemleri.setBackground(new Color(102, 153, 204));
		btnMteriIlemleri.setBounds(501, 363, 130, 47);
		contentPane.add(btnMteriIlemleri);
	}
}
