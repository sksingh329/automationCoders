package flows.googleFlows;

import flows.BaseWebFlow;
import pages.web.googlePages.GmailHomePage;
import org.openqa.selenium.WebDriver;

public class GmailFlow extends BaseWebFlow {
    private final WebDriver driver;
    public GmailFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public String gmailTitle(){
        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        return gmailHomePage.getGmailHomePageTitle();
    }
}
