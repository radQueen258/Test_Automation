package instruction_33;

import org.junit.*;

public class TestBase {
    protected AppManager app;

    @Before
    public void setUp() {
        app = new AppManager();
    }

//    @After
//    public void tearDown() {
//        app.stop();
//    }
}

