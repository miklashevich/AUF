package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class jsHomeTask extends BaseTest {

    @Test
    public void scrollTest(){
        WebDriver driver = browsersService.getDriver();
        driver.get("https://www.onliner.by/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)  driver;
        javascriptExecutor.executeScript("window.scrollBy(0, 7000);");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
// Thread.sleep поставил чтобы видеть что скроллит
}


