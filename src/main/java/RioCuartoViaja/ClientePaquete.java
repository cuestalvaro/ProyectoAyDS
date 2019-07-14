package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class ClientePaquete extends Model {

    public ClientePaquete() {}

    public ClientePaquete(int id,int dni, int id_paquete,int id_atraccion) {
        set("id",id,"dni",dni,"id_paquete",id_paquete,"id_atraccion",id_atraccion);
    }

    public String getId(){
        return getString("id");
    }

    public void setId(int id){
        set ("id",id);
    }

    public String getDni(){
        return getString("dni");
    }

    public void setDni(int dni){
        set ("dni",dni);
    }

    public String getIdPaquete(){
        return getString("id_paquete");
    }

    public void setIdPaquete(int id_paquete){
        set("id_paquete",id_paquete);
    }

    public String getIdAtraccion(){
        return getString("id_atraccion");
    }

    public void setIdAtraccion(int id_atraccion){
        set("id_atraccion",id_atraccion);
    }

    public void setClientePaquete(int id,int dni, int id_paquete,int id_atraccion) {
        set("id",id,"dni",dni,"id_paquete",id_paquete,"id_atraccion",id_atraccion);
    }
}