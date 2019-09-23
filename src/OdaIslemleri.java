import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class OdaIslemleri {
	
	
	static GirisYapanKullaniciBilgileri kullanici_bilgileri = new GirisYapanKullaniciBilgileri();

	
	
	public static boolean KayitlariCek(DefaultTableModel dm, JTable table) {
		// TODO Auto-generated method stub
		Boolean sonuc=false;
		
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Numara");
		dm.addColumn("Fiyat");
		dm.addColumn("Durum");
		dm.addColumn("Tür");
		dm.addColumn("Vtdurum");
		dm.addColumn("Id");	
		
        String query = "SELECT O.oda_id,O.oda_numara,O.oda_gunlukfiyat,O.oda_durum,O.oda_vtdurum,T.odakategori_ad FROM oda O inner join odakategori T on T.odaKategori_id=O.odaKategori_id  WHERE O.oda_vtdurum='1' AND O.otel_id='"+kullanici_bilgileri.getOtelId()+"' "; //AND otel_id='"+GirisYapanKullaniciBilgileri.otelId+"'           
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			DB.getInstance();
			rs = DB.getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				 String id = rs.getString(1);
			     String numara=rs.getString(2);
			     String fiyat=rs.getString(3);			     
			     String durum=rs.getString(4);
			     String vtdurum=rs.getString(5);
			     String oda_kategori=rs.getString(6);
			     String sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{sira,numara,fiyat,durum,oda_kategori,vtdurum,id});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 table.getColumnModel().getColumn(5).setMinWidth(0);
			table.getColumnModel().getColumn(5).setMaxWidth(0); 
			 table.getColumnModel().getColumn(6).setMinWidth(0);
				table.getColumnModel().getColumn(6).setMaxWidth(0); 
			   
		    
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
	
	public static boolean  OdaEkle(String numara, String fiyat,String durum,  String tur, String vtdurum,String otel_id) 
	{
			boolean sonuc = false;
			String numara_kontrol="";
			String query_kontrol ="SELECT oda_numara FROM oda WHERE oda_numara='"+numara+"' AND oda_vtdurum='1'";

			String query ="INSERT INTO oda(oda_numara,oda_gunlukfiyat,oda_durum,odaKategori_id,oda_vtdurum,otel_id) values('"+numara+"','"+fiyat+"','"+durum+"','"+tur+"','"+vtdurum+"','"+otel_id+"')";
			
			try 
				{
					DB.getInstance().BaglantiyiAc();
					ResultSet rs = DB.getResultSet(query_kontrol);
					while(rs.next())
					{
						numara_kontrol = rs.getString(1);
						
					}
					if(!numara_kontrol.equals(numara))
					{
						DB.getInstance();
						DB.runQuery(query);
						JOptionPane.showMessageDialog(null,"Oda Ekleme İşlemi Başarılı!!");
						sonuc=true;
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Kayıtlı Olmayan Bir Oda Giriniz!!");
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
	
	public static boolean cbTurYukle(JComboBox<String> cbTur)
	{
		boolean sonuc = false;
		
		if(cbTur.getItemCount()>0)
		{
			cbTur.removeAllItems();
			OdaIslemleri.cbTurYukle(cbTur);
			cbTur.setSelectedIndex(0);
			sonuc=true;
		}
		else
		{
			if(cbTur.getItemCount()==0)
			{
				String query="SELECT odaKategori_id ,odaKategori_ad FROM odaKategori";
				try 
				{
					DB.getInstance().BaglantiyiAc();
					DB.getInstance();
					ResultSet rs = 	DB.getResultSet(query);
					while(rs.next())
					{
						cbTur.addItem(rs.getString(2));
						
					}
					if(cbTur.getItemCount()>0)
					{
						sonuc=true;
						cbTur.setSelectedIndex(0);
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
	
	public static  boolean AlanlariTemizle(JTextField txNumara, JTextField txFiyat, JComboBox<?> cbDurum, JComboBox<?> cbTur)
	{
		boolean sonuc=false;
		
		txNumara.setText("");
		txFiyat.setText("");
		cbDurum.setSelectedItem("");
		cbTur.setSelectedItem("");
		
		
		
		
		if(		txNumara.getText().isEmpty() &&  txFiyat.getText().isEmpty() 
		  )
		{
			sonuc=true;
		}
		
		// TODO Auto-generated method stub
		return sonuc;
	}
	
	public static boolean AlanKontrolu(String numara, String fiyat,String durum, String tur) 
	{
		boolean sonuc = false;
		
		if(	!numara.isEmpty() && !fiyat.isEmpty() &&
				 
				!durum.isEmpty() && !tur.isEmpty()
				 
				)
			
			
		{
			sonuc=true;
		}
		else
		{
			JOptionPane.showMessageDialog(null," LÃ¼tfen BoÃ¾ AlanlarÃ½ Doldurup Tekrar Deneyiniz");
		}
		
		
		// TODO Auto-generated method stub
		return sonuc;
	}	
	
	public static boolean TurIdCek(JComboBox cbTur,String[] odaKategori_id) 
	{	
		boolean sonuc = false;
		
		//OdaIslemleri.cbTurYukle(cbTur);
		
		
		
		
		String tur_ad = cbTur.getSelectedItem().toString();
		String query="select odaKategori_id from odakategori where odaKategori_ad='"+tur_ad+"'";
		try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs=DB.getInstance().getResultSet(query);

			while(rs.next())
			{
				//lblTur.setText(rs.getString(1));
				odaKategori_id[0]=rs.getString(1);
				
				
			}
			if(odaKategori_id.length>0)
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
		return sonuc;
	}
	
	public static boolean OdaSil(String oda_id) 
	{
		
		boolean sonuc=false;
		
		if(Fonksiyonlar.BosDegilse(oda_id))
		{
			String query = "update oda SET oda_vtdurum=0 WHERE oda_id='"+oda_id+"'";
			try
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				JOptionPane.showMessageDialog(null,"Oda Silme İşlemi Başarılı!");
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
	
	public static boolean OdaGuncelle(String id,String numara, String fiyat,String durum,  String tur, String vtdurum) 
	{
		
		boolean sonuc =false;
		String query="update oda set oda_numara='"+numara+"',oda_gunlukfiyat='"+fiyat+"',oda_durum='"+durum+"',odaKategori_id='"+tur+"',oda_vtdurum='"+vtdurum+"' where  oda_id='"+id+"'";
		
			try 
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				  JOptionPane.showMessageDialog(null,"Oda Güncelleme İşlemi Başarılı!");
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
