package apps.web.google;

import flows.web.google.GmailFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class GmailTest{
    public Properties env;
    GmailFlow gmailFlow;
    TestValidations validate;

    @BeforeMethod
    public void getGmailApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_GMAIL_PROD.properties");
        validate = new TestValidations();
        gmailFlow = new GmailFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateGmailTitle(){
        String expectedTitle = "Gmail";
        String actualTitle = gmailFlow.gmailTitle();
        validate.checkEquals("Validate title: ",actualTitle,expectedTitle);
    }
    @AfterMethod
    public void quitBrowser(){
        gmailFlow.quitBrowser();
    }
}
