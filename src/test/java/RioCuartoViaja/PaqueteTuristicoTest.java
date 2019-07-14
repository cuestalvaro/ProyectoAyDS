package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class PaqueteTuristico extends Model {

    public PaqueteTuristico() {}

    public PaqueteTuristico(int id,String ciudad_destino) {
        set("id",id,"ciudad_destino",ciudad_destino);
    }

    public String getId(){
        return getString("id");
    }

    public void setId(int id){
        set("id",id);
    }

    public String getDestino(){
        return getString("ciudad_destino");
    }
    
    public void setDestino(String ciudad_destino){
        set("ciudad_destino",ciudad_destino);
    }

    public void setPaqueteTuristico(int id,String ciudad_destino) {
        set("id",id,"ciudad_destino",ciudad_destino);
    }
}