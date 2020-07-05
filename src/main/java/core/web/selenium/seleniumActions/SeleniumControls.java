package core.web.selenium.seleniumActions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import utils.CustomLogger;


public class SeleniumControls extends SeleniumDropDown {
    public Logger log = CustomLogger.getLogger(SeleniumControls.class.getName());

    public boolean click(WebElement elem){
        //System.out.println("Clicking on "+locator.toString());
        elem.click();
        log.info("Element "+elem+ " is clicked.");
        return true;
    }
    public boolean submit(WebElement elem){
        elem.submit();
        log.info("Element "+elem+" is submitted.");
        return true;
    }
    public boolean type(WebElement elem,String value){
        elem.sendKeys(value);
        log.info("Element "+elem+" is entered with value "+value);
        return true;
    }
    public String getText(WebElement elem){
        String text = elem.getText();
        log.info("Elements "+elem+" contains text "+text);
        return text;
    }
}
