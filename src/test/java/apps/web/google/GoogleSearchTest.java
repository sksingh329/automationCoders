package apps.web.google;


import flows.web.google.GoogleSearchFlow;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.assertions.TestValidations;
import utils.HandlePropertiesFile;

import java.util.Properties;


@Listeners(reports.listeners.TestNGListener.class)
public class GoogleSearchTest {
    public Properties env;
    public Logger log;
    GoogleSearchFlow googleSearch;
    TestValidations validate;
    @BeforeMethod
    public void getGoogleSearchApp(){
        env = HandlePropertiesFile.loadProperties("src/test/resources/env/", "env.properties");
        validate = new TestValidations();
        googleSearch = new GoogleSearchFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test(testName = "Validate Google Menu Controls Are Enabled")
    public void validateGoogleMenusControlsAreEnabled(){
        googleSearch.validateGoogleMenusIsEnabled();
    }
    @Test(testName = "Validate Google Search Controls Are Enabled")
    public void validateGoogleSearchControlsAreEnabled(){
        googleSearch.validateGoogleSearchControlsAreEnabled();
    }
    @Test(testName = "Google Search",dataProvider = "googleSearchTestData")
    public void googleSearchTest(String searchValue){
        String resultStat = googleSearch.googleSearch(searchValue);
        validate.checkNotNull(resultStat);
    }
    @DataProvider
    public Object[][] googleSearchTestData(){
        Object[][] data=new Object[2][1];
        data[0][0] = "Selenium";
        data[1][0] = "Appium";
        return data;
    }
    @AfterClass
    public void closeBrowser(){
        googleSearch.quitBrowser();
    }
}
