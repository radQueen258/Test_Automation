package instruction_33;

import org.openqa.selenium.By;

public class ProfileHelper extends HelperBase{


    public ProfileHelper(AppManager manager) {
        super(manager);
    }

    public void changeLanguage() {
        driver.findElement(By.cssSelector(".head__user-img > .ng-tns-c479218729-0")).click();
        driver.findElement(By.cssSelector("div:nth-child(1) > .user-menu__item > h5")).click();
        driver.findElement(By.cssSelector(".user-menu__item:nth-child(2) > h5")).click();
    }
}
