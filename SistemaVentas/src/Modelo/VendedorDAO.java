
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class VendedorDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    
    Conexion con=new Conexion();
    
    Connection acceso;
    
    public E_Vendedor ValidarVendedor(String dni, String user){
        E_Vendedor ev = new E_Vendedor();
        String sql = "select * from vendedor where Dni LIKE ? and User_2 LIKE ?";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs=ps.executeQuery();
            while(rs.next()){
                ev.setId(rs.getInt(1));
                ev.setDni(rs.getString(2));
                ev.setNombre(rs.getString(3));
                ev.setTelefono(rs.getString(4));
                ev.setDireccion(rs.getString(5));
                ev.setEstado(rs.getString(6));
                ev.setUsuario(rs.getString(7));
                
            }
        } catch (Exception e) {
        }
        return ev;
    }
    
    
    
    
    
}
