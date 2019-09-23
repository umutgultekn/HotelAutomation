import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class OdaIslemleriFormu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txNumara;
	private JTextField txFiyat;
	private JComboBox<String> cbTur;
	private JComboBox<Object> cbDurum;
	private String oda_id;
	GirisYapanKullaniciBilgileri kullaniciBilgileri = new GirisYapanKullaniciBilgileri();
	
	DefaultTableModel dm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdaIslemleriFormu frame = new OdaIslemleriFormu();
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
	public OdaIslemleriFormu() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				OdaIslemleri.KayitlariCek(dm, table);
				OdaIslemleri.cbTurYukle(cbTur);

				
			}
		});
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,600,650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 385, 516);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String tablo_secilen_id = table.getValueAt(table.getSelectedRow(),6).toString();
				String tablo_secilen_numara = table.getValueAt(table.getSelectedRow(),1).toString();
				String tablo_secilen_fiyat = table.getValueAt(table.getSelectedRow(),2).toString(); 
				String tablo_secilen_durum = table.getValueAt(table.getSelectedRow(),3).toString();
				String tablo_secilen_tur = table.getValueAt(table.getSelectedRow(),4).toString();
				
			 
				txNumara.setText(tablo_secilen_numara);
				txFiyat.setText(tablo_secilen_fiyat);
				cbDurum.setSelectedItem(tablo_secilen_durum);
				cbTur.setSelectedItem(tablo_secilen_tur);
				
				 
				 
				oda_id = tablo_secilen_id;
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblTur = new JLabel("");
		lblTur.setBounds(20, 11, 46, 14);
		contentPane.add(lblTur);
		
		
		txNumara = new JTextField();
		txNumara.setBounds(488, 82, 86, 20);
		contentPane.add(txNumara);
		txNumara.setColumns(10);
		
		txFiyat = new JTextField();
		txFiyat.setColumns(10);
		txFiyat.setBounds(488, 110, 86, 20);
		contentPane.add(txFiyat);
		
		cbDurum = new JComboBox<Object>();
		cbDurum.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbDurum.setModel(new DefaultComboBoxModel<Object>(new String[] {"Bos", "Dolu"}));
		cbDurum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		cbDurum.setBounds(490, 138, 84, 20);
		contentPane.add(cbDurum);
		
		cbTur = new JComboBox<String>();

		cbTur.setBounds(490, 166, 84, 20);
		contentPane.add(cbTur);
		
		JLabel lblNewLabel = new JLabel("Odalar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(168, 35, 104, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				

				if(OdaIslemleri.AlanKontrolu(txNumara.getText(),txFiyat.getText(),cbDurum.getSelectedItem().toString(),cbTur.getSelectedItem().toString()))
				{
					if(		
							Fonksiyonlar.SayisalMi(txNumara.getText(),"Numara") ==true &&
							Fonksiyonlar.SayisalMi(txFiyat.getText(),"Fiyat") ==true
							
					  )
					{  	
						String [] odaKategori_id = new String[1];			
						OdaIslemleri.TurIdCek(cbTur,odaKategori_id);
						JOptionPane.showMessageDialog(null,odaKategori_id[0]);

						OdaIslemleri.OdaEkle(txNumara.getText(),txFiyat.getText(),cbDurum.getSelectedItem().toString(),odaKategori_id[0],"1",kullaniciBilgileri.getOtelId());
						OdaIslemleri.KayitlariCek(dm,table);
						OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);
						OdaIslemleri.cbTurYukle(cbTur);

					}
					else
					{
						OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);

					}
				}
				else
				{
					OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);
				}

			}
		});
		
		
		
		
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEkle.setBounds(445, 229, 104, 48);
		contentPane.add(btnEkle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				 if(oda_id!=null )
					{
						 
					 OdaIslemleri.OdaSil(oda_id);
						 
					 OdaIslemleri.KayitlariCek(dm, table);
					 OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);	
						
						
					}
					else
					{
						OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);							
					}
					 
				}
				
				
			
		});
		btnSil.setBounds(445, 288, 104, 48);
		contentPane.add(btnSil);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		 
				if(OdaIslemleri.AlanKontrolu(txNumara.getText(),txFiyat.getText(),cbDurum.getSelectedItem().toString(),cbTur.getSelectedItem().toString()))
				{
					if(		Fonksiyonlar.SayisalMi(txNumara.getText(),"Numara") ==true &&
							Fonksiyonlar.SayisalMi(txFiyat.getText(),"Fiyat") ==true
							 
							
					  )
					{
						String [] odaKategori_id = new String[1];			
						OdaIslemleri.TurIdCek(cbTur,odaKategori_id);
						
						OdaIslemleri.OdaGuncelle(oda_id, txNumara.getText(), txFiyat.getText(), cbDurum.getSelectedItem().toString(),odaKategori_id[0], "1");
						OdaIslemleri.KayitlariCek(dm,table);
						
						OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);
						OdaIslemleri.cbTurYukle(cbTur);
														
						
						
					}
					else
					{
						OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);							
	
					}
				}
				else
				{
					OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);			
							
				}
				
				
				
	 
				
			}
				
				
			
		});
		btnGuncelle.setBounds(445, 347, 104, 48);
		contentPane.add(btnGuncelle);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OdaIslemleri.AlanlariTemizle(txNumara, txFiyat,cbDurum,cbTur);
			}
		});
		btnTemizle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTemizle.setBounds(445, 406, 104, 50);
		contentPane.add(btnTemizle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MudurFormu MF = new MudurFormu();
				MF.setVisible(true);
				
			}
		});
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGeri.setBounds(445, 553, 104, 33);
		contentPane.add(btnGeri);
		
		JLabel lblNewLabel_1 = new JLabel("Numara");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(422, 82, 58, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFiyat.setBounds(422, 110, 58, 17);
		contentPane.add(lblFiyat);
		
		JLabel lblDurum = new JLabel("Durum");
		lblDurum.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDurum.setBounds(422, 138, 58, 17);
		contentPane.add(lblDurum);
		
		JLabel lblTr = new JLabel("T\u00FCr");
		lblTr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTr.setBounds(422, 166, 58, 17);
		contentPane.add(lblTr);
		
	
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(405, 201, 169, 332);
		contentPane.add(separator);
		
		
	}
}
