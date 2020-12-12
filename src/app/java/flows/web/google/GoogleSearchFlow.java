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
    public boolean validateGoogleMenusIsEnabled(){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        return searchPage.isLinkGmailEnabled() &&
        searchPage.isLinkImagesEnabled() &&
        searchPage.isLinkGoogleAppsEnabled() &&
        searchPage.isLinkSignInEnabled();
    }
    public boolean validateGoogleSearchControlsAreEnabled(){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        return searchPage.isBtnGoogleSearchEnabled() &&
        searchPage.isBtnImFellingLuckyEnabled();
    }
    public void scrollToNext(String searchText){
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        GoogleResultPage googleResultPage = searchPage.doSearch(searchText);
        googleResultPage.scrollToNextButton();
    }
    public String navigateGooglePage(String searchText,String navigation){
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        GoogleResultPage googleResultPage = searchPage.doSearch(searchText);
        googleResultPage.getTitleAfterBrowserNavigation("back");
        return googleResultPage.getTitleAfterBrowserNavigation("forward");
    }
    public String navigateForwardGooglePage(String navigation){
        GoogleResultPage googleResultPage = new GoogleResultPage(driver);
        return googleResultPage.getTitleAfterBrowserNavigation(navigation);
    }
}
