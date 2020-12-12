package apps.web.herokuapp;

import flows.web.herokuapp.DoubleClickFlow;
import flows.web.herokuapp.WindowFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.web.herokuapp.DoubleClickPage;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class DoubleClickTest {
    public Properties env;
    DoubleClickFlow doubleClickFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        doubleClickFlow = new DoubleClickFlow(env.getProperty("browser"),env.getProperty("appGuruUrlForDoubleClick"));
    }
    @Test
    public void validateDoubleClickIsPerformed(){
        String actualValue = "You double clicked me.. Thank You..";
        String expectedValue = doubleClickFlow.getAlertTextAfterDoubleClick();
        validate.checkEquals("Validate alert text after double click",actualValue,expectedValue);
    }
    @AfterMethod
    public void quitBrowser(){
        doubleClickFlow.quitBrowser();
    }
}
