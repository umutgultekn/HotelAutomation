import java.sql.*;

import javax.swing.*;

public class KullaniciGirisIslemleri {
	

	
	public static boolean BosAlanKontrolu(String kullaniciAdi, String sifre)
	{
		boolean sonuc =false;
		if(!kullaniciAdi.isEmpty() && !sifre.isEmpty())
		{
			sonuc=true;
		}
		else
		{
			JOptionPane.showMessageDialog(null," Lütfen Boþ Alanlarý Doldurup Tekrar Deneyiniz");

		}
		
		
		// TODO Auto-generated method stub
		return sonuc;
	}
	
	
	
	public static boolean AlanlariTemizle(JTextField txKullaniciAdi, JPasswordField txSifre) 
	{
		boolean sonuc=false;
		
		txKullaniciAdi.setText(null);
		txSifre.setText(null);
		
		if(txKullaniciAdi.getText().isEmpty() && txSifre.getText().isEmpty())
		{
			sonuc=true;
		}
		
		// TODO Auto-generated method stub
		return sonuc;
	}




	public static boolean GirisveYetkilendirme(String kullaniciAdi, String sifre) 
	{
		boolean sonuc=false;
		
		
		
		
			  String yetki;

			  String query = "Select * From kisi  WHERE kisi_kullaniciadi='" + kullaniciAdi + "' AND kisi_sifre='" + sifre + "'";
			  try
			  {
					DB.getInstance().BaglantiyiAc();
					ResultSet rs = DB.getInstance().getResultSet(query);
					while (rs.next()) 
					{
		               //yetki = rs.getString(1);  
						  GirisYapanKullaniciBilgileri bilgiler = new GirisYapanKullaniciBilgileri(
								  rs.getInt(1),
								  rs.getString(2),
								  rs.getString(3),
								  rs.getString(4),
								  rs.getString(5),
								  rs.getString(6),
								  rs.getFloat(7),
								  rs.getString(8),
								  rs.getString(9),
								  rs.getString(10),
								  rs.getInt(11),
								  rs.getString(12)
								  );
						  
						  yetki =  bilgiler.getYetki();	
						  if(Fonksiyonlar.BosDegilse(yetki))
						  {
							  sonuc=true;
							  
							  
													
					        	if(yetki.equals("yonetici"))
								{
									YoneticiFormu yonetici = new YoneticiFormu();
									yonetici.setVisible(true);
								}
								else if(yetki.equals("mudur"))
								{
									MudurFormu mudur=new MudurFormu();
									mudur.setVisible(true);
								}
								else if(yetki.equals("resepsiyonist"))
								{
									ResepsiyonistFormu resepsiyonist=new ResepsiyonistFormu();
									resepsiyonist.setVisible(true);
								}
								else if(yetki.equals("katgorevlisi"))
								{
									KatGorevlisiFormu katgorevlisi=new KatGorevlisiFormu();
									katgorevlisi.setVisible(true);
								}
	 
						  }
						  
					}
					if(sonuc==false)
					{
						   JOptionPane.showMessageDialog(null,"Yanlýþ Bilgiler Girdiniz !");

					}
			  } 
			  catch (ClassNotFoundException e) 
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  } catch (SQLException e) 
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }	  
			  
			  finally 
			  {
				  try
				  {
					DB.getInstance().BaglantiyiKapat(null, null);
				  } 
				  catch (SQLException e1) 
				  {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				  }
				
			  }  
		
	
				
			 
		        return sonuc;
		}



	




	

	


	

}
