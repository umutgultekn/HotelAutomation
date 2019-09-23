import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MudurGelir {
	
static GirisYapanKullaniciBilgileri bilgiler = new GirisYapanKullaniciBilgileri();
	
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
