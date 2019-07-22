package RioCuartoViaja;

import RioCuartoViaja.*;
import org.javalite.activejdbc.*;
import static org.junit.Assert.*;
import org.junit.*; 

public class FichaMedicaTest {

    @BeforeClass
	public static void before(){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/RioCuartoViaja_test", "root", "root");
		System.out.println("FichaMedicaTest: ");
		Base.openTransaction();
	}

	@AfterClass
	public static void after(){
		System.out.println("FichaMedicaTest end");
		Base.rollbackTransaction();
		Base.close();
	}
	
	@Test
	public void addFicha(){
        FichaMedica ficha = new FichaMedica();
        
		ficha.setDni(10226554);
        ficha.setNombreEnfermedad("Loquitis");
        ficha.setEsCronica("si");
        ficha.setNombreMedicamento("ibuprofeno");
        ficha.setFrecuencia("diaria");
        ficha.setMedicamentoAlergico("Penicilina");

        assertEquals("10226554",ficha.getDni());
        assertEquals("Loquitis",ficha.getNombreEnfermedad());
        assertEquals("si",ficha.getEsCronica());
        assertEquals("ibuprofeno",ficha.getNombreMedicamento());
        assertEquals("diaria",ficha.getFrecuencia());
        assertEquals("Penicilina",ficha.getMedicamentoAlergico());
	}

	@Test
	public void addFicha2(){

		FichaMedica ficha = new FichaMedica(10226554,"Loquitis","si","ibuprofeno","diaria","Penicilina");
		
        assertEquals("10226554",ficha.getDni());
        assertEquals("Loquitis",ficha.getNombreEnfermedad());
        assertEquals("si",ficha.getEsCronica());
        assertEquals("ibuprofeno",ficha.getNombreMedicamento());
        assertEquals("diaria",ficha.getFrecuencia());
        assertEquals("Penicilina",ficha.getMedicamentoAlergico());
	}

	@Test
	public void setFicha(){

		FichaMedica ficha = new FichaMedica(10226554,"Loquitis","si","ibuprofeno","diaria","Penicilina");
        
        ficha.setFichaMedica(10226554,"Loquitis","no","paracetamol","diaria","aspirineta");

        assertEquals("10226554",ficha.getDni());
        assertEquals("Loquitis",ficha.getNombreEnfermedad());
        assertEquals("no",ficha.getEsCronica());
        assertEquals("paracetamol",ficha.getNombreMedicamento());
        assertEquals("diaria",ficha.getFrecuencia());
        assertEquals("aspirineta",ficha.getMedicamentoAlergico());
	}
}