import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import junit.framework.TestCase;

public class PersonelIslemleriTest extends TestCase{
	
	private PersonelIslemleri islemler;
	DefaultTableModel dm = new DefaultTableModel();
	JTable table = new JTable();
	
	
	public void testPersonelIslemleriKayitlariCek() 
	{
		 
		assertEquals(true, islemler.KayitlariCek(dm,table)); 
	}
	
	public void testPersonelIslemleriPersonelEkle()
	{
		GirisYapanKullaniciBilgileri bilgiler = new GirisYapanKullaniciBilgileri();
		bilgiler.setOtelId("1");
		assertTrue(islemler.PersonelEkle("ad","soyad","kullanýcýadi","sifre","yetki","maas","adres","tel","email","1"));
	}
	
	public void testAlanKontrolu()
	{
		assertTrue(islemler.AlanKontrolu("ad","soyad","yetki","kullaniciadi","sifre","maas","tel","email","adres","otel"));
	}
	
	public void testPersonelSil()
	{
		
		assertTrue(islemler.PersonelSil("24"));
	}
	
	public void testPersonelGuncelle()
	{
		
		assertTrue(islemler.PersonelGuncelle("25","cano","soyad","yetki","kullanýcýadi","sifre","maas","tel","email","adres","1","1"));
	}
	public void testPersonelAra()
	{
		
		assertTrue(islemler.PersonelAra(dm, table, "asd", "", "hello", "", ""));
	}

}
