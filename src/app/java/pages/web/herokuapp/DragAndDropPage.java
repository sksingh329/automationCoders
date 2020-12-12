package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BaseWebPage {
    private final By divColumnA = By.id("column-a");
    private final By divColumnB = By.id("column-b");

    private final WebDriver pageDriver;
    public DragAndDropPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public void performDragAndDrop(){
        dragAndDrop(getWebElement(pageDriver,divColumnA),getWebElement(pageDriver,divColumnB),
                pageDriver,true,"DragAndDrop");
    }
}
