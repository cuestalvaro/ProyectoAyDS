package RioCuartoViaja;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;

@IdName("dni")
public class Cliente extends Model {

    public Cliente() {}

    public Cliente(int dni, String nombre, String apellido,String direccion, String telefono,String nombre_agrupacion) {
        set("dni",dni,"nombre",nombre,"apellido",apellido,"direccion",direccion, "telefono",telefono,"nombre_agrupacion",nombre_agrupacion);
    }

    public String getDni(){
        return getString("dni");
    }

    public void setDni(int dni){
        set("dni",dni);
    }

    public String getNombre(){
        return getString("nombre");
    }

    public void setNombre(String nombre){
        set("nombre",nombre);
    }

    public String getApellido(){
        return getString("apellido");
    }

    public void setApellido(String apellido){
        set("apellido",apellido);
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

    public String getNombreAgrupacion(){
        return getString("nombre_agrupacion");
    }

    public void setNombreAgrupacion(String nombre_agrupacion){
        set("nombre_agrupacion",nombre_agrupacion);
    }

    public void setCliente(int dni, String nombre, String apellido,String direccion, String telefono,String nombre_agrupacion) {
        set("dni",dni,"nombre",nombre,"apellido",apellido,"direccion",direccion, "telefono",telefono,"nombre_agrupacion",nombre_agrupacion);
    }
}