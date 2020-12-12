package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.DoubleClickPage;
import pages.web.herokuapp.HomePage;
import pages.web.herokuapp.WindowPage;

public class DoubleClickFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final DoubleClickPage doubleClickPage;
    public DoubleClickFlow(String browser, String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        doubleClickPage = new DoubleClickPage(driver);
    }
    public String getAlertTextAfterDoubleClick(){
        doubleClickPage.performDoubleClick();
        String alertText = doubleClickPage.getAlertText();
        doubleClickPage.acceptAlert();
        return alertText;
    }
}
