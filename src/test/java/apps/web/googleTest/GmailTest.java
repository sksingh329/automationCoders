package apps.web.googleTest;

import flows.googleFlows.GmailFlow;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class GmailTest {
    public Properties env;
    public Logger log;
    GmailFlow gmailFlow;

    @BeforeMethod
    public void getGmailApp(){
        env = HandlePropertiesFile.loadProperties("src/test/java/env/", "ENV_WEB_GMAIL_PROD.properties");
        //log = CustomLogger.getLogger(GmailTest.class.getName());
        gmailFlow = new GmailFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateGmailTitle(){
        String expectedTitle = "Gmail";
        String actualTitle = gmailFlow.gmailTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @AfterMethod
    public void quitBrowser(){
        gmailFlow.quitBrowser();
    }
}
