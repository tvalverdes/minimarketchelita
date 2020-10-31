
package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO implements CRUD{
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
    List<Producto> lista = new ArrayList<>();
    String sql = "select * from producto";
        try {
            con = (Connection) cn.Conectar();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int agregar(Object[] o) {
        int r = 0;
       String sql = "INSERT INTO producto(Nombres,Precio,Stock)values(?,?,?)";
        try {
            con = (Connection) cn.Conectar();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setObject(1, o[0] );
            ps.setObject(2, o[1] );
            ps.setObject(3, o[2] );
            r = ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int editar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
