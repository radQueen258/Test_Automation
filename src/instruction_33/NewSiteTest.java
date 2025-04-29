package instruction_33;

import org.junit.Test;

public class NewSiteTest extends TestBase {

    @Test
    public void newSite() {
        app.navigation().openHomePage();
        app.login().login("radqueen.nhapulo@gmail.com", "AkdarNhapulo");
        app.login().continueAfterLogin();
        app.profile().changeLanguage();

//        app.notes().createNote("It has a title", "This is my new note");
    }
}

