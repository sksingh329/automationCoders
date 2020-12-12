package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionSendKeysPage extends BaseWebPage {
    private final By textTarget = By.id("target");
    private final By lblResult = By.id("result");

    private final WebDriver pageDriver;
    public ActionSendKeysPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public String typeValueInTarget(String key,String text){
        actionKeysDownTypeKeysUp(getWebElement(pageDriver,textTarget),pageDriver,
        key,text,true,"CapsLetter");
        String getText = getText(getWebElement(pageDriver,textTarget),pageDriver);
        String getResultText = getText(getWebElement(pageDriver,lblResult,true,"Keys"),pageDriver);
        return getResultText;
    }
}
