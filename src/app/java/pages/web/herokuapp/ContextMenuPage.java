package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContextMenuPage extends BaseWebPage {
    private final By divHotSpot = By.id("hot-spot");

    private final WebDriver pageDriver;
    public ContextMenuPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public String getContextMenuText(){
        contextClick(getWebElement(pageDriver,divHotSpot),pageDriver);
        String alertText = getAlertText(pageDriver);
        acceptAlert(pageDriver,true,"ContextMenu");
        return alertText;
    }
}
