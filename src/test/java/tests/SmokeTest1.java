package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OverviewPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class SmokeTest1 extends BaseTest {

    @Test (timeOut = 8000L, description = "max время выполнения теста, если не успее будет fail")
    public void LoginTest() {
/*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard page отобразился
*/
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test
    public void LoginTestWithIncorrectCredentials() {
/*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard page отобразился
*/
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        Assert.assertEquals(loginPage.errorLabel.getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }


    @Test
    public void waitTest() {

        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.emailInput.sendKeys("atrostyanko+0401@gmail.com");
        loginPage.passwordInput.sendKeys("QqtRK9elseEfAk6ilYcJ");
        loginPage.logInButton.click();

        WebDriverWait wait = new WebDriverWait(browsersService.getDriver(), 20);
WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidebar-projects-add")));

       Assert.assertTrue(webElement.isDisplayed());

    }
    @Test
    public void waitTest2() {

        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.emailInput.sendKeys("atrostyanko+0401@gmail.com");
        loginPage.passwordInput.sendKeys("QqtRK9elseEfAk6ilYcJ");
        loginPage.logInButton.click();


        WebElement webElement = waits.waitForVisibility(By.id("sidebar-projects-add"));
        Assert.assertTrue(webElement.isDisplayed());

    }
    @Test
    public void waitTest3() {

        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.emailInput.sendKeys("atrostyanko+0401@gmail.com");
        loginPage.passwordInput.sendKeys("QqtRK9elseEfAk6ilYcJ");
        loginPage.logInButton.click();


        WebElement webElement = waits.waitForVisibility(
                new DashboardPage(browsersService, false).getSidebarProjectsAddButton());
        Assert.assertTrue(webElement.isDisplayed());

    }
   @Test
   public void actionTest(){
       LoginSteps loginSteps = new LoginSteps(browsersService);
       DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials ("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

       dashboardPage.getSidebarProjectsAddButton().click();

       WebElement icon = waits.waitForVisibility(By.className("icon-markdown-table"));
       Actions actions = new Actions(browsersService.getDriver());
       actions.moveToElement(icon).build().perform();
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e){
           e.printStackTrace();
       }


   }

}
