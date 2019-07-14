package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class Efectivo extends Model {

    public Efectivo() {}

    public Efectivo(int id_pago,float monto_total_descuento,String fecha ){
        set("id_pago",id_pago,"monto_total_descuento",monto_total_descuento,"fecha",fecha);
    }

    public String getIdPago(){
        return getString("id_pago");
    }

    public void setIdPago(int id_pago){
        set("id_pago",id_pago);
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

    public void setEfectivo(int id_pago,float monto_total_descuento,String fecha ){
        set("id_pago",id_pago,"monto_total_descuento",monto_total_descuento,"fecha",fecha);
    }
}