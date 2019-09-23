import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class EsyaIslemleri {
	static String oda_id;
	static GirisYapanKullaniciBilgileri bilgiler = new GirisYapanKullaniciBilgileri();
	
	
	public static boolean KayitlariCek(DefaultTableModel dm, JTable table) {
		// TODO Auto-generated method stub
		Boolean sonuc=false;
		
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Eþya");
		dm.addColumn("Durum");
		dm.addColumn("Oda Numara");
		dm.addColumn("Vtdurum");
		dm.addColumn("Oda_id");
		dm.addColumn("Id");	
		
        String query = "SELECT O.oda_numara,E.esya_id,E.esya_adi,E.oda_id,E.esya_durum,E.esya_vtdurum FROM oda O inner join esya E on E.oda_id=O.oda_id  WHERE  E.esya_vtdurum='1'  ";           
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			DB.getInstance();
			rs = DB.getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				 String id = rs.getString(2);
			     String esya=rs.getString(3);
			     String durum=rs.getString(5);
			     String vtdurum=rs.getString(6);
			     String oda_numara=rs.getString(1);
			     oda_id=rs.getString(4);
			     String sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{sira,esya,durum,oda_numara,vtdurum,oda_id,id});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 table.getColumnModel().getColumn(4).setMinWidth(0);
			 table.getColumnModel().getColumn(4).setMaxWidth(0); 
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
	
	
	public static boolean OdaKayitlariCek(DefaultTableModel dm, JTable table) {
		// TODO Auto-generated method stub
		Boolean sonuc=false;
		
		dm = new DefaultTableModel();
		dm.addColumn("Sıra");
		dm.addColumn("Numara");
		dm.addColumn("OtelID");
		dm.addColumn("Id");
		
		
        String query = "SELECT oda_id,oda_numara,Oda.otel_id FROM oda Oda inner join otel O on Oda.otel_id=O.otel_id  WHERE Oda.otel_id='"+bilgiler.getOtelId()+"' AND oda_vtdurum='1' ";           
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			DB.getInstance();
			rs = DB.getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				 String oda_id = rs.getString(1);			     
			     String oda_numara=rs.getString(2);
			     String otel_id = rs.getString(3);			     
			     
		         String sira =Integer.toString(sirasayaci);

			     
			     dm.addRow(new String[]{sira,oda_numara,oda_id,otel_id});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			table.getColumnModel().getColumn(2).setMinWidth(0);
			 table.getColumnModel().getColumn(2).setMaxWidth(0);
			 table.getColumnModel().getColumn(3).setMinWidth(0);
			 table.getColumnModel().getColumn(3).setMaxWidth(0); 
		   
		    
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
	
	
	
	public static boolean  EsyaEkle(String esya, String durum,  String numara, String vtdurum) 
	{
			boolean sonuc = false;
			String numara_kontrol="";
			String query_kontrol ="SELECT oda_numara FROM oda WHERE oda_numara='"+numara+"' AND oda_vtdurum='1'";

			String query ="INSERT INTO esya(esya_adi,esya_durum,esya.oda_id,esya_vtdurum) values('"+esya+"','"+durum+"','"+numara+"','"+vtdurum+"')";
			
			try 
				{
					DB.getInstance().BaglantiyiAc();
					ResultSet rs = DB.getResultSet(query_kontrol);
					while(rs.next())
					{
						numara_kontrol = rs.getString(1);
						
					}
				
						DB.getInstance();
						DB.runQuery(query);
						JOptionPane.showMessageDialog(null,"Eþya Ekleme Ýþlemi Baþarýlý!!");
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
	
	public static  boolean AlanlariTemizle(JTextField txEsya, JTextField txDurum, JTextField txNumara)
	{
		boolean sonuc=false;
		
		txEsya.setText("");
		txDurum.setText("");
		txNumara.setText("");
		
		
		
		
		if(		txEsya.getText().isEmpty() &&  txDurum.getText().isEmpty() &&  txNumara.getText().isEmpty()
		  )
		{
			sonuc=true;
		}
		
		// TODO Auto-generated method stub
		return sonuc;
	}
	
	public static boolean AlanKontrolu(String esya, String durum, String numara) 
	{
		boolean sonuc = false;
		
		if(	!numara.isEmpty() && !esya.isEmpty() &&
				 
				!durum.isEmpty()
				 
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
	
	public static boolean EsyaSil(String esya_id) 
	{
		
		boolean sonuc=false;
		
		if(Fonksiyonlar.BosDegilse(esya_id))
		{
			String query = "update esya SET esya_vtdurum=0 WHERE esya_id='"+esya_id+"'";
			try
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				JOptionPane.showMessageDialog(null,"Esya Silme Ýþlemi Baþarýlý!");
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
	
	public static boolean EsyaGuncelle(String id,String esya, String oda_id,String durum, String vtdurum) 
	{
		
		boolean sonuc =false;
		String query="update esya set esya_adi='"+esya+"',esya_durum='"+durum+"',oda_id='"+oda_id+"',esya_vtdurum='"+vtdurum+"' where  esya_id='"+id+"'";
		
			try 
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				  JOptionPane.showMessageDialog(null,"Esya Güncelleme Ýþlemi Baþarýlý!");
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
