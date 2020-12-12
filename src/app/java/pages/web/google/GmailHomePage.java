package pages.web.google;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailHomePage extends BaseWebPage {
    private WebDriver gmailHomePageDriver;
    private By txtEmailPhone = By.id("identifierId");
    private By btnEmailOrPhone = By.xpath("//button[contains(text(),'Forgot email?')]");
    private By linkLearnMore = By.linkText("Learn more");
    private By linkCreateAccount = By.xpath("//span[contains(text(),'Create account')]");
    private By btnNext = By.xpath("//span[contains(text(),'Next')]");

    public GmailHomePage(WebDriver driver){
        this.gmailHomePageDriver = driver;
    }
    public String getGmailHomePageTitle(){
        return gmailHomePageDriver.getTitle();
    }
    public boolean isTxtEmailPhoneEnabled(){
        return isEnabled(getWebElement(gmailHomePageDriver,txtEmailPhone),gmailHomePageDriver);
    }
    public boolean isBtnEmailOrPhoneEnabled(){
        return isEnabled(getWebElement(gmailHomePageDriver,btnEmailOrPhone),gmailHomePageDriver);
    }
    public boolean isLinkLearnMoreEnabled(){
        return isEnabled(getWebElement(gmailHomePageDriver,linkLearnMore),gmailHomePageDriver);
    }
    public boolean isLinkCreateAccountEnabled(){
        return isEnabled(getWebElement(gmailHomePageDriver,linkCreateAccount),gmailHomePageDriver);
    }
    public boolean isBtnNextEnabled(){
        return isEnabled(getWebElement(gmailHomePageDriver,btnNext),gmailHomePageDriver);
    }
}
