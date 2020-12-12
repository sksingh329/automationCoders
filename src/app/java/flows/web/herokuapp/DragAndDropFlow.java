package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.DragAndDropPage;
import pages.web.herokuapp.HomePage;
import pages.web.herokuapp.WindowPage;

public class DragAndDropFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final DragAndDropPage dragAndDropPage;
    public DragAndDropFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        dragAndDropPage = homePage.getDragAndDropPage();
    }
    public void actionDragAndDrop(){
        dragAndDropPage.performDragAndDrop();
    }
}
