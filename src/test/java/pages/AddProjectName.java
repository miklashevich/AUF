import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddProjectName extends BasePage{

    protected static final By nameBy = By.id("name");
    protected static final By announcementBy = By.id("announcement");
    protected static final By addProjectButtonBy = By.id("accept");


    public AddProjectName(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
@Override
    protected void openPage() {
    driver.get(baseUrl);
}

@Override
    public boolean isPageOpened() {
        try {
            return addProjectButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }


    public WebElement getNameProjectInput() {
        return driver.findElement(nameBy);
    }
    public WebElement getAnnouncementInput() {
        return driver.findElement(announcementBy);
    }
    public WebElement addProjectButton() {
        return driver.findElement(addProjectButtonBy);
    }


}