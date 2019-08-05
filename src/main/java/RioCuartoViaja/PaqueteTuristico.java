package RioCuartoViaja;
import org.javalite.activejdbc.Model;
/**
 * Clase que modela la tabla paquete_turisticos de la base datos RioCuartoViaja
 * que repesenta los paquete que estan a la venta.
 * @author Álvaro Cuesta
 */
public class PaqueteTuristico extends Model {

    public PaqueteTuristico() {}

    public PaqueteTuristico(int id,String ciudad_destino,int id_traslado) {
        set("id",id,"ciudad_destino",ciudad_destino,"id_traslado",id_traslado);
    }

    public String getId(){
        return getString("id");
    }

    public void setId(int id){
        set("id",id);
    }

    public String getIdTraslado(){
        return getString("id_traslado");
    }

    public void setIdTraslado(int id_traslado){
        set("id_traslado",id_traslado);
    }

    public String getDestino(){
        return getString("ciudad_destino");
    }
    
    public void setDestino(String ciudad_destino){
        set("ciudad_destino",ciudad_destino);
    }

    public void setPaqueteTuristico(int id,String ciudad_destino,int id_traslado) {
        set("id",id,"ciudad_destino",ciudad_destino,"id_traslado",id_traslado);
    }
}