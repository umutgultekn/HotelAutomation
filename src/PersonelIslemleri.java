import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PersonelIslemleri {

	static GirisYapanKullaniciBilgileri k_bilgiler = new GirisYapanKullaniciBilgileri();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	public static Object KayitlariCek(DefaultTableModel dm, JTable table)
	{
		Boolean sonuc=false;
		
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Ad");
		dm.addColumn("Soyad");
		dm.addColumn("KullaniciAdi");
		dm.addColumn("Sifre");
		dm.addColumn("Yetki");
		dm.addColumn("Maas");
		dm.addColumn("Adress");
		dm.addColumn("Tel");
		dm.addColumn("Email");
		dm.addColumn("Vtdurum");
		dm.addColumn("Otel");
		dm.addColumn("Id");		
        String query = "SELECT K.kisi_id,K.kisi_ad,K.kisi_soyad,"
        		+ "K.kisi_kullaniciadi,K.kisi_sifre,K.kisi_yetki,"
        		+ "K.kisi_maas,K.kisi_adres,K.kisi_tel,"
        		+ "K.kisi_email,K.kisi_vtdurum,O.otel_ad FROM kisi K inner join otel O on K.otel_Id=O.otel_Id  WHERE  k.otel_id='"+k_bilgiler.getOtelId()+"' AND  kisi_vtdurum='1' AND kisi_yetki IN('resepsiyonist','katGorevlisi') ";            
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
			     String otelid=rs.getString(12);
			     String sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{sira,ad,soyad,kullaniciadi,sifre,yetki,maas,adres,tel,email,vtdurum,otelid,id});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 
		    table.getColumnModel().getColumn(12).setMinWidth(0);
		    table.getColumnModel().getColumn(12).setMaxWidth(0);
		    
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
	
	public static boolean  PersonelEkle(String ad, String soyad, String kullaniciadi, String sifre,String yetki, String maas,String adres,  String tel,String email, String vtdurum) 
	{
			boolean sonuc = false;

			String query ="INSERT INTO kisi(kisi_ad,kisi_soyad,kisi_kullaniciadi,kisi_sifre,kisi_yetki,kisi_maas,kisi_adres,kisi_tel,kisi_email,kisi_vtdurum,otel_id) values('"+ad+"','"+soyad+"','"+kullaniciadi+"','"+sifre+"','"+yetki+"','"+maas+"','"+adres+"','"+tel+"','"+email+"','"+vtdurum+"','"+k_bilgiler.getOtelId()+"')";
			
			try 
				{
					DB.getInstance().BaglantiyiAc();
					DB.getInstance().runQuery(query);
					JOptionPane.showMessageDialog(null,"Personel Ekleme Ýþlemi Baþarýlý");
					sonuc=true;
					//buraya kadar hata olmazsa ekleme baþarýlýdýr zaten sonuc =true kullan
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
	
	public static boolean AlanKontrolu(String ad, String soyad, String yetki, String kullaniciadi, String sifre, String maas,
			String tel, String email, String adres,String otelID) 
	{
		boolean sonuc = false;
		
		if(	!ad.isEmpty() && !soyad.isEmpty() &&
				!yetki.isEmpty() && !kullaniciadi.isEmpty() && 
				!sifre.isEmpty() && !maas.isEmpty()  &&
				!tel.isEmpty() && !email.isEmpty()
				&& !adres.isEmpty()&& !otelID.isEmpty()
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
	
	public static  boolean AlanlariTemizle(JTextField txAdi, JTextField txSoyadi, JComboBox cbYetki, JTextField txKullaniciAdi,
			 JPasswordField txSifre,JTextField txEmail,JTextField txAdres,JTextField txTel,JTextField txMaas,JComboBox cbOtel)
	{
		boolean sonuc=false;
		
		txAdi.setText(null);
		txSoyadi.setText(null);
		txKullaniciAdi.setText(null);
		txAdres.setText(null);
		txTel.setText(null);
		txMaas.setText(null);
		txSifre.setText(null);
		txEmail.setText(null);
		cbYetki.setSelectedItem(null);
		cbOtel.setSelectedItem(null);
		
		
		if(		txAdi.getText().isEmpty() &&  txSoyadi.getText().isEmpty()  && 
				txKullaniciAdi.getText().isEmpty() && txSifre.getText().isEmpty() && txAdres.getText().isEmpty()  &&
				txTel.getText().isEmpty() && txMaas.getText().isEmpty() && txEmail.getText().isEmpty() && cbYetki.getSelectedItem()==null&& cbYetki.getSelectedItem()==null
		  )
		{
			sonuc=true;
		}
		
		// TODO Auto-generated method stub
		return sonuc;
	}
	
	public static boolean PersonelSil(String kisi_id) 
	{
		
		boolean sonuc=false;
		
		if(Fonksiyonlar.BosDegilse(kisi_id))
		{
			String query = "update kisi SET kisi_vtdurum=0 WHERE kisi_id='"+kisi_id+"'";
			try
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				JOptionPane.showMessageDialog(null,"Personel Silme Ýþlemi Baþarýlý");
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
	
	public static boolean MudurYetki(JComboBox cbYetki) {
		
		boolean sonuc=false;
		
		String query="SELECT yetki_id ,yetki_adi FROM yetki";
		
		cbYetki.removeAllItems();
		try 
		{
			DB.getInstance().BaglantiyiAc();
			ResultSet rs = 	DB.getInstance().getResultSet(query);
			while(rs.next())
			{
				if(!rs.getString(2).equals("mudur") && !rs.getString(2).equals("yonetici"))
				cbYetki.addItem(rs.getString(2));
			}
			sonuc=true;
			return sonuc;
			 
		} catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sonuc;
		
	}

	public static boolean PersonelGuncelle(String id,String ad, String soyad, String kullaniciadi, String sifre,String yetki, String maas,String adres,  String tel,String email, String vtdurum,String otel_id) 
	{
		
		boolean sonuc =false;
		String query="update kisi set kisi_ad='"+ad+"',kisi_soyad='"+soyad+"',kisi_kullaniciadi='"+kullaniciadi+"',kisi_sifre='"+sifre+"',kisi_yetki='"+yetki+"',kisi_maas='"+maas+"',kisi_adres='"+adres+"',kisi_tel='"+tel+"',kisi_email='"+email+"',otel_id='"+otel_id+"',kisi_vtdurum='"+vtdurum+"' where  kisi_id='"+id+"'";
		
			try 
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				  JOptionPane.showMessageDialog(null,"Personel Güncelleme Ýþlemi Baþarýlý");
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

	public static boolean PersonelAra(DefaultTableModel dm, JTable table,String ad, String soyad, String kullaniciadi,String email,String tel)
	{
		boolean sonuc=false;
		
		ad=!ad.equals("") ? ad :"%%";
		soyad=!soyad.equals("") ? soyad :"%%";
		kullaniciadi=!kullaniciadi.equals("") ? kullaniciadi :"%%";
		email=!email.equals("") ? email :"%%";
		tel=!tel.equals("") ? tel :"%%";
		
		String query="SELECT * FROM kisi where kisi_ad  LIKE '"+ad+"'and kisi_soyad LIKE '"+soyad+"' and kisi_kullaniciadi LIKE '"+kullaniciadi+"' and kisi_email LIKE '"+email+"' and kisi_tel LIKE '"+tel+"' and kisi_yetki IN ('katgorevlisi','resepsiyonist')";
		 
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Ad");
		dm.addColumn("Soyad");
		dm.addColumn("KullaniciAdi");
		dm.addColumn("Sifre");
		dm.addColumn("Yetki");
		dm.addColumn("Maas");
		dm.addColumn("Adress");
		dm.addColumn("Tel");
		dm.addColumn("Email");
		dm.addColumn("Vtdurum");
		dm.addColumn("Otel");
		dm.addColumn("Id");		
                   
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				 
			     dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),Integer.toString(sirasayaci)});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 
		    table.getColumnModel().getColumn(12).setMinWidth(0);
		    table.getColumnModel().getColumn(12).setMaxWidth(0);
		    
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
	
}