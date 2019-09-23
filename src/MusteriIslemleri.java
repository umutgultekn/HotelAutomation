import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MusteriIslemleri {
	
	

	public static Object KayitlariCek(DefaultTableModel dm, JTable table) {
		// TODO Auto-generated method stub
Boolean sonuc=false;
		
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Ad");
		dm.addColumn("Soyad");
		 
		dm.addColumn("Adress");
		dm.addColumn("Tel");
		dm.addColumn("Email");
		dm.addColumn("Vtdurum");
		 
		dm.addColumn("Id");		
        String query = "SELECT * FROM musteri where musteri_vtdurum='1'";            
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				 String id = rs.getString(1);
			     String ad=rs.getString(2);
			     String soyad=rs.getString(3);			     
			     String adres=rs.getString(4);
			     String tel=rs.getString(5);
			     String email=rs.getString(6);
			     String vtdurum=rs.getString(7);			     
			     String sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{sira,ad,soyad,adres,tel,email,vtdurum,id});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 table.getColumnModel().getColumn(7).setMinWidth(0);
			 table.getColumnModel().getColumn(7).setMaxWidth(0); 
		   
		    
		    sonuc=true;
	        
		} 
        catch (ClassNotFoundException | SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
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

	
	
	public static boolean  MusteriEkle(String ad, String soyad,String adres,  String tel,String email, String vtdurum) 
	{
			boolean sonuc = false;
			String ad_kontrol="", soyad_kontrol="",tel_kontrol="";
			String query_kontrol ="SELECT musteri_ad,musteri_soyad,musteri_tel FROM musteri WHERE musteri_ad='"+ad+"' AND musteri_soyad='"+soyad+"' AND  musteri_tel='"+tel+"'  AND musteri_vtdurum='1'";

			String query ="INSERT INTO musteri(musteri_ad,musteri_soyad,musteri_adres,musteri_tel,musteri_email,musteri_vtdurum) values('"+ad+"','"+soyad+"','"+adres+"','"+tel+"','"+email+"','"+vtdurum+"')";
			
			try 
				{
					DB.getInstance().BaglantiyiAc();
					ResultSet rs = DB.getResultSet(query_kontrol);
					while(rs.next())
					{
						ad_kontrol = rs.getString(1);
						soyad_kontrol = rs.getString(2);
						tel_kontrol = rs.getString(3);
					}
					if(!ad_kontrol.equals(ad) && !soyad_kontrol.equals(soyad)  && !tel_kontrol.equals(tel))
					{
						DB.getInstance().runQuery(query);
						JOptionPane.showMessageDialog(null,"Müşteri  İşlemi Başarılı");
						sonuc=true;
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Kayıtlı Olmayan Bir Müşteri Giriniz");
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
		return sonuc;
	}

	
	public static boolean AlanKontrolu(String ad, String soyad,String tel, String email, String adres) 
	{
		boolean sonuc = false;
		
		if(	!ad.isEmpty() && !soyad.isEmpty() &&
				 
				!tel.isEmpty() && !email.isEmpty()
				&& !adres.isEmpty() 
				)
			
			
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

	
	
	public static  boolean AlanlariTemizle(JTextField txAdi, JTextField txSoyadi, JTextField txEmail,JTextField txAdres,JTextField txTel)
	{
		boolean sonuc=false;
		
		txAdi.setText(null);
		txSoyadi.setText(null);
		txAdres.setText(null);
		txTel.setText(null);
		txEmail.setText(null);
		
		
		
		if(		txAdi.getText().isEmpty() &&  txSoyadi.getText().isEmpty()  && 
				txAdres.getText().isEmpty()  &&
				txTel.getText().isEmpty()  && txEmail.getText().isEmpty() 
		  )
		{
			sonuc=true;
		}
		
		// TODO Auto-generated method stub
		return sonuc;
	}
	
	
	
	public static boolean MusteriSil(String kisi_id) 
	{
		
		boolean sonuc=false;
		
		if(Fonksiyonlar.BosDegilse(kisi_id))
		{
			String query = "update musteri SET musteri_vtdurum=0 WHERE musteri_id='"+kisi_id+"'";
			try
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				JOptionPane.showMessageDialog(null,"Musteri Silme Ýþlemi Baþarýlý");
				sonuc=true;

			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		

		// TODO Auto-generated method stub
		return sonuc;
	}
	
	
	public static boolean MusteriGuncelle(String id,String ad, String soyad,String adres,  String tel,String email, String vtdurum) 
	{
		
		boolean sonuc =false;
		String query="update musteri set musteri_ad='"+ad+"',musteri_soyad='"+soyad+"',musteri_adres='"+adres+"',musteri_tel='"+tel+"',musteri_email='"+email+"',musteri_vtdurum='"+vtdurum+"' where  musteri_id='"+id+"'";
		
			try 
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				  JOptionPane.showMessageDialog(null,"Musteri Güncelleme Ýþlemi Baþarýlý");
					sonuc=true;
			}
			catch (ClassNotFoundException | SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
	
		
		// TODO Auto-generated method stub
		return sonuc;
		
		
		// TODO Auto-generated method stub
		
	}

	
	
	public static boolean MusteriAra(DefaultTableModel dm, JTable table,String ad, String soyad,String email,String tel)
	{
		boolean sonuc=false;
		
		ad=!ad.equals("") ? ad :"%%";
		soyad=!soyad.equals("") ? soyad :"%%";
		 
		email=!email.equals("") ? email :"%%";
		tel=!tel.equals("") ? tel :"%%";
		
		String query="SELECT * FROM musteri where musteri_ad  LIKE '"+ad+"'and musteri_soyad LIKE '"+soyad+"' and musteri_email LIKE '"+email+"' and musteri_tel LIKE '"+tel+"' ";
		 
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Ad");
		dm.addColumn("Soyad");
		 
		dm.addColumn("Adress");
		dm.addColumn("Tel");
		dm.addColumn("Email");
		dm.addColumn("Vtdurum");
		 
		dm.addColumn("Id");		
                   
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				 
				String id = rs.getString(1);
			     String adi=rs.getString(2);
			     String soyadi=rs.getString(3);			     
			     String adres=rs.getString(4);
			     String teli=rs.getString(5);
			     String emaili=rs.getString(6);
			     String vtdurum=rs.getString(7);			     
			     String sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{sira,adi,soyadi,adres,teli,emaili,vtdurum,id});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 
		    table.getColumnModel().getColumn(7).setMinWidth(0);
		    table.getColumnModel().getColumn(7).setMaxWidth(0);
		    
		    sonuc=true;
	        
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
		
		
		return sonuc;
	}



	
	



	public static boolean MusteriTelDenIdCek(String musteri_tel,String[] musteri_id)
	{
		boolean sonuc=false;
		
	     String query = "SELECT musteri_id FROM musteri WHERE musteri_vtdurum='1' AND musteri_tel='"+musteri_tel+"' ";            
	        try {
				DB.getInstance().BaglantiyiAc();
				ResultSet rs;
				rs = DB.getInstance().getResultSet(query);
				int sirasayaci=1;
				while (rs.next()) 
				{
					musteri_id[0]=rs.getString(1);
				}
				
				
			    sonuc=true;

		        
			} 
	        catch (ClassNotFoundException | SQLException e) 
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return true;
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




	





	
	
	
	
	
}
