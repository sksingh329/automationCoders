package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.AlertPage;
import pages.web.herokuapp.HomePage;

public class AlertFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final HomePage homePage;
    private final AlertPage alertPage;
    public AlertFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        alertPage = homePage.getAlertPage();
    }
    public String getAlertMessage(){
        return alertPage.handleAlert();
    }
    public String getAlertConfirmMessage(){
        return alertPage.handleAlertConfirm();
    }
    public String getAlertPromptMessage(String alertMessage){
        return alertPage.handleAlertPrompt(alertMessage);
    }
    public String getResult(){
        return alertPage.getResult();
    }
}
