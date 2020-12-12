package pages.web.facebook;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBHomePage extends BaseWebPage {
    String pageTitle = "Facebook – log in or sign up";

    private final By btnForgotPassword = By.linkText("Forgotten password?");
    private final By btnCreateNewAccount = By.linkText("Create New Account");
    private final By btnCreatePage = By.linkText("Create a Page");

    private final WebDriver pageDriver;
    public FBHomePage(WebDriver driver){
        this.pageDriver = driver;
    }
    public String checkTitle(){
        return getTitle(pageDriver);
    }
    public FBSignInPage getFBSignInPage(){
        return new FBSignInPage(pageDriver);
    }
    public FBSignUpPage clickCreateNewAccount(){
        click(getWebElement(pageDriver,btnCreateNewAccount),pageDriver);
        return new FBSignUpPage(pageDriver);
    }
}
