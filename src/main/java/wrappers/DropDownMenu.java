package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private UIElement webElement;
    private List<UIElement> optionsList = new ArrayList<>();
    private List<String> optionsTextList = new ArrayList<>();
    private WebDriver webDriver;


    public DropDownMenu(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
       List<WebElement> options = webDriver.findElements(by);
       optionsTextList = getAllOptions(options);
    }
   private List<String> getAllOptions(List<WebElement>dropDownMenuList) {
       List<String> resultList = new ArrayList<>();

       for (WebElement webElement : dropDownMenuList) {
           UIElement uiElement = new UIElement(webDriver, webElement);
          optionsList.add(uiElement);
          resultList.add(uiElement.findElement(By.className("dropdown-menu-link")).getText());
       }
       return resultList;
    }

    public void openDropDownMenu(){
        webElement.click();
    }
    public void selectByOptions(String optionName){
        int index = optionsTextList.indexOf(optionName);
        optionsList.get(index).click();
    }
    public void click(){
        webElement.click();
    }
}


