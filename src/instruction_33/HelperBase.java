package instruction_33;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HelperBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public HelperBase(AppManager manager) {
        this.driver = manager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

    protected void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    protected void acceptCookiesIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".message-component.message-button.no-children.focusable.sp_choice_type_11.last-focusable-el")
            ));
            acceptBtn.click();
            Thread.sleep(1000);
        } catch (TimeoutException | InterruptedException e) {
        }
    }

}

