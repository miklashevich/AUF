package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class iFrameTest extends BaseTest {
    @Test
    public void switchToFrameTest(){
        WebDriver driver = browsersService.getDriver();
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
       // driver.switchTo().frame(driver.findElement(By.tagName("iFrame")));
       // driver.switchTo().frame("mce_0_ifr");

        WebElement webElement = driver.findElement(By.xpath("//p[. = 'Your content goes here.']"));
        driver.switchTo().parentFrame();
        WebElement elementFromParent = driver.findElement(By.cssSelector(".tox-icon.tox-tbtn__icon-wrap"));


    }

}
