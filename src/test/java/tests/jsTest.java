package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class jsTest extends BaseTest {
    @Test
    public void jsTest(){
        WebDriver driver = browsersService.getDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement webElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)  driver;
        javascriptExecutor.executeScript("arguments[0].click;", webElement);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        javascriptExecutor.executeScript("alert('Привет!!!')");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void scrollTest(){
        WebDriver driver = browsersService.getDriver();
        driver.get("http://the-internet.herokuapp.com/infinite_scroll");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)  driver;
        javascriptExecutor.executeScript("window.scrollBy(0, 1600);");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
