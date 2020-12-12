package apps.web.herokuapp;

import flows.web.herokuapp.FrameFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class FrameTest {
    public Properties env;
    FrameFlow frameFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        frameFlow = new FrameFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateTextInsideFrame(){
        String expectedLeftText = "LEFT";
        String expectedRightText = "RIGHT";
        String expectedMiddleText = "MIDDLE";
        String actualLeftText = frameFlow.getTextFromLeftFrame();
        String actualRightText = frameFlow.getTextFromRightFrame();
        String actualMiddleText = frameFlow.getTextFromMiddleFrame();
        validate.checkEquals("Validate text in left frame",actualLeftText,expectedLeftText);
        validate.checkEquals("Validate text in right frame",actualRightText,expectedRightText);
        validate.checkEquals("Validate text in middle frame",actualMiddleText,expectedMiddleText);
    }
    @AfterMethod
    public void quitBrowser(){
        frameFlow.quitBrowser();
    }
}
