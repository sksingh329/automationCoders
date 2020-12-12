package flows.web.herokuapp;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.herokuapp.AlertPage;
import pages.web.herokuapp.CheckboxesPage;
import pages.web.herokuapp.HomePage;

public class CheckBoxesFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final CheckboxesPage checkboxesPage;
    public CheckBoxesFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        checkboxesPage = homePage.getCheckBoxesPage();
    }
    public boolean selectCheckBox1(){
        return checkboxesPage.selectCheckBox1();
    }
    public boolean selectCheckBox2(){
        return checkboxesPage.selectCheckBox2();
    }
    public boolean deSelectCheckBox1(){
        return checkboxesPage.deSelectCheckBox1();
    }
    public boolean deSelectCheckBox2(){
        return checkboxesPage.deSelectCheckBox2();
    }
}
