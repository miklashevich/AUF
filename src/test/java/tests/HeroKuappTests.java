package tests;

import baseEntities.BaseTest;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.Driver;

public class HeroKuappTests extends BaseTest {

    @Test
    public void ContextMenuTest() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement contextMenu = driver.findElementByPartialLinkText("Context Menu");
        waits.waitForVisibility(contextMenu);
        contextMenu.click();

        Actions actions = new Actions(driver);
        WebElement window = driver.findElementById("hot-spot");
        actions.moveToElement(window, 10, 10).contextClick().build().perform();
        driver.quit();

    }

    @Test
    public void ControlsTest() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement dynamicControls = driver.findElementByPartialLinkText("Dynamic Controls");
        waits.waitForVisibility(dynamicControls);
        dynamicControls.click();

        Actions actions = new Actions(driver);
        WebElement checkBox = driver.findElementById("checkbox");
        waits.waitForVisibility(checkBox);
        WebElement button = driver.findElementByXPath("//button[contains(text(),'Remove')]");
        button.click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        wait.until(ExpectedConditions.invisibilityOf(checkBox));

        WebElement inputField = driver.findElement(By.tagName("input"));
        WebElement enableDisableBtn = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
        enableDisableBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement enableDisableBtn1 = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
        Assert.assertTrue(enableDisableBtn1.isDisplayed());

        actions.moveToElement(inputField, 5, 5).click().sendKeys("test test test").build().perform();
        driver.quit();

    }

    @Test
    public void FileUploadTest() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement fileUploadLink = driver.findElementByXPath("//a[contains(text(),'File Upload')]");
        waits.waitForVisibility(fileUploadLink);
        fileUploadLink.click();


        Actions actions = new Actions(driver);
        WebElement chooseFileBtn = driver.findElementById("file-upload");
        waits.waitForVisibility(chooseFileBtn);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("picture.jpg").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("pathFile", absolutePath);


        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(absolutePath);
        driver.findElement(By.id("file-submit")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='uploaded-files']")));


        WebElement fileName = driver.findElementByXPath("//div[@id='uploaded-files']");
        String uploadedFileName = fileName.getText();
        String needToBeUploadedFileName = file.getName();

        Assert.assertEquals(uploadedFileName, needToBeUploadedFileName);






    }
}
