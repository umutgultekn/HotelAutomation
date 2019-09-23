import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RezervasyonIslemleri {

	static GirisYapanKullaniciBilgileri bilgiler = new GirisYapanKullaniciBilgileri();
	static String otel_id = bilgiler.getOtelId(); 
	static LocalDate localDate = LocalDate.now();

	

	public static boolean OdaAramaCbFiyatYukle(JComboBox cbOdaGunlukFiyat)
	{
		boolean sonuc = false;
		
		if(cbOdaGunlukFiyat.getItemCount()>0)
		{
			cbOdaGunlukFiyat.removeAllItems();
			RezervasyonIslemleri.OdaAramaCbFiyatYukle(cbOdaGunlukFiyat);
			sonuc = true;

		}
		else
		{
			if(cbOdaGunlukFiyat.getItemCount()==0)
			{
				cbOdaGunlukFiyat.addItem("Seciniz");
				cbOdaGunlukFiyat.addItem("<100");
				cbOdaGunlukFiyat.addItem("100-200");
				cbOdaGunlukFiyat.addItem("200-300");
				cbOdaGunlukFiyat.addItem(">300");
				
			}
			if(cbOdaGunlukFiyat.getItemCount()>1)
			{
				sonuc = true;
			}
			
	
		}	
		// TODO Auto-generated method stub
		return sonuc;
		/*boolean sonuc=false;
		
		cbOdaGunlukFiyat.addItem("Seciniz");
		cbOdaGunlukFiyat.addItem("<100");
		cbOdaGunlukFiyat.addItem("100-200");
		cbOdaGunlukFiyat.addItem("200-300");
		cbOdaGunlukFiyat.addItem(">300");

		if(cbOdaGunlukFiyat.getItemCount()>1)
		{
			sonuc = true;
		}
		
		
		// TODO Auto-generated method stub
		return sonuc;*/
	}

	public static boolean OdaAramaCbDurumYukle(JComboBox cbOdaDurumu) {
		
		boolean sonuc = false;
		
		if(cbOdaDurumu.getItemCount()>0)
		{
			cbOdaDurumu.removeAllItems();
			RezervasyonIslemleri.OdaAramaCbDurumYukle(cbOdaDurumu);
			sonuc = true;

		}
		else
		{
			if(cbOdaDurumu.getItemCount()==0)
			{
				
				cbOdaDurumu.addItem("Seciniz");
				cbOdaDurumu.addItem("Bos");
				cbOdaDurumu.addItem("Dolu");
			}
			if(cbOdaDurumu.getItemCount()>1)
			{
				sonuc = true;
			}
			
	
		}	
		// TODO Auto-generated method stub
		return sonuc;
		/*
		boolean sonuc=false;
		cbOdaDurumu.addItem("Seciniz");
		cbOdaDurumu.addItem("Bos");
		cbOdaDurumu.addItem("Dolu");

		if(cbOdaDurumu.getItemCount()>1)
		{
			sonuc = true;
		}
		// TODO Auto-generated method stub
		return sonuc;*/
	}

	public static boolean OdaAramaCbSinifYukle(JComboBox cbOdaSinifi) 
	{
		boolean sonuc = false;
		
		if(cbOdaSinifi.getItemCount()>0)
		{
			cbOdaSinifi.removeAllItems();
			RezervasyonIslemleri.OdaAramaCbSinifYukle(cbOdaSinifi);
			sonuc=true;
		}
		else
		{
			if(cbOdaSinifi.getItemCount()==0)
			{
				cbOdaSinifi.addItem("Seciniz");

				String query="SELECT odaKategori_ad FROM odakategori";
				try {
					DB.getInstance().BaglantiyiAc();
					ResultSet rs=DB.getInstance().getResultSet(query);

					while(rs.next())
					{
						cbOdaSinifi.addItem(rs.getString(1));
					}
					
					if(cbOdaSinifi.getItemCount()>1)
					{
						sonuc=true;
					}

				} 
				catch (ClassNotFoundException | SQLException e) 
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
					catch (SQLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// TODO Auto-generated method stub
			
			}	
		}
		return sonuc;
		/*
		boolean sonuc=false;
		cbOdaSinifi.addItem("Seciniz");
		
		String query="SELECT odaKategori_ad FROM odakategori";
		try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs=DB.getInstance().getResultSet(query);

			while(rs.next())
			{
				cbOdaSinifi.addItem(rs.getString(1));
			}
			
			if(cbOdaSinifi.getItemCount()>1)
			{
				sonuc=true;
			}

		} 
		catch (ClassNotFoundException | SQLException e) 
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
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		return sonuc;*/
	}

	public static boolean OdaAramaTemizle(JComboBox cbOdaGunlukFiyat, JComboBox cbOdaSinifi, JComboBox cbOdaDurumu) 
	{

		boolean sonuc = false;

		// COMBOBOXLARA DEĞER YUKLEMEZSEK BOŞ GORDUGU ICIN TESTTE HATA VERECEKTİR
		RezervasyonIslemleri.OdaAramaCbDurumYukle(cbOdaDurumu);
		RezervasyonIslemleri.OdaAramaCbFiyatYukle(cbOdaGunlukFiyat);
		RezervasyonIslemleri.OdaAramaCbSinifYukle(cbOdaSinifi);
		
		cbOdaGunlukFiyat.setSelectedIndex(0);
		cbOdaSinifi.setSelectedIndex(0);
		cbOdaDurumu.setSelectedIndex(0);

		if(cbOdaGunlukFiyat.getSelectedIndex()==0 && cbOdaSinifi.getSelectedIndex()==0 && cbOdaDurumu.getSelectedIndex()==0)
		{
			sonuc = true;

		}
		// TODO Auto-generated method stub
		return sonuc;
	}


	public static boolean OdaKayitlariCek(DefaultTableModel dm, JTable tableOda)
	{

		boolean sonuc =false;
		
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Numara");
		dm.addColumn("Oda Sinifi");
		dm.addColumn("Durum");
		dm.addColumn("Fiyati");
		dm.addColumn("Id");
	
		
		
        String query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"'  ORDER BY O.oda_gunlukfiyat ASC";

      
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
		          String sira =Integer.toString(sirasayaci);
		          String id = rs.getString(1);
		          String numara=rs.getString(2);
		          String gunlukfiyat=rs.getString(3);
		          String durum=rs.getString(4);
		          String odakategori=rs.getString(5);
		          dm.addRow(new String[]{sira,numara,odakategori,durum,gunlukfiyat,id});
				  sirasayaci++;

			}
			
			tableOda.setModel(dm);
			tableOda.getColumnModel().getColumn(5).setMinWidth(0);
			tableOda.getColumnModel().getColumn(5).setMaxWidth(0);
		 
	        
		    sonuc = true;
		} 
        catch (ClassNotFoundException | SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {
        	try 
        	{
				DB.getInstance().BaglantiyiKapat(null, null);
			} catch (SQLException e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		// TODO Auto-generated method stub
		return sonuc;
	}



	public static boolean OdaArama(DefaultTableModel dm, JTable tableOda, JComboBox cbOdaGunlukFiyat, JComboBox cbOdaSinifi, JComboBox cbOdaDurumu) 
	{
		
		boolean sonuc=false;

		// COMBOBOXLARA DEĞER YUKLEMEZSEK BOŞ GORDUGU ICIN TESTTE HATA VERECEKTİR
				RezervasyonIslemleri.OdaAramaCbDurumYukle(cbOdaDurumu);
				RezervasyonIslemleri.OdaAramaCbFiyatYukle(cbOdaGunlukFiyat);
				RezervasyonIslemleri.OdaAramaCbSinifYukle(cbOdaSinifi);
				
				
		String query="";
		
		
		//FİYATA GORE
		 if(cbOdaGunlukFiyat.getSelectedIndex()!=0 && cbOdaSinifi.getSelectedIndex()==0 && cbOdaDurumu.getSelectedIndex()==0)
		{
			if(cbOdaGunlukFiyat.getSelectedIndex()==1)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat<100 ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==2)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=100 AND O.oda_gunlukfiyat<200  ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==3)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND O.oda_gunlukfiyat>=200 AND O.oda_gunlukfiyat<300 ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==4)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=300 ORDER BY O.oda_gunlukfiyat ASC";
			}
		}
		 //FİYAT VE SİNİFA GORE
		else if( cbOdaGunlukFiyat.getSelectedIndex()!=0 && cbOdaSinifi.getSelectedIndex()!=0 && cbOdaDurumu.getSelectedIndex()==0)
		{
			if(cbOdaGunlukFiyat.getSelectedIndex()==1)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat<100 AND OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"'  ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==2)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=100 AND O.oda_gunlukfiyat<200 AND OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"'  ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==3)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=200 AND O.oda_gunlukfiyat<300 AND OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==4)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=300 AND OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
		}
		 //FİYAT VE DURUMA GORE
		else if( cbOdaGunlukFiyat.getSelectedIndex()!=0 && cbOdaSinifi.getSelectedIndex()==0 && cbOdaDurumu.getSelectedIndex()!=0)
		{
			if(cbOdaGunlukFiyat.getSelectedIndex()==1)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat<100  AND O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==2)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=100  AND O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==3)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=200 AND O.oda_gunlukfiyat<300 AND  O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==4)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=300 AND O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
		}
		
		//SİNİFA GORE
		else if( cbOdaGunlukFiyat.getSelectedIndex()==0 && cbOdaSinifi.getSelectedIndex()!=0 && cbOdaDurumu.getSelectedIndex()==0)
		{
					
			query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"'  ORDER BY O.oda_gunlukfiyat ASC";
					
		}
		//SİNİFA VE DURUMNA  GORE
		else if( cbOdaGunlukFiyat.getSelectedIndex()==0 && cbOdaSinifi.getSelectedIndex()!=0 && cbOdaDurumu.getSelectedIndex()!=0)
		{

				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"' AND O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";		
		}
		// DURUMNA  GORE
		else if( cbOdaGunlukFiyat.getSelectedIndex()==0 && cbOdaSinifi.getSelectedIndex()==0 && cbOdaDurumu.getSelectedIndex()!=0)
		{						
					
			query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND   O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
					
		}	
		 //FİYAT - SINIF VE DURUMUNA GORE
		else if( cbOdaGunlukFiyat.getSelectedIndex()!=0 && cbOdaSinifi.getSelectedIndex()!=0 && cbOdaDurumu.getSelectedIndex()!=0)
		{
		
		
			if(cbOdaGunlukFiyat.getSelectedIndex()==1)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat<100 AND OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"' AND O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==2)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=100 AND O.oda_gunlukfiyat<200 AND OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"' AND O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==3)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=200 AND O.oda_gunlukfiyat<300 AND OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"' AND O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
			else if(cbOdaGunlukFiyat.getSelectedIndex()==4)
			{
				query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat>=300 AND OK.odaKategori_ad='"+cbOdaSinifi.getSelectedItem()+"' AND O.oda_durum='"+cbOdaDurumu.getSelectedItem()+"' ORDER BY O.oda_gunlukfiyat ASC";
			}
		}
		else if( cbOdaGunlukFiyat.getSelectedIndex()==0 && cbOdaSinifi.getSelectedIndex()==0 && cbOdaDurumu.getSelectedIndex()==0)
		{
			query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum, OK.odaKategori_ad FROM  odakategori OK inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' ORDER BY O.oda_gunlukfiyat ASC";
			  JOptionPane.showMessageDialog(null,"Herhangi Bir Kriter Seçmediniz !");

		}
		
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Numara");
		dm.addColumn("Oda Sinifi");
		dm.addColumn("Durum");
		dm.addColumn("Fiyati");
		dm.addColumn("Id");
	

        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
		          String sira =Integer.toString(sirasayaci);
		          String id = rs.getString(1);
		          String numara=rs.getString(2);
		          String gunlukfiyat=rs.getString(3);
		          String durum=rs.getString(4);
		          String odakategori=rs.getString(5);
		          dm.addRow(new String[]{sira,numara,odakategori,durum,gunlukfiyat,id});
				  sirasayaci++;

			}
			
			tableOda.setModel(dm);
			tableOda.getColumnModel().getColumn(5).setMinWidth(0);
			tableOda.getColumnModel().getColumn(5).setMaxWidth(0);
		 
	      
			
			    sonuc = true;

	        
		} 
        catch (ClassNotFoundException | SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {
        	try 
        	{
				DB.getInstance().BaglantiyiKapat(null, null);
			} catch (SQLException e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		
		
		// TODO Auto-generated method stub
		return sonuc;
	}

	public static int RezervasyonTutarHesapla(int i, int j)
	{
		int rezervasyonTutar=0;	
		rezervasyonTutar = i*j;
		// TODO Auto-generated method stub
		return rezervasyonTutar;
	}

	public static boolean RezervasyonKaydet(String oda_id, String musteri_id, String rezervasyon_baslangic_tarihi,
			String rezervasyon_bitis_tarihi, String rezervasyon_ucret, String rezervasyon_vtdurum) 
	{
		
		boolean sonuc=false;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		
		String query="INSERT INTO rezervasyon(oda_id,musteri_id,rezervasyon_tarihi,rezervasyon_baslangictarihi,rezervasyon_bitistarihi,rezervasyon_ucret,rezervasyon_vtdurum) values('"+oda_id+"','"+musteri_id+"','"+DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate)+"','"+rezervasyon_baslangic_tarihi+"','"+rezervasyon_bitis_tarihi+"','"+rezervasyon_ucret+"','"+rezervasyon_vtdurum+"')";
			try 
			{
				DB.getInstance().BaglantiyiAc();
				
					DB.getInstance().runQuery(query);
					sonuc=true;

					JOptionPane.showMessageDialog(null,"Rezervasyon Ekleme İşlemi Başarılı");
			}

			catch (ClassNotFoundException | SQLException e)
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
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		

		// TODO Auto-generated method stub
		return sonuc;
		
	/*	boolean sonuc=false;
	
		String oda_id_kontrol="",musteri_id_kontrol="",bas_tarihi_kontrol="",bitis_tarihi_kontrol="";
		String query_kontrol ="SELECT oda_id,musteri_id,rezervasyon_baslangictarihi,rezervasyon_bitistarihi  FROM otel WHERE otel_'"+otel_id+"' oda_id='"+oda_id+"' AND rezervasyon_baslangictarihi between '\"+fiyat1+\"' and '\"+fiyat2+\"'     AND rezervasyon_vtdurum='1'";

		String query="INSERT INTO otel(oda_id,musteri_id,rezervasyon_tarihi,rezervasyon_baslangictarihi,rezervasyon_bitistarihi,rezervasyon_ucret,rezervasyon_vtdurum) values('"+rezervasyon_id+"','"+oda_id+"','"+musteri_id+"','"+rezervasyon_tarihi+"','"+rezervasyon_baslangic_tarihi+"','"+rezervasyon_bitis_tarihi+"','"+rezervasyon_ucret+"','"+rezervasyon_vtdurum+"')";
			try 
			{
				DB.getInstance().BaglantiyiAc();
				ResultSet rs = DB.getResultSet(query_kontrol);
				while(rs.next())
				{
					oda_id_kontrol = rs.getString(1);
					musteri_id_kontrol = rs.getString(2);
					bas_tarihi_kontrol = rs.getString(3);
					bitis_tarihi_kontrol = rs.getString(4);

				}
				if(!oda_id_kontrol.equals(oda_id) && !musteri_id_kontrol.equals(oda_id) && !bas_tarihi_kontrol.equals(rezervasyon_baslangic_tarihi) && !bitis_tarihi_kontrol.equals(rezervasyon_bitis_tarihi))
				{
					DB.getInstance().runQuery(query);
					sonuc=true;

					JOptionPane.showMessageDialog(null,"Otel Ekleme İşlemi Başarılı");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Kayıtlı Olmayan Bir Otel Adı Giriniz");
				}
				
				
				
				//buraya kadar hata olmazsa ekleme başarılıdır zaten sonuc =true kullan
			}
			catch (ClassNotFoundException | SQLException e)
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
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	// TODO Auto-generated method stub
	return sonuc;
		
		*/
		
	
	}

	public static boolean RezervasyonKayitlariCek(DefaultTableModel dm, JTable table) 
	{
	
		boolean sonuc = false;
		
		dm = new DefaultTableModel();
	//	dm.addColumn("Sira");
		dm.addColumn("Oda Numara");
		dm.addColumn("Müşteri");
		dm.addColumn("Başlangıç Tarihi");
		dm.addColumn("Bitiş Tarihi");		
		dm.addColumn("Id");
	

        String query = "SELECT O.oda_numara,M.musteri_ad,M.musteri_soyad,R.rezervasyon_baslangictarihi,R.rezervasyon_bitistarihi,R.rezervasyon_id  FROM rezervasyon R inner join oda O on R.oda_id=O.oda_id inner join musteri M on M.musteri_id=R.musteri_id  WHERE rezervasyon_vtdurum='1' ORDER BY rezervasyon_id DESC ";       
      
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
		          String oda = rs.getString(1);
		          String musteri=rs.getString(2)+" "+rs.getString(3);
		          String başlangicTarihi=rs.getString(4);
		          String bitisTarihi=rs.getString(5);
		          String rezervasyonId=rs.getString(6);	         
		          String sira =Integer.toString(sirasayaci);
		          dm.addRow(new String[]{oda,musteri,başlangicTarihi,bitisTarihi,rezervasyonId});
				  sirasayaci++;

			}
			
			table.setModel(dm);
		    table.getColumnModel().getColumn(4).setMinWidth(0);
		    table.getColumnModel().getColumn(4).setMaxWidth(0);

	        
		    sonuc = true;
		} 
        catch (ClassNotFoundException | SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {
        	try 
        	{
				DB.getInstance().BaglantiyiKapat(null, null);
			} catch (SQLException e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		// TODO Auto-generated method stub
		return sonuc;
	}

	
	
	public static boolean RezervasyonAramaKayitlariCek(DefaultTableModel dm, JTable table, String rezervasyon_arama_baslangic_tarihi, String rezervasyon_arama_bitis_tarihi) 
	{
	boolean sonuc = false;
	
	dm = new DefaultTableModel();
//	dm.addColumn("Sira");
	dm.addColumn("Oda Numara");
	dm.addColumn("Müşteri");
	dm.addColumn("Başlangıç Tarihi");
	dm.addColumn("Bitiş Tarihi");		
	dm.addColumn("Id");


    String query = "SELECT O.oda_numara,M.musteri_ad,M.musteri_soyad,R.rezervasyon_baslangictarihi,R.rezervasyon_bitistarihi,R.rezervasyon_id  FROM rezervasyon R inner join oda O on R.oda_id=O.oda_id inner join musteri M on M.musteri_id=R.musteri_id  WHERE rezervasyon_vtdurum='1'  AND ( rezervasyon_baslangictarihi  between '"+rezervasyon_arama_baslangic_tarihi+"' and '"+rezervasyon_arama_bitis_tarihi+"' ) AND (rezervasyon_bitistarihi between '"+rezervasyon_arama_baslangic_tarihi+"' and '"+rezervasyon_arama_bitis_tarihi+"' ) ORDER BY rezervasyon_id DESC ";       
  
    try {
		DB.getInstance().BaglantiyiAc();
		ResultSet rs;
		rs = DB.getInstance().getResultSet(query);
		int sirasayaci=1;
		while (rs.next()) 
		{
	          String oda = rs.getString(1);
	          String musteri=rs.getString(2)+" "+rs.getString(3);
	          String başlangicTarihi=rs.getString(4);
	          String bitisTarihi=rs.getString(5);
	          String rezervasyonId=rs.getString(6);	         
	          String sira =Integer.toString(sirasayaci);
	          dm.addRow(new String[]{oda,musteri,başlangicTarihi,bitisTarihi,rezervasyonId});
			  sirasayaci++;

		}
		
		table.setModel(dm);
	    table.getColumnModel().getColumn(4).setMinWidth(0);
	    table.getColumnModel().getColumn(4).setMaxWidth(0);

        
	    sonuc = true;
	} 
    catch (ClassNotFoundException | SQLException e) 
    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally 
    {
    	try 
    	{
			DB.getInstance().BaglantiyiKapat(null, null);
		} catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	// TODO Auto-generated method stub
	return sonuc;
	}
	
	
	
	
/*
	public boolean RezervasyonListele(DefaultTableModel dm, JTable tableRezervasyon) 
	{
		boolean sonuc=false;
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Oda Numara");
		dm.addColumn("Müşteri");
		dm.addColumn("Baş. Tar.");
		dm.addColumn("Bit. Tar.");
		dm.addColumn("Id");
	
		String query = "SELECT O.oda_numara, FROM   inner join oda O on O.odaKategori_id=OK.odaKategori_id  WHERE  O.oda_vtdurum='1' AND O.otel_id='"+otel_id+"' AND  O.oda_gunlukfiyat<100 ORDER BY O.oda_gunlukfiyat ASC";

        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
		          String sira =Integer.toString(sirasayaci);
		          String id = rs.getString(1);
		          String numara=rs.getString(2);
		          String gunlukfiyat=rs.getString(3);
		          String durum=rs.getString(4);
		          String odakategori=rs.getString(5);
		          dm.addRow(new String[]{sira,numara,odakategori,durum,gunlukfiyat,id});
				  sirasayaci++;

			}
			
			tableOda.setModel(dm);
			tableOda.getColumnModel().getColumn(5).setMinWidth(0);
			tableOda.getColumnModel().getColumn(5).setMaxWidth(0);
		 
	      
			
			    sonuc = true;

	        
		} 
        catch (ClassNotFoundException | SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {
        	try 
        	{
				DB.getInstance().BaglantiyiKapat(null, null);
			} catch (SQLException e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		
		
		// TODO Auto-generated method stub
		return sonuc;
	}
	
	
*/

	
	//public static boolean RezervasyonKaydet(String oda_id,String musteri_id ,String rezervasyon_ucret,)
	
	

}
