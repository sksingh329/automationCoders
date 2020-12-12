package core.web.selenium.seleniumDriver;

import org.openqa.selenium.WebDriver;

public class SeleniumBaseDriver {
    private WebDriver driver;

    public WebDriver getDriver(BrowserType type) {
        driver = WebDriverFactory.getInstance().getDriver(type);
        return driver;
    }
    public void quitBrowser(){
        driver.quit();
        WebDriverFactory.getInstance().releaseDriver();
    }
}
