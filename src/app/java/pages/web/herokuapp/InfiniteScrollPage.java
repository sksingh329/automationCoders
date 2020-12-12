package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.extent.ReporterUtils;

import java.util.List;

public class InfiniteScrollPage extends BaseWebPage {
    private final By divJsScrollAdded = By.xpath("//div[@class='jscroll-added']");

    private final WebDriver pageDriver;
    public InfiniteScrollPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public int getJsScrollAddedCount(){
        //WebDriverWait webDriverWait = new WebDriverWait(pageDriver,10);
        //webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(divJsScrollAdded,1));
        explicitWaitForNumberOfElementsAndWindows(pageDriver,divJsScrollAdded,NumberOfElementsAndWindowsConditions.numberOfElementsToBeMoreThan,1);
        List<WebElement> elements = getWebElements(pageDriver,divJsScrollAdded);
        int countElem = elements.size();
        ReporterUtils.log(ReporterUtils.Status.PASS,"getJsScrollAddedCount","Count of jsScroll is "+countElem);
        return countElem;
    }

    public void scrollWindow() throws InterruptedException {
        String jsScrollCommand = "window.scrollTo(0, document.body.scrollHeight);";
        Thread.sleep(2000);
        jsExecuteCommand(pageDriver,jsScrollCommand);
        Thread.sleep(2000);
        jsExecuteCommand(pageDriver,jsScrollCommand);
        Thread.sleep(2000);
        jsExecuteCommand(pageDriver,jsScrollCommand);
        Thread.sleep(2000);
        jsExecuteCommand(pageDriver,jsScrollCommand);
        Thread.sleep(2000);
        jsExecuteCommand(pageDriver,jsScrollCommand);
        Thread.sleep(2000);
        WebDriverWait webDriverWait = new WebDriverWait(pageDriver,10);
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(divJsScrollAdded,3));
    }
}
