package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	private static final String USUARIO = "root";
    private static final String SENHA = "TH@1098a";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/primeiroapp";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private Connection conn;
     
   	public Connection getConn() {
		return conn;
	}
   	
    public  void abrir() throws Exception {          
    	Class.forName(DRIVER);     
        conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        System.out.println("Connection is Successful to the database" + URL);
    }

    public  void fechar() throws Exception {
    	if(!this.getConn().isClosed())
    		this.getConn().close();        
    }
       
}
