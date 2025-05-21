package instruction_33;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginHelper extends HelperBase {
    public LoginHelper(AppManager manager) {
        super(manager);
    }

    public void login(String email, String password) {
        waitForPageToLoad();

        if (isLoggedIn()) {
            if (isLoggedIn(email)) {
                return; // Already logged in as correct user
            } else {
                logout(); // Logged in as someone else
            }
        }

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log In")));
        loginButton.click();

        waitForPageToLoad();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.manage().window().setSize(new Dimension(1854, 1048));
        driver.findElement(By.cssSelector(".login__bottom:nth-child(7) .submit-login")).click();

        waitForPageToLoad();
        try {
            continueAfterLogin();
        } catch (TimeoutException e) {
            // Optional: Log a warning that the continue button did not appear
            System.out.println("Login may have failed — 'Continue' button not found.");
        }
    }

    public void continueAfterLogin() {
        waitForPageToLoad();
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("ab-continue")));
//        continueButton.click();
        waitForPageToLoad();
    }

    public void logout() {
        waitForPageToLoad();

        // Click on user avatar/profile image
        WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".head__user-img > .ng-tns-c479218729-0")));
        avatar.click();

        // Click the logout item (10th inserted element)
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".ng-star-inserted:nth-child(10) h5")));
        logoutButton.click();

        waitForPageToLoad();
    }

    public boolean isLoggedIn() {
        try {
            // If the avatar is visible, user is logged in
            return driver.findElements(By.id("ab-continue")).size() > 0;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoggedIn(String email) {
        try {
            // Hover over avatar and find displayed email or username
            WebElement avatar = driver.findElement(By.cssSelector(".head__user-img > .ng-tns-c479218729-0"));
            avatar.click();
            WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".profile-email-selector"))); // <-- Adjust if needed
            String displayedEmail = emailElement.getText();
            return displayedEmail.equalsIgnoreCase(email);
        } catch (Exception e) {
            return false;
        }
    }
}
