package instruction_33;

import model.NoteData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NoteHelper extends HelperBase{
    public NoteHelper(AppManager manager) {
        super(manager);
    }

    public void createNote(NoteData note) {
        waitForPageToLoad();

        WebElement element = driver.findElement(By.cssSelector(".tw-w-12"));
        new Actions(driver).moveToElement(element).perform();

        WebElement body = driver.findElement(By.tagName("body"));
        new Actions(driver).moveToElement(body, 0, 0).perform();

        driver.findElement(By.cssSelector(".mat-tooltip-trigger > .ng-tns-c1065955076-1")).click();
        driver.findElement(By.id("mat-input-1")).sendKeys(note.getContent());
        driver.findElement(By.id("mat-input-0")).sendKeys(note.getTitle());
        driver.findElement(By.cssSelector(".btn-save")).click();

        waitForPageToLoad();
    }
}
