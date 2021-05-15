package pages;


import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ProjectsPage extends BasePage {


    // Описание селекторов

    private static String END_POINT = "index.php?/admin/projects/overview";
    protected static final By sideNavigationSubProjectsBy = By.id("navigation-sub-projects");
    protected static final By messageSuccessBy = By.className("message-success");
    String deleteIconForElementInTableSelector = "//a[text()= 'remove']/ancestor::tr/descendant::div[@class='icon-small-delete']";
    protected static final By checkboxBy = By.xpath("//body/div[@id='dialog-ident-deleteDialog']/div[@id='deleteDialog']/div[2]/div[1]/div[1]/label[1]/input[1]");
    protected static final By buttonOkBy = By.xpath("//body/div[@id='dialog-ident-deleteDialog']/div[@id='deleteDialog']/div[3]/a[1]");
    String rowForElementInTableSelector = "//a[text()='remove']/ancestor::tr";
    protected static final By announcementBy = By.id("announcement");
    protected static final By saveProjectButtonBy = By.id("accept");


    // Инициализация класса

    public ProjectsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return sideNavigationSubProjects().isDisplayed();

        } catch (Exception ex) {
            return false;
        }
    }

    // Методы для WebElement-ов

    public WebElement sideNavigationSubProjects() {
        return driver.findElement(sideNavigationSubProjectsBy);
    }

    public String getMessageSuccess() {
        return driver.findElement(messageSuccessBy).getText();
    }


    public WebElement getDeleteIconForElementInTable(String projectName) {
        return driver.findElement(By.xpath(deleteIconForElementInTableSelector.replace("remove", projectName)));

    }

    public WebElement getCheckbox() {
        return driver.findElement(checkboxBy);
    }

    public WebElement buttonOk() {
        return driver.findElement(buttonOkBy);
    }

    public WebElement getRowForElementInTable(String projectName) {
        return driver.findElement(By.xpath(rowForElementInTableSelector.replace("remove", projectName)));
    }

    public WebElement getAnnouncementInput() {
        return driver.findElement(announcementBy);
    }

    public WebElement saveProjectButton() {
        return driver.findElement(saveProjectButtonBy);
    }
}
