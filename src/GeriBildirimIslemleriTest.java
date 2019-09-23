import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import junit.framework.TestCase;

public class GeriBildirimIslemleriTest extends TestCase{

	private GeriBildirimIslemleri islemler = new GeriBildirimIslemleri();
	private DefaultTableModel dm = new DefaultTableModel();
	private JTable table = new JTable();
	private JComboBox cbTemizlik,cbKonfor,cbHKalite,cbYKalite,cbUKalite;
	private ArrayList<JComboBox> cbliste; 
	
	
	public void testGeriBildirmIslemleri_KayitÇek() 
	{
		
		assertEquals(true,islemler.KayitlariCek(dm,table)); 
		
	}
	
	public void testGeriBildirmIslemleri_Ekle() 
	{
		
		assertEquals(true,islemler.GeriBildirimEkle(5, 5, 2, 5, 2, 5, "harika", "2017-12-25")); 
		
	}
	
	public void testGeriBildirmIslemleri_Sil() 
	{
		
		assertEquals(true,islemler.GeriBildirimSil(13)); 
		
	}
	
	public void testGeriBildirmIslemleri_Guncelle() 
	{
		
		assertEquals(true,islemler.GeriBildirimGuncelle(13, 1, 1, 1,1, 1, "harika test", "2017-12-12")); 
		 
	}
	
	public void testGeriBildirmIslemleri_Ara() 
	{
		
		assertEquals(true,islemler.GeriBildirimAra(dm, table, 1, "Seciniz", "Seciniz", "Seciniz", "Seciniz", null)); 
		 
	}
	
	public void testGeriBildirmIslemleri_componentKontrol() 
	{
		JDateChooser tarih = new JDateChooser();
		TextArea not = new TextArea();
		cbHKalite = new JComboBox<>();
		cbKonfor = new JComboBox<>();
		cbTemizlik = new JComboBox<>();
		cbUKalite = new JComboBox<>();
		cbYKalite = new JComboBox<>();
		cbliste = new ArrayList(Arrays.asList(cbHKalite,cbKonfor,cbTemizlik,cbUKalite,cbYKalite)) ; 
		for (JComboBox jComboBox : cbliste) {
			
			jComboBox.addItem("Seciniz");
			jComboBox.addItem(1);
			jComboBox.addItem(2);
			jComboBox.addItem(3);
			jComboBox.addItem(4);
			jComboBox.addItem(5);
			
		}
		 
		cbTemizlik.setSelectedIndex(0);
		 
		assertEquals(false,islemler.componentKontrol(cbliste,tarih,not)); //deger false ise seçilmemiþ component var
		 
	}
	
	
	
	
	
	
}
