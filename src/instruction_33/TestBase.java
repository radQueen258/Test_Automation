package instruction_33;

import org.junit.*;

public class TestBase {
    protected AppManager app;

    @Before
    public void setUp() {
        app = AppManager.getInstance(); // this initializes driver and opens homepage
        app.navigation().openHomePage();
    }

}

