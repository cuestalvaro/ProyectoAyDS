package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class AtraccionCliente extends Model {

    public AtraccionCliente() {}

    public AtraccionCliente(int dni, int id_paquete, int id_atraccion) {
        set("dni", dni, "id_paquete", id_paquete,"id_atraccion",id_atraccion);
    }

    public String getDni(){
        return getString("dni");
    }

    public void setDni(int dni){
        set("dni",dni);
    }

    public String getIdPaquete(){
        return getString("id_paquete");
    }

    public void setIdPaquete(int id_paquete){
        set("id_paquete", id_paquete);
    }

    public String getIdAtraccion(){
        return getString("id_atraccion");
    }

    public void setIdAtraccion(int id_atraccion){
        set("id_atraccion", id_atraccion);
    }

    public void setAtraccionCliente(int dni, int id_paquete, int id_atraccion) {
        set("dni", dni, "id_paquete", id_paquete,"id_atraccion",id_atraccion);
    }
}