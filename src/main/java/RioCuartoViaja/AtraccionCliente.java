package RioCuartoViaja;
import org.javalite.activejdbc.Model;
/**
 * Clase que modela la tabla atraccion_clientes de la base datos RioCuartoViaja
 * que representa las atraccione que eligio cada cliente
 * @author Álvaro Cuesta
 */
public class AtraccionCliente extends Model {

    public AtraccionCliente() {}

    public AtraccionCliente(int id_cliente_paquete, int id_atraccion) {
        set("id_cliente_paquete", id_cliente_paquete,"id_atraccion",id_atraccion);
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