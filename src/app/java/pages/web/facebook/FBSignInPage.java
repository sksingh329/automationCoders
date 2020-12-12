package pages.web.facebook;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBSignInPage extends BaseWebPage {
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("pass");
    private final By btnLogIn = By.name("login");
    private final By labelLogInEmailError = By.xpath("//div[@id='email_container']/div[2]");
    private final By labelLoginInPasswordError = By.xpath("//input[@id='pass']/parent::div/div[2]");

    private final WebDriver pageDriver;
    public FBSignInPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public void fbLogin(String userName, String password){
        type(getWebElement(pageDriver,txtEmail),userName,pageDriver);
        type(getWebElement(pageDriver,txtPassword),password,pageDriver);
        click(getWebElement(pageDriver,btnLogIn),pageDriver);
    }
    public String getLoginInEmailError(){
        return getText(getWebElement(pageDriver,labelLogInEmailError),pageDriver,true,"InvalidLogin");
    }
    public String getLogInPasswordError(){
        return getText(getWebElement(pageDriver,labelLoginInPasswordError),pageDriver,true,"InvalidLogin");
    }
}
