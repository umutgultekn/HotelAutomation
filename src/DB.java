import java.sql.*;

public class DB {
	
	//
	  private static final String jdbc_driver = "com.mysql.jdbc.Driver";  
	  private static final String db_url = "jdbc:mysql://localhost:3306/projeotelotomasyonu";	 
	  static final String user = "root";
	  static final String password = "";
	//
	   
	private static DB _db=null;
	private static Connection _con ;
	
	public static DB getInstance() 
	{
		if(_db==null)
		{
			_db = new DB(_con);

		}
		return _db;
	}
	public DB(Connection con)
	{
		_con=con;
	}
	public void BaglantiyiAc() throws SQLException, ClassNotFoundException 
	{
		 if(_con !=  null)
	          if( !_con.isClosed())
	              return;
		 
		 
/*		 E�ER DAHA ONCE BA�LANTI OLUSTURULMUSSA RETURN ILE METOTTAN CIKIYORUZ, E�ER BA�LANTI YOK ISE  YEN� B�R BA�LANTI KURUYORUZ
		dinamik olarak y�klenecek sinifin belirliyoruz.Yani  com paketinin i�indeki mysql paketinin i�indeki jdbc paketinin i�indeki Driver classini �alisma zamaninda �alistiriyoruz. 
		con = (Connection ) ����� satirinda ise baglantimizi kuruyoruz.
*/
		 
		 Class.forName(jdbc_driver);
		_con = (Connection) DriverManager.getConnection(db_url,user,password);
		 
	}
	public void BaglantiyiKapat(PreparedStatement prepared, ResultSet result) throws SQLException 
	   {
	     if(prepared != null)
	         prepared.close();
	     if(result != null)
	         prepared.close();
	     if(_con != null)
	         _con.close();
  }
	
	
	// SONUC KUMESI ALMAK ICIN
    public static ResultSet getResultSet(String query) throws SQLException {
        Connection con = _con;
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
       
        rs = st.executeQuery();
       return rs;
    }

    
    
	// GUNCELLEME, EKLEME� SILME SORGUSU
    public static void runQuery(String query) throws SQLException {
    	Connection con = _con;
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        st.executeUpdate();
    }
	
	
}
