package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends BaseWebPage {
    private final By linkClickHere = By.linkText("Click Here");

    private final WebDriver pageDriver;
    public WindowPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public void clickHere(){
        click(getWebElement(pageDriver,linkClickHere),pageDriver);
    }
    public void switchToNewWindow(){
        switchToNewWindow(pageDriver);
    }
    public String getWindowTitle(){
        return getTitle(pageDriver);
    }
    public void switchToParentWindow(){
        switchToDefaultWindow(pageDriver);
    }
}
