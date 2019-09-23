import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import junit.framework.TestCase;

public class MusteriIslemleriTest extends TestCase{

	private static MusteriIslemleri islemler;
	DefaultTableModel dm = new DefaultTableModel();
	JTable table = new JTable();
	
	
	public void testMusteriIslemleriKayitlariCek() 
	{
		 
		assertEquals(true, islemler.KayitlariCek(dm,table)); 
	}
	
	public void testMusteriIslemleriMusteriEkle()
	{
		assertTrue(islemler.MusteriEkle("ad2","soyad2","adres","1111111111","email","1"));
	}
	
	public void testAlanKontrolu()
	{
		assertTrue(islemler.AlanKontrolu("ad","soyad","1111111111","email","adres"));
	}
	
	public void testMusteriSil()
	{
		
		assertTrue(islemler.MusteriSil("2"));
	}
	
	public void testPersonelGuncelle()
	{
		
		assertTrue(islemler.MusteriGuncelle("1","cano","soyad","1111111111","email","adres","1"));
	}
	
	public void testMusteriAra()
	{
		
		assertTrue(islemler.MusteriAra(dm, table, "cano", "", "", ""));
	}
	
	
	public static void testMusteriTelDenIdCek()
	{
		String musteri_tel="54187412563";
		String[] musteri_id = new String[1];
		assertTrue(islemler.MusteriTelDenIdCek(musteri_tel,musteri_id));

	}
	
	
	
}
