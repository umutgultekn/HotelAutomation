import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import junit.framework.*;


public class MudurIslemleriTest extends TestCase {
	
	private MudurIslemleri islemler;
	DefaultTableModel dm = new DefaultTableModel();
	JTable table = new JTable();
	
	public void testAlanKontrolu()
	{
		assertTrue(islemler.AlanKontrolu("ad","soyad","yetki","kullaniciadi","sifre","maas","tel","email","adres"));
	}
	
	public void testMudurIslemleriMudurEkle()
	{
		//assertTrue(islemler.MudurEkle("ad","soyad","yetki","kullanýcýadi","sifre","maas","tel","email","adres","1","1"));
		assertTrue(islemler.MudurEkle("ad","soyad","1","kullanýcýadi","sifre","2500","adres","5879632415","email","mudur","1"));

	}	
	
	public void testMudurIslemleriKayitlariCek() 
	{
		assertNull(islemler.KayitlariCek(dm,table));
	}
	
	public void testMudurSil()
	{
		
		assertTrue(islemler.MudurSil("14"));
	}

	public void testMudurGuncelle()
	{
		
		assertTrue(MudurIslemleri.MudurGuncelle("id","ad","soyad","yetki","kullanýcýadi","sifre","maas","tel","email","adres","1","1"));
	}
	
	public void testMudurAra()
	{
		assertTrue(islemler.MudurAra(dm,table,"ad","soyad","1","kullaniciadi","sifre","maas","tel","email","adres"));
	}
	
	
}
