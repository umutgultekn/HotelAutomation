import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

import com.mysql.jdbc.StringUtils;

public class Fonksiyonlar 
{


 	public static boolean UygulamaCikisYap()
	{
		
		boolean sonuc =false;
	
		JFrame cikisIslemi = new JFrame("Çıkış İşlemi");
		int reply = JOptionPane.showConfirmDialog(cikisIslemi, "Uygulamayı Kapatmak İstediğinizden Emin misiniz?", "Çıkış İşlemi",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION)
		{
		   sonuc=true;
		   System.exit(0);
		}
		else if(reply==JOptionPane.NO_OPTION)
		{
			sonuc=true;
		}
	
		// TODO Auto-generated method stub
		return sonuc;
	}

	
	public static boolean StringMi(String deger)
	{
		
		boolean sonuc = false;
		
		for(int i=0;i<deger.length();i++)
		{
			if(!Character.isDigit(deger.charAt(i)))
			{
				sonuc=true;
			}
			
		}
		if(sonuc!=true)
		{
			 JOptionPane.showMessageDialog(null,"Lütfen Metinsel Değer Giriniz !");
		}

		// TODO Auto-generated method stub
		return sonuc;
	}
	
	
	public static boolean SayisalMi(String deger,String AlanAdi)
	{
		boolean sonuc = false;
		
		for(int i=0;i<deger.length();i++)
		{
			if(Character.isDigit(deger.charAt(i)))
			{
				sonuc=true;
			}
			else
			{
				sonuc=false;
				continue;
			}
		
			
		}
		if(sonuc==false)
		{
			 JOptionPane.showMessageDialog(null,"Lütfen '"+AlanAdi+"' Alanına Sayısal Değer Giriniz !");
		}
	
		// TODO Auto-generated method stub
		return sonuc;
	}
	
	
	public static boolean BosDegilse(String deger) 
	{
		boolean sonuc =false;
		if(!StringUtils.isNullOrEmpty(deger))
		{
			sonuc=true;
		}
		else
		{
            JOptionPane.showMessageDialog(null,"Lütfen Boş Alanları Doldurunuz !");
		}
	
		// TODO Auto-generated method stub
		return sonuc;
	}


	public static boolean GirisYapanKullanicininAdiniSoyadiniCek(JLabel lblMesaj) 
	{
		boolean sonuc =false;
		
		//BUNU KULLANMADIGIMIZDA BAĞLANTI İŞLEMİ YAPILMADIĞI İÇİN TEST KISMINDA LABELIN İCERİĞİ BOŞ OLACAGINDAN FALSE DONECEK VE TEST HATA VERECEKTİR.
		//lblMesaj.setText(" TEST İÇİN --> Hoşgeldiniz ADMİN");
		
		GirisYapanKullaniciBilgileri bilgiler=new GirisYapanKullaniciBilgileri();
		lblMesaj.setText("Hoşgeldiniz : "+bilgiler.getAd().toUpperCase()+" "+bilgiler.getSoyad().toUpperCase());		
		if(BosDegilse(lblMesaj.getText().toString()))
		{
			sonuc=true;
		}

		// TODO Auto-generated method stub
		return sonuc;
	}


	public static boolean GirisYapanKullanicininOtelIdCek(JLabel lblOtelId) {
		boolean sonuc=false;
		GirisYapanKullaniciBilgileri bilgiler=new GirisYapanKullaniciBilgileri();
		lblOtelId.setText(bilgiler.getOtelId());		
		if(!lblOtelId.getText().isEmpty())
		{
			sonuc=true;
		}
		// TODO Auto-generated method stub
		return sonuc;
	}

	//2 tarih arasýndaki gün sayýsýný bulan fonksiyon
	public static boolean daysBetween(Date GirisTarihi ,Date CikisTarihi, int[] GunSayisi)
	{
		boolean sonuc =false;
		
       
		GunSayisi[0] = (int)( (CikisTarihi.getTime() - GirisTarihi.getTime()) / (1000 * 60 * 60 * 24)) +1;
        if(GunSayisi.length>0)
        {
        	
        	sonuc=true;
        }
         
         return sonuc ;
	}

}
	
