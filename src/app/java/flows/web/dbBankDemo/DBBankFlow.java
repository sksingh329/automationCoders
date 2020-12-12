package flows.web.dbBankDemo;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.dbBankDemo.DBBankHomePage;
import pages.web.dbBankDemo.DBBankLoginPage;

public class DBBankFlow extends BaseWebFlow {
    private final WebDriver driver;
    public DBBankFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public String dbBankLogin(String userName, String password){
        DBBankLoginPage loginPage = new DBBankLoginPage(driver);
        DBBankHomePage dbBankHomePage = loginPage.login(userName,password);
        return dbBankHomePage.getPageTitle();
    }
}
