import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.awt.TextArea;

public class GeriBildirimIslemleriFormu extends JFrame {

	private JPanel contentPane;
	private JTable table;
    JComboBox cbTemizlik,cbKonfor,cbHKalite,cbYKalite,cbUKalite;
	JDateChooser tarih;
	TextArea not;
	DefaultTableModel dm;
	SimpleDateFormat sdfs;
	int geriBildirimID=0;
	GeriBildirimIslemleri geriIslemler;
	ArrayList<JComboBox> comboliste;
	static GeriBildirimIslemleriFormu frame = new GeriBildirimIslemleriFormu();
	 
	
	
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
	public GeriBildirimIslemleriFormu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				geriIslemler = new GeriBildirimIslemleri();
				geriIslemler.KayitlariCek(dm, table);
				comboDereceYukle();
				comboliste = new ArrayList(Arrays.asList(cbHKalite,cbKonfor,cbTemizlik,cbUKalite,cbYKalite)) ;
 				sdfs = new SimpleDateFormat("yyyy-MM-dd");		
				  
			}

			
				
				
		});
	
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100,1000,500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblMdrIlemleri = new JLabel("Geri Bildirim \u0130\u015Flemleri");
	lblMdrIlemleri.setHorizontalAlignment(SwingConstants.CENTER);
	lblMdrIlemleri.setFont(new Font("Tahoma", Font.BOLD, 24));
	lblMdrIlemleri.setBounds(276, 27, 367, 30);
	contentPane.add(lblMdrIlemleri);
	
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
			
			int tablo_secilen_geriBilId = Integer.parseInt(table.getValueAt(table.getSelectedRow(),8).toString());
			int tablo_secilen_rezId = Integer.parseInt(table.getValueAt(table.getSelectedRow(),9).toString());
			int tablo_secilen_temizlik = Integer.parseInt(table.getValueAt(table.getSelectedRow(),1).toString());
			int tablo_secilen_konfor = Integer.parseInt(table.getValueAt(table.getSelectedRow(),2).toString());
			int tablo_secilen_urun_kalitesi = Integer.parseInt(table.getValueAt(table.getSelectedRow(),3).toString());
			int tablo_secilen_hizmet_kalitesi = Integer.parseInt(table.getValueAt(table.getSelectedRow(),4).toString());
			int tablo_secilen_yemek_kalitesi= Integer.parseInt(table.getValueAt(table.getSelectedRow(),5).toString());
			String tablo_secilen_not = table.getValueAt(table.getSelectedRow(),6).toString();
			String tablo_secilen_tarih = table.getValueAt(table.getSelectedRow(),7).toString();
			
			try {//tarih bilgisinin JCalendara set etmek için
			    		 
				Date date = sdfs.parse(tablo_secilen_tarih);									
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				tarih.setDate(calendar.getTime());
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			  
		    
		    not.setText(tablo_secilen_not);
		    
		    cbHKalite.setSelectedItem(tablo_secilen_hizmet_kalitesi);
		    cbKonfor.setSelectedItem(tablo_secilen_konfor);
		    cbTemizlik.setSelectedItem(tablo_secilen_temizlik);
		    cbUKalite.setSelectedItem(tablo_secilen_urun_kalitesi);
		    cbYKalite.setSelectedItem(tablo_secilen_yemek_kalitesi);
		    
		     
		    System.out.print(tablo_secilen_geriBilId);
		    geriBildirimID=tablo_secilen_geriBilId;
			 
			  
		}
	});
	scrollPane.setViewportView(table);
	table.setFillsViewportHeight(true);
	
	JLabel lblAd = new JLabel("Temizlik");
	lblAd.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblAd.setBounds(70, 261, 92, 30);
	contentPane.add(lblAd);
	
	JLabel lblSoyad = new JLabel("Konfor");
	lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblSoyad.setBounds(70, 304, 92, 30);
	contentPane.add(lblSoyad);
	
	JLabel lblKullaniciAdi = new JLabel("Hizmet Kalitesi");
	lblKullaniciAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblKullaniciAdi.setBounds(394, 261, 134, 30);
	contentPane.add(lblKullaniciAdi);
	
	JLabel lblSifre = new JLabel("Yemek Kalitesi");
	lblSifre.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblSifre.setBounds(394, 304, 134, 30);
	contentPane.add(lblSifre);
	
	JButton btnGeriDon = new JButton("Geri D\u00F6n");
	btnGeriDon.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ResepsiyonistFormu resepsiyonist_formu = new ResepsiyonistFormu();
			resepsiyonist_formu.setVisible(true);
			frame.setVisible(false);			
		}
	});
	btnGeriDon.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnGeriDon.setBounds(826, 385, 144, 55);
	contentPane.add(btnGeriDon);
	
	JButton btnAra = new JButton("Ara");
	btnAra.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			String texttarih =null;
			if(tarih.getDate()!=null)
			{
				texttarih = sdfs.format(tarih.getDate());
			}
			geriIslemler.GeriBildirimAra(dm,table,cbTemizlik.getSelectedItem(),cbKonfor.getSelectedItem(),cbUKalite.getSelectedItem(),cbHKalite.getSelectedItem(),cbYKalite.getSelectedItem(),texttarih );
			 
			
		}
	});
	btnAra.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnAra.setBounds(643, 385, 144, 55);
	contentPane.add(btnAra);
	
	JButton btnGuncelle = new JButton("G\u00FCncelle");
	btnGuncelle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		 
		
	 
			
			if(geriBildirimID > 0 && geriIslemler.componentKontrol(comboliste, tarih, not)==true) 
			{
				geriIslemler.GeriBildirimGuncelle(geriBildirimID, (int)cbTemizlik.getSelectedItem(), (int)cbKonfor.getSelectedItem(), (int)cbUKalite.getSelectedItem(), (int)cbHKalite.getSelectedItem(),(int) cbYKalite.getSelectedItem(),not.getText(),sdfs.format(tarih.getDate()).toString());
				geriIslemler.KayitlariCek(dm, table)	;
				geriIslemler.componentTemizle(comboliste,tarih,not);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null," Listeden geri bildirim seçilmedi");
			}
		  
		 
		}
		
	});
	btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnGuncelle.setBounds(456, 385, 144, 55);
	contentPane.add(btnGuncelle);
	
	JButton btnSil = new JButton("Sil");
	btnSil.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			
			 
			
			if(geriBildirimID > 0) 
			{
				geriIslemler.GeriBildirimSil(geriBildirimID);
				geriIslemler.KayitlariCek(dm, table);
				geriIslemler.componentTemizle(comboliste,tarih,not);
			}
			else
			{
				JOptionPane.showMessageDialog(null," Listeden geri bildirim seçilmedi");
			}
			
		}
	});
	btnSil.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnSil.setBounds(261, 385, 144, 55);
	contentPane.add(btnSil);
	
	JButton btnEkle = new JButton("Ekle");
	btnEkle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		
			
			 
			
			if(geriIslemler.componentKontrol(comboliste,tarih,not)==true) 
			{
				geriIslemler.GeriBildirimEkle(4, (int)cbTemizlik.getSelectedItem(), (int)cbKonfor.getSelectedItem(), (int)cbUKalite.getSelectedItem(), (int)cbHKalite.getSelectedItem(),(int) cbYKalite.getSelectedItem(),not.getText(),sdfs.format(tarih.getDate()).toString() );
				geriIslemler.KayitlariCek(dm, table) ;
				geriIslemler.componentTemizle(comboliste,tarih,not);
			}
			else
			{
				JOptionPane.showMessageDialog(null," Lütfen Boþ Alanlarý Doldurup Tekrar Deneyiniz");
			}
			 
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
	
	JLabel lblOtel = new JLabel("Urun Kalitesi");
	lblOtel.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblOtel.setBounds(70, 342, 115, 30);
	contentPane.add(lblOtel);
	
	JLabel lblMaas = new JLabel("Tarih");
	lblMaas.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblMaas.setBounds(394, 342, 134, 30);
	contentPane.add(lblMaas);
	
	JLabel lblAdres = new JLabel("NOT");
	lblAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblAdres.setBounds(670, 261, 92, 30);
	contentPane.add(lblAdres);
	
	 
	
	  
	
	 tarih = new JDateChooser();
	tarih.setBounds(538, 342, 122, 20);
	contentPane.add(tarih);
	
	not = new TextArea();
	not.setBounds(665, 291, 305, 72);
	contentPane.add(not);
	
	 cbTemizlik = new JComboBox();
	cbTemizlik.setBounds(196, 267, 122, 22);
	contentPane.add(cbTemizlik);
	
	 cbKonfor = new JComboBox();
	cbKonfor.setBounds(196, 310, 122, 22);
	contentPane.add(cbKonfor);
	
	 cbUKalite = new JComboBox();
	cbUKalite.setBounds(195, 348, 123, 22);
	contentPane.add(cbUKalite);
	
	 cbHKalite = new JComboBox();
	cbHKalite.setBounds(538, 267, 122, 22);
	contentPane.add(cbHKalite);
	
	 cbYKalite = new JComboBox();
	cbYKalite.setBounds(538, 304, 122, 22);
	contentPane.add(cbYKalite);
	
	 
}
	private void comboDereceYukle() {

		for(int i=0;i<6;i++) { 
			cbHKalite.addItem(i==0 ? "Seciniz":i);
		    cbKonfor.addItem(i==0 ? "Seciniz":i);
		    cbTemizlik.addItem(i==0 ? "Seciniz":i);
		    cbUKalite.addItem(i==0 ? "Seciniz":i);
		    cbYKalite.addItem(i==0 ? "Seciniz":i);
		}
	}

}
