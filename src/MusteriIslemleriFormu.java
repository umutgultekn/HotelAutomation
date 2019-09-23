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

public class MusteriIslemleriFormu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txAdi;
	private JTextField txSoyadi;
	private JTextField txTel;
	private JTextField txEmail;
	 
	private JTextField txAdres;


	
	DefaultTableModel dm;
	String kisi_id;
	
	static MusteriIslemleriFormu frame = new MusteriIslemleriFormu();

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
	public MusteriIslemleriFormu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				MusteriIslemleri.KayitlariCek(dm, table);
				
			}
		});
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100,997,500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblMstrIlemleri = new JLabel("Musteri Islemleri");
	lblMstrIlemleri.setHorizontalAlignment(SwingConstants.CENTER);
	lblMstrIlemleri.setFont(new Font("Tahoma", Font.BOLD, 24));
	lblMstrIlemleri.setBounds(386, 37, 286, 30);
	contentPane.add(lblMstrIlemleri);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(36, 87, 900, 1);
	contentPane.add(separator);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(37, 106, 898, 142);
	contentPane.add(scrollPane);
	
	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			String tablo_secilen_id = table.getValueAt(table.getSelectedRow(),7).toString();
			String tablo_secilen_ad = table.getValueAt(table.getSelectedRow(),1).toString();
			String tablo_secilen_soyad = table.getValueAt(table.getSelectedRow(),2).toString(); 
			String tablo_secilen_adres = table.getValueAt(table.getSelectedRow(),3).toString();
			String tablo_secilen_tel = table.getValueAt(table.getSelectedRow(),4).toString();
			String tablo_secilen_email= table.getValueAt(table.getSelectedRow(),5).toString();			 
			String tablo_secilen_vtdurum= table.getValueAt(table.getSelectedRow(),6).toString();
		 
			txAdi.setText(tablo_secilen_ad);
			txSoyadi.setText(tablo_secilen_soyad);
			txAdres.setText(tablo_secilen_adres);
			txTel.setText(tablo_secilen_tel);
			txEmail.setText(tablo_secilen_email);
			 
			 
			kisi_id = tablo_secilen_id;
			
			
		}
	});
	scrollPane.setViewportView(table);
	table.setFillsViewportHeight(true);
	
	txAdi = new JTextField();
	txAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
	txAdi.setColumns(10);
	txAdi.setBounds(140, 289, 122, 22);
	contentPane.add(txAdi);
	
	txSoyadi = new JTextField();
	txSoyadi.setFont(new Font("Tahoma", Font.BOLD, 15));
	txSoyadi.setColumns(10);
	txSoyadi.setBounds(140, 317, 122, 22);
	contentPane.add(txSoyadi);
	
	JLabel lblAd = new JLabel("Ad\u0131");
	lblAd.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblAd.setBounds(36, 285, 92, 30);
	contentPane.add(lblAd);
	
	JLabel lblSoyad = new JLabel("Soyad");
	lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblSoyad.setBounds(36, 310, 92, 30);
	contentPane.add(lblSoyad);
	
	JLabel lblTel = new JLabel(" Tel");
	lblTel.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblTel.setBounds(338, 285, 92, 30);
	contentPane.add(lblTel);
	
	JLabel lblEmail = new JLabel("Email");
	lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblEmail.setBounds(338, 309, 92, 30);
	contentPane.add(lblEmail);
	
	txTel = new JTextField();
	txTel.setFont(new Font("Tahoma", Font.BOLD, 15));
	txTel.setColumns(10);
	txTel.setBounds(442, 289, 122, 22);
	contentPane.add(txTel);
	
	JButton btnGeriDon = new JButton("Geri D\u00F6n");
	btnGeriDon.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ResepsiyonistFormu rsFormu = new ResepsiyonistFormu();
			rsFormu.setVisible(true);
			frame.setVisible(false);
			
		}
	});
	btnGeriDon.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnGeriDon.setBounds(792, 385, 144, 55);
	contentPane.add(btnGeriDon);
	
	JButton btnAra = new JButton("Ara");
	btnAra.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnAra.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			MusteriIslemleri.MusteriAra(dm, table,txAdi.getText().toString(), txSoyadi.getText().toString(), txEmail.getText().toString(),txTel.getText().toString());
			
		}
	});//, txAdi.getText(), txSoyadi.getText(), txKullaniciAdi.getText(), txEmail.getText(), txTel.getText()
	btnAra.setBounds(609, 385, 144, 55);
	contentPane.add(btnAra);
	
	JButton btnGuncelle = new JButton("G\u00FCncelle");
	btnGuncelle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
	 
			if(MusteriIslemleri.AlanKontrolu(
					txAdi.getText(), txSoyadi.getText(),
					txTel.getText(),
					txEmail.getText(),txAdres.getText()))
			{
				if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
						Fonksiyonlar.StringMi(txSoyadi.getText().toString())==true &&			 
								Fonksiyonlar.SayisalMi(txTel.getText()," tel ")==true &&
						Fonksiyonlar.StringMi(txEmail.getText().toString())==true &&
						Fonksiyonlar.StringMi(txAdres.getText().toString())==true  
						 
						
				  )
				{
					 
					MusteriIslemleri.MusteriGuncelle(kisi_id,txAdi.getText(), txSoyadi.getText(),txAdres.getText(), txTel.getText(), txEmail.getText(),"1");					 
					MusteriIslemleri.KayitlariCek(dm, table);
					MusteriIslemleri.AlanlariTemizle(txAdi, txSoyadi,txEmail, txAdres, txTel);								
					
					
				}
				else
				{
					 MusteriIslemleri.AlanlariTemizle(txAdi, txSoyadi,txEmail, txAdres, txTel);		
				}
			}
			else
			{
				   MusteriIslemleri.AlanlariTemizle(txAdi, txSoyadi,txEmail, txAdres, txTel);							
			}
			
			
			
 
			
		}
			
			
		
	});
	btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnGuncelle.setBounds(422, 385, 144, 55);
	contentPane.add(btnGuncelle);
	
	JButton btnSil = new JButton("Sil");
	btnSil.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			
			 if(kisi_id!=null )
				{
					 
				 MusteriIslemleri.MusteriSil(kisi_id);
					 
				 MusteriIslemleri.KayitlariCek(dm, table);
				 MusteriIslemleri.AlanlariTemizle(txAdi, txSoyadi,txEmail, txAdres, txTel);		
					
					
				}
				else
				{
					MusteriIslemleri.AlanlariTemizle(txAdi, txSoyadi,txEmail, txAdres, txTel);							
				}
				 
			}
			
			
		
	});
	btnSil.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnSil.setBounds(227, 385, 144, 55);
	contentPane.add(btnSil);
	
	JButton btnEkle = new JButton("Ekle");
	btnEkle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

		 	
			 
		 	
			if(MusteriIslemleri.AlanKontrolu(
					txAdi.getText(), txSoyadi.getText(),					 
				 txTel.getText(),txEmail.getText(),txAdres.getText()))
			{
				if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
						Fonksiyonlar.StringMi(txSoyadi.getText().toString())==true &&						 
						Fonksiyonlar.SayisalMi(txTel.getText()," tel ")==true &&
						Fonksiyonlar.StringMi(txEmail.getText().toString())==true &&
						Fonksiyonlar.StringMi(txAdres.getText().toString())==true 				 
						
				  )
				{
					
					MusteriIslemleri.MusteriEkle(txAdi.getText(), txSoyadi.getText(),txAdres.getText(), txTel.getText(), txEmail.getText(),"1");
					
					MusteriIslemleri.KayitlariCek(dm, table);
					
					MusteriIslemleri.AlanlariTemizle(txAdi, txSoyadi,txEmail, txAdres, txTel);						
					
				}
				else{
					MusteriIslemleri.AlanlariTemizle(txAdi, txSoyadi,txEmail, txAdres, txTel);	
					}
				}
			 
			else{
					MusteriIslemleri.AlanlariTemizle(txAdi, txSoyadi,txEmail, txAdres, txTel);				
				}
			 
			
			
			 

			
		}
	});
	btnEkle.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnEkle.setBounds(36, 385, 144, 55);
	contentPane.add(btnEkle);
	
	JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
	btnCikis.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Fonksiyonlar.UygulamaCikisYap();
		}
	});
	btnCikis.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnCikis.setBounds(826, 26, 110, 41);
	contentPane.add(btnCikis);
	
	txEmail = new JTextField();
	txEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
	txEmail.setColumns(10);
	txEmail.setBounds(442, 314, 122, 22);
	contentPane.add(txEmail);
	 
	
	JLabel lblAdres = new JLabel("Adres");
	lblAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblAdres.setBounds(629, 269, 307, 63);
	contentPane.add(lblAdres);
	
	txAdres = new JTextField();
	txAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
	txAdres.setColumns(10);
	txAdres.setBounds(732, 279, 203, 58);
	contentPane.add(txAdres);
	
	JButton btnGeri = new JButton("Geri");
	btnGeri.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ResepsiyonistFormu  rf=new ResepsiyonistFormu();
			rf.setVisible(true);
			frame.setVisible(false);
		}
	});
	btnGeri.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnGeri.setBounds(36, 26, 110, 41);
	contentPane.add(btnGeri);
	
	  
	
	 
	}
	
	

}
