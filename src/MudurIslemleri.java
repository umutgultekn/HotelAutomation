import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MudurIslemleri {

	public  static boolean cbYetkiYukle(JComboBox cbYetki)
	{
		boolean sonuc = false;

		
		if(cbYetki.getItemCount()>0)
		{
			cbYetki.removeAllItems();
			MudurIslemleri.cbYetkiYukle(cbYetki);
		}
		else
		{
			if(cbYetki.getItemCount()==0)
			{
			
				String query="SELECT yetki_id ,yetki_adi FROM yetki";
				try 
				{
					DB.getInstance().BaglantiyiAc();
					ResultSet rs = 	DB.getInstance().getResultSet(query);
					while(rs.next())
					{
						cbYetki.addItem(rs.getString(2));
					}
					if(cbYetki.getItemCount()>0)
					{
						sonuc=true;
					}

					
				} catch (ClassNotFoundException | SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		
			
		}
		
	
		
		// TODO Auto-generated method stub
		return sonuc;
	}

	public static boolean AlanKontrolu(String ad, String soyad, String otel, String kullaniciadi, String sifre, String maas,
			String tel, String email, String adres) 
	{
		boolean sonuc = false;
		if(	!ad.isEmpty() && !soyad.isEmpty() &&
				!otel.isEmpty() && !kullaniciadi.isEmpty() && 
				!sifre.isEmpty() && !maas.isEmpty()  &&
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
	
	
	public static  boolean AlanlariTemizle(JTextField txAdi, JTextField txSoyadi, JComboBox cbOtel, JTextField txKullaniciAdi,
			 JPasswordField txSifre,JTextField txMaas,JTextField txAdres,JTextField txTel,JTextField txEmail)
	{
		boolean sonuc=false;
		
		txAdi.setText(null);
		txSoyadi.setText(null);
		cbOtel.setSelectedItem(null);
		txKullaniciAdi.setText(null);
		txSifre.setText(null);
		txMaas.setText(null);
		txAdres.setText(null);
		txTel.setText(null);
		txEmail.setText(null);
		if(		txAdi.getText().isEmpty() &&  txSoyadi.getText().isEmpty()  && cbOtel.getSelectedItem().toString().isEmpty() && 
				txKullaniciAdi.getText().isEmpty() && txSifre.getText().isEmpty() &&  txMaas.getText().isEmpty() &&
				txAdres.getText().isEmpty()  &&	txTel.getText().isEmpty() && txEmail.getText().isEmpty() 
		  )
		{
			sonuc=true;
		}
		
		// TODO Auto-generated method stub
		return sonuc;
	}
	
	
	public static boolean  MudurEkle(String ad, String soyad,String otel_id,String kullaniciadi, String sifre,String maas,String adres,  String tel,String email,String yetki,  String vtdurum) 
	{
			boolean sonuc = false;
			String mudur_ad_kontrol="", mudur_soyad_kontrol="", mudur_yetki_kontrol="mudur", mudur_tel_kontrol="";
			String query_kontrol ="SELECT kisi_ad,kisi_soyad,kisi_tel FROM kisi WHERE kisi_ad='"+ad+"' AND kisi_soyad='"+soyad+"' AND kisi_yetki='mudur' AND kisi_tel='"+tel+"'  AND kisi_vtdurum='1'";

			String query ="INSERT INTO kisi(kisi_ad,kisi_soyad,otel_id,kisi_kullaniciadi,kisi_sifre,kisi_maas,kisi_adres,kisi_tel,kisi_email,kisi_yetki,kisi_vtdurum) values('"+ad+"','"+soyad+"','"+otel_id+"','"+kullaniciadi+"','"+sifre+"','"+maas+"','"+adres+"','"+tel+"','"+email+"','"+yetki+"','"+vtdurum+"')";
			
			try 
				{
					DB.getInstance().BaglantiyiAc();

					ResultSet rs = DB.getResultSet(query_kontrol);
					while(rs.next())
					{
						mudur_ad_kontrol = rs.getString(1);
						mudur_soyad_kontrol = rs.getString(2);
						mudur_tel_kontrol = rs.getString(3);
					}
					if(!mudur_ad_kontrol.equals(ad) && !mudur_soyad_kontrol.equals(soyad)  && !mudur_tel_kontrol.equals(tel))
					{
						DB.getInstance().runQuery(query);
						JOptionPane.showMessageDialog(null,"MüdürEkleme Ýþlemi Baþarýlý");
						sonuc=true;
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Kayýtlý Olmayan Bir Müdür Giriniz");
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

	public static Object KayitlariCek(DefaultTableModel dm, JTable table)
	{
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Ad");
		dm.addColumn("Soyad");
		dm.addColumn("Otel");
		dm.addColumn("Adres");
		dm.addColumn("Tel");
		dm.addColumn("Email");
		dm.addColumn("KullaniciAdi");
		dm.addColumn("Sifre");
		dm.addColumn("Yetki");
		dm.addColumn("Maas");
		dm.addColumn("Vtdurum");
		dm.addColumn("Id");		
        String query = "SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_yetki='mudur'  ORDER BY kisi_id DESC  ";            
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
			     String kullaniciadi=rs.getString(4);
			     String sifre=rs.getString(5);
			     String yetki=rs.getString(6);
			     String maas=rs.getString(7);
			     String adres=rs.getString(8);
			     String tel=rs.getString(9);
			     String email=rs.getString(10);
			     String vtdurum=rs.getString(11);
			     String otelad=rs.getString(12);
			     String sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{sira,ad,soyad,otelad,adres,tel,email,kullaniciadi,sifre,yetki,maas,vtdurum,id});
				  sirasayaci++;

			}
			
			table.setModel(dm);
		    table.getColumnModel().getColumn(11).setMinWidth(0);
		    table.getColumnModel().getColumn(11).setMaxWidth(0);
		    table.getColumnModel().getColumn(12).setMinWidth(0);
		    table.getColumnModel().getColumn(12).setMaxWidth(0);
	        
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
		return null;

	}

	public static boolean MudurSil(String kisi_id) 
	{
		
		boolean sonuc=false;
		
		if(Fonksiyonlar.BosDegilse(kisi_id))
		{
			String query = "update kisi SET kisi_vtdurum=0 WHERE kisi_id='"+kisi_id+"'";
			try
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				JOptionPane.showMessageDialog(null,"Müdür Silme Ýþlemi Baþarýlý");
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

	public static boolean MudurGuncelle(String id,String ad, String soyad, String kullaniciadi, String sifre,String yetki, String maas,String adres,  String tel,String email, String vtdurum,String otel_id) 
	{
		
		boolean sonuc =false;
		String query="update kisi set kisi_ad='"+ad+"',kisi_soyad='"+soyad+"',kisi_kullaniciadi='"+kullaniciadi+"',kisi_sifre='"+sifre+"',kisi_yetki='"+yetki+"',kisi_maas='"+maas+"',kisi_adres='"+adres+"',kisi_tel='"+tel+"',kisi_email='"+email+"',otel_id='"+otel_id+"' where  kisi_id='"+id+"'";
		
			try 
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				  JOptionPane.showMessageDialog(null,"Müdür Güncelleme Ýþlemi Baþarýlý");
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


	public static boolean MudurAra(DefaultTableModel dm, JTable table, String ad, String soyad, String otel,
			String kullaniciadi, String sifre, String maas, String tel, String email, String adres) 
	{
		boolean sonuc = false;
	
		String query="";
		
		
		
		if(!ad.isEmpty() &&  soyad.isEmpty() && !otel.isEmpty() && kullaniciadi.isEmpty() && sifre.isEmpty() && maas.isEmpty() && tel.isEmpty() && email.isEmpty() && adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_ad  LIKE '%"+ad+"%' ORDER BY kisi_id DESC ";            
		}
		else if(ad.isEmpty() &&  !soyad.isEmpty() && !otel.isEmpty() && kullaniciadi.isEmpty() && sifre.isEmpty() && maas.isEmpty() && tel.isEmpty() && email.isEmpty() && adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_soyad LIKE '%"+soyad+"%' ORDER BY kisi_id DESC ";   
		}
		else if(ad.isEmpty() &&  soyad.isEmpty() && !otel.isEmpty() && kullaniciadi.isEmpty() && sifre.isEmpty() && maas.isEmpty() && tel.isEmpty() && email.isEmpty() && adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_otel LIKE  '%"+otel+"%' ORDER BY kisi_id DESC ";
		}
		else if(ad.isEmpty() &&  !soyad.isEmpty() && !otel.isEmpty() && !kullaniciadi.isEmpty() && sifre.isEmpty() && maas.isEmpty() && tel.isEmpty() && email.isEmpty() && adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_kullaniciadi LIKE '%"+kullaniciadi+"%' ORDER BY kisi_id DESC ";     
		}
		else if(ad.isEmpty() &&  soyad.isEmpty() && !otel.isEmpty() && kullaniciadi.isEmpty() && !sifre.isEmpty() && maas.isEmpty() && tel.isEmpty() && email.isEmpty() && adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_sifre LIKE '%"+sifre+"%' ORDER BY kisi_id DESC ";   
		}
		else if(ad.isEmpty() &&  soyad.isEmpty() && !otel.isEmpty() && kullaniciadi.isEmpty() && sifre.isEmpty() && !maas.isEmpty() && tel.isEmpty() && email.isEmpty() && adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_maas LIKE '%"+maas+"%' ORDER BY kisi_id DESC "; 
		}
		else if(ad.isEmpty() &&  soyad.isEmpty() && !otel.isEmpty() && kullaniciadi.isEmpty() && sifre.isEmpty() && maas.isEmpty() && !tel.isEmpty() && email.isEmpty() && adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_tel LIKE '%"+tel+"%' ORDER BY kisi_id DESC ";  
		}
		else if(ad.isEmpty() &&  soyad.isEmpty() && !otel.isEmpty() && kullaniciadi.isEmpty() && sifre.isEmpty() && maas.isEmpty() && tel.isEmpty() && !email.isEmpty() && adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_email LIKE '%"+email+"%' ORDER BY kisi_id DESC ";       
		}
		else if(ad.isEmpty() &&  soyad.isEmpty() && !otel.isEmpty() && kullaniciadi.isEmpty() && sifre.isEmpty() && maas.isEmpty() && tel.isEmpty() && email.isEmpty() && !adres.isEmpty() )
		{
			query ="SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
	        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
	        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
	        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE kisi_vtdurum='1' AND kisi_adres LIKE ='%"+adres+"%' ORDER BY kisi_id DESC ";      
		}
	
		
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Ad");
		dm.addColumn("Soyad");
		dm.addColumn("Otel");
		dm.addColumn("Adres");
		dm.addColumn("Tel");
		dm.addColumn("Email");
		dm.addColumn("KullaniciAdi");
		dm.addColumn("Sifre");
		dm.addColumn("Yetki");
		dm.addColumn("Maas");
		dm.addColumn("Vtdurum");
		dm.addColumn("Id");		
    
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				String kisi_id = rs.getString(1);
			     String kisi_ad=rs.getString(2);
			     String kisi_soyad=rs.getString(3);
			     String kisi_kullaniciadi=rs.getString(4);
			     String kisi_sifre=rs.getString(5);
			     String kisi_yetki=rs.getString(6);
			     String kisi_maas=rs.getString(7);
			     String kisi_adres=rs.getString(8);
			     String kisi_tel=rs.getString(9);
			     String kisi_email=rs.getString(10);
			     String kisi_vtdurum=rs.getString(11);
			     String kisi_otelad=rs.getString(12);
			     String kisi_sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{kisi_sira,kisi_ad,kisi_soyad,kisi_otelad,kisi_adres,kisi_tel,kisi_email,kisi_kullaniciadi,kisi_sifre,kisi_yetki,kisi_maas,kisi_vtdurum,kisi_id});
				  sirasayaci++;

			}
			
			table.setModel(dm);
		    table.getColumnModel().getColumn(11).setMinWidth(0);
		    table.getColumnModel().getColumn(11).setMaxWidth(0);
		    table.getColumnModel().getColumn(12).setMinWidth(0);
		    table.getColumnModel().getColumn(12).setMaxWidth(0);
		    
		    if(table.getRowCount()>0)
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


