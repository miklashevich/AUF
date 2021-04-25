package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class AlertsHomeTask extends BaseTest {

    @Test
    public void AlertsTest() {
        WebDriver driver = browsersService.getDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlertBtn =  browsersService.getDriver().findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        waits.waitForVisibility(jsAlertBtn);
        jsAlertBtn.click();

        Alert alert = browsersService.getDriver().switchTo().alert();
        alert.accept();

        WebElement result1 = driver.findElement(By.xpath("//p[contains(text(),'You successfully clicked an alert')]"));
         String resultMessage1 = result1.getText();
        Assert.assertEquals(resultMessage1, "You successfully clicked an alert");

        WebElement jsConfirmBtn =  browsersService.getDriver().findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        jsConfirmBtn.click();
        alert.dismiss();
        WebElement result2 = driver.findElement(By.xpath("//p[contains(text(),'You clicked: Cancel')]"));
        String resultMessage = result2.getText();
        Assert.assertEquals(resultMessage, "You clicked: Cancel");

        WebElement jsPromptBtn =  browsersService.getDriver().findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        jsPromptBtn.click();
        alert.sendKeys("I am a JS prompt");
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']")));
        WebElement result3 = driver.findElement(By.xpath("//p[@id='result']"));
        String enteredMessage = result3.getText();

        Assert.assertEquals(enteredMessage, "You entered: I am a JS prompt");


    }
}