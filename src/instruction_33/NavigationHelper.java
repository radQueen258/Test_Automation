package instruction_33;

import org.openqa.selenium.*;

public class NavigationHelper extends HelperBase {
    private String baseURL;

    public NavigationHelper(AppManager manager, String baseURL) {
        super(manager);
        this.baseURL = baseURL;
    }

    public void openHomePage() {
        driver.get(baseURL);
        driver.manage().window().setSize(new Dimension(1854, 1048));
        waitForPageToLoad();
        acceptCookiesIfPresent();
    }
}
