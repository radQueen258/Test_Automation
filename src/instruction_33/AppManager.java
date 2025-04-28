package instruction_33;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppManager {
    private WebDriver driver;
    private NavigationHelper navigation;
    private LoginHelper login;
    private NotesHelper notes;

    public AppManager() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1854, 1048));
        navigation = new NavigationHelper(this, "https://alison.com/");
        login = new LoginHelper(this);
        notes = new NotesHelper(this);
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

    public NotesHelper notes() {
        return notes;
    }

    public void stop() {
        driver.quit();
    }
}

