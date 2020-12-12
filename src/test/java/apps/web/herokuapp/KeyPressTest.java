package apps.web.herokuapp;

import flows.web.herokuapp.ActionSendKeysFlow;
import flows.web.herokuapp.WindowFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class KeyPressTest {
    public Properties env;
    ActionSendKeysFlow actionSendKeysFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        actionSendKeysFlow = new ActionSendKeysFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateValueEnteredInCaps(){
        String input = "rest assured";
        String expectedValue = "You entered: "+input.substring(input.length() - 1).toUpperCase();
        String actualValue = actionSendKeysFlow.typeValueInTarget("shift",input);
        validate.checkEquals("Validate value are entered in capital letter",actualValue,expectedValue);
    }

    @AfterMethod
    public void quitBrowser(){
        actionSendKeysFlow.quitBrowser();
    }
}
