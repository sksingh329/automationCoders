package apps.web.herokuapp;

import flows.web.herokuapp.AlertFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

/*
    Link - http://the-internet.herokuapp.com/javascript_alerts
    Click for JS Alert
    Click for JS confirm
    Click for JS prompt
 */
@Listeners(reports.listeners.TestNGListener.class)
public class AlertTest {
    public Properties env;
    AlertFlow alertFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        alertFlow = new AlertFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void testJSAlert(){
        String expectedMessage = "I am a JS Alert";
        String expectedResult = "You successfuly clicked an alert";
        String actualMessage = alertFlow.getAlertMessage();
        String actualResult = alertFlow.getResult();
        validate.checkEquals("Validate Alert text",actualMessage,expectedMessage);
        validate.checkEquals("Validate result text",actualResult,expectedResult);
    }
    @Test
    public void testJSConfirm(){
        String expectedMessage = "I am a JS Confirm";
        String expectedResult = "You clicked: Ok";
        String actualMessage = alertFlow.getAlertConfirmMessage();
        String actualResult = alertFlow.getResult();
        validate.checkEquals("Validate Alert text",actualMessage,expectedMessage);
        validate.checkEquals("Validate result text",actualResult,expectedResult);
    }
    @Test
    public void testJSPrompt(){
        String alertText = "Hello Js Alert";
        String expectedMessage = "I am a JS prompt";
        String expectedResult = "You entered: "+alertText;
        String actualMessage = alertFlow.getAlertPromptMessage(alertText);
        String actualResult = alertFlow.getResult();
        validate.checkEquals("Validate Alert text",actualMessage,expectedMessage);
        validate.checkEquals("Validate result text",actualResult,expectedResult);
    }
    @AfterMethod
    public void quitBrowser(){
        alertFlow.quitBrowser();
    }

}
