
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
   private static Connection con;
   private static final String bd = "sistemasminimarket";
   private static final String url = "jdbc:mysql://localhost:3306/" +bd;
   private static final String user = "admin";
   private static final String pass = "12345678";
   private static final String driver = "com.mysql.jdbc.Driver";
   
   public Connection Conectar(){
       con = null;
       try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            if(con != null){
                System.out.println("Conexión establecida");
            }
       } catch (ClassNotFoundException| SQLException e) {
           System.out.println("Error en conexión"+e);
       }
       return con;
      
   }

    public Connection getConnection() {
        return con;
    }

    public void desconectar(){
        con=null;
        if(con==null){
            System.out.println("Conexión terminada");
        }
    }
   

   

    

   
}
