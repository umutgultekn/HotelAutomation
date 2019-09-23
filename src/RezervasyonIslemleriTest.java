import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import junit.framework.*;

public class RezervasyonIslemleriTest extends TestCase{
	
	private RezervasyonIslemleri RezervasyonIslemleri ;
	
	JComboBox cbOdaGunlukFiyat = new JComboBox();
	JComboBox cbOdaSinifi = new JComboBox();
	JComboBox cbOdaDurumu = new JComboBox();
	DefaultTableModel dm= new DefaultTableModel();
	JTable table = new JTable();
	public void testOdaAramaCbFiyatYukle()
	{
		
		assertTrue(RezervasyonIslemleri.OdaAramaCbFiyatYukle(cbOdaGunlukFiyat));
	}

	public void testOdaAramaCbSinifYukle()
	{
		
		assertTrue(RezervasyonIslemleri.OdaAramaCbSinifYukle(cbOdaSinifi));
	}
	public void testOdaAramaCbDurumYukle()
	{
		
		assertTrue(RezervasyonIslemleri.OdaAramaCbDurumYukle(cbOdaDurumu));
	}


	public void testOdaAramaTemizle()
	{
		assertTrue(RezervasyonIslemleri.OdaAramaTemizle(cbOdaGunlukFiyat,cbOdaSinifi,cbOdaDurumu));
	}

	public void testOdaKayitlariCek()
	{
		
		assertTrue(RezervasyonIslemleri.OdaKayitlariCek(dm,table));
	}
	
	public void testOdaArama()
	{
		assertTrue(RezervasyonIslemleri.OdaArama(dm,table,cbOdaGunlukFiyat,cbOdaSinifi,cbOdaDurumu));
	}
	public void testRezervasyonTutarHesapla()
	{
		assertTrue(RezervasyonIslemleri.RezervasyonTutarHesapla(5,10)==50);
	}
	
	public void testRezervasyonKaydet()
	{
		assertTrue(RezervasyonIslemleri.RezervasyonKaydet("1","1","2017-12-10","2017-12-17","2500","1"));
	}

	public void testRezervasyonKayitlariCek()
	{
		assertTrue(RezervasyonIslemleri.RezervasyonKayitlariCek(dm,table));
	}
	public void testRezervasyonAramaKayitlariCek()
	{
		assertTrue(RezervasyonIslemleri.RezervasyonAramaKayitlariCek(dm,table,"2017-12-10","2017-12-17"));
	}

	
	
	
/*	
	public void testRezervasyonListele()
	{
		assertTrue(RezervasyonIslemleri.RezervasyonListele(dm,table));

	}
	*/
	
	
	
	
	
	 public void setUp() throws Exception 
	   {
		   super.setUp();
		   RezervasyonIslemleri=new RezervasyonIslemleri();
	   }
	   public void tearDown() throws Exception
	   {
		   super.tearDown();
		   RezervasyonIslemleri=null;
	   }
	   public RezervasyonIslemleri getRezervasyonIslemleri()
	   {
		   return RezervasyonIslemleri;
	   }
	   public void setRezervasyonIslemleri(RezervasyonIslemleri islemler)
	   {
		   this.RezervasyonIslemleri=islemler;
	   }
	
}
