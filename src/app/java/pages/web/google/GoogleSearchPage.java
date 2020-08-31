package pages.web.google;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reports.extent.CustomReporter;
import utils.CustomLogger;


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
        log = CustomLogger.getLogger(GoogleSearchPage.class.getName());
    }

    public boolean isBtnGoogleSearchEnabled(){
        return isEnabled(pageDriver,btnGoogleSearch);
    }
    public boolean isBtnImFellingLuckyEnabled(){
        return isEnabled(pageDriver,btnImFellingLucky);
    }
    public boolean isLinkGmailEnabled(){
        return isEnabled(pageDriver,linkGmail);
    }
    public boolean isLinkImagesEnabled(){
        return isEnabled(pageDriver,linkImages);
    }
    public boolean isLinkGoogleAppsEnabled(){
        return isEnabled(pageDriver,linkGoogleApps);
    }
    public boolean isLinkSignInEnabled(){
        return isEnabled(pageDriver,linkSignIn);
    }


    public GoogleResultPage doSearch(String text){
        String methodInfo = "GoogleSearchPage->doSearch";
        String screenshotPath = getScreenShot(pageDriver,"GoogleSearchPage");
        if(type(getWebElement(pageDriver,txtGoogleSearch),text))
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo +": Value "+text+" is entered on element "+txtGoogleSearch,screenshotPath);
        if(click(getWebElement(pageDriver,btnGoogleSearch)))
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo + btnGoogleSearch+" is clicked");
        return new GoogleResultPage(pageDriver);
    }
}
