package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.HomePage;
import pages.web.herokuapp.HoversPage;
import pages.web.herokuapp.WindowPage;

public class HoversFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final HoversPage hoversPage;
    public HoversFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        hoversPage = homePage.getHoversPage();
    }
    public String hoverAndGetFirstAvatarCaption(){
        return hoversPage.getFirstAvatarCaption();
    }
    public String hoverAndGetSecondAvatarCaption(){
        return hoversPage.getSecondAvatarCaption();
    }
    public String hoverAndGetThirdAvatarCaption(){
        return hoversPage.getThirdAvatarCaption();
    }

}
