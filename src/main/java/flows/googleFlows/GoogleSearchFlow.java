package flows.googleFlows;

import flows.BaseWebFlow;
import googlePages.GoogleResultPage;
import googlePages.GoogleSearchPage;
import org.openqa.selenium.WebDriver;

import reports.extent.CustomReporter;


public class GoogleSearchFlow extends BaseWebFlow {
    private final WebDriver driver;
    public GoogleSearchFlow(String browser, String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public WebDriver getDriver(){return driver;}
    public void googleSearch(String searchValue){
        String methodInfo = "GoogleSearchFlow->googleSearch";
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        GoogleResultPage resultPage = searchPage.doSearch(searchValue);
        if(resultPage!=null)
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Search is done navigated to page "+resultPage.getTitle(driver));
        if(resultPage.getResultStat()!=null)
            CustomReporter.setReporter(CustomReporter.Status.INFO,methodInfo+": Search Result output - "+resultPage.getResultStat());
    }
    public void validateGoogleMenusIsEnabled(){
        String methodInfo = "GoogleSearchFlow->validateGoogleMenusIsEnabled";
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        if(searchPage.isLinkGmailEnabled())
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Gmail link is enabled on Google Search Page.");
        else
            CustomReporter.setReporter(CustomReporter.Status.FAIL,methodInfo+": Gmail link is enabled on Google Search Page.");
        if(searchPage.isLinkImagesEnabled())
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Images link is enabled on Google Search Page.");
        else
            CustomReporter.setReporter(CustomReporter.Status.FAIL,methodInfo+": Images link is enabled on Google Search Page.");
        if(searchPage.isLinkGoogleAppsEnabled())
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Google Apps link is enabled on Google Search Page.");
        else
            CustomReporter.setReporter(CustomReporter.Status.FAIL,methodInfo+": Google Apps link is enabled on Google Search Page.");
        if(searchPage.isLinkSignInEnabled())
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Sign In link is enabled on Google Search Page.");
        else
            CustomReporter.setReporter(CustomReporter.Status.FAIL,methodInfo+": Sign In link is enabled on Google Search Page.");
    }
    public void validateGoogleSearchControlsAreEnabled(){
        String methodInfo = "GoogleSearchFlow->validateGoogleSearchControlsAreEnabled";
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        if(searchPage.isBtnGoogleSearchEnabled())
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Google Search Button is enabled on Google Search Page.");
        else
            CustomReporter.setReporter(CustomReporter.Status.FAIL,methodInfo+": Google Search Button link is enabled on Google Search Page.");
        if(searchPage.isBtnImFellingLuckyEnabled())
            CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": I'm felling Lucky Button is enabled on Google Search Page.");
        else
            CustomReporter.setReporter(CustomReporter.Status.FAIL,methodInfo+": I'm felling Lucky Button link is enabled on Google Search Page.");
    }
}
