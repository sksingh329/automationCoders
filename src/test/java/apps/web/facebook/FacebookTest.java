package apps.web.facebook;

import flows.web.facebook.FBFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class FacebookTest {
    public Properties env;
    TestValidations validate;
    FBFlow faceBookApp;

    @BeforeMethod
    public void getFBApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_FACEBOOK.properties");
        validate = new TestValidations();
        faceBookApp = new FBFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void testFBSignUp(){
        faceBookApp.fbSignUp("Subodh","Singh","8050086130","test123","1","Dec","1986","male");
    }
    @Test(enabled = false)
    public void validateFBTitle(){
        String expectedTitle = "Facebook";
        validate.checkEquals("Check FB title: ",faceBookApp.checkFbTitle(),expectedTitle);
    }
    @Test(enabled = false)
    public void testFBLogInErrorWithBlankEmailAndPassword(){
        String expectedError = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
        String actualError = faceBookApp.fbInvalidLogin("","");
        validate.checkEquals("Validate Email Field Error while login with blank user name and password",actualError,expectedError);
    }
    @Test(enabled = false)
    public void testFBLogInErrorWithValidEmailAndBlankPassword(){
        String expectedError = "The password that you've entered is incorrect. Forgotten password?";
        String actualError = faceBookApp.fbInvalidLogin("8050086130","");
        validate.checkEquals("Validate Password Field Error while login with blank user name and password",actualError,expectedError);
    }
    @Test(enabled = false)
    public void testFBLogInErrorWithInvalidEmailAndPassword(){
        String expectedError = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
        String actualError = faceBookApp.fbInvalidLogin("test@","1232");
        validate.checkEquals("Validate Email Field Error while login with blank user name and password",actualError,expectedError);
    }
    @AfterMethod
    public void quitBrowser(){
        faceBookApp.quitBrowser();
    }
}
