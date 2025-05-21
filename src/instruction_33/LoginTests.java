package instruction_33;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidData() {
//        app.login().logout(); // Ensure clean state
        app.login().login(Settings.getLogin(), Settings.getPassword());
        assertTrue(app.login().isLoggedIn());
    }

    @Test
    public void loginWithInvalidData() {
//        app.login().logout();
        app.login().login("invalid@example.com", "wrongpass");
        assertFalse(app.login().isLoggedIn());
    }
}
