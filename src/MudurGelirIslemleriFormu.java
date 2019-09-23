import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

public class MudurGelirIslemleriFormu extends JFrame {

	private JPanel contentPane;
	String date;
	String date2;
	float tp1=0,tp2=0,toplam=0;
	static GirisYapanKullaniciBilgileri bilgiler = new GirisYapanKullaniciBilgileri();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MudurGelirIslemleriFormu frame = new MudurGelirIslemleriFormu();
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
	public MudurGelirIslemleriFormu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gelir");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(100, 177, 56, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblGider_1 = new JLabel("Gider");
		lblGider_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGider_1.setBounds(100, 214, 41, 26);
		contentPane.add(lblGider_1);
		
		JLabel lblNet = new JLabel("***");
		lblNet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNet.setBounds(166, 278, 71, 26);
		contentPane.add(lblNet);
		
		JLabel lblNet_1 = new JLabel("Net");
		lblNet_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNet_1.setBounds(100, 278, 56, 26);
		contentPane.add(lblNet_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(68, 259, 183, 84);
		contentPane.add(separator);
		
		JLabel lblBalangTarihi = new JLabel("Ba\u015Flang\u0131\u00E7 Tarihi");
		lblBalangTarihi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBalangTarihi.setBounds(39, 59, 128, 26);
		contentPane.add(lblBalangTarihi);
		
		JLabel lblBitiTarihi = new JLabel("Biti\u015F Tarihi");
		lblBitiTarihi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBitiTarihi.setBounds(202, 59, 95, 26);
		contentPane.add(lblBitiTarihi);
		
		JLabel gelir = new JLabel("***");
		gelir.setFont(new Font("Tahoma", Font.BOLD, 14));
		gelir.setBounds(165, 177, 86, 26);
		contentPane.add(gelir);
		
		JLabel gider = new JLabel("***");
		
		gider.setFont(new Font("Tahoma", Font.BOLD, 14));
		gider.setBounds(165, 214, 86, 26);
		contentPane.add(gider);
		
		JDateChooser baslangic1 = new JDateChooser();
		baslangic1.setBounds(39, 85, 102, 20);
		contentPane.add(baslangic1);
		
		JDateChooser bitis1 = new JDateChooser();
		bitis1.setBounds(191, 85, 106, 20);
		contentPane.add(bitis1);
		
		
		
		JButton btnNewButton = new JButton("Hesapla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
				date = dFormat.format(baslangic1.getDate());
				
				SimpleDateFormat dFormat2 = new SimpleDateFormat("yyyy-MM-dd");
				date2 = dFormat2.format(bitis1.getDate());
				
				tp1=new MudurGelir().GelirveriAl(date,date2,bilgiler.getOtelId());
				tp2=new MudurGelir().GiderveriAl("1",bilgiler.getOtelId());
				
				gelir.setText(Float.toString(tp1));
				
				gider.setText(Float.toString(tp2));
				
				toplam=tp1-tp2;
				
				lblNet.setText(Float.toString(toplam));
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(245, 152, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gelir.setText("***");
				gider.setText("***");
				lblNet.setText("***");
				
			}
		});
		btnTemizle.setBounds(245, 197, 89, 23);
		contentPane.add(btnTemizle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MudurFormu mgg=new MudurFormu();
				mgg.setVisible(true);
			}
		});
		btnGeri.setBounds(245, 337, 89, 23);
		contentPane.add(btnGeri);
		
		
	}
}
