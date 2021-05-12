package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

public class LoginTests extends BaseTest {
    @Test
    public void LoginPositiveTest() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test
    public void LoginTestWithIncorrectCredentials() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        Assert.assertEquals(loginPage.getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
    }
    @Test
    public void LoginNegativeTest() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginNegativeTest();


        Assert.assertEquals(loginPage.isPageOpened(), true);

    }



}
