package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {
    @Test
    public void simpleAlertTest() {
       browsersService.getDriver().get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement button =  browsersService.getDriver().findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        waits.waitForVisibility(button);
        button.click();

        Alert alert = browsersService.getDriver().switchTo().alert();
        alert.accept();

    }


}
