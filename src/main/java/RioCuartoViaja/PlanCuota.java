package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class PlanCuota extends Model {

    public PlanCuota() {}

    public PlanCuota(int id_pago,int nro_plan,int cant_cuotas,String fecha_inc,String fecha_fin ){
        set("id_pago",id_pago,"nro_plan",nro_plan,"cant_cuotas",cant_cuotas,"fecha_inc",fecha_inc,"fecha_fin",fecha_fin);
    }

    public String getIdPago(){
        return getString("id_pago");
    }

    public void getIdPago(int id_pago){
        set("id_pago",id_pago);
    }

    public String getNroPlan(){
        return getString("nro_plan");
    }

    public void setNroPlan(int nro_plan){
        set("nro_plan",nro_plan);
    }

    public String getCantCoutas(){
        return getString("cant_cuotas");
    }

    public void setCantCoutas(int cant_cuotas){
        set("cant_cuotas",cant_cuotas);
    }

    public String getFechaInc(){
        return getString("fecha_inc");
    }

    public void setFechaInc(String fecha_inc){
        set("fecha_inc",fecha_inc);
    }

    public String getFechaFin(){
        return getString("fecha_fin");
    }

    public void setFechaFin(String fecha_fin){
        set("fecha_fin",fecha_fin);
    }

    public void setPlanCuota(int id_pago,int nro_plan,int cant_cuotas,String fecha_inc,String fecha_fin ){
        set("id_pago",id_pago,"nro_plan",nro_plan,"cant_cuotas",cant_cuotas,"fecha_inc",fecha_inc,"fecha_fin",fecha_fin);
    }
}