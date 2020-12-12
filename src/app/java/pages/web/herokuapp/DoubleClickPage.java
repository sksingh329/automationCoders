package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DoubleClickPage extends BaseWebPage {
   private final By btnDoubleClick = By.xpath("//button[text()='Double-Click Me To See Alert']");

    private final WebDriver pageDriver;
    public DoubleClickPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public void performDoubleClick(){
        doubleClick(getWebElement(pageDriver,btnDoubleClick),pageDriver);
    }
    public String getAlertText(){
        return getAlertText(pageDriver);
    }
    public void acceptAlert(){
        acceptAlert(pageDriver);
    }
}
