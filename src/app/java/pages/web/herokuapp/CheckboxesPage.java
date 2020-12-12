package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage extends BaseWebPage {
    private final By checkBox1 = By.xpath("(//input[@type='checkbox'])[1]");
    private final By checkBox2 = By.xpath("(//input[@type='checkbox'])[2]");

    private final WebDriver pageDriver;
    public CheckboxesPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public boolean selectCheckBox1(){
        selectCheckBox(getWebElement(pageDriver,checkBox1),pageDriver);
        return isSelected(getWebElement(pageDriver,checkBox1),pageDriver);
    }
    public boolean selectCheckBox2(){
        selectCheckBox(getWebElement(pageDriver,checkBox2),pageDriver,true,"CheckBox2");
        return isSelected(getWebElement(pageDriver,checkBox2),pageDriver);
    }
    public boolean deSelectCheckBox1(){
        deSelectCheckBox(getWebElement(pageDriver,checkBox1),pageDriver);
        return isSelected(getWebElement(pageDriver,checkBox1),pageDriver);
    }
    public boolean deSelectCheckBox2(){
        deSelectCheckBox(getWebElement(pageDriver,checkBox2),pageDriver,true,"CheckBox2");
        return isSelected(getWebElement(pageDriver,checkBox2),pageDriver);
    }
}
