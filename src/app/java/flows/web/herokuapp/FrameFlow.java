package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.FramePage;
import pages.web.herokuapp.HomePage;

public class FrameFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final FramePage framePage;
    public FrameFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        framePage = homePage.getFramePage();
    }
    public String getTextFromLeftFrame(){
        framePage.clickNestedFrames();
        return framePage.getTextFromTopLeftFrame();
    }
    public String getTextFromRightFrame(){
        return framePage.getTextFromTopRightFrame();
    }
    public String getTextFromMiddleFrame(){
        return framePage.getTextFromTopMiddleFrame();
    }
}
