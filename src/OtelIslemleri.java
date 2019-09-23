import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class OtelIslemleri {

	
	public static boolean CbYildizYukle(JComboBox cbYildiz)
	{
		boolean sonuc = false;
		
		if(cbYildiz.getItemCount()>0)
		{
			cbYildiz.removeAllItems();
			OtelIslemleri.CbYildizYukle(cbYildiz);
			sonuc = true;

		}
		else
		{
			if(cbYildiz.getItemCount()==0)
			{
				for(int i=1;i<=8;i++)
				{
					cbYildiz.addItem(i);
				}
				if(cbYildiz.getItemCount()>0)
				{
					sonuc = true;
				}
			}
	
		}	
		// TODO Auto-generated method stub
		return sonuc;
	}

	
	public static boolean BosAlanKontrolu(String ad, String il, String ilce, String adres, String tel, String yildiz)
	{
		boolean sonuc = false;
		if(	!ad.isEmpty() && !il.isEmpty() && !ilce.isEmpty() && !adres.isEmpty() && !tel.isEmpty() && !yildiz.isEmpty())
		{
			sonuc=true;
		}
		else
		{
			JOptionPane.showMessageDialog(null," Lütfen Boş Alanları Doldurup Tekrar Deneyiniz");
		}	
		// TODO Auto-generated method stub
		return sonuc;
	}
	
		
	public static  boolean AlanlariTemizle(JTextField txAdi, JTextField txIl, JTextField txIlce, JTextField txAdres,
			JTextField txTel, JComboBox cbYildiz)
	{
		boolean sonuc=false;
		
		txAdi.setText(null);
		txIl.setText(null);
		txIlce.setText(null);
		txAdres.setText(null);
		txTel.setText(null);
		cbYildiz.setSelectedItem(null);
		
		
		if(		txAdi.getText().isEmpty() &&  txIl.getText().isEmpty()  && 
				txIlce.getText().isEmpty()  &&	txAdres.getText().isEmpty()  &&
				txTel.getText().isEmpty() 
		  )
		{
			sonuc=true;
		}
		
		// TODO Auto-generated method stub
		return sonuc;
	}


	public static boolean  OtelEkle(String otel_ad, String otel_il, String otel_ilce, String otel_adres, String otel_tel, String otel_yildiz, String otel_vtdurum) 
	{
			boolean sonuc = false;
			
			String otel_ad_kontrol="";
			String query_kontrol ="SELECT otel_ad FROM otel WHERE otel_ad='"+otel_ad+"' AND otel_vtdurum='1'";

			String query="INSERT INTO otel(otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum) values('"+otel_ad+"','"+otel_il+"','"+otel_ilce+"','"+otel_adres+"','"+otel_tel+"','"+otel_yildiz+"','"+otel_vtdurum+"')";
				try 
				{
					DB.getInstance().BaglantiyiAc();
					ResultSet rs = DB.getResultSet(query_kontrol);
					while(rs.next())
					{
						otel_ad_kontrol = rs.getString(1);
					}
					if(!otel_ad_kontrol.equals(otel_ad))
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
	}


	public static boolean KayitlariCek(DefaultTableModel dm, JTable table) 
	{
		boolean sonuc = false;
		
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Ad");
		dm.addColumn("İl");
		dm.addColumn("İlçe");
		dm.addColumn("Adres");
		dm.addColumn("Tel");
		dm.addColumn("Yildiz");
		dm.addColumn("Vtdurum");
		dm.addColumn("Id");
	
		
        String query = "SELECT otel_id,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum FROM otel  WHERE otel_vtdurum='1' ORDER BY otel_id DESC ";       
      
        try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs;
			rs = DB.getInstance().getResultSet(query);
			int sirasayaci=1;
			while (rs.next()) 
			{
		          String otel_id = rs.getString(1);
		          String otel_ad=rs.getString(2);
		          String otel_il=rs.getString(3);
		          String otel_ilce=rs.getString(4);
		          String otel_adres=rs.getString(5);
		          String otel_tel=rs.getString(6);
		          String otel_yildiz=rs.getString(7);
		          String otel_vtdurum=rs.getString(8);
		          String sira =Integer.toString(sirasayaci);
		          dm.addRow(new String[]{sira,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum,otel_id});
				  sirasayaci++;

			}
			
			table.setModel(dm);
		    table.getColumnModel().getColumn(7).setMinWidth(0);
		    table.getColumnModel().getColumn(7).setMaxWidth(0);
		    table.getColumnModel().getColumn(8).setMinWidth(0);
		    table.getColumnModel().getColumn(8).setMaxWidth(0);
	        
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

	
	public static boolean OtelSil(String id) {
		
		boolean sonuc=false;
		
		if(Fonksiyonlar.BosDegilse(id))
		{
			String query = "update otel SET otel_vtdurum=0 WHERE otel_id='"+id+"'";
			try
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				JOptionPane.showMessageDialog(null,"Otel Silme İşlemi Başarılı");
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


	public static boolean OtelGuncelle(String otel_id,String otel_ad, String otel_il, String otel_ilce, String otel_adres, String otel_tel, String otel_yildiz) 
	{
		boolean sonuc =false;
		
		
		String query="update otel set otel_ad='"+otel_ad+"',otel_il='"+otel_il+"',otel_ilce='"+otel_ilce+"',otel_adres='"+otel_adres+"',otel_tel='"+otel_tel+"',otel_yildiz='"+otel_yildiz+"' where otel_id='"+otel_id+"'";
		
			try 
			{
				DB.getInstance().BaglantiyiAc();
				DB.getInstance().runQuery(query);
				  JOptionPane.showMessageDialog(null,"Otel Güncelleme İşlemi Başarılı");
					sonuc=true;
			}
			catch (ClassNotFoundException | SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
	
		
		// TODO Auto-generated method stub
		return sonuc;
	}

	
	public static boolean OtelArama(DefaultTableModel dm,JTable table, String ad, String il, String ilce, String adres, String tel, String yildiz)	
	{
		boolean sonuc = false;
		String query="";
		
		
		
		if(!ad.isEmpty() &&  il.isEmpty() && ilce.isEmpty() && adres.isEmpty() && tel.isEmpty() && !yildiz.isEmpty()  )
		{
			query ="SELECT otel_id,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum FROM otel  WHERE otel_vtdurum='1' AND otel_ad LIKE '%"+ad+"%' ORDER BY otel_ad DESC";       
		}
		else if(ad.isEmpty() &&  !il.isEmpty() && ilce.isEmpty() && adres.isEmpty() && tel.isEmpty() && !yildiz.isEmpty()  )
		{
			query ="SELECT otel_id,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum FROM otel  WHERE otel_vtdurum='1' AND otel_il LIKE  '%"+il+"%' ORDER BY otel_il DESC";       
		}
		else if(ad.isEmpty() &&  il.isEmpty() && !ilce.isEmpty() && adres.isEmpty() && tel.isEmpty() && !yildiz.isEmpty()  )
		{
			query ="SELECT otel_id,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum FROM otel  WHERE otel_vtdurum='1' AND otel_ilce LIKE '%"+ilce+"%' ORDER BY otel_ilce DESC";       
		}
		else if(ad.isEmpty() &&  il.isEmpty() && ilce.isEmpty() && !adres.isEmpty() && tel.isEmpty() && !yildiz.isEmpty()  )
		{
			query ="SELECT otel_id,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum FROM otel  WHERE otel_vtdurum='1' AND otel_adres LIKE '%"+adres+"%' ORDER BY otel_adres DESC";       
		}
		else if(ad.isEmpty() &&  il.isEmpty() && ilce.isEmpty() && adres.isEmpty() && !tel.isEmpty() && !yildiz.isEmpty()  )
		{
			query ="SELECT otel_id,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum FROM otel  WHERE otel_vtdurum='1' AND otel_tel LIKE '%"+tel+"%' ORDER BY otel_tel DESC";       
		}
		else if(ad.isEmpty() &&  il.isEmpty() && ilce.isEmpty() && adres.isEmpty() && tel.isEmpty() && !yildiz.isEmpty()  )
		{
			query ="SELECT otel_id,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum FROM otel  WHERE otel_vtdurum='1' AND otel_yildiz LIKE '%"+yildiz+"%' ORDER BY otel_yildiz DESC";       
		}
		
	
		dm = new DefaultTableModel();
		dm.addColumn("Sira");
		dm.addColumn("Ad");
		dm.addColumn("İl");
		dm.addColumn("İlçe");
		dm.addColumn("Adres");
		dm.addColumn("Tel");
		dm.addColumn("Yildiz");
		dm.addColumn("Vtdurum");
		dm.addColumn("Id");
	
	
		

		  try {
				DB.getInstance().BaglantiyiAc();
				ResultSet rs;
				rs = DB.getInstance().getResultSet(query);
				int sirasayaci=1;
				while (rs.next()) 
				{
			          String otel_id = rs.getString(1);
			          String otel_ad=rs.getString(2);
			          String otel_il=rs.getString(3);
			          String otel_ilce=rs.getString(4);
			          String otel_adres=rs.getString(5);
			          String otel_tel=rs.getString(6);
			          String otel_yildiz=rs.getString(7);
			          String otel_vtdurum=rs.getString(8);
			          String sira =Integer.toString(sirasayaci);
			          dm.addRow(new String[]{sira,otel_ad,otel_il,otel_ilce,otel_adres,otel_tel,otel_yildiz,otel_vtdurum,otel_id});
					  sirasayaci++;

				}
				
				table.setModel(dm);
			    table.getColumnModel().getColumn(7).setMinWidth(0);
			    table.getColumnModel().getColumn(7).setMaxWidth(0);
			    table.getColumnModel().getColumn(8).setMinWidth(0);
			    table.getColumnModel().getColumn(8).setMaxWidth(0);
		        
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


	public static boolean cbOtelYukle(JComboBox cbOtel)
	{
		boolean sonuc = false;
		
		if(cbOtel.getItemCount()>0)
		{
			cbOtel.removeAllItems();
			OtelIslemleri.cbOtelYukle(cbOtel);
			cbOtel.setSelectedIndex(0);
			sonuc=true;
		}
		else
		{
			if(cbOtel.getItemCount()==0)
			{
				String query="SELECT otel_id ,otel_ad FROM otel where otel_vtdurum='1'";
				try 
				{
					DB.getInstance().BaglantiyiAc();
					ResultSet rs = 	DB.getInstance().getResultSet(query);
					while(rs.next())
					{
						cbOtel.addItem(rs.getString(2));
						
					}
					if(cbOtel.getItemCount()>0)
					{
						sonuc=true;
						cbOtel.setSelectedIndex(0);
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



	public static boolean cbOtelIdCek(JComboBox cbOtel,JLabel lblOtelId) 
	{	
		boolean sonuc = false;
		
		OtelIslemleri.cbOtelYukle(cbOtel);
		
		
		String secilen_otel = cbOtel.getSelectedItem().toString();
		String query="select otel_id from otel where otel_ad='"+secilen_otel+"'";
		try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs=DB.getInstance().getResultSet(query);

			while(rs.next())
			{
				lblOtelId.setText(rs.getString(1));
				if(!lblOtelId.getText().isEmpty())
				{
					sonuc=true;
				}
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


	
	
/*	public static boolean cbOtelAdCek(JComboBox cbOtel, String otelId)
	{
		boolean sonuc = false;
		
		String secilen_otel = cbOtel.getSelectedItem().toString();
		String query="select otel_ad from otel where otel_id='"+otelId+"'";
		try {
			DB.getInstance().BaglantiyiAc();
			ResultSet rs=DB.getInstance().getResultSet(query);

			while(rs.next())
			{
				cbOtel.addItem(rs.getString(1));
				  JOptionPane.showMessageDialog(null,rs.getString(1));

			}
			if(cbOtel.getItemCount()>0)
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

*/
	
}
