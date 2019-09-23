import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class GeriBildirimIslemleri {

	GirisYapanKullaniciBilgileri girisyapanKullanici = new GirisYapanKullaniciBilgileri();
	
	public boolean KayitlariCek(DefaultTableModel dm, JTable table ) {
		// TODO Auto-generated method stub
		 
	 int otelid = Integer.parseInt(girisyapanKullanici.getOtelId());
	 System.out.print(otelid);
			 
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Temizlik");
		dm.addColumn("Konfor");		 
		dm.addColumn("Urun Kalitesi");
		dm.addColumn("Hizmet Kalitesi");
		dm.addColumn("Yemek Kalitesi");
		dm.addColumn("Not");
		dm.addColumn("Tarih");		 
		dm.addColumn("rezId");
		dm.addColumn("geriBilId");
		
        String query = "SELECT geribildirim_id,geribildirim.rezervasyon_id, geribildirim_temizlik, geribildirim_konfor,geribildirim_urunkalitesi,geribildirim_hizmetkalitesi,geribildirim_yemekkalitesi, geribildirim_not, geribildirim_tarih, geribildirim_vtdurum,rz.oda_id ,od.otel_id FROM geribildirim INNER JOIN rezervasyon rz ON geribildirim.rezervasyon_id = rz.rezervasyon_id INNER JOIN oda od on od.oda_id=rz.oda_id where od.otel_id="+otelid+"";            
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
				 String geriBilId = Integer.toString(rs.getInt(1));
			     String rezId=Integer.toString(rs.getInt(2));
			     String temizlik=Integer.toString(rs.getInt(3));			     
			     String konfor=Integer.toString(rs.getInt(4));
			     String urun_kalitesi=Integer.toString(rs.getInt(5));
			     String hizmet_kalitesi=Integer.toString(rs.getInt(6));
			     String yemek_kalitesi=Integer.toString(rs.getInt(7));			     
			     String not = rs.getString(8);
			     String tarih = rs.getString(9).toString();
			     String vtdurum =Integer.toString(rs.getInt(10));	
			     String sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{sira,temizlik,konfor,urun_kalitesi,hizmet_kalitesi,yemek_kalitesi,not,tarih,geriBilId,rezId});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 table.getColumnModel().getColumn(9).setMinWidth(0);
			 table.getColumnModel().getColumn(9).setMaxWidth(0); 
			 table.getColumnModel().getColumn(8).setMinWidth(0);
			 table.getColumnModel().getColumn(8).setMaxWidth(0); 
		   
			 DB.getInstance().BaglantiyiKapat(null, null);
		    	return true;
	        
		} 
        catch (ClassNotFoundException | SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
         
     
		
	}
	public boolean GeriBildirimEkle(int rezervasyon_id,int geribildirim_temizlik,int geribildirim_konfor,int geribildirim_urunkalitesi,int geribildirim_hizmetkalitesi,int geribildirim_yemekkalitesi, String geribildirim_not,String geribildirim_tarih) 
	{
			boolean sonuc = false;

			String query ="INSERT INTO geribildirim(rezervasyon_id, geribildirim_temizlik, geribildirim_konfor,geribildirim_urunkalitesi,geribildirim_hizmetkalitesi,geribildirim_yemekkalitesi, geribildirim_not, geribildirim_tarih, geribildirim_vtdurum)  values('"+rezervasyon_id+"','"+geribildirim_temizlik+"','"+geribildirim_konfor+"','"+geribildirim_urunkalitesi+"','"+geribildirim_hizmetkalitesi+"','"+geribildirim_yemekkalitesi+"','"+geribildirim_not+"','"+geribildirim_tarih+"',1)";
			
			try 
				{
					DB.getInstance().BaglantiyiAc();
					DB.getInstance().runQuery(query);
					JOptionPane.showMessageDialog(null,"Geri Bildirim Ekleme Ýþlemi Baþarýlý");
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
	public boolean GeriBildirimSil(int geriBildirimID) 
	{
		
		
		
		if(geriBildirimID>0)
		{
			String query = "update geribildirim SET geribildirim_vtdurum=0 WHERE geribildirim_id="+geriBildirimID+"";
			try
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				JOptionPane.showMessageDialog(null,"Geri Bildirim Silme Ýþlemi Baþarýlý");
				return true;

			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
		}
		else {return false;}
			
		 
	 
	} 
	public boolean GeriBildirimGuncelle(int geriBildirimID,int geribildirim_temizlik,int geribildirim_konfor,int geribildirim_urunkalitesi,int geribildirim_hizmetkalitesi,int geribildirim_yemekkalitesi, String geribildirim_not,String geribildirim_tarih) {
		
		String query="update geribildirim set geribildirim_temizlik="+geribildirim_temizlik+",geribildirim_konfor="+geribildirim_konfor+",geribildirim_urunkalitesi="+geribildirim_urunkalitesi+",geribildirim_hizmetkalitesi="+geribildirim_hizmetkalitesi+",geribildirim_yemekkalitesi="+geribildirim_yemekkalitesi+",geribildirim_not='"+geribildirim_not+"' ,geribildirim_tarih='"+geribildirim_tarih+"' where  geribildirim_id="+geriBildirimID+"";
		
		try 
		{
			DB.getInstance().BaglantiyiAc();
			DB.getInstance().runQuery(query);
		    JOptionPane.showMessageDialog(null,"Geri Bildirim Güncelleme Ýþlemi Baþarýlý");
			 return true;
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
      
		
		 
	};
	public boolean GeriBildirimAra(DefaultTableModel dm, JTable table,Object geribildirim_temizlik,Object geribildirim_konfor,Object geribildirim_urunkalitesi,Object geribildirim_hizmetkalitesi,Object geribildirim_yemekkalitesi,String geribildirim_tarih)
	{
		boolean sonuc ;
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Temizlik");
		dm.addColumn("Konfor");		 
		dm.addColumn("Urun Kalitesi");
		dm.addColumn("Hizmet Kalitesi");
		dm.addColumn("Yemek Kalitesi");
		dm.addColumn("Not");
		dm.addColumn("Tarih");		 
		dm.addColumn("rezId");
		dm.addColumn("geriBilId");
		
		
		
		String query = "SELECT * from geribildirim where geribildirim_vtdurum= 1 AND geribildirim_temizlik LIKE   "+(!geribildirim_temizlik.equals("Seciniz") ?   geribildirim_temizlik : "'%%'")+ " AND geribildirim_konfor LIKE "+(!geribildirim_konfor .equals("Seciniz") ? geribildirim_konfor :"'%%'")+" AND geribildirim_urunkalitesi LIKE "+(!geribildirim_urunkalitesi .equals("Seciniz") ? geribildirim_urunkalitesi :"'%%'")+" AND geribildirim_hizmetkalitesi LIKE "+(!geribildirim_hizmetkalitesi .equals("Seciniz") ? geribildirim_hizmetkalitesi :"'%%'")+" AND geribildirim_yemekkalitesi LIKE "+(!geribildirim_yemekkalitesi .equals("Seciniz") ? geribildirim_yemekkalitesi :"'%%'")+" AND geribildirim_tarih LIKE '"+(geribildirim_tarih ==null ? "%%" : geribildirim_tarih )+"'";
		try {
			  
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
		 
			 
			int sirasayaci=1;
			while (rs.next()) 
			{
				 String geriBilId = Integer.toString(rs.getInt(1));
			     String rezId=Integer.toString(rs.getInt(2));
			     String temizlik=Integer.toString(rs.getInt(3));			     
			     String konfor=Integer.toString(rs.getInt(4));
			     String urun_kalitesi=Integer.toString(rs.getInt(5));
			     String hizmet_kalitesi=Integer.toString(rs.getInt(6));
			     String yemek_kalitesi=Integer.toString(rs.getInt(7));			     
			     String not = rs.getString(8);
			     String tarih = rs.getString(9).toString();
			     String vtdurum =Integer.toString(rs.getInt(10));	
			     String sira =Integer.toString(sirasayaci);
			     dm.addRow(new String[]{sira,temizlik,konfor,urun_kalitesi,hizmet_kalitesi,yemek_kalitesi,not,tarih,geriBilId,rezId});
				 sirasayaci++;

			}
			
			table.setModel(dm);
			 table.getColumnModel().getColumn(9).setMinWidth(0);
			 table.getColumnModel().getColumn(9).setMaxWidth(0); 
			 table.getColumnModel().getColumn(8).setMinWidth(0);
			 table.getColumnModel().getColumn(8).setMaxWidth(0); 
		   
		    
		    sonuc=true;
	 
			 
	        
		} 
        catch (ClassNotFoundException | SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sonuc=false;
			 
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
	public boolean componentKontrol(ArrayList<JComboBox> comboListe,JDateChooser date,TextArea not) {
		
		for (JComboBox jComboBox : comboListe) {
			
			if((jComboBox.getSelectedIndex()==0)) {return false;}
		}
		
		if(date.getDate()==null || not.getText().equals("")) {return false;}
		
		 
		
		
		return true;
		
	}
	public boolean componentTemizle(ArrayList<JComboBox> comboListe,JDateChooser date,TextArea not) {
		
		for (JComboBox jComboBox : comboListe) {
			
			if((jComboBox.getSelectedIndex()>0)) {jComboBox.setSelectedIndex(0);}
			
		}
		
		date.setDate(null);
		not.setText(null);
		
		
		
		return true;
		
	}
	 

}
