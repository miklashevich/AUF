package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class iFrameHomeTask extends BaseTest {
    @Test
    public void switchToFrameTest(){

        WebDriver driver = browsersService.getDriver();
        driver.get("http://the-internet.herokuapp.com");
        WebElement frameBtn = browsersService.getDriver().findElement(By.partialLinkText("Frames"));
        waits.waitForVisibility(frameBtn);
        frameBtn.click();

        WebElement iframeBtn = browsersService.getDriver().findElement(By.xpath("//a[contains(text(),'iFrame')]"));
        waits.waitForVisibility(iframeBtn);
        iframeBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));


        WebElement fieldToInput = browsersService.getDriver().findElement(By.xpath("//p[. = 'Your content goes here.']"));
        fieldToInput.sendKeys("test message");

        browsersService.getDriver().switchTo().defaultContent();

        WebElement alignCenterBtn = browsersService.getDriver().findElement(By.cssSelector("[title='Align center']"));
        alignCenterBtn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 // Thread.sleep поставил только для того чтобы увидеть что текст выровнялся

    }
    @Test
    public void onlinerFrameTest(){

        WebDriver driver = browsersService.getDriver();
        driver.get("https://www.onliner.by/");

        WebElement searchField = browsersService.getDriver().findElement(By.cssSelector("[type='text']"));
        waits.waitForVisibility(searchField).sendKeys("Тостер");

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//body/div[@id='search-page']/div[1]")));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".modal-iframe")));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


      WebElement searchElement = browsersService.getDriver().findElement(By.cssSelector(".product__title-link"));
      String nameSearchElement = searchElement.getText();



        //browsersService.getDriver().switchTo().defaultContent();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement search = browsersService.getDriver().findElement(By.xpath("//body/div[@id='search-page']/div[1]/div[1]/input[1]"));
        search.click();
     search.clear();
      search.sendKeys(nameSearchElement);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement closeBtn = browsersService.getDriver().findElement(By.cssSelector(".search__close"));
        closeBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

            // WebElement fieldToInput = browsersService.getDriver().findElement(By.xpath("//p[. = 'Your content goes here.']"));
            //  fieldToInput.sendKeys("test message");

            // browsersService.getDriver().switchTo().defaultContent();

            //  WebElement alignCenterBtn = browsersService.getDriver().findElement(By.cssSelector("[title='Align center']"));
            //  alignCenterBtn.click();


        }

}
}
