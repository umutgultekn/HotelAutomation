
public class GirisYapanKullaniciBilgileri {
	
	private static int id;
	private static String ad;
	private static String soyad;
	private static String kullaniciAdi;
	private static String sifre;
	private static String yetki;
	private static float maas;
	private static String adres;
	private static String tel;
	private static String email;
	private static int vtDurum;
	private static String otelId;
	private static String otelAd;

	public GirisYapanKullaniciBilgileri(int id, String ad, String soyad, String kullaniciAdi,  String sifre, String yetki, float maas,  String adres, String tel, String email, int vtDurum, String otelId)
	{
		this.id=id;
		this.ad=ad;
		this.soyad=soyad;
		this.kullaniciAdi=kullaniciAdi;
		this.sifre=sifre;
		this.yetki = yetki;
		this.maas = maas;
		this.adres=adres;
		this.tel = tel;
		this.email=email;
		this.vtDurum=vtDurum;
		this.otelId=otelId;
	}
	
	 public GirisYapanKullaniciBilgileri() 
	 {
		// TODO Auto-generated constructor stub
	}

	public int getId()
	 {
	        return id;
	 }
	 public void setId(int id)
	 {
	       this.id = id;
	 }
	 
	 
	 
	 public String getAd()
	 {
	        return ad;
	 }
	 public void setAd(String ad)
	 {
	       this.ad = ad;
	 }
	 
	 
	 
	 public String getSoyad()
	 {
	        return soyad;
	 }
	 public void setSoyad(String soyad)
	 {
	       this.soyad = soyad;
	 }
	 
	 
	 
	 public String getKullaniciAdi()
	 {
	        return kullaniciAdi;
	 }
	 public void setKullaniciAdi(String kullaniciAdi)
	 {
	       this.kullaniciAdi =kullaniciAdi ;
	 }
	 
	 
	 
	 public String getSifre()
	 {
	        return sifre;
	 }
	 public void setSifre(String sifre)
	 {
	       this.sifre =sifre ;
	 }
	 
	 
	 
	 public String getYetki()
	 {
	        return yetki;
	 }
	 public void setYetki(String yetki)
	 {
	       this.yetki =yetki;
	 }
	 
	 
	 
	 public float getMaas()
	 {
	        return maas;
	 }
	 public void setMaas(float maas)
	 {
	       this.maas =maas;
	 }
	 
	 
	 
	 public String getAdres()
	 {
	        return adres;
	 }
	 public void setAdres(String adres)
	 {
	       this.adres =adres;
	 }
	 
	 
	 
	 public String getEmail()
	 {
	        return email;
	 }
	 public void setEmail(String email )
	 {
	       this.email =email;
	 }

	 
	 
	 public int getVtDurum()
	 {
	        return vtDurum;
	 }
	 public void setVtDurum(int vtDurum)
	 {
	       this.vtDurum = vtDurum;
	 }
	 
	 
	 public String getOtelId()
	 {
	        return otelId;
	 }
	 public void setOtelId(String otelId)
	 {
	       this.otelId = otelId;
	 }
	 
	 public String getOtelAd()
	 {
	        return otelAd;
	 }
	 public void setOtelAd(String otelAd)
	 {
	       this.otelAd = otelAd;
	 }
	 
	 
}
