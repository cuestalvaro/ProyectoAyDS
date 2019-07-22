package RioCuartoViaja;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;

@IdName("dni")
public class Empleado extends Model {

    public Empleado() {}

    public Empleado(int dni, String nombre, String apellido,String loc_origen, String telefono,String pass) {
        set("dni",dni,"nombre",nombre,"apellido",apellido,"loc_origen",loc_origen,"telefono",telefono,"pass",pass);
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

    public String getLocalidadOrigen(){
        return getString("loc_origen");
    }

    public void setLocalidadOrigen(String loc_origen){ 
        set("loc_origen",loc_origen);
    }

    public String getTelefono(){
        return getString("telefono");
    }

    public void setTelefono(String telefono){
        set("telefono",telefono);
    }

    public String getPass(){
        return getString("pass");
    }

    public void setPass(String pass){
        set("pass",pass);
    }

    public void setEmpleado(int dni, String nombre, String apellido,String loc_origen, String telefono,String pass) {
        set("dni",dni,"nombre",nombre,"apellido",apellido,"loc_origen",loc_origen,"telefono",telefono,"pass",pass);
    }

}