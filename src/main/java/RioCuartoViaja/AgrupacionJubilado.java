package RioCuartoViaja;
import org.javalite.activejdbc.Model;
/**
 * Clase que modela la tabla agrupacion_jubilados de la base datos RioCuartoViaja
 * que representa las agrupaciones de los jubilados
 * @author Álvaor Cuesta
 */
public class AgrupacionJubilado extends Model {

    public AgrupacionJubilado() {}

    public AgrupacionJubilado(String nombre,String direccion,String telefono) {
        set("nombre",nombre,"direccion",direccion,"telefono",telefono);
    }

    public String getNombre(){
        return getString("nombre");
    }

    public void setNombre(String nombre){
        set("nombre",nombre);
    }

    public String getDireccion(){
        return getString("direccion");
    }

    public void setDireccion(String direccion){
        set("direccion",direccion);
    }

    public String getTelefono(){
        return getString("telefono");
    }

    public void setTelefono(String telefono){
        set("telefono",telefono);
    }

    public void setAgrupacionJubilado(String nombre,String direccion,String telefono) {
        set("nombre",nombre,"direccion",direccion,"telefono",telefono);
    }
}