import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

public class OtelIslemleriFormu extends JFrame {

	String otel_id;
	int otel_yildiz;
	private JPanel contentPane;
	private JTable table;
	private JTextField txAdi;
	private JLabel lblOtelIl;
	private JTextField txIl;
	private JLabel lblOtelIle;
	private JTextField txIlce;
	private JTextField txAdres;
	private JLabel lblOtelAdres;
	private JLabel lblOtelTelefon;
	private JTextField txTel;
	private JLabel lblOtelYldz;
	private JComboBox cbYildiz;
	DefaultTableModel dm;
	private JScrollPane scrollPane;
	static OtelIslemleriFormu frame = new OtelIslemleriFormu();

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
	
	public OtelIslemleriFormu() 
	{
		
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowOpened(WindowEvent arg0)
			{
				OtelIslemleri.CbYildizYukle(cbYildiz);
				OtelIslemleri.KayitlariCek(dm, table);
			}
		}
	);
	
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,1000,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOtelIlemleri = new JLabel("Otel \u0130\u015Flemleri");
		lblOtelIlemleri.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtelIlemleri.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOtelIlemleri.setBounds(400, 25, 200, 30);
		contentPane.add(lblOtelIlemleri);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 75, 900, 1);
		contentPane.add(separator);
		
		cbYildiz = new JComboBox();
		cbYildiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				OtelIslemleri.CbYildizYukle(cbYildiz);
			}
		});
		cbYildiz.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbYildiz.setBounds(828, 303, 122, 22);
		contentPane.add(cbYildiz);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(50, 93, 900, 144);
			contentPane.add(scrollPane);
			
			
			
			
			table = new JTable();		
			scrollPane.setViewportView(table);
			table.setFillsViewportHeight(true);
			
				table.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						String tablo_secilen_id = table.getValueAt(table.getSelectedRow(),8).toString();
						String tablo_secilen_ad = table.getValueAt(table.getSelectedRow(),1).toString();
						String tablo_secilen_il = table.getValueAt(table.getSelectedRow(),2).toString();
						String tablo_secilen_ilce = table.getValueAt(table.getSelectedRow(),3).toString();
						String tablo_secilen_adres = table.getValueAt(table.getSelectedRow(),4).toString();
						String tablo_secilen_tel = table.getValueAt(table.getSelectedRow(),5).toString();
						String tablo_secilen_yildiz= table.getValueAt(table.getSelectedRow(),6).toString();
						String tablo_secilen_vtdurum = table.getValueAt(table.getSelectedRow(),7).toString();
					

						txAdi.setText(tablo_secilen_ad);
						txIl.setText(tablo_secilen_il);
						txIlce.setText(tablo_secilen_ilce);
						txAdres.setText(tablo_secilen_adres);
						txTel.setText(tablo_secilen_tel);
						//cbYildiz.setSelectedItem(tablo_secilen_yildiz.toString());
						cbYildiz.removeAllItems();
						cbYildiz.addItem(tablo_secilen_yildiz);
						otel_yildiz = Integer.parseInt((String)tablo_secilen_yildiz);
						otel_id = tablo_secilen_id;
						
					}
				});
	
		
		JLabel lblNewLabel = new JLabel("Otel Ad\u0131");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 255, 92, 30);
		contentPane.add(lblNewLabel);
		
		txAdi = new JTextField();
		txAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txAdi.setBounds(154, 259, 122, 22);
		contentPane.add(txAdi);
		txAdi.setColumns(10);
		
		lblOtelIl = new JLabel("Otel \u0130l");
		lblOtelIl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtelIl.setBounds(50, 298, 92, 30);
		contentPane.add(lblOtelIl);
		
		txIl = new JTextField();
		txIl.setFont(new Font("Tahoma", Font.BOLD, 15));
		txIl.setColumns(10);
		txIl.setBounds(154, 302, 122, 22);
		contentPane.add(txIl);
		
		lblOtelIle = new JLabel("Otel \u0130l\u00E7e");
		lblOtelIle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtelIle.setBounds(374, 255, 92, 30);
		contentPane.add(lblOtelIle);
		
		txIlce = new JTextField();
		txIlce.setFont(new Font("Tahoma", Font.BOLD, 15));
		txIlce.setColumns(10);
		txIlce.setBounds(478, 259, 122, 22);
		contentPane.add(txIlce);
		
		txAdres = new JTextField();
		txAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
		txAdres.setColumns(10);
		txAdres.setBounds(478, 302, 122, 22);
		contentPane.add(txAdres);
		
		lblOtelAdres = new JLabel("Otel Adres");
		lblOtelAdres.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtelAdres.setBounds(374, 298, 92, 30);
		contentPane.add(lblOtelAdres);
		
		lblOtelTelefon = new JLabel("Otel Tel");
		lblOtelTelefon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtelTelefon.setBounds(724, 255, 92, 30);
		contentPane.add(lblOtelTelefon);
		
		txTel = new JTextField();
		txTel.setFont(new Font("Tahoma", Font.BOLD, 15));
		txTel.setColumns(10);
		txTel.setBounds(828, 259, 122, 22);
		contentPane.add(txTel);
		
		lblOtelYldz = new JLabel("Otel Y\u0131ld\u0131z");
		lblOtelYldz.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtelYldz.setBounds(724, 298, 92, 30);
		contentPane.add(lblOtelYldz);
		
		
		
		
		
		JButton btnEkle = new JButton("Otel Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				
				if(OtelIslemleri.BosAlanKontrolu(txAdi.getText(),txIl.getText(),txIlce.getText(),txAdres.getText(),txTel.getText(),cbYildiz.getSelectedItem().toString()))
				{
					if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txIl.getText().toString())==true &&
							Fonksiyonlar.StringMi(txIlce.getText().toString())==true &&
							Fonksiyonlar.StringMi(txAdres.getText().toString())==true &&
							Fonksiyonlar.SayisalMi(txTel.getText(),"telefon") ==true 
							
					  )
					{
						OtelIslemleri.OtelEkle(txAdi.getText(),txIl.getText(),txIlce.getText(),txAdres.getText(),txTel.getText(),cbYildiz.getSelectedItem().toString(),"1");
						OtelIslemleri.KayitlariCek(dm,table);
						OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);
						OtelIslemleri.CbYildizYukle(cbYildiz);

					}
					else
					{
						OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);

					}
				}
				else
				{
					OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);
				}

		
			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEkle.setBounds(50, 351, 144, 55);
		contentPane.add(btnEkle);
		
		JButton btnSil = new JButton("Otel Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				if(OtelIslemleri.BosAlanKontrolu(txAdi.getText(),txIl.getText(),txIlce.getText(),txAdres.getText(),txTel.getText(),cbYildiz.getSelectedItem().toString()))
				{
					if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txIl.getText().toString())==true &&
							Fonksiyonlar.StringMi(txIlce.getText().toString())==true &&
							Fonksiyonlar.StringMi(txAdres.getText().toString())==true &&
							Fonksiyonlar.SayisalMi(txTel.getText(),"telefon") ==true 
							
					  )
					{
						OtelIslemleri.OtelSil(otel_id);
						OtelIslemleri.KayitlariCek(dm,table);				
						OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);
						OtelIslemleri.CbYildizYukle(cbYildiz);
					}
					else
					{
						OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);

					}
				}
				else
				{
					OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);

				}
				
				
				
					
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSil.setBounds(241, 351, 144, 55);
		contentPane.add(btnSil);
		
		JButton btnGuncelle = new JButton("Otel G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				if(OtelIslemleri.BosAlanKontrolu(txAdi.getText(),txIl.getText(),txIlce.getText(),txAdres.getText(),txTel.getText(),cbYildiz.getSelectedItem().toString()))
				{
					if(		Fonksiyonlar.StringMi(txAdi.getText().toString())==true &&
							Fonksiyonlar.StringMi(txIl.getText().toString())==true &&
							Fonksiyonlar.StringMi(txIlce.getText().toString())==true &&
							Fonksiyonlar.StringMi(txAdres.getText().toString())==true &&
							Fonksiyonlar.SayisalMi(txTel.getText(),"telefon") ==true 
							
					  )
					{
						OtelIslemleri.OtelGuncelle(otel_id,txAdi.getText(), txIl.getText(), txIlce.getText(), txAdres.getText(), txTel.getText(), cbYildiz.getSelectedItem().toString());
						OtelIslemleri.KayitlariCek(dm,table);
						OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);
						OtelIslemleri.CbYildizYukle(cbYildiz);
						
						
					}
					else
					{
						OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);

					}
				}
				else
				{
					OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);

				}
				
				
				
				
			}
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuncelle.setBounds(434, 351, 144, 55);
		contentPane.add(btnGuncelle);
		
		JButton btnArama = new JButton("Ara");
		btnArama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			OtelIslemleri.OtelArama(dm, table,txAdi.getText(),txIl.getText(),txIlce.getText(),txAdres.getText(),txTel.getText(),cbYildiz.getSelectedItem().toString());
			

			}
		});
		btnArama.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnArama.setBounds(623, 351, 144, 55);
		contentPane.add(btnArama);
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				OtelIslemleri.AlanlariTemizle(txAdi, txIl, txIlce, txAdres, txTel, cbYildiz);
				OtelIslemleri.KayitlariCek(dm, table);
				OtelIslemleri.CbYildizYukle(cbYildiz);

			}
		});
		btnListele.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListele.setBounds(806, 351, 144, 55);
		contentPane.add(btnListele);
		
		JButton button = new JButton("\u00C7\u0131k\u0131\u015F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			Fonksiyonlar.UygulamaCikisYap();
				
				
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(840, 14, 110, 41);
		contentPane.add(button);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				YoneticiFormu yonetici_formu = new YoneticiFormu();
					yonetici_formu.setVisible(true);
							frame.setVisible(false);
			}
		});
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGeri.setBounds(50, 14, 110, 41);
		contentPane.add(btnGeri);
      

		
		
	
	
	}
}
