package RioCuartoViaja;
import org.javalite.activejdbc.Model;
/**
 * Clase que modela la tabla traslados de la base datos RioCuartoViaja
 * que representa el traslado hacia algun destino
 * @author Álvaro Cuesta
 */
public class Traslado extends Model {

    public Traslado() {}

    public Traslado(int id,float costo,float duracion,float distancia) {
        set("id",id,"costo",costo,"duracion",duracion,"distancia",distancia);
    }

    public String getId(){
        return getString("id");
    }

    public void setId(int id){
        set("id",id);
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

    public void setTraslado(int id,float costo,float duracion,float distancia) {
        set("id",id,"costo",costo,"duracion",duracion,"distancia",distancia);
    }

}