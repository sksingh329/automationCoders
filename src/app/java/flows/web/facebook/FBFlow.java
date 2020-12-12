package flows.web.facebook;

import core.web.selenium.BaseWebFlow;
import org.openqa.selenium.WebDriver;
import pages.web.facebook.FBHomePage;
import pages.web.facebook.FBSignInPage;
import pages.web.facebook.FBSignUpPage;

public class FBFlow extends BaseWebFlow {
    private final WebDriver driver;
    private final FBHomePage fbHomePage;
    public FBFlow(String browser,String url){
        driver = super.getWebDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        fbHomePage = new FBHomePage(driver);
    }
    public String checkFbTitle(){
        return fbHomePage.checkTitle();
    }
    public String fbInvalidLogin(String userName,String password){
        FBSignInPage fbSignInPage = fbHomePage.getFBSignInPage();
        fbSignInPage.fbLogin(userName,password);
        if(userName.equals(""))
            return fbSignInPage.getLoginInEmailError();
        else if(password.equals(""))
            return fbSignInPage.getLogInPasswordError();
        else
            return fbSignInPage.getLoginInEmailError();
    }
    public void fbSignUp(String firstName, String surName, String emailOrMobile, String password, String dayDOB, String monthDOB, String yearDOB, String gender){
        FBSignUpPage fbSignUpPage = fbHomePage.clickCreateNewAccount();
        fbSignUpPage.waitTillSignUpWindowLoaded();
        fbSignUpPage.setFirstName(firstName);
        fbSignUpPage.setLastName(surName);
        fbSignUpPage.setEmailOrMobile(emailOrMobile);
        fbSignUpPage.setPassword(password);
        fbSignUpPage.setDOB(dayDOB,monthDOB,yearDOB);
        fbSignUpPage.setGender(gender);
        fbSignUpPage.clickSignUp();
    }
}
