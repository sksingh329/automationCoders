package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.ActionSendKeysPage;
import pages.web.herokuapp.HomePage;
import pages.web.herokuapp.WindowPage;

public class ActionSendKeysFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final ActionSendKeysPage actionSendKeysPage;
    public ActionSendKeysFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        actionSendKeysPage = homePage.getKeyPressPage();
    }
    public String typeValueInTarget(String key,String text){
        return actionSendKeysPage.typeValueInTarget(key,text);
    }
}
