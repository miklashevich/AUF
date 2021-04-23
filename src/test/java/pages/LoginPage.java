
package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Описание селекторов
    protected static final By emailInputBy = By.id("name");
    protected static final By passwordInputBy = By.id("password");
    protected static final By logInButtonBy = By.id("button_primary");
    protected static final By errorLabelBy = By.className("error-text");
    protected static final By emailIsRequiredBy = By.className("loginpage-message ");


    // Инициализация класса
    public LoginPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getLogInButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    // Методы для WebElement-ов
    public WebElement getEmailInput() {
        return driver.findElement(emailInputBy);
    }
    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputBy);
    }
    public WebElement getLogInButton() {
        return driver.findElement(logInButtonBy);
    }
    public String getErrorText() {
        return driver.findElement(errorLabelBy).getText();
    }
    public String emailIsRequired() {
        return driver.findElement(emailIsRequiredBy).getText();
    }


}
