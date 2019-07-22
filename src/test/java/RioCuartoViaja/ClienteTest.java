package RioCuartoViaja;

import RioCuartoViaja.*;
import org.javalite.activejdbc.*;
import static org.junit.Assert.*;
import org.junit.*; 


public class ClienteTest {

    @BeforeClass
	public static void before(){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/RioCuartoViaja_test", "root", "root");
		System.out.println("ClienteTest: ");
		Base.openTransaction();
	}

	@AfterClass
	public static void after(){
		System.out.println("ClienteTest end");
		Base.rollbackTransaction();
		Base.close();
	}
	
	@Test
	public void addCliente(){
		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setNombre("Jorge");
        nuevoCliente.setApellido("Suarez");
        nuevoCliente.setDni(37875866);
        nuevoCliente.setDireccion("Av. Ranqueles 4");
        nuevoCliente.setTelefono("358240654");
        nuevoCliente.setNombreAgrupacion("Los nonos");

        assertEquals("Jorge",nuevoCliente.getNombre());
        assertEquals("Suarez",nuevoCliente.getApellido());
        assertEquals("37875866",nuevoCliente.getDni());
        assertEquals("Av. Ranqueles 4",nuevoCliente.getDireccion());
        assertEquals("358240654",nuevoCliente.getTelefono());
        assertEquals("Los nonos",nuevoCliente.getNombreAgrupacion());
	}

	@Test
	public void addCliente2(){

		Cliente nuevoCliente = new Cliente(37875866,"Jorge","Suarez","Av. Ranqueles 4","358240654","Los nonos");
		
        assertEquals("Jorge",nuevoCliente.getNombre());
        assertEquals("Suarez",nuevoCliente.getApellido());
        assertEquals("37875866",nuevoCliente.getDni());
        assertEquals("Av. Ranqueles 4",nuevoCliente.getDireccion());
        assertEquals("358240654",nuevoCliente.getTelefono());
        assertEquals("Los nonos",nuevoCliente.getNombreAgrupacion());
	}

	@Test
	public void setCliente(){

		Cliente nuevoCliente = new Cliente(37875866,"Jorge","Suarez","Av. Ranqueles 4","358240654","Los nonos");
        
        nuevoCliente.setCliente(37875866, "Jorge","Suarez","Av. Italia 5","358240656","Vivir");

        assertEquals("Jorge",nuevoCliente.getNombre());
        assertEquals("Suarez",nuevoCliente.getApellido());
        assertEquals("37875866",nuevoCliente.getDni());
        assertEquals("Av. Italia 5",nuevoCliente.getDireccion());
        assertEquals("358240656",nuevoCliente.getTelefono());
        assertEquals("Vivir",nuevoCliente.getNombreAgrupacion());
	}
}