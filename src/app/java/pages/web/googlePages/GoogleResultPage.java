package pages.web.googlePages;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GoogleResultPage extends BaseWebPage {
    private final By lblResult = By.id("result-stats");

    private final WebDriver pageDriver;
    public GoogleResultPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public String getResultStat() {
        return getText(getWebElementAfterVisible(pageDriver,lblResult,10));
    }
}
