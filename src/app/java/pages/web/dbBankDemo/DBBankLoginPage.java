package pages.web.dbBankDemo;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DBBankLoginPage extends BaseWebPage {
    private final By txtUserName = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnSignIn = By.id("submit");

    private final WebDriver pageDriver;
    public DBBankLoginPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public DBBankHomePage login(String userName, String password){
        type(getWebElement(pageDriver,txtUserName),userName,pageDriver);
        type(getWebElement(pageDriver,txtPassword),password,pageDriver);
        click(getWebElement(pageDriver,btnSignIn),pageDriver);
        return new DBBankHomePage(pageDriver);
    }
}
