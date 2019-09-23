import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PersonelIslemleriFormu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txAdi;
	private JTextField txSoyadi;
	private JTextField txKullaniciAdi;
	private JTextField txTel;
	private JTextField txEmail;
	private JTextField txMaas;
	private JTextField txAdres;
	private JPasswordField txSifre;
	private  JComboBox cbOtel;
	private  JComboBox cbYetki;
	String kisi_otel;
	String otel_id;
	JLabel lblOtelId;
	DefaultTableModel dm;
	String kisi_id;
	static PersonelIslemleriFormu frame = new PersonelIslemleriFormu();
	
	  
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
	 
	public PersonelIslemleriFormu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				OtelIslemleri.cbOtelYukle(cbOtel);
				PersonelIslemleri.MudurYetki(cbYetki);
				PersonelIslemleri.KayitlariCek(dm, table);
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrsIlemleri = new JLabel("Personel Islemleri");
		lblPrsIlemleri.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrsIlemleri.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPrsIlemleri.setBounds(420, 37, 286, 30);
		contentPane.add(lblPrsIlemleri);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(70, 87, 900, 1);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 106, 898, 142);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String tablo_secilen_id = table.getValueAt(table.getSelectedRow(),12).toString();
				String tablo_secilen_ad = table.getValueAt(table.getSelectedRow(),1).toString();
				String tablo_secilen_soyad = table.getValueAt(table.getSelectedRow(),2).toString();
				String tablo_secilen_otel = table.getValueAt(table.getSelectedRow(),11).toString();
				String tablo_secilen_adres = table.getValueAt(table.getSelectedRow(),7).toString();
				String tablo_secilen_tel = table.getValueAt(table.getSelectedRow(),8).toString();
				String tablo_secilen_email= table.getValueAt(table.getSelectedRow(),9).toString();
				String tablo_secilen_kullaniciadi = table.getValueAt(table.getSelectedRow(),3).toString();
				String tablo_secilen_sifre = table.getValueAt(table.getSelectedRow(),4).toString();
				String tablo_secilen_yetki = table.getValueAt(table.getSelectedRow(),5).toString();
				String tablo_secilen_maas = table.getValueAt(table.getSelectedRow(),6).toString();
				String tablo_secilen_vtdurum= table.getValueAt(table.getSelectedRow(),10).toString();
			

				txAdi.setText(tablo_secilen_ad);
				txSoyadi.setText(tablo_secilen_soyad);
				txAdres.setText(tablo_secilen_adres);
				txTel.setText(tablo_secilen_tel);
				txEmail.setText(tablo_secilen_email);
				txKullaniciAdi.setText(tablo_secilen_kullaniciadi);
				txSifre.setText(tablo_secilen_sifre);
				txMaas.setText(tablo_secilen_maas);
				
				
			
				cbOtel.removeAllItems();
				cbOtel.addItem(tablo_secilen_otel);
				cbYetki.removeAllItems();
				cbYetki.addItem(tablo_secilen_yetki);
				
				kisi_otel = tablo_secilen_otel;
				kisi_id = tablo_secilen_id;
				
				
			}
		});
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		txAdi = new JTextField();
		txAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txAdi.setColumns(10);
		txAdi.setBounds(174, 265, 122, 22);
		contentPane.add(txAdi);
		
		txSoyadi = new JTextField();
		txSoyadi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txSoyadi.setColumns(10);
		txSoyadi.setBounds(174, 293, 122, 22);
		contentPane.add(txSoyadi);
		
		JLabel lblAd = new JLabel("Ad\u0131");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAd.setBounds(70, 261, 92, 30);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoyad.setBounds(70, 286, 92, 30);
		contentPane.add(lblSoyad);
		
		JLabel lblKullaniciAdi = new JLabel("Kullanici Adi");
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKullaniciAdi.setBounds(394, 261, 92, 30);
		contentPane.add(lblKullaniciAdi);
		
		JLabel lblSifre = new JLabel("Sifre");
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSifre.setBounds(394, 304, 92, 30);
		contentPane.add(lblSifre);
		
		txKullaniciAdi = new JTextField();
		txKullaniciAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txKullaniciAdi.setColumns(10);
		txKullaniciAdi.setBounds(498, 265, 122, 22);
		contentPane.add(txKullaniciAdi);
		
		JLabel lblTel = new JLabel(" Tel");
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTel.setBounds(744, 261, 92, 30);
		contentPane.add(lblTel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(744, 304, 92, 30);
		contentPane.add(lblEmail);
		
		txTel = new JTextField();
		txTel.setFont(new Font("Tahoma", Font.BOLD, 15));
		txTel.setColumns(10);
		txTel.setBounds(848, 265, 122, 22);
		contentPane.add(txTel);
		
		JButton btnGeriDon = new JButton("Geri D\u00F6n");
		btnGeriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MudurFormu mudurFormu = new MudurFormu();
				mudurFormu.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnGeriDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGeriDon.setBounds(826, 385, 144, 55);
		contentPane.add(btnGeriDon);
		
		JButton btnAra = new JButton("Ara");
		btnAra.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				PersonelIslemleri.PersonelAra(dm, table,txAdi.getText().toString(),txKullaniciAdi.getText().toString() ,txSoyadi.getText().toString()  , txEmail.getText().toString()  ,txTel.getText().toString()  );
				
			}
		}); 
		btnAra.setBounds(643, 385, 144, 55);
		contentPane.add(btnAra);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(PersonelIslemleri.AlanKontrolu(
						txAdi.getText(), txSoyadi.getText(),
						cbYetki.getSelectedItem().toString(),
						txKullaniciAdi.getText() , txSifre.getText(),
						txMaas.getText(), txTel.getText(),
						txEmail.getText(),txAdres.getText(),cbOtel.getSelectedItem().toString()))
				{
					if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSoyadi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txKullaniciAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSifre.getText().toString())==true &&
									Fonksiyonlar.SayisalMi(txMaas.getText(),"Maaþ")==true &&
									Fonksiyonlar.SayisalMi(txTel.getText(),"Tel")==true &&
								/*	Fonksiyonlar.StringMi(txMaas.getText().toString())==true &&
									Fonksiyonlar.StringMi(txTel.getText().toString())==true &&*/
							Fonksiyonlar.StringMi(txEmail.getText().toString())==true &&
							Fonksiyonlar.StringMi(txAdres.getText().toString())==true &&
							Fonksiyonlar.StringMi(cbOtel.getSelectedItem().toString())==true &&
							Fonksiyonlar.StringMi(cbYetki.getSelectedItem().toString())==true 
							
					  )
					{
						OtelIslemleri.cbOtelIdCek(cbOtel, lblOtelId);
						PersonelIslemleri.PersonelGuncelle(kisi_id,txAdi.getText(), txSoyadi.getText(),  txKullaniciAdi.getText(), txSifre.getText(),cbYetki.getSelectedItem().toString(), txMaas.getText(),txAdres.getText(), txTel.getText(), txEmail.getText(),"1",lblOtelId.getText());
						OtelIslemleri.cbOtelYukle(cbOtel);
						PersonelIslemleri.KayitlariCek(dm, table);
						PersonelIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbYetki, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas,cbOtel);						
						
						
					}
					else
					{
						PersonelIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbYetki, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas,cbOtel);						
					}
				}
				else
				{
					PersonelIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbYetki, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas,cbOtel);						
				}
				
				
				

				
			}
				
				
			
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuncelle.setBounds(456, 385, 144, 55);
		contentPane.add(btnGuncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(kisi_id!=null )
					{
						OtelIslemleri.cbOtelIdCek(cbOtel, lblOtelId);
						PersonelIslemleri.PersonelSil(kisi_id);
						OtelIslemleri.cbOtelYukle(cbOtel);
						PersonelIslemleri.KayitlariCek(dm, table);
						PersonelIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbYetki, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas,cbOtel);						
						
						
					}
					else
					{
						PersonelIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbYetki, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas,cbOtel);						
					}
				}
				
				
			
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSil.setBounds(261, 385, 144, 55);
		contentPane.add(btnSil);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 	
				 
				
				if(PersonelIslemleri.AlanKontrolu(
						txAdi.getText(), txSoyadi.getText(),
						cbYetki.getSelectedItem().toString(),
						txKullaniciAdi.getText() , txSifre.getText(),
						txMaas.getText(), txTel.getText(),
						txEmail.getText(),txAdres.getText(),cbOtel.getSelectedItem().toString()))
				{
					if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSoyadi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txKullaniciAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSifre.getPassword().toString())==true &&
							Fonksiyonlar.SayisalMi(txMaas.getText(),"Maaþ")==true &&
							Fonksiyonlar.SayisalMi(txTel.getText(),"Tel")==true &&
						/*	Fonksiyonlar.StringMi(txMaas.getText().toString())==true &&
							Fonksiyonlar.StringMi(txTel.getText().toString())==true &&*/
							Fonksiyonlar.StringMi(txEmail.getText().toString())==true &&
							Fonksiyonlar.StringMi(txAdres.getText().toString())==true &&
							Fonksiyonlar.StringMi(cbOtel.getSelectedItem().toString())==true 
							
					  )
					{
					//	OtelIslemleri.cbOtelIdCek(cbOtel, lblOtelId);
						PersonelIslemleri.PersonelEkle(txAdi.getText(), txSoyadi.getText(),  txKullaniciAdi.getText(), txSifre.getText(),cbYetki.getSelectedItem().toString(), txMaas.getText(),txAdres.getText(), txTel.getText(), txEmail.getText(),"1");
						OtelIslemleri.cbOtelYukle(cbOtel);
						PersonelIslemleri.KayitlariCek(dm, table);
						PersonelIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbYetki, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas,cbOtel);						
						
					}
					else{PersonelIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbYetki, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas,cbOtel);						}
				}
				else{PersonelIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbYetki, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas,cbOtel);						}
				
				
				

				
			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEkle.setBounds(70, 385, 144, 55);
		contentPane.add(btnEkle);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fonksiyonlar.UygulamaCikisYap();
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCikis.setBounds(860, 26, 110, 41);
		contentPane.add(btnCikis);
		
		txEmail = new JTextField();
		txEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		txEmail.setColumns(10);
		txEmail.setBounds(848, 309, 122, 22);
		contentPane.add(txEmail);
		
		JLabel lblOtel = new JLabel("Otel");
		lblOtel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtel.setBounds(70, 342, 92, 30);
		contentPane.add(lblOtel);
		
		JLabel lblMaas = new JLabel("Maas");
		lblMaas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaas.setBounds(394, 342, 92, 30);
		contentPane.add(lblMaas);
		
		txMaas = new JTextField();
		txMaas.setFont(new Font("Tahoma", Font.BOLD, 15));
		txMaas.setColumns(10);
		txMaas.setBounds(498, 346, 122, 22);
		contentPane.add(txMaas);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdres.setBounds(744, 342, 92, 30);
		contentPane.add(lblAdres);
		
		txAdres = new JTextField();
		txAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
		txAdres.setColumns(10);
		txAdres.setBounds(848, 347, 122, 22);
		contentPane.add(txAdres);
		
		 cbOtel = new JComboBox();
		 cbOtel.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		OtelIslemleri.cbOtelYukle(cbOtel);
		 	}
		 });
		cbOtel.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbOtel.setBounds(174, 347, 122, 22);
		contentPane.add(cbOtel);
		
		txSifre = new JPasswordField();
		txSifre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		txSifre.setBounds(498, 309, 122, 22);
		contentPane.add(txSifre);
		
		lblOtelId = new JLabel("");
		lblOtelId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtelId.setBounds(12, 13, 92, 30);
		contentPane.add(lblOtelId);
		
		JLabel lblYetki = new JLabel("Yetki");
		lblYetki.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYetki.setBounds(70, 316, 92, 30);
		contentPane.add(lblYetki);
		
	    cbYetki = new JComboBox();
	    cbYetki.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		// TODO Auto-generated method stub
	    		PersonelIslemleri.MudurYetki(cbYetki);
	    	}
		});
		cbYetki.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbYetki.setBounds(174, 320, 122, 22);
		contentPane.add(cbYetki);
	}
}
