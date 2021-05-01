package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 5;
    protected WebDriver driver;
    protected BrowsersService browsersService;
    public String baseUrl;

    protected abstract void openPage();
    public abstract boolean isPageOpened();

    public BasePage(BrowsersService browsersService, boolean openPageByUrl) {
        this.browsersService = browsersService;
        this.driver = browsersService.getDriver();
        this.baseUrl = new ReadProperties().getURL();

        if (openPageByUrl) {
            openPage();
        }

        waitForOpen();
    }

    protected void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS) {
            browsersService.sleep(1000);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened.");
        }
    }
}
