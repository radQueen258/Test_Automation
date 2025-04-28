package instruction_33;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginHelper extends HelperBase {
    public LoginHelper(AppManager manager) {
        super(manager);
    }

    public void login(String email, String password) {
        waitForPageToLoad();

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log In")));
        loginButton.click();

        waitForPageToLoad();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.manage().window().setSize(new Dimension(1854, 1048));
        driver.findElement(By.cssSelector(".login__bottom:nth-child(7) .submit-login")).click();
    }

    public void continueAfterLogin() {
        waitForPageToLoad();
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("ab-continue")));
        continueButton.click();
        waitForPageToLoad();
    }
}

