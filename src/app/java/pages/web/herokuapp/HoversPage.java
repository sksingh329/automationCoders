package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HoversPage extends BaseWebPage {
    private final By imgAvatarFirst = By.xpath("(//img[@alt='User Avatar'])[1]");
    private final By imgAvatarSecond = By.xpath("(//img[@alt='User Avatar'])[2]");
    private final By imgAvatarThree = By.xpath("(//img[@alt='User Avatar'])[3]");
    private final By headerUserFirst = By.xpath("(//div[@class='figcaption']/h5)[1]");
    private final By headerUserSecond = By.xpath("(//div[@class='figcaption']/h5)[2]");
    private final By headerUserThree = By.xpath("(//div[@class='figcaption']/h5)[3]");

    private final WebDriver pageDriver;
    public HoversPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public String getFirstAvatarCaption(){
        moveToElement(getWebElement(pageDriver,imgAvatarFirst),pageDriver);
        return getText(getWebElement(pageDriver,headerUserFirst),pageDriver,true,"FirstUserAvatar");
    }
    public String getSecondAvatarCaption(){
        moveToElement(getWebElement(pageDriver,imgAvatarSecond),pageDriver);
        return getText(getWebElement(pageDriver,headerUserSecond),pageDriver,true,"FirstUserAvatar");
    }
    public String getThirdAvatarCaption(){
        moveToElement(getWebElement(pageDriver,imgAvatarThree),pageDriver);
        return getText(getWebElement(pageDriver,headerUserThree),pageDriver,true,"FirstUserAvatar");
    }
}
