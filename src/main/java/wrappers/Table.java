package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private UIElement webElement;
    private List <TableRow> rowList = new ArrayList<>();

    public Table(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);

        int cellsCount = webElement.findElements(By.tagName("col")).size();
        for (WebElement webElement: webElement.findElements(By.tagName("tr"))){
            TableRow tableRow = new TableRow(webDriver, webElement);
            tableRow.setCellsCount(cellsCount);
            rowList.add(tableRow);
        }

    }

    public int RowsCount(){
        return rowList.size();
    }
    public int getCellsCountForRow(int index){
        return rowList.get(index).getCellsCount();
    }
   public TableRow getRowByTextInColumn(String text, int column){
        return null;
   }
    public TableRow getRowByTextInColumn(String text, String columnName){
        return null;
    }


}
