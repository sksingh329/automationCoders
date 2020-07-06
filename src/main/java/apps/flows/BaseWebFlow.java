package apps.flows;

import core.web.selenium.seleniumDriver.BrowserType;
import core.web.selenium.seleniumDriver.SeleniumBaseDriver;
import org.openqa.selenium.WebDriver;



public class BaseWebFlow extends SeleniumBaseDriver {
   public WebDriver getWebDriver(String browser){
        BrowserType browserType;
        String browserParam = browser.toUpperCase();
       switch (browserParam){
           case "FIREFOX":
               browserType=BrowserType.FIREFOX;
               break;
           case "SAFARI":
               browserType=BrowserType.SAFARI;
               break;
           default:
               browserType=BrowserType.CHROME;
       }
       return super.getDriver(browserType);
    }
}
