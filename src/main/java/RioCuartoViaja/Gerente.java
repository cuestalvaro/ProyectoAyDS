package RioCuartoViaja;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
/**
 * Clase que modela la tabla gerentes de la base datos RioCuartoViaja
 * que representa el gerente de la empresa
 * @author Álvaor Cuesta
 */
@IdName("dni")
public class Gerente extends Model {

    public Gerente() {}

    public Gerente(int dni, float gastos_repres) {
        set("dni", dni, "gastos_repres", gastos_repres);
    }

    public String getDni(){
        return getString("dni");
    }

    public void setDni(int dni){
        set("dni",dni);
    }

    public String getGastos(){
        return getString("gastos_repres");
    }

    public void setGastos(float gastos_repres){
        set("gastos_repres",gastos_repres);
    }

    public void setGerente(int dni, float gastos_repres) {
        set("dni", dni, "gastos_repres", gastos_repres);
    }
}