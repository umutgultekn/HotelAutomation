import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EsyaIslemleriFormu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txEsya;
	private JTextField txDurum;
	DefaultTableModel dm;
	private String esya_id;
	private JTextField txOdaId;
	JTable table2;
	String secilen_oda_id="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EsyaIslemleriFormu frame = new EsyaIslemleriFormu();
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
	public EsyaIslemleriFormu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				EsyaIslemleri.KayitlariCek(dm, table);
				EsyaIslemleri.OdaKayitlariCek(dm, table2);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E\u015Fyalar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(210, 38, 92, 27);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 75, 338, 335);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String tablo_secilen_id = table.getValueAt(table.getSelectedRow(),6).toString();
				
				String tablo_secilen_esya = table.getValueAt(table.getSelectedRow(),1).toString(); 
				String tablo_secilen_durum = table.getValueAt(table.getSelectedRow(),2).toString();
				
	
				txEsya.setText(tablo_secilen_esya);
				txDurum.setText(tablo_secilen_durum);
				txOdaId.setText(tablo_secilen_id);
			 
				
				
				 
				 
				esya_id = tablo_secilen_id;
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(EsyaIslemleri.AlanKontrolu(txEsya.getText(),txDurum.getText(),txOdaId.getText()))
				{
					if(		Fonksiyonlar.SayisalMi(txOdaId.getText(),"Numara") ==true &&
							Fonksiyonlar.StringMi(txDurum.getText().toString())==true &&
							Fonksiyonlar.StringMi(txEsya.getText().toString())==true 
							 
							
					  )
					{
						EsyaIslemleri.EsyaGuncelle(esya_id,txEsya.getText(),txOdaId.getText(),txDurum.getText(),"1");
						EsyaIslemleri.KayitlariCek(dm,table);
						EsyaIslemleri.AlanlariTemizle(txEsya, txDurum, txOdaId);
														
						
						
					}
					else
					{
						EsyaIslemleri.AlanlariTemizle(txEsya, txDurum,txOdaId);							
	
					}
				}
				else
				{
					EsyaIslemleri.AlanlariTemizle(txEsya, txDurum,txOdaId);		
							
				}
				
				
				
				
				
			}
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuncelle.setBounds(557, 337, 126, 48);
		contentPane.add(btnGuncelle);
		
		JLabel lblNewLabel_1 = new JLabel("E\u015Fya Ad\u0131");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(504, 75, 70, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEyaDurumu = new JLabel("E\u015Fya Durumu");
		lblEyaDurumu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEyaDurumu.setBounds(504, 113, 92, 27);
		contentPane.add(lblEyaDurumu);
		
		txEsya = new JTextField();
		txEsya.setBounds(605, 80, 104, 20);
		contentPane.add(txEsya);
		txEsya.setColumns(10);
		
		txDurum = new JTextField();
		txDurum.setColumns(10);
		txDurum.setBounds(606, 118, 103, 20);
		contentPane.add(txDurum);
		
		JLabel lblOdaNumara = new JLabel("Oda Id");
		lblOdaNumara.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOdaNumara.setBounds(504, 151, 92, 27);
		contentPane.add(lblOdaNumara);
		
		txOdaId = new JTextField();
		txOdaId.setColumns(10);
		txOdaId.setBounds(606, 156, 103, 20);
		contentPane.add(txOdaId);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(EsyaIslemleri.AlanKontrolu(txEsya.getText(),txDurum.getText(),txOdaId.getText()))
				{
					if(		
							Fonksiyonlar.SayisalMi(txOdaId.getText(),"Numara") ==true &&
							Fonksiyonlar.StringMi(txDurum.getText().toString())==true &&
							Fonksiyonlar.StringMi(txEsya.getText().toString())==true 
							
					  )
					{  	
						
						
						
						EsyaIslemleri.EsyaEkle(txEsya.getText(),txDurum.getText(),txOdaId.getText(),"1");
						EsyaIslemleri.KayitlariCek(dm,table);
						EsyaIslemleri.AlanlariTemizle(txEsya, txDurum,txOdaId);
						

					}
					else
					{
						EsyaIslemleri.AlanlariTemizle(txEsya, txDurum,txOdaId);

					}
				}
				else
				{
					EsyaIslemleri.AlanlariTemizle(txEsya, txDurum,txOdaId);
				}
			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEkle.setBounds(557, 219, 126, 48);
		contentPane.add(btnEkle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 if(esya_id!=null )
					{
						 
					 EsyaIslemleri.EsyaSil(esya_id);
					 EsyaIslemleri.KayitlariCek(dm, table);
					 
					 EsyaIslemleri.AlanlariTemizle(txEsya, txDurum,txOdaId);	
						
						
					}
					else
					{
						EsyaIslemleri.AlanlariTemizle(txEsya, txDurum,txOdaId);							
					}
					 
				}
			
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSil.setBounds(557, 278, 126, 48);
		contentPane.add(btnSil);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(497, 201, 237, 209);
		contentPane.add(separator);
		
		JLabel lblOdalar = new JLabel("Odalar");
		lblOdalar.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblOdalar.setBounds(22, 38, 92, 27);
		contentPane.add(lblOdalar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 75, 126, 335);
		contentPane.add(scrollPane_2);
		
		table2 = new JTable();
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				//secilen_oda_id = table2.getValueAt(table.getSelectedRow(),2).toString();
				secilen_oda_id= table.getValueAt(table.getSelectedRow(),2).toString();

				JOptionPane.showMessageDialog(null,secilen_oda_id);

			}
		});
		scrollPane_2.setViewportView(table2);
	}
}
