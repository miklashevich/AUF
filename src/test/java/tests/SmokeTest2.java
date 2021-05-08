package tests;

import baseEntities.BaseTest;
import core.BrowsersService;
import enums.ProjectType;
import models.Project;
import models.ProjectBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OverviewPage;
import steps.LoginSteps;
import steps.ProjectSteps;

import java.util.concurrent.TimeUnit;

public class SmokeTest2 extends BaseTest {

    @Test
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

        Assert.assertEquals(loginPage.getEmailInput().getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

    @Test //(dependsOnMethods = "LoginTestWithIncorrectCredentials")
    public void AddNewProjectTes() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

    }

    @Test
    public void chainTest() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");


        WebDriverWait wait = new WebDriverWait(browsersService.getDriver(), 20);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidebar-projects-add")));

        Assert.assertTrue(webElement.isDisplayed());
    }

    @Test
    public void AddNewProjectTestBuilder() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();
        ProjectBuilder project = new ProjectBuilder.Builder()
                .withName("A_Mik5")
                .withAnnouncement("Test builder")
                .withIsShowAnnouncement(true)
                .withType(ProjectType.MULTIPLE)
                .build();

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.addProject(project);

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully added the new project.");

    }
}