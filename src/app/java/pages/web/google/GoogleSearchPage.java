package pages.web.google;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reports.extent.ReporterUtils;

public class GoogleSearchPage extends BaseWebPage {
    private final By txtGoogleSearch = By.name("q");
    private final By btnGoogleSearch = By.xpath("(//input[@name='btnK'])[2]");
    private final By btnImFellingLucky = By.xpath("(//input[@name='btnI'])[2]");
    private final By linkGmail = By.xpath("//a[contains(text(),'Gmail')]");
    private final By linkSignIn = By.xpath("//a[contains(text(),'Sign in')]");
    private final By linkGoogleApps = By.xpath("//a[@title='Google apps']");
    private final By linkImages = By.xpath("//a[contains(text(),'Images')]");

    private final WebDriver pageDriver;
    public GoogleSearchPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public boolean isBtnGoogleSearchEnabled(){
        return isEnabled(getWebElement(pageDriver,btnGoogleSearch));
    }
    public boolean isBtnImFellingLuckyEnabled(){
        return isEnabled(getWebElement(pageDriver,btnImFellingLucky));
    }
    public boolean isLinkGmailEnabled(){
        return isEnabled(getWebElement(pageDriver,linkGmail));
    }
    public boolean isLinkImagesEnabled(){
        return isEnabled(getWebElement(pageDriver,linkImages));
    }
    public boolean isLinkGoogleAppsEnabled(){
        return isEnabled(getWebElement(pageDriver,linkGoogleApps));
    }
    public boolean isLinkSignInEnabled(){
        return isEnabled(getWebElement(pageDriver,linkSignIn));
    }
    public GoogleResultPage doSearch(String text){
        type(getWebElement(pageDriver,txtGoogleSearch),text);
        click(getWebElement(pageDriver,btnGoogleSearch),true,pageDriver,"GoogleSearch");
        return new GoogleResultPage(pageDriver);
    }
}
