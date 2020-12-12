package apps.web.dbBankDemo;

import flows.web.dbBankDemo.DBBankFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class DBBankLoginTest {
    public Properties env;
    TestValidations validate;
    DBBankFlow dbBankFlow;

    @BeforeMethod
    public void getDBBankApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_DBBANK.properties");
        validate = new TestValidations();
        dbBankFlow = new DBBankFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateLoginIsSuccessful(){
        String homePageTitle = dbBankFlow.dbBankLogin("test@test.com","Test@123");
        validate.checkEquals("Validate page title after login",homePageTitle,"Welcome Subodh");
    }
    @AfterMethod
    public void quitBrowser(){
        dbBankFlow.quitBrowser();
    }
}
