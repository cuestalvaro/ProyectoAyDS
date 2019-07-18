package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class PlanCuota extends Model {

    public PlanCuota() {}

    public PlanCuota(int id_paquete,int cant_cuotas,String fecha_inc,String fecha_fin ){
        set("id_paquete",id_paquete,"nro_plan",null,"cant_cuotas",cant_cuotas,"fecha_inc",fecha_inc,"fecha_fin",fecha_fin);
    }

    public String getIdPaquete(){
        return getString("id_paquete");
    }

    public void setIdPaquete(int id_paquete){
        set("id_paquete",id_paquete);
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

    public void setPlanCuota(int id_paquete,int cant_cuotas,String fecha_inc,String fecha_fin ){
        set("id_paquete",id_paquete,"cant_cuotas",cant_cuotas,"fecha_inc",fecha_inc,"fecha_fin",fecha_fin);
    }
}