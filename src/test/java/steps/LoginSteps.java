package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps extends BaseStep {

    public LoginSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step ("Логирование с корректными '{email}' '{psw}'")
    public DashboardPage loginWithCorrectCredentials(String email, String psw) {
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLogInButton().click();

        return new DashboardPage(browsersService, false);
    }

    @Step("Логирование с корректными '{email}' '{psw}'")
    public LoginPage loginWithIncorrectCredentials(String email, String psw) {
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLogInButton().click();

        return new LoginPage(browsersService, false);
    }

    @Step
    public LoginPage loginNegativeTest() {
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.getLogInButton().click();

        return new LoginPage(browsersService, false);
    }

}
