package RioCuartoViaja;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;

@IdName("dni")
public class Administrativo extends Model {

    public Administrativo() {}

    public Administrativo(int dni, String turno) {
        set("dni", dni, "turno", turno);
    }

    public String getDni(){
        return getString("dni");
    }

    public void setDni(int dni){
        set("dni",dni);
    }

    public String getTurno(){
        return getString("turno");
    }

    public void setTurno(String turno){
        set("turno",turno);
    }

    public void setAdministrativo(int dni, String turno) {
        set("dni", dni, "turno", turno);
    }
}