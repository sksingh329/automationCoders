package apps.web.googleTest;


import flows.googleFlows.GoogleSearchFlow;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import utils.CustomLogger;
import utils.HandlePropertiesFile;

import java.util.Properties;


@Listeners(reports.listeners.TestNGListener.class)
public class GoogleSearchTest {
    public Properties env;
    public Logger log;
    GoogleSearchFlow googleSearch;
    @BeforeMethod
    public void getGoogleSearchApp(){
        env = HandlePropertiesFile.loadProperties("src/test/java/env/", "env.properties");
        log = CustomLogger.getLogger(GoogleSearchTest.class.getName());
        googleSearch = new GoogleSearchFlow(env.getProperty("browser"),env.getProperty("appUrl"));
    }
    @Test(testName = "Validate Google Menu Controls Are Enabled")
    public void validateGoogleMenusControlsAreEnabled(){
        log.info("*********Test Start - validateGoogleMenusControlsAreEnabled**********");
        googleSearch.validateGoogleMenusIsEnabled();
        log.info("*********Test End - validateGoogleMenusControlsAreEnabled**********");
    }
    @Test(testName = "Validate Google Search Controls Are Enabled")
    public void validateGoogleSearchControlsAreEnabled(){
        log.info("*********Test Start - validateGoogleSearchControlsAreEnabled**********");
        googleSearch.validateGoogleSearchControlsAreEnabled();
        log.info("*********Test End - validateGoogleSearchControlsAreEnabled**********");
    }
    @Test(testName = "Google Search",dataProvider = "googleSearchTestData")
    public void googleSearchTest(String searchValue){
        log.info("*********Test Start - googleSearchTest**********");
        googleSearch.googleSearch(searchValue);
        log.info("*********Test End - googleSearchTest**********");
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
