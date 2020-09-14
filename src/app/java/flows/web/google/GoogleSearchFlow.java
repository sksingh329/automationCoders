package flows.web.google;

import core.web.selenium.BaseWebFlow;
import pages.web.google.GoogleResultPage;
import pages.web.google.GoogleSearchPage;
import org.openqa.selenium.WebDriver;

import reports.extent.ReporterUtils;

public class GoogleSearchFlow extends BaseWebFlow {
    private final WebDriver driver;
    public GoogleSearchFlow(String browser, String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public WebDriver getDriver(){return driver;}
    public String googleSearch(String searchValue){
        String searchResultStat = null;
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        GoogleResultPage resultPage = searchPage.doSearch(searchValue);
        if(resultPage!=null){
            searchResultStat = resultPage.getResultStat();
            if(searchResultStat!=null)
                ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Search is done and navigated to page "+resultPage.getTitle(driver));
        }
        return searchResultStat;
    }
    public void validateGoogleMenusIsEnabled(){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        if(searchPage.isLinkGmailEnabled())
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Gmail link is enabled on Google Search Page.");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,"Gmail link is enabled on Google Search Page.");
        if(searchPage.isLinkImagesEnabled())
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Images link is enabled on Google Search Page.");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,"Images link is enabled on Google Search Page.");
        if(searchPage.isLinkGoogleAppsEnabled())
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Google Apps link is enabled on Google Search Page.");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,"Google Apps link is enabled on Google Search Page.");
        if(searchPage.isLinkSignInEnabled())
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Sign In link is enabled on Google Search Page.");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,"Sign In link is enabled on Google Search Page.");
    }
    public void validateGoogleSearchControlsAreEnabled(){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        if(searchPage.isBtnGoogleSearchEnabled())
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Google Search Button is enabled on Google Search Page.");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,"Google Search Button link is enabled on Google Search Page.");
        if(searchPage.isBtnImFellingLuckyEnabled())
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"I'm felling Lucky Button is enabled on Google Search Page.");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,"I'm felling Lucky Button link is enabled on Google Search Page.");
    }
}
