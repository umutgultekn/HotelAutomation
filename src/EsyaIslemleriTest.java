import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import junit.framework.TestCase;

public class EsyaIslemleriTest extends TestCase {
	

	private EsyaIslemleri islemler;
	DefaultTableModel dm = new DefaultTableModel();
	JTable table = new JTable();
	
	public void testAlanKontrolu()
	{
		assertTrue(islemler.AlanKontrolu("esya", "durum", "id"));
	}
	
	public void testEsyaIslemleriEsyaEkle()
	{
		assertTrue(islemler.EsyaEkle("esya", "durum", "25", "1"));
	}	
	
	public void testEsyaIslemleriKayitlariCek() 
	{
		assertTrue(islemler.KayitlariCek(dm,table));
	}
	
	public void testEsyaSil()
	{
		
		assertTrue(islemler.EsyaSil("2"));
	}

	public void testEsyaGuncelle()
	{
		
		assertTrue(islemler.EsyaGuncelle("id", "ad", "2", "durum"," 1"));
	}

}
