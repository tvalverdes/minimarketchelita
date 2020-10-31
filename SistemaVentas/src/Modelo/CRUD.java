
package Modelo;

import java.util.List;


public interface CRUD {
    
    public List listar();
    public int agregar(Object[] o);
    public int editar(Object[] o);
    public void eliminar(int id);
    
}
