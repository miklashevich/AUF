package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.CheckBox;
import wrappers.RadioButton;

import java.util.List;

public class AddProjectPage extends BasePage {

    // Описание селекторов
    protected static final By nameBy = By.id("name");
    protected static final By announcementBy = By.id("announcement");
    protected static final By addProjectButtonBy = By.id("accept");
    protected static final By successTextBy = By.className("message-success");
    protected static final By isShowAnnouncementBy = By.id("show_announcement");
    protected static final By selectTypeBy = By.name("suite_mode");
    protected static final By suite_mode_singleBy = By.id("suite_mode_single");
    protected static final By suite_mode_single_baselineBy = By.id("suite_mode_single_baseline");
    protected static final By suite_mode_multiBy = By.id("suite_mode_multi");
    protected static final By radioButtonSelector = By.cssSelector("[name='suite_mode']");




    // Инициализация класса
    public AddProjectPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return addProjectButton() .isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    // Методы для WebElement-ов
    public WebElement addProjectButton() {
        return driver.findElement(addProjectButtonBy);
    }

    public WebElement getNameInput() {
        return driver.findElement(nameBy);
    }
    public WebElement getAnnouncementInput() {
        return driver.findElement(announcementBy);
    }

    //public WebElement IsShowAnnouncementInput() { return driver.findElement(isShowAnnouncementBy);}
    public CheckBox setCheckBox(){
        return new CheckBox(driver, isShowAnnouncementBy);
    }

    public WebElement getTypeInput() {return driver.findElement(selectTypeBy);}

    public WebElement suite_mode_singleInput() { return driver.findElement(suite_mode_singleBy);}
   public WebElement suite_mode_single_baselineInput() { return driver.findElement(suite_mode_single_baselineBy);}
    public WebElement suite_mode_multiInput() { return driver.findElement(suite_mode_multiBy);}


    public String getSuccessText() {

        return driver.findElement(successTextBy).getText();
    }

public RadioButton radioButton(){
        return new RadioButton(driver, radioButtonSelector);
}




}

