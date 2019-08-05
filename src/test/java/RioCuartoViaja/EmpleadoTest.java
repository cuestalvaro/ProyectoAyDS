package RioCuartoViaja;

import RioCuartoViaja.*;
import org.javalite.activejdbc.*;
import static org.junit.Assert.*;
import org.junit.*; 

public class EmpleadoTest{

    @BeforeClass
	public static void before(){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/RioCuartoViaja_test", "root", "root");
		System.out.println("EmpeladoTest: ");
		Base.openTransaction();
	}

	@AfterClass
	public static void after(){
		System.out.println("EmpleadoTest end");
		Base.rollbackTransaction();
		Base.close();
	}

	@Test
	public void loginEmpelado(){

		Empleado nuevoEmpelado = new Empleado(37875300,"Lucas","Pratto","Rio Cuarto","358240654","4321");

        assertEquals("37875300",nuevoEmpelado.getDni());
        assertEquals("4321",nuevoEmpelado.getPass());
        
    }
}