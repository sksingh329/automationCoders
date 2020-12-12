package apps.web.herokuapp;

import flows.web.herokuapp.AlertFlow;
import flows.web.herokuapp.CheckBoxesFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;
import utils.assertions.TestValidations;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class CheckBoxTest {
    public Properties env;
    CheckBoxesFlow checkBoxesFlow;
    TestValidations validate;
    @BeforeMethod
    public void getHerokuApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "ENV_WEB_APP_HEROKUAPP.properties");
        validate = new TestValidations();
        checkBoxesFlow = new CheckBoxesFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test
    public void validateCheckBoxesAreSelected(){
        boolean isCheckBox1Selected = checkBoxesFlow.selectCheckBox1();
        boolean isCheckBox2Selected = checkBoxesFlow.selectCheckBox2();
        validate.checkTrue("Validate checkbox1 is selected",isCheckBox1Selected);
        validate.checkTrue("Validate checkbox1 is selected",isCheckBox2Selected);
    }
    @Test
    public void validateCheckBoxesAreDeSelected(){
        boolean isCheckBox1DeSelected = checkBoxesFlow.deSelectCheckBox1();
        boolean isCheckBox2DeSelected = checkBoxesFlow.deSelectCheckBox2();
        validate.checkFalse("Validate checkbox1 is selected",isCheckBox1DeSelected);
        validate.checkFalse("Validate checkbox1 is selected",isCheckBox2DeSelected);
    }
    @AfterMethod
    public void quitBrowser(){
        checkBoxesFlow.quitBrowser();
    }
}
