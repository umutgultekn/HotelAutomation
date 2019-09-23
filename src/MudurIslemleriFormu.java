import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MudurIslemleriFormu extends JFrame {

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
	String kisi_otel;
	String otel_id;
	JLabel lblOtelId;
	DefaultTableModel dm;
	String kisi_id;
	static MudurIslemleriFormu frame = new MudurIslemleriFormu();
	

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
	public MudurIslemleriFormu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				OtelIslemleri.cbOtelYukle(cbOtel);
				MudurIslemleri.KayitlariCek(dm, table);
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMdrIlemleri = new JLabel("M\u00FCd\u00FCr \u0130\u015Flemleri");
		lblMdrIlemleri.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdrIlemleri.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMdrIlemleri.setBounds(391, 37, 200, 30);
		contentPane.add(lblMdrIlemleri);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(41, 87, 900, 1);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 106, 898, 142);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String tablo_secilen_id = table.getValueAt(table.getSelectedRow(),12).toString();
				String tablo_secilen_ad = table.getValueAt(table.getSelectedRow(),1).toString();
				String tablo_secilen_soyad = table.getValueAt(table.getSelectedRow(),2).toString();
				String tablo_secilen_otel = table.getValueAt(table.getSelectedRow(),3).toString();
				String tablo_secilen_adres = table.getValueAt(table.getSelectedRow(),4).toString();
				String tablo_secilen_tel = table.getValueAt(table.getSelectedRow(),5).toString();
				String tablo_secilen_email= table.getValueAt(table.getSelectedRow(),6).toString();
				String tablo_secilen_kullaniciadi = table.getValueAt(table.getSelectedRow(),7).toString();
				String tablo_secilen_sifre = table.getValueAt(table.getSelectedRow(),8).toString();
				String tablo_secilen_yetki = table.getValueAt(table.getSelectedRow(),9).toString();
				String tablo_secilen_maas = table.getValueAt(table.getSelectedRow(),10).toString();
				String tablo_secilen_vtdurum= table.getValueAt(table.getSelectedRow(),11).toString();
			

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
				kisi_otel = tablo_secilen_otel;
				kisi_id = tablo_secilen_id;
				
				
			}
		});
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		txAdi = new JTextField();
		txAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txAdi.setColumns(10);
		txAdi.setBounds(145, 265, 122, 22);
		contentPane.add(txAdi);
		
		txSoyadi = new JTextField();
		txSoyadi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txSoyadi.setColumns(10);
		txSoyadi.setBounds(145, 308, 122, 22);
		contentPane.add(txSoyadi);
		
		JLabel lblAd = new JLabel("Ad\u0131");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAd.setBounds(41, 261, 92, 30);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoyad.setBounds(41, 304, 92, 30);
		contentPane.add(lblSoyad);
		
		JLabel lblKullaniciAdi = new JLabel("Kullanici Adi");
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKullaniciAdi.setBounds(365, 261, 92, 30);
		contentPane.add(lblKullaniciAdi);
		
		JLabel lblSifre = new JLabel("Sifre");
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSifre.setBounds(365, 304, 92, 30);
		contentPane.add(lblSifre);
		
		txKullaniciAdi = new JTextField();
		txKullaniciAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txKullaniciAdi.setColumns(10);
		txKullaniciAdi.setBounds(469, 265, 122, 22);
		contentPane.add(txKullaniciAdi);
		
		JLabel lblTel = new JLabel(" Tel");
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTel.setBounds(715, 261, 92, 30);
		contentPane.add(lblTel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(715, 304, 92, 30);
		contentPane.add(lblEmail);
		
		txTel = new JTextField();
		txTel.setFont(new Font("Tahoma", Font.BOLD, 15));
		txTel.setColumns(10);
		txTel.setBounds(819, 265, 122, 22);
		contentPane.add(txTel);
		
		JButton btnAra = new JButton("Ara");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtelIslemleri.cbOtelIdCek(cbOtel, lblOtelId);
				MudurIslemleri.MudurAra(dm, table,txAdi.getText(),txSoyadi.getText(),lblOtelId.getText(),txKullaniciAdi.getText(),txSifre.getText(),txMaas.getText(),txTel.getText()
						, txEmail.getText(),txAdres.getText());
				
			}
		});
		btnAra.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAra.setBounds(613, 385, 144, 55);
		contentPane.add(btnAra);
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				MudurIslemleri.KayitlariCek(dm, table);
				MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);
				OtelIslemleri.cbOtelYukle(cbOtel);
				
			}
		});
		btnListele.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListele.setBounds(797, 385, 144, 55);
		contentPane.add(btnListele);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(MudurIslemleri.AlanKontrolu(
						txAdi.getText(), txSoyadi.getText(),
						cbOtel.getSelectedItem().toString(),
						txKullaniciAdi.getText() , txSifre.getText(),
						txMaas.getText(), txTel.getText(),
						txEmail.getText(),txAdres.getText()))
				{
					if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSoyadi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txKullaniciAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSifre.getText().toString())==true &&
									Fonksiyonlar.SayisalMi(txMaas.getText()," maaþ ")==true &&
									Fonksiyonlar.SayisalMi(txTel.getText()," tel ")==true &&
							Fonksiyonlar.StringMi(txEmail.getText().toString())==true &&
							Fonksiyonlar.StringMi(txAdres.getText().toString())==true &&
							Fonksiyonlar.StringMi(cbOtel.getSelectedItem().toString())==true 
							
					  )
					{
						OtelIslemleri.cbOtelIdCek(cbOtel, lblOtelId);
						MudurIslemleri.MudurGuncelle(kisi_id,txAdi.getText(), txSoyadi.getText(),  txKullaniciAdi.getText(), txSifre.getText(),"mudur", txMaas.getText(),txAdres.getText(), txTel.getText(), txEmail.getText(),"1",lblOtelId.getText());
						OtelIslemleri.cbOtelYukle(cbOtel);
						MudurIslemleri.KayitlariCek(dm, table);
						MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);						
						
						
					}
					else
					{
						MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);
					}
				}
				else
				{
					MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);
				}
				
				
				

				
			}
				
				
			
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuncelle.setBounds(427, 385, 144, 55);
		contentPane.add(btnGuncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(MudurIslemleri.AlanKontrolu(
						txAdi.getText(), txSoyadi.getText(),
						cbOtel.getSelectedItem().toString(),
						txKullaniciAdi.getText() , txSifre.getText(),
						txMaas.getText(), txTel.getText(),
						txEmail.getText(),txAdres.getText()))
				{
					if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSoyadi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txKullaniciAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSifre.getText().toString())==true &&
							Fonksiyonlar.SayisalMi(txMaas.getText()," maaþ ")==true &&
							Fonksiyonlar.SayisalMi(txTel.getText()," tel ")==true &&
							Fonksiyonlar.StringMi(txEmail.getText().toString())==true &&
							Fonksiyonlar.StringMi(txAdres.getText().toString())==true &&
							Fonksiyonlar.StringMi(cbOtel.getSelectedItem().toString())==true 
							
					  )
					{
						OtelIslemleri.cbOtelIdCek(cbOtel, lblOtelId);
						MudurIslemleri.MudurSil(kisi_id);
						OtelIslemleri.cbOtelYukle(cbOtel);
						MudurIslemleri.KayitlariCek(dm, table);
						MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);						
						
						
					}
					else
					{
						MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);
					}
				}
				else
				{
					MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);
				}
				
				
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSil.setBounds(232, 385, 144, 55);
		contentPane.add(btnSil);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
				if(MudurIslemleri.AlanKontrolu(
						txAdi.getText(), txSoyadi.getText(),
						cbOtel.getSelectedItem().toString(),
						txKullaniciAdi.getText() , txSifre.getText(),
						txMaas.getText(), txTel.getText(),
						txEmail.getText(),txAdres.getText()))
				{
					if(		
							Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSoyadi.getText().toString())==true &&
							Fonksiyonlar.StringMi(cbOtel.getSelectedItem().toString())==true &&
							Fonksiyonlar.StringMi(txKullaniciAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txSifre.getText().toString())==true &&
							Fonksiyonlar.SayisalMi(txMaas.getText()," maaþ ")==true &&
							Fonksiyonlar.SayisalMi(txTel.getText()," tel ")==true &&
							Fonksiyonlar.StringMi(txEmail.getText().toString())==true &&
							Fonksiyonlar.StringMi(txAdres.getText().toString())==true 
							
					  )
					{
						OtelIslemleri.cbOtelIdCek(cbOtel,lblOtelId);
						MudurIslemleri.MudurEkle(txAdi.getText(), txSoyadi.getText(),lblOtelId.getText() ,txKullaniciAdi.getText(), txSifre.getText(),txMaas.getText(),txAdres.getText(), txTel.getText(), txEmail.getText(),"mudur","1");
						MudurIslemleri.KayitlariCek(dm, table);
						MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txMaas, txAdres, txTel,txEmail);						
						OtelIslemleri.cbOtelYukle(cbOtel);

						
					}
					else
					{
						MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);
					}
				}
				else
				{
					MudurIslemleri.AlanlariTemizle(txAdi, txSoyadi, cbOtel, txKullaniciAdi, txSifre, txEmail, txAdres, txTel, txMaas);
				}
				
				
				

				
			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEkle.setBounds(41, 385, 144, 55);
		contentPane.add(btnEkle);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Fonksiyonlar.UygulamaCikisYap();
				
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCikis.setBounds(831, 26, 110, 41);
		contentPane.add(btnCikis);
		
		txEmail = new JTextField();
		txEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		txEmail.setColumns(10);
		txEmail.setBounds(819, 309, 122, 22);
		contentPane.add(txEmail);
		
		JLabel lblOtel = new JLabel("Otel");
		lblOtel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtel.setBounds(41, 342, 92, 30);
		contentPane.add(lblOtel);
		
		JLabel lblMaas = new JLabel("Maas");
		lblMaas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaas.setBounds(365, 342, 92, 30);
		contentPane.add(lblMaas);
		
		txMaas = new JTextField();
		txMaas.setFont(new Font("Tahoma", Font.BOLD, 15));
		txMaas.setColumns(10);
		txMaas.setBounds(469, 346, 122, 22);
		contentPane.add(txMaas);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdres.setBounds(715, 342, 92, 30);
		contentPane.add(lblAdres);
		
		txAdres = new JTextField();
		txAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
		txAdres.setColumns(10);
		txAdres.setBounds(819, 347, 122, 22);
		contentPane.add(txAdres);
		
		 cbOtel = new JComboBox();
		 cbOtel.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		OtelIslemleri.cbOtelYukle(cbOtel);
		 	}
		 });
		cbOtel.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbOtel.setBounds(145, 347, 122, 22);
		contentPane.add(cbOtel);
		
		txSifre = new JPasswordField();
		txSifre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		txSifre.setBounds(469, 309, 122, 22);
		contentPane.add(txSifre);
		
		 lblOtelId = new JLabel("");
		lblOtelId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtelId.setBounds(210, 13, 92, 30);
		lblOtelId.setVisible(false);
		contentPane.add(lblOtelId);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				YoneticiFormu yonetici_formu = new YoneticiFormu();
					yonetici_formu.setVisible(true);
							frame.setVisible(false);
			}
		});
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGeri.setBounds(41, 26, 110, 41);
		contentPane.add(btnGeri);
	}
}
