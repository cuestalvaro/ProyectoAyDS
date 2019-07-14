package RioCuartoViaja;

import RioCuartoViaja.Administrativo;
import org.javalite.activejdbc.Base;
import org.junit.*; 
import org.javalite.activejdbc.DBException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdministrativoTest extends Model {

    @BeforeClass
	public static void before(){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/RioCuartoViaja_test", "root", "root");
		System.out.println("Inicio Test Administrativo");
		Base.openTransaction();
	}

	@AfterClass
	public static void after(){
		System.out.println("Fin Test Administrativo");
		Base.rollbackTransaction();
		Base.close();
	}
	
	@Test
	public void addPlayerSuccessful(){
		Administrativo admin = new Administrativo();
		admin.a
		user.set("player_name","Matias");
		user.set("player_login","mbf");
		user.set("player_pass","1234");
		assertEquals(39322824,user.get("id"));
	}

	@Test
	public void primaryKeyRepetition(){
		try {
			Player user = new Player();
			user.set("id", 40297554);
			user.set("player_name","Mariano");
			user.set("player_login","PapaNatas");
			user.set("player_pass","1234");
			Player user1 = new Player();
			user1.set("id", 40297554);
		} catch (DBException e) {
			assertTrue(e instanceof DBException);
		}
	}

	@Test
	public void atributeNotNull(){
		try {
			Player user = new Player();
			user.set("id",null);
		} catch (DBException e) {
			assertTrue(e instanceof DBException);
		}
	}

}
}