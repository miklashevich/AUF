package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

    private UIElement webElement;

    public CheckBox(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
    }

    public CheckBox(WebDriver webDriver, WebElement webElement) {
        this.webElement = new UIElement(webDriver, webElement);
    }

    public void setCheckBox(){
        webElement.click();
    }

}
