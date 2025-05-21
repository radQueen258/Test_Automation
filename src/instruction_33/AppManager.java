package instruction_33;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppManager {
    private WebDriver driver;
    private NavigationHelper navigation;
    private LoginHelper login;
//    private NotesHelper notes;
    private ProfileHelper profile;
    private NoteHelper notes;


    private static ThreadLocal<AppManager> app = new ThreadLocal<>();

    public AppManager() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1854, 1048));
//        navigation = new NavigationHelper(this, "https://alison.com/");
        navigation = new NavigationHelper(this, Settings.getBaseUrl());
        login = new LoginHelper(this);
        profile = new ProfileHelper(this);
        notes = new NoteHelper(this);

    }

    public static AppManager getInstance() {
        if (app.get() == null) {
            AppManager newInstance = new AppManager();
            newInstance.navigation.openHomePage();
            app.set(newInstance);
        }
        return app.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper navigation() {
        return navigation;
    }

    public LoginHelper login() {
        return login;
    }

    public ProfileHelper profile() { return profile; }

    public NoteHelper notes() {
        return notes;
    }


    public void stop() {
        driver.quit();
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            driver.quit();
        } catch (Exception ignored) {}
    }
}

