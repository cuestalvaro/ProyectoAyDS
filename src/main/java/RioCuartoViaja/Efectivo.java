package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class Efectivo extends Model {

    public Efectivo() {}

    public Efectivo(int id_paquete,float monto_total_descuento,String fecha ){
        set("id_paquete",id_paquete,"monto_total_descuento",monto_total_descuento,"fecha",fecha);
    }

    public String getIdPaquete(){
        return getString("id_paquete");
    }

    public void setIdPago(int id_paquete){
        set("id_paquete",id_paquete);
    }

    public String getMontoDescuento(){
        return getString("monto_total_descuento");
    }

    public void setMontoDescuento(float monto_total_descuento){
        set("monto_total_descuento",monto_total_descuento);
    }

    public String getFecha(){
        return getString("fecha");
    }

    public void setFecha(String fecha){
        set("fecha",fecha);
    }

    public void setEfectivo(int id_paquete,float monto_total_descuento,String fecha ){
        set("id_paquete",id_paquete,"monto_total_descuento",monto_total_descuento,"fecha",fecha);
    }
}