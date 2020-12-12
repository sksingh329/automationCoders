package pages.web.google;

import core.web.selenium.BaseWebPage;
import exceptions.CustomExceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GoogleResultPage extends BaseWebPage {
    private final By lblResult = By.id("result-stats");
    private final By btnNext = By.xpath("//a[@id='pnnext']//span[text()='Next']");

    private final WebDriver pageDriver;
    public GoogleResultPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public String getResultStat() {
        explicitWaitForElementVisibility(pageDriver,lblResult,ElementVisibilityWaitConditions.visibilityOfElementLocated);
        return getText(getWebElement(pageDriver,lblResult,10),pageDriver);
    }
    public void scrollToNextButton(){
        jsScrollToElement(pageDriver,getWebElement(pageDriver,btnNext),true,"ScrollToNextButton");
    }
    public String getTitleAfterBrowserNavigation(String navigation) {
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        switch (navigation.toLowerCase()){
            case "back":
                navigateBack(pageDriver);
                break;
            case "forward":
                navigateForward(pageDriver);
                break;
            default:
                throw new CustomExceptions(methodName,"Invalid navigation command");
        }
        return getTitle(pageDriver,true,"GoogleSearch");
    }

}
