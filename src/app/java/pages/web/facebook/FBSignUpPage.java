package pages.web.facebook;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBSignUpPage extends BaseWebPage {
    private final By lblSignUp = By.xpath("//div[contains(text(),'Sign Up')]");
    private final By lblItsQuickAndEasy = By.xpath("//div[contains(text(),\"It's quick and easy.\")]");
    private final By txtFirstName = By.name("firstname");
    private final By txtLastName = By.name("lastname");
    private final By txtEmail = By.name("reg_email__");
    private final By txtConfirmEmail = By.name("reg_email_confirmation__");
    private final By txtPassword = By.name("reg_passwd__");
    private final By dropDownDayDOB = By.id("day");
    private final By dropDownMonthDOB = By.id("month");
    private final By dropDownYearDOB = By.id("year");
    private final By radioGenderFemale = By.xpath("//span[@data-name='gender_wrapper']//label[contains(text(),'Female')]/following-sibling::input");
    private final By radioGenderMale = By.xpath("//span[@data-name='gender_wrapper']//label[contains(text(),'Male')]/following-sibling::input");
    private final By btnSignUp = By.xpath("//button[contains(text(),'Sign Up') and @name='websubmit']");

    private final WebDriver pageDriver;
    public FBSignUpPage(WebDriver driver){
        this.pageDriver = driver;
    }
    public void waitTillSignUpWindowLoaded(){
        explicitWaitForElementVisibility(pageDriver,lblSignUp,ElementVisibilityWaitConditions.visibilityOfElementLocated,10);
    }
    public void setFirstName(String firstName){
        type(getWebElement(pageDriver,txtFirstName),firstName,pageDriver);
    }
    public void setLastName(String lastName){
        type(getWebElement(pageDriver,txtLastName),lastName,pageDriver);
    }
    public void setEmailOrMobile(String emailOrMobile){
        type(getWebElement(pageDriver,txtEmail),emailOrMobile,pageDriver);
    }
    public void setPassword(String password){
        type(getWebElement(pageDriver,txtPassword),password,pageDriver);
    }
    public void setDOB(String day, String month, String year){
        selectFromDropDown(getWebElement(pageDriver,dropDownDayDOB),SelectOptions.VISIBLETEXT,day,pageDriver);
        selectFromDropDown(getWebElement(pageDriver,dropDownMonthDOB),SelectOptions.VISIBLETEXT,month,pageDriver);
        selectFromDropDown(getWebElement(pageDriver,dropDownYearDOB),SelectOptions.VISIBLETEXT,year,pageDriver);
    }
    public void setGender(String gender){
        switch (gender.toLowerCase()){
            case "male":
                click(getWebElement(pageDriver,radioGenderMale),pageDriver);
                break;
            case "female":
                click(getWebElement(pageDriver,radioGenderFemale),pageDriver);
                break;
        }
    }
    public void clickSignUp(){
        click(getWebElement(pageDriver,btnSignUp),pageDriver,true,"FBSignUp");
    }
}
