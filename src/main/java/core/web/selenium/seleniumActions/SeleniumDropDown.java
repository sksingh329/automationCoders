package core.web.selenium.seleniumActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDropDown extends SeleniumElements {

    public void selectByIndex(WebDriver driver, By locator, int index){
        new Select(getWebElement(driver,locator)).selectByIndex(index);
    }
    public void selectByValue(WebDriver driver,By locator, String value){
        new Select(getWebElement(driver,locator)).selectByValue(value);
    }
    public void selectByVisibleText(WebDriver driver,By locator, String text){
        new Select(getWebElement(driver,locator)).selectByVisibleText(text);
    }
}
