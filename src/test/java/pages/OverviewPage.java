package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/overview";
    protected static final By sideNavigationSubProjectsBy = By.id("navigation-sub-projects");
    protected static final By messageSuccessBy = By.className("message-success");

    public OverviewPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
       driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return sideNavigationSubProjects().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement sideNavigationSubProjects() {
        return driver.findElement(sideNavigationSubProjectsBy);
    }

    public String getMessageSuccess() {
        return driver.findElement(messageSuccessBy).getText();}

}
