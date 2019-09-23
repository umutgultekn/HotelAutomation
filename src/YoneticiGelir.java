import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class YoneticiGelir {
	
	
	static GirisYapanKullaniciBilgileri bilgiler = new GirisYapanKullaniciBilgileri();
	
	public static boolean OtelKayitlariCek(DefaultTableModel dm, JTable table) {
		// TODO Auto-generated method stub
		Boolean sonuc=false;
		
		dm = new DefaultTableModel();
		dm.addColumn("Id");
		dm.addColumn("Otel");
		dm.addColumn("Id");
		
        String query = "SELECT otel_id,otel_ad FROM otel WHERE  otel_vtdurum='1' ";         
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			DB.getInstance();
			rs = DB.getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				 String id = rs.getString(1);
			     
			     String otel_ad=rs.getString(2);
			     String sira =Integer.toString(sirasayaci);
			     
			     dm.addRow(new String[]{sira,otel_ad,id});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 table.getColumnModel().getColumn(2).setMinWidth(0);
			 table.getColumnModel().getColumn(2).setMaxWidth(0); 
		   
		    
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
	
	public  static float GiderveriAl(String vtdurum,String otel_id) {
		       
        
        float toplam=0;


        String query="";
        
  /*      if(!otel_id.equals("0"))
        {
         query = "SELECT SUM(rezervasyon_ucret) FROM rezervasyon WHERE otel_id='"+otel_id+"' rezervasyon_vtdurum='1' AND  rezervasyon_tarihi  BETWEEN '"+baslangic+"'AND '"+bitis+"'"; 

        }
        else
        {
        	query = "SELECT SUM(kisi_maas) FROM kisi WHERE kisi_vtdurum='"+vtdurum+"'"; 
      }
        */
        if(otel_id.equals("0"))
    	{
			JOptionPane.showMessageDialog(null,"0");
        	query = "SELECT SUM(kisi_maas) FROM kisi WHERE  kisi_vtdurum='"+vtdurum+"'"; 

    	}
    	else
    	{
        	query = "SELECT SUM(K.kisi_maas) FROM kisi K inner join otel O on K.otel_id=O.otel_id WHERE O.otel_id='"+otel_id+"' AND kisi_vtdurum='"+vtdurum+"'"; 

    	}
        
        try {
        	
        	
        		DB.getInstance().BaglantiyiAc();
        		ResultSet rs;
        		DB.getInstance();
        		rs = DB.getResultSet(query);

            
        
           
          
            while (rs.next()) {
             
              toplam = Float.parseFloat(rs.getString(1));
  
            }

            return toplam;

        }
        catch (ClassNotFoundException | SQLException e) 
        {
			
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
				
				e.printStackTrace();
			}
        }
		return toplam;
    
        	
	
	
	
	
	
	
   

	
}

	public static float GelirveriAl(String baslangic,String bitis,String otel_id) {
   

    float toplam=0;

    String query="";
    
  /*  if(!otel_id.equals("0"))
    {
     query = "SELECT SUM(rezervasyon_ucret) FROM rezervasyon WHERE otel_id='"+otel_id+"' rezervasyon_vtdurum='1' AND  rezervasyon_tarihi  BETWEEN '"+baslangic+"'AND '"+bitis+"'"; 

    }
    else
    {*/

    	if(otel_id.equals("0"))
    	{
			JOptionPane.showMessageDialog(null,"Lütfen Otel Seçiniz!");
        	//query = "SELECT SUM(rezervasyon_ucret) FROM rezervasyon  WHERE  rezervasyon_vtdurum='1' AND  rezervasyon_tarihi  BETWEEN '"+baslangic+"'AND '"+bitis+"'";

    	}
    	else
    	{
        	query = "SELECT SUM(R.rezervasyon_ucret) FROM rezervasyon R inner join otel O on R.otel_id=O.otel_id WHERE O.otel_id='"+otel_id+"' AND rezervasyon_vtdurum='1' AND  rezervasyon_tarihi  BETWEEN '"+baslangic+"'AND '"+bitis+"'";

    	}
    	
    	
   // }
   
    
    try {
    	
    	DB.getInstance().BaglantiyiAc();
		ResultSet rs;
		DB.getInstance();
		rs = DB.getResultSet(query);

        
        while (rs.next()) {
            
          toplam = Float.parseFloat(rs.getString(1));
          
           
            
            
        }

        return toplam;

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    finally 
    {
    	try 
    	{
			DB.getInstance().BaglantiyiKapat(null, null);
		} 
    	catch (SQLException e) 
    	{
			
			e.printStackTrace();
		}
    }
	return toplam;

}

	
	
}