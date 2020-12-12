package apps.web.herokuapp;

import flows.web.herokuapp.FrameFlow;
import flows.web.herokuapp.WindowFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class NewWindowTest {
    public Properties env;
    WindowFlow windowFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        windowFlow = new WindowFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateNewWindowTitle(){
        String expectedTitle = "New Window";
        String actualTitle = windowFlow.getNewWindowTitle();
        validate.checkEquals("Validate new window title",actualTitle,expectedTitle);
    }
    @Test
    public void validateParentWindowTitle(){
        String expectedTitle = "The Internet";
        String actualTitle = windowFlow.getParentWindowTitle();
        validate.checkEquals("Validate parent window title",actualTitle,expectedTitle);
    }
    @AfterMethod
    public void quitBrowser(){
        windowFlow.quitBrowser();
    }
}
