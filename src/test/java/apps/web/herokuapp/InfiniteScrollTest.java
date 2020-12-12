package apps.web.herokuapp;

import flows.web.herokuapp.InfiniteScrollFlow;
import flows.web.herokuapp.WindowFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class InfiniteScrollTest {
    public Properties env;
    InfiniteScrollFlow infiniteScrollFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        infiniteScrollFlow = new InfiniteScrollFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateJsScroll(){
       int expectedCount = 2;
       int actualCount =  infiniteScrollFlow.getJsScrollCount();
       validate.checkEquals("Validate count of jsScrollAdded element on page",actualCount,expectedCount);
        infiniteScrollFlow.scrollWindowUsingJs();
        infiniteScrollFlow.getJsScrollCount();
    }
    @AfterMethod
    public void quitBrowser(){
        infiniteScrollFlow.quitBrowser();
    }
}
