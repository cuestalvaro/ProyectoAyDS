package RioCuartoViaja;

import java.util.List;
import RioCuartoViaja.*;
import org.javalite.activejdbc.*;

/**
 * Clase principal del proyecyo AyDS 
 * @author Álvaro Cuesta
 */
public class App {
    /**
     * Metodo principal de la clase donde habre la ventana login para
     * iniciar sesion
     * @param args
     */
    public static void main( String[] args ){
      
        Login log = new Login();
        log.setVisible(true);
    }
}
