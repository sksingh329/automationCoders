package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.ContextMenuPage;
import pages.web.herokuapp.HomePage;
import pages.web.herokuapp.WindowPage;

public class ContextMenuFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final ContextMenuPage contextMenuPage;
    public ContextMenuFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        contextMenuPage = homePage.getContextMenuPage();
    }
    public String getContextMenuAlertText(){
        return contextMenuPage.getContextMenuText();
    }
}
