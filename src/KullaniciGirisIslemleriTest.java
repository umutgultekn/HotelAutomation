import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import junit.framework.*;
public class KullaniciGirisIslemleriTest extends TestCase {

	private KullaniciGirisIslemleri islemler;
	 JTextField txKullaniciAdi= new JTextField();
	 JPasswordField txSifre = new JPasswordField();

	

   
   public void testBosAlanKontrolu()
   {
	   assertTrue(islemler.BosAlanKontrolu("kullaniciAdi","Sifre"));
   }
   
   
   public void testAlanlariTemizle()
   {
	  
	   assertTrue(islemler.AlanlariTemizle(txKullaniciAdi,txSifre));
   }
   

   public void testGirisveYetkilendirme()
   {
	   assertTrue(islemler.GirisveYetkilendirme("admin","admin"));
   }

   
   public void setUp() throws Exception 
   {
	   super.setUp();
	   islemler=new KullaniciGirisIslemleri();
   }
   public void tearDown() throws Exception
   {
	   super.tearDown();
	   islemler=null;
   }
   public KullaniciGirisIslemleri getKullaniciGirisIslemleri()
   {
	   return islemler;
   }
   public void setKullaniciGirisIslemleri(KullaniciGirisIslemleri islemler)
   {
	   this.islemler=islemler;
   }
   
   
}
