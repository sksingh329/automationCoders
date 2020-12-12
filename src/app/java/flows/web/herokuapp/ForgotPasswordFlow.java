package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.ForgotPasswordPage;
import pages.web.herokuapp.HomePage;
import pages.web.herokuapp.WindowPage;

public class ForgotPasswordFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final ForgotPasswordPage forgotPasswordPage;
    public ForgotPasswordFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        forgotPasswordPage= homePage.getForgotPasswordPage();
    }
    public String forgotPasswordUsingJs(String email){
        return forgotPasswordPage.retrievePassword(email);
    }
}
