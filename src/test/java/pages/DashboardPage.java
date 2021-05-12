package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends BasePage {
    private static String END_POINT = "index.php?/dashboard";


    protected static final By sidebarProjectsAddButtonBy = By.id("sidebar-projects-add");
    protected static final By projectsListBy = By.className("flex-projects-row");


    public DashboardPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSidebarProjectsAddButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }

    }

    public WebElement getSidebarProjectsAddButton() {
        return driver.findElement(sidebarProjectsAddButtonBy);
    }

}


