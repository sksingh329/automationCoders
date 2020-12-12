package apps.web.herokuapp;

import flows.web.herokuapp.DragAndDropFlow;
import flows.web.herokuapp.WindowFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class DragAndDropTest {
    public Properties env;
    DragAndDropFlow dragAndDropFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        dragAndDropFlow = new DragAndDropFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateDragAndDropIsPerformed(){
        dragAndDropFlow.actionDragAndDrop();
    }

    @AfterMethod
    public void quitBrowser(){
        dragAndDropFlow.quitBrowser();
    }
}
