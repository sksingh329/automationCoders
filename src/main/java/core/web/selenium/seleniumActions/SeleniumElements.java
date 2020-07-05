package core.web.selenium.seleniumActions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CustomLogger;


public class SeleniumElements extends SeleniumAlert {
    private final int WAIT_SLEEP_TIME_IN_MILLIS = 100;
    Logger log = CustomLogger.getLogger(SeleniumElements.class.getName());

    public boolean isEnabled(WebDriver driver, By locator){
        return driver.findElement(locator).isEnabled();
    }
    public boolean isDisplayed(WebDriver driver,By locator){return driver.findElement(locator).isDisplayed();}
    public boolean isSelected(WebDriver driver,By locator){return driver.findElement(locator).isSelected();}
    public WebElement getWebElement(WebDriver driver, By locator){
        WebElement elem = driver.findElement(locator);
        if(elem.isEnabled())
            log.info("Element "+elem+" is located and enabled");
        return elem;
    }
    public WebElement getWebElementAfterVisible(WebDriver driver,By locator, int durationInSeconds){
        WebDriverWait webDriverWait = new WebDriverWait(driver,durationInSeconds);
        WebElement elem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(elem.isEnabled()) return elem;
        return null;
    }
}
