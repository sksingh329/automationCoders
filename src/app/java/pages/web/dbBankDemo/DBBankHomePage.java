package pages.web.dbBankDemo;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DBBankHomePage extends BaseWebPage {
    private By labelPageTitle = By.xpath("//div[@class='page-title']//li");
    private final WebDriver pageDriver;
    public DBBankHomePage(WebDriver driver){
        this.pageDriver = driver;
    }
    public String getPageTitle(){
        return getText(getWebElement(pageDriver,labelPageTitle),pageDriver);
    }
}
