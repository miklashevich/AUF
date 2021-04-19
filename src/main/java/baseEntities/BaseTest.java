package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected BrowsersService browsersService;
    protected ReadProperties readProperties;

    @BeforeSuite
    public void setupSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeGroups
    public void setupGroups(){
        System.out.println("BeforeGroups");
    }

    @BeforeTest
    public void setupTest() {
        System.out.println("BeforeTest");
        readProperties = new ReadProperties();
    }

    @BeforeClass
    public void setupClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void setupMethod() {
        browsersService = new BrowsersService();
        browsersService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        browsersService.getDriver().get(readProperties.getURL());
    }

    @AfterMethod
    public void tearDownMethod() {
        browsersService.getDriver().quit();
        browsersService = null;
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("BeforeClass");
    }

    @AfterTest
    public void tearDownTest(){
    System.out.println("AfterTest");
    }


    @AfterGroups
    public void tearDownGroups(){
        System.out.println("AfterGroups");
    }


    @AfterSuite
    public void tearDownSuite(){
        System.out.println("AfterSuite");
    }

}
