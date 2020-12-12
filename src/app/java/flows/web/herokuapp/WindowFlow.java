package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.FramePage;
import pages.web.herokuapp.HomePage;
import pages.web.herokuapp.WindowPage;

public class WindowFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final WindowPage windowPage;
    public WindowFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        windowPage = homePage.getWindowPage();
    }
    public String getNewWindowTitle(){
        windowPage.clickHere();
        windowPage.switchToNewWindow();
        return windowPage.getWindowTitle();
    }
    public String getParentWindowTitle(){
        windowPage.clickHere();
        windowPage.switchToNewWindow();
        windowPage.switchToParentWindow();
        return windowPage.getWindowTitle();
    }
}
