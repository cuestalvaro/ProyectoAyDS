package RioCuartoViaja;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;

@IdName("id")
public class AtraccionCliente extends Model {

    public AtraccionCliente() {}

    public AtraccionCliente(int id_cliente_paquete, int id_atraccion) {
        set("id","NULL","id_cliente_paquete", id_cliente_paquete,"id_atraccion",id_atraccion);
    }

    public String getIdClientePaquete(){
        return getString("id_cliente_paquete");
    }

    public void setIdClientePaquete(int id_cliente_paquete){
        set("id_cliente_paquete", id_cliente_paquete);
    }

    public String getIdAtraccion(){
        return getString("id_atraccion");
    }

    public void setIdAtraccion(int id_atraccion){
        set("id_atraccion", id_atraccion);
    }

    public void setAtraccionCliente(int id_cliente_paquete, int id_atraccion) {
        set("id_cliente_paquete", id_cliente_paquete,"id_atraccion",id_atraccion);
    }
}