import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import junit.framework.TestCase;

public class YoneticiGelirTest extends TestCase{
	
	private YoneticiGelir islemler;
	DefaultTableModel dm = new DefaultTableModel();
	JTable table = new JTable();
	
	
	public void testYoneticiGelirIslemleriGiderAl()
	{
		assertTrue(islemler.GiderveriAl("1","1")!=0);
	
	}	
	
	public void testYoneticiGelirIslemleriGelirAl()
	{
		assertTrue(islemler.GelirveriAl("2017-12-1", "2018-12-31","1")!=0);
	
	}	

}
