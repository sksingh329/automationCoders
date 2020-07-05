package core.web.selenium.seleniumDriver;

import org.openqa.selenium.WebDriver;

public class SeleniumBaseDriver {

    public WebDriver driver;

    public WebDriver getDriver(BrowserType type){
        driver = WebDriverFactory.getInstance().getDriver(type);
        return driver;
    }

    //TODO - Add code for handling browser - getTitle, getWindowHandle, pageRefresh
    public String getTitle(){return driver.getTitle();}
    public void quitBrowser(){
        driver.close();
    }
    public void cleanCookies(){
        driver.manage().deleteAllCookies();
    }

}
