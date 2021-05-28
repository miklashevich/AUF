package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RowsCell {
    private UIElement webElement;

    public RowsCell(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);

    }

    public RowsCell(WebDriver webDriver, WebElement webElement) {
        this.webElement = new UIElement(webDriver, webElement);
    }
}
