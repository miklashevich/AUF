package utils;

import core.ReadProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
private WebDriverWait wait;

    public Waits(WebDriver driver, int timeOut){
        wait = new WebDriverWait(driver, timeOut);
    }

    public Waits(WebDriver driver){
         wait = new WebDriverWait(driver, new ReadProperties().getTimeout());
    }

    public WebElement waitForVisibility(By by){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibility(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public Alert waitForVisibilityAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

}
