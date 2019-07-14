package RioCuartoViaja;
import org.javalite.activejdbc.Model;

public class FichaMedica extends Model {

    public FichaMedica() {}

    public FichaMedica(int dni, String nombre_enfermedad,String es_cronica,String nombre_medicamento,String frecuencia,String medicamento_alergico) {
        set("dni",dni,"nombre_enfermedad",nombre_enfermedad,"es_cronica",es_cronica,"nombre_medicamento",nombre_medicamento,"frecuencia",frecuencia,"medicamento_alergico",medicamento_alergico);
    }

    public String getDni(){
        return getString("dni");
    }
    
    public void setDni(int dni){
        set("dni",dni);
    }

    public String getNombreEnfermedad(){
        return getString("nombre_enfermedad");
    }

    public void setNombreEnfermedad(String nombre_enfermedad){
        set("nombre_enfermedad",nombre_enfermedad);
    }

    public String getEsCronica(){
        return getString("es_cronica");
    }

    public void setEsCronica(String es_cronica){
        set("es_cronica",es_cronica);
    }

    public String getNombreMedicamento(){
        return getString("nombre_medicamento");
    }

    public void setNombreMedicamento(String nombre_medicamento){
        set("nombre_medicamento",nombre_medicamento);
    }

    public String getFrecuencia(){
        return getString("frecuencia");
    }

    public void setFrecuencia(String frecuencia){
        set("frecuencia",frecuencia);
    }

    public String getMedicamentoAlergico(){
        return getString("medicamento_alergico");
    }

    public void setMedicamentoAlergico(String medicamento_alergico){
        set("medicamento_alergico",medicamento_alergico);
    }

    public void setFichaMedica(int dni, String nombre_enfermedad,String es_cronica,String nombre_medicamento,String frecuencia,String medicamento_alergico) {
        set("dni",dni,"nombre_enfermedad",nombre_enfermedad,"es_cronica",es_cronica,"nombre_medicamento",nombre_medicamento,"frecuencia",frecuencia,"medicamento_alergico",medicamento_alergico);
    }

}