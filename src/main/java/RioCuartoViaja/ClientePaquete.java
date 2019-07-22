package RioCuartoViaja;
import org.javalite.activejdbc.Model;
/**
 * Clase que modela la tabla cliente_paquetes de la base datos RioCuartoViaja
 * que representa el paquete que tiene cada cliente
 * @author Álvaro Cuesta
 */
public class ClientePaquete extends Model {

    public ClientePaquete() {}

    public ClientePaquete(int dni, int id_paquete) {
        set("dni",dni,"id_paquete",id_paquete);
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

    public void setClientePaquete(int dni, int id_paquete) {
        set("dni",dni,"id_paquete",id_paquete);
    }
}