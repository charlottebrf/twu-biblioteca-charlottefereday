import com.twu.biblioteca.BibliotecaApp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    @Test
    public void welcomeMessage() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        String welcome = "Welcome to the new Biblioteca App: we are open for business!";
        assertEquals(welcome, biblioteca.getWelcome());
    }
}


