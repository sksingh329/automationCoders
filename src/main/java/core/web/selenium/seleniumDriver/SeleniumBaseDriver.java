package core.web.selenium.seleniumDriver;

import org.openqa.selenium.WebDriver;

public class SeleniumBaseDriver {

    public WebDriver driver;

    public WebDriver getDriver(BrowserType type){
        driver = WebDriverFactory.getInstance().getDriver(type);
        return driver;
    }

    //TODO - Add code for handling browser - getTitle, getWindowHandle, pageRefresh
    public void quitBrowser(){
        driver.quit();
        WebDriverFactory.getInstance().releaseDriver();
    }
    public void cleanCookies(){
        driver.manage().deleteAllCookies();
    }

}
