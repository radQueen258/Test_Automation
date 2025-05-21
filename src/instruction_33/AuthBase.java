package instruction_33;

import org.junit.Before;

public class AuthBase extends TestBase {
    @Before
    public void setUpAuth() {
        app.login().login(Settings.getLogin(), Settings.getPassword());
    }
}
