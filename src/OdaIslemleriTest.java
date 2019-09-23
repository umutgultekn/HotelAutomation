import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import junit.framework.Assert;
import junit.framework.TestCase;

public class OdaIslemleriTest extends TestCase {
	
	private OdaIslemleri islemler;
	DefaultTableModel dm= new DefaultTableModel();
	JTable table = new JTable();
	JComboBox cbTur = new JComboBox();
	JLabel lblTur = new JLabel();
	


	
	public void testOdaIslemleriBosAlanKontrolu()
	{
		assertTrue(OdaIslemleri.AlanKontrolu("100", "200", "Dolu", "3"));
	}

	public void testOdaIslemleriAlanlariTemizle()
	{
		JTextField txNumara = new JTextField();
		JTextField txFiyat = new JTextField();
		JComboBox<String> cbDurum = new JComboBox();
		JComboBox<String> cbTur = new JComboBox();
		assertTrue(islemler.AlanlariTemizle(txNumara,txFiyat,cbDurum,cbTur));
	}


	public void testOdaIslemleriOdaEkle()
	{
		assertTrue(islemler.OdaEkle("3532","150","Bos","3","1","1"));
	}		


	public void testOdaIslemleriKayitlariCek()
	{
		assertTrue(islemler.KayitlariCek(dm, table));
	}

public void testOdaIslemleriOdaSil()
	{
		 assertTrue(islemler.OdaSil(("13")));
	}
 
	public void testOdaIslemleriOdaGuncelle()
	{
		 assertTrue(islemler.OdaGuncelle("2", "14", "250", "Dolu", "5", "1"));
	}

	 
	
	public void testcbTurIdCek()
	{	
		String [] odaKategori_id = new String[1];			
		assertTrue(islemler.TurIdCek(cbTur,odaKategori_id));
	}
	

	 


public OdaIslemleri getFonksiyonlar()
	{
		return islemler;
	}

public void setFonksiyonlar(OdaIslemleri islemler)
{
	this.islemler=islemler;
}
public void setUp() throws Exception
{
		super.setUp();
		islemler = new OdaIslemleri();
}

public void tearDown() throws Exception
	{
		super.tearDown();
		islemler=null;
	}


}
