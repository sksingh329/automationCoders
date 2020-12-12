package apps.web.herokuapp;

import flows.web.herokuapp.HoversFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class HoversTest {
    public Properties env;
    HoversFlow hoversFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        hoversFlow = new HoversFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateUserCaption(){
        String expectedUser1Caption = "name: user1";
        String expectedUser2Caption = "name: user2";
        String expectedUser3Caption = "name: user3";
        String actualUser1Caption = hoversFlow.hoverAndGetFirstAvatarCaption();
        String actualUser2Caption = hoversFlow.hoverAndGetSecondAvatarCaption();
        String actualUser3Caption = hoversFlow.hoverAndGetThirdAvatarCaption();
        validate.checkEquals("Validate user1 action",actualUser1Caption,expectedUser1Caption);
        validate.checkEquals("Validate user2 action",actualUser2Caption,expectedUser2Caption);
        validate.checkEquals("Validate user3 action",actualUser3Caption,expectedUser3Caption);
    }
    @AfterMethod
    public void quitBrowser(){
        hoversFlow.quitBrowser();
    }
}
