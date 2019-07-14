package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class Cuota extends Model {

    public Cuota() {}

    public Cuota(int nro_plan,float monto,String fecha,String estado ){
        set("nro_plan",nro_plan,"monto",monto,"fecha",fecha,"estado",estado);
    }

    public String getNroPlan(){
        return getString("nro_plan");
    }

    public void setNroPlan(int nro_plan){
        set("nro_plan",nro_plan);
    }

    public String getMonto(){
        return getString("monto");
    }

    public void setMonto(float monto){
        set("monto",monto);
    }

    public String getFecha(){
        return getString("fecha");
    }

    public void setFecha(String fecha){
        set("fecha",fecha);
    }

    public String getEstado(){
        return getString("estado");
    }

    public void setEstado(String estado){
        set("estado",estado);
    }

    public void setCuota(int nro_plan,float monto,String fecha,String estado ){
        set("nro_plan",nro_plan,"monto",monto,"fecha",fecha,"estado",estado);
    }
}