package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BaseWebPage {
    private final By txtEmail = By.id("email");
    private final By btnRetrievePassword = By.id("form_submit");
    private final By lblEmailSentMessage = By.id("content");

    private final WebDriver pageDriver;
    public ForgotPasswordPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public String retrievePassword(String email){
        jsSetValueAttribute(pageDriver,getWebElement(pageDriver,txtEmail),email);
        jsClick(pageDriver,getWebElement(pageDriver,btnRetrievePassword),true,"ForgotPassword");
        return getText(getWebElement(pageDriver,lblEmailSentMessage),pageDriver,true,"EmailSent");
    }
}
