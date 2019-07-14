package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class Traslado extends Model {

    public Traslado() {}

    public Traslado(int id_paquete,float costo,float duracion,float distancia) {
        set("id_paquete",id_paquete,"costo",costo,"duracion",duracion,"distancia",distancia);
    }

    public String getIdPaquete(){
        return getString("id_paquete");
    }

    public void setIdPaquete(int id_paquete){
        set("id_paquete",id_paquete);
    }

    public String getCosto(){
        return getString("costo");
    }

    public void setCosto(float costo){
        set("costo",costo);
    }

    public String getDuracion(){
        return getString("duracion");
    }

    public void setDuracion(float duracion){
        set("duracion",duracion);
    }

    public String getDistancia(){
        return getString("distancia");
    }

    public void setDistancia(float distancia){
        set("distancia",distancia);
    }

    public void setTraslado(String id_paquete,float costo,float duracion,float distancia) {
        set("id_paquete",id_paquete,"costo",costo,"duracion",duracion,"distancia",distancia);
    }

}