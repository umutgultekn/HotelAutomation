import java.awt.BorderLayout;
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
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class YoneticiGelirIslemleri extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel dm;
	String date;
	String date2;
	float tp1=0,tp2=0,toplam=0;
	String tablo_secilen_id="0";
	// Label ile secili otel id alýnýp ona göre hesap yapýlacak
	JLabel gelir ;
	JLabel gider;
	JLabel lblNet;
	JLabel label_44;
	
	static GirisYapanKullaniciBilgileri bilgiler = new GirisYapanKullaniciBilgileri();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiGelirIslemleri frame = new YoneticiGelirIslemleri();
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
	public YoneticiGelirIslemleri() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				YoneticiGelir.OtelKayitlariCek(dm, table);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(21, 53, 140, 357);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablo_secilen_id = table.getValueAt(table.getSelectedRow(),2).toString();
				
				label_44.setText(tablo_secilen_id);
				
				gelir.setText("***");
				gider.setText("***");
				lblNet.setText("***");
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Oteller");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(56, 21, 82, 33);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Ba\u015Flang\u0131\u00E7 Tarihi");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(233, 53, 128, 26);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Biti\u015F Tarihi");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(396, 53, 95, 26);
		contentPane.add(label_1);
		
		JDateChooser baslangic = new JDateChooser();
		baslangic.setBounds(240, 90, 95, 20);
		contentPane.add(baslangic);
		
		JDateChooser bitis = new JDateChooser();
		bitis.setBounds(390, 90, 95, 20);
		contentPane.add(bitis);
		
		JLabel label_2 = new JLabel("Gelir");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(294, 171, 56, 26);
		contentPane.add(label_2);
		
		gelir = new JLabel("***");
		gelir.setFont(new Font("Tahoma", Font.BOLD, 14));
		gelir.setBounds(359, 171, 86, 26);
		contentPane.add(gelir);
		
		JLabel label_4 = new JLabel("Gider");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(294, 208, 41, 26);
		contentPane.add(label_4);
		
		gider = new JLabel("***");
		gider.setFont(new Font("Tahoma", Font.BOLD, 14));
		gider.setBounds(359, 208, 86, 26);
		contentPane.add(gider);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(262, 253, 183, 84);
		contentPane.add(separator);
		
		JLabel label_6 = new JLabel("Net");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(294, 272, 56, 26);
		contentPane.add(label_6);
		
		lblNet = new JLabel("***");
		lblNet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNet.setBounds(360, 272, 71, 26);
		contentPane.add(lblNet);
		
		JButton btnNewButton = new JButton("Hesapla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			

				SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
				date = dFormat.format(baslangic.getDate());
				
				SimpleDateFormat dFormat2 = new SimpleDateFormat("yyyy-MM-dd");
				date2 = dFormat2.format(bitis.getDate());
				
				
				
				tp1=new YoneticiGelir().GelirveriAl(date,date2,label_44.getText());
				tp2=new YoneticiGelir().GiderveriAl("1",label_44.getText());
				
				gelir.setText(Float.toString(tp1));
				
				gider.setText(Float.toString(tp2));
				
				toplam=tp1-tp2;
				
				lblNet.setText(Float.toString(toplam));
			}
		});
		btnNewButton.setBounds(439, 146, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YoneticiGelir.OtelKayitlariCek(dm, table);
				
				JOptionPane.showMessageDialog(null, bilgiler.getOtelId());
				
				gelir.setText("***");
				gider.setText("***");
				lblNet.setText("***");
				
				tablo_secilen_id="0";
				
			}
		});
		btnTemizle.setBounds(246, 350, 89, 23);
		contentPane.add(btnTemizle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YoneticiFormu yf= new YoneticiFormu();
				yf.setVisible(true);
			}
		});
		btnGeri.setBounds(396, 349, 89, 23);
		contentPane.add(btnGeri);
		
		label_44 = new JLabel("0");
		label_44.setVisible(false);
		label_44.setBounds(148, 11, 46, 14);
		contentPane.add(label_44);
	}
}
