package tests.uiTests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginSteps;

public class ChainTest extends BaseTest {


    @Test
    public void chainTest() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage =
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

    }
}