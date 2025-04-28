package instruction_33;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class NotesHelper extends HelperBase {
    public NotesHelper(AppManager manager) {
        super(manager);
    }

    public void createNote(String title, String noteContent) {
        waitForPageToLoad();
        WebElement element = driver.findElement(By.cssSelector(".tw-w-12"));
        new Actions(driver).moveToElement(element).perform();

        WebElement body = driver.findElement(By.tagName("body"));
        new Actions(driver).moveToElement(body, 0, 0).perform();

        waitForPageToLoad();
        driver.manage().window().setSize(new Dimension(1854, 1048));
        waitForPageToLoad();
        driver.findElement(By.cssSelector(".mat-tooltip-trigger > .ng-tns-c1065955076-1")).click();
        driver.findElement(By.id("mat-input-1")).sendKeys(noteContent);
        driver.findElement(By.id("mat-input-0")).sendKeys(title);
        driver.findElement(By.cssSelector(".btn-save")).click();
        driver.findElement(By.cssSelector(".btn-save > .mat-button-wrapper")).click();

        waitForPageToLoad();
    }
}

