package RioCuartoViaja;
import org.javalite.activejdbc.Model;
/**
 * Clase que modela la tabla atraccion_turisticas de la base datos RioCuartoViaja
 * que representan las atraccioens turisticas que tiene disponible
 * cada destino
 * @author Álvaro Cuesta
 */
public class AtraccionTuristica extends Model {

    public AtraccionTuristica() {}

    public AtraccionTuristica(int id,int id_paquete,String nombre,String descripcion,float costo) {
        set("id",id,"id_paquete",id_paquete,"nombre",nombre,"descripcion",descripcion,"costo",costo);
    }

    public String getId(){
        return getString("id");
    }
    
    public void setId(int id){
        set("id",id);
    }

    public String getIdPaquete(){
        return getString("id_paquete");
    }
    
    public void setIdPaquete(int id_paquete){
        set("id_paquete",id_paquete);
    }

    public String getNombre(){
        return getString("nombre");
    }

    public void setNombre(String nombre){
        set("nombre",nombre);
    }

    public String getDescripcion(){
        return getString("descripcion");
    }

    public void setDescripcion(String descripcion){
        set("descripcion",descripcion);
    }

    public String getCosto(){              
        return getString("costo");
    }
    
    public void setCosto(float costo){              
        set("costo",costo);
    }

    public void setAtraccionTuristica(int id,int id_paquete,String nombre,String descripcion,float costo) {
        set("id",id,"id_paquete",id_paquete,"nombre",nombre,"descripcion",descripcion,"costo",costo);
    }
}