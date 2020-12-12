package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BaseWebPage {
    private final By btnJsAlert = By.xpath("//button[text()='Click for JS Alert']");
    private final By btnJsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    private final By btnJsPrompt = By.xpath("//button[text()='Click for JS Prompt']");
    private final By lblResult = By.id("result");

    private final WebDriver pageDriver;
    public AlertPage(WebDriver driver){
        this.pageDriver = driver;
    }
    public void clickBtnJsAlert(){
        click(getWebElement(pageDriver,btnJsAlert),pageDriver);
    }
    public void clickBtnJsConfirm(){
        click(getWebElement(pageDriver,btnJsConfirm),pageDriver);
    }
    public void clickBtnJsPrompt(){
        click(getWebElement(pageDriver,btnJsPrompt),pageDriver);
    }
    public String getResult(){
        return getText(getWebElement(pageDriver,lblResult),pageDriver);
    }
    public String handleAlert(){
        clickBtnJsAlert();
        String alertText = getAlertText(pageDriver);
        acceptAlert(pageDriver);
        return alertText;
    }
    public String handleAlertConfirm(){
        clickBtnJsConfirm();
        String alertText = getAlertText(pageDriver);
        acceptAlert(pageDriver);
        return alertText;
    }
    public String handleAlertPrompt(String value){
        clickBtnJsPrompt();
        String alertText = getAlertText(pageDriver);
        sendKeysAlert(pageDriver,value);
        acceptAlert(pageDriver);
        return alertText;
    }
}
