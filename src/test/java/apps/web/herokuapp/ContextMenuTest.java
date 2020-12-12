package apps.web.herokuapp;

import flows.web.herokuapp.ContextMenuFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class ContextMenuTest {
    public Properties env;
    ContextMenuFlow contextMenuFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        contextMenuFlow = new ContextMenuFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateContextMenuAlert(){
        String expectedContextMenuAlertText = "You selected a context menu";
        String actualContextMenuAlertText = contextMenuFlow.getContextMenuAlertText();
        validate.checkEquals("Validate context menu alert text",actualContextMenuAlertText,expectedContextMenuAlertText);
    }

    @AfterMethod
    public void quitBrowser(){
        contextMenuFlow.quitBrowser();
    }
}
