package pages.web.google;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.WebDriver;

public class GmailHomePage extends BaseWebPage {
    private WebDriver gmailHomePageDriver;
    public GmailHomePage(WebDriver driver){
        this.gmailHomePageDriver = driver;
    }
    public String getGmailHomePageTitle(){
        return gmailHomePageDriver.getTitle();
    }
}
