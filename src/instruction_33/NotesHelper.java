package instruction_33;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotesHelper extends HelperBase {
    public NotesHelper(AppManager manager) {
        super(manager);
    }

    public void openAllNotes() {
        waitForPageToLoad();
        WebElement notesButton = driver.findElement(By.cssSelector(".mat-tooltip-trigger"));
        notesButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".see-all-notes"))).click();
    }

    public void deleteLastNote() {
        waitForPageToLoad();

        // Hover over the note action
        WebElement noteAction = driver.findElement(By.cssSelector(".download-notes-action .btn-content"));
        new Actions(driver).moveToElement(noteAction).perform();

        WebElement body = driver.findElement(By.tagName("body"));
        new Actions(driver).moveToElement(body, 0, 0).perform();

        WebElement deleteButton = driver.findElement(By.cssSelector(".btn:nth-child(1) > .mat-mdc-button-touch-target"));
        new Actions(driver).moveToElement(deleteButton).perform();

        body = driver.findElement(By.tagName("body"));
        new Actions(driver).moveToElement(body, 0, 0).perform();

        // Click on delete
        driver.findElement(By.cssSelector(".ng-tns-c125666391-24:nth-child(4)")).click();
        waitForPageToLoad();
    }

    public boolean isNotePresent() {
        try {
            return driver.findElement(By.cssSelector(".note-card")) != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//    public void createNote(String title, String noteContent) {
//        waitForPageToLoad();
//        WebElement element = driver.findElement(By.cssSelector(".tw-w-12"));
//        new Actions(driver).moveToElement(element).perform();
//
//        WebElement body = driver.findElement(By.tagName("body"));
//        new Actions(driver).moveToElement(body, 0, 0).perform();
//
//        waitForPageToLoad();
//        driver.manage().window().setSize(new Dimension(1854, 1048));
//        waitForPageToLoad();
//        driver.findElement(By.cssSelector(".mat-tooltip-trigger > .ng-tns-c1065955076-1")).click();
//        driver.findElement(By.id("mat-input-1")).sendKeys(noteContent);
//        driver.findElement(By.id("mat-input-0")).sendKeys(title);
//        driver.findElement(By.cssSelector(".btn-save")).click();
//        driver.findElement(By.cssSelector(".btn-save > .mat-button-wrapper")).click();
//
//        waitForPageToLoad();
//    }
}

