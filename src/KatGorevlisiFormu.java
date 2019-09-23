import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KatGorevlisiFormu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KatGorevlisiFormu frame = new KatGorevlisiFormu();
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
	public KatGorevlisiFormu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEyaIlemleri = new JButton("E\u015Fya \u0130\u015Flemleri");
		btnEyaIlemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EsyaIslemleriFormu ei = new EsyaIslemleriFormu();
				ei.setVisible(true);
				
			}
		});
		btnEyaIlemleri.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEyaIlemleri.setBounds(97, 153, 295, 46);
		contentPane.add(btnEyaIlemleri);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 116, 386, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Ho\u015Fgeldiniz ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(50, 86, 386, 28);
		contentPane.add(label);
		
		JButton button_2 = new JButton("\u00C7\u0131k\u0131\u015F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fonksiyonlar.UygulamaCikisYap();
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\ABRA\\Desktop\\gorseller\\cikis_24_kirmizi.png"));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(360, 32, 110, 41);
		contentPane.add(button_2);
	}

}
