import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import junit.framework.*;




public class OtelIslemleriTest extends TestCase {

		private OtelIslemleri islemler;
		DefaultTableModel dm= new DefaultTableModel();
		JTable table = new JTable();
		JComboBox cbOtel = new JComboBox();
		JLabel lblOtelId = new JLabel();
		public void testOtelIslemleriCbYildizYukle()
		{
			
			JComboBox cbYildiz = new JComboBox();
			assertTrue(islemler.CbYildizYukle(cbYildiz));
		}
	
	
		
		public void testOtelIslemleriBosAlanKontrolu()
		{
			assertTrue(islemler.BosAlanKontrolu("ad","il","ilce","adres","tel","1"));
		}

		public void testOtelIslemleriAlanlariTemizle()
		{
			JTextField txAdi = new JTextField();
			JTextField txIl = new JTextField();
			JTextField txIlce = new JTextField();
			JTextField txAdres = new JTextField();
			JTextField txTel = new JTextField();
			JComboBox cbYildiz = new JComboBox();
			assertTrue(islemler.AlanlariTemizle(txAdi,txIl,txIlce,txAdres,txTel,cbYildiz));
		}


		public void testOtelIslemleriOtelEkle()
		{
			assertTrue(islemler.OtelEkle("adTest","ilTest","ilceTest","adresTest","5478523698","5","1"));
		}		


		public void testOtelIslemleriKayitlariCek()
		{
			assertTrue(islemler.KayitlariCek(dm,table));
		}
	
	public void testOtelIslemleriOtelSil()
		{
			 assertTrue(islemler.OtelSil("id"));
		}
	 
		public void testOtelIslemleriOtelGuncelle()
		{
			 assertTrue(islemler.OtelGuncelle("id","adTest","ilTest","ilceTest","adresTest","5478523698","4"));
		}
	/* 
		public void testOtelIslemleriOtelArama()
		{
			assertTrue(islemler.OtelArama(dm,table,"ad","il","ilce","adres","tel","1"));
		}
		*/
		 
		 
		public void testOtelIslemlericbOtelYukle()
		{
			assertTrue(islemler.cbOtelYukle(cbOtel));
		}
		
		public void testcbOtelIdCek()
		{	
			assertTrue(islemler.cbOtelIdCek(cbOtel, lblOtelId));
		}
		
/*		public void testCbOtelAdCek()
		{
			String OtelId="";
			assertTrue(islemler.cbOtelAdCek(cbOtel,OtelId));

		}
	*/	
		 
	public void setUp() throws Exception
	{
			super.setUp();
			islemler = new OtelIslemleri();
	}
	
	public void tearDown() throws Exception
		{
			super.tearDown();
			islemler=null;
		}
	
	public OtelIslemleri getFonksiyonlar()
		{
			return islemler;
		}
	
	public void setFonksiyonlar(OtelIslemleri islemler)
	{
		this.islemler=islemler;
	}

	
	

	

}
