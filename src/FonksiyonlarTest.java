import javax.swing.*;

import junit.framework.*;
public class FonksiyonlarTest  extends TestCase{
	
	
	private static Fonksiyonlar islemler;

	public void testUygulamaCikisYap()
	{
		assertTrue(islemler.UygulamaCikisYap());	
		
	}


	public void testStringMi()
	{
		assertTrue(islemler.StringMi("deger"));
	}
	
	public void testSayisalMi()
	{
		assertTrue(islemler.SayisalMi("456","telefon numarasýný"));
	}	
	public void testBosDegilse()
	{
		assertTrue(islemler.BosDegilse("deger"));
	}

	public void testGirisYapanKullanicininAdiniSoyadiniCek()
	{
		JLabel lblMesaj = new JLabel();
		assertTrue(islemler.GirisYapanKullanicininAdiniSoyadiniCek(lblMesaj));
	}

	
	
	public void testGirisYapanKullanicininOtelIdCek()
	{
		JLabel lblOtelId = new JLabel();
		assertTrue(islemler.GirisYapanKullanicininOtelIdCek(lblOtelId));
	}
	
	
	
	
	public void setUp() throws Exception
	{
		super.setUp();
		islemler = new Fonksiyonlar();
	}
	public void tearDown() throws Exception
	{
		super.tearDown();
		islemler=null;
	}
	public Fonksiyonlar getFonksiyonlar()
	{
		return islemler;
	}
	public void setFonksiyonlar(Fonksiyonlar islemler)
	{
		this.islemler=islemler;
	}

}
