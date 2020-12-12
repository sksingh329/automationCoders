package apps.web.herokuapp;

import flows.web.herokuapp.ForgotPasswordFlow;
import flows.web.herokuapp.WindowFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class ForgotPasswordTest {
    public Properties env;
    ForgotPasswordFlow forgotPasswordFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        forgotPasswordFlow = new ForgotPasswordFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void retrievePasswordTestUsingJs(){
        String email = "test@test.com";
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = forgotPasswordFlow.forgotPasswordUsingJs(email);
        validate.checkEquals("Validate Email Sent Message",actualMessage,expectedMessage);
    }

    @AfterMethod
    public void quitBrowser(){forgotPasswordFlow.quitBrowser();}
}
