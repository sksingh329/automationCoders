package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.HomePage;
import pages.web.herokuapp.InfiniteScrollPage;
import pages.web.herokuapp.WindowPage;

public class InfiniteScrollFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final InfiniteScrollPage infiniteScrollPage;
    public InfiniteScrollFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        infiniteScrollPage = homePage.getInfiniteScrollPage();
    }
    public int getJsScrollCount(){
        return infiniteScrollPage.getJsScrollAddedCount();
    }
    public void scrollWindowUsingJs(){
        try {
            infiniteScrollPage.scrollWindow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
