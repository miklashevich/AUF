
package pages;

import baseEntities.BasePage;
import baseEntities.BasePageFactory;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;

public class LoginPage extends BasePageFactory {

    // Описание селекторов
    @FindBy(id = "name")
    public WebElement emailInput;
    // protected static final By emailInputBy = By.id("name");//

    @FindBy(id = "password")
    public WebElement passwordInput;
    //protected static final By passwordInputBy = By.id("password");

    @FindBy(id = "button_primary")
    public WebElement logInButton;
    // protected static final By logInButtonBy = By.id("button_primary");

    @FindBy(className = "error-text")
    public WebElement errorLabel;
    //protected static final By errorLabelBy = By.className("error-text");

    @FindBy(className = "loginpage-message")
    public WebElement emailIsRequired;
    // protected static final By emailIsRequiredBy = By.className("loginpage-message");

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
            return logInButton.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

}


