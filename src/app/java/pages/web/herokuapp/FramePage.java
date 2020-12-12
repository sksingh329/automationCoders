package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BaseWebPage {
    private final By linkNestedFrames = By.linkText("Nested Frames");
    private final By linkIFrame = By.linkText("iFrame");
    private final String frameTopParent = "frame-top";
    private final String frameTopLeft = "frame-left";
    private final By frameTopMiddle = By.xpath("//frame[@name='frame-middle']");
    private final String frameTopRight = "frame-right";
    private final String frameBottom = "frame-bottom";
    private final By lblLeft = By.xpath("//body[contains(text(),'LEFT')]");
    private final By lblRight = By.xpath("//body[contains(text(),'RIGHT')]");
    private final By lblBottom = By.xpath("//body[contains(text(),'BOTTOM')]");
    private final By lblMiddle = By.id("content");

    private final WebDriver pageDriver;
    public FramePage(WebDriver driver){
        this.pageDriver = driver;
    }

    public void clickNestedFrames(){
        click(getWebElement(pageDriver,linkNestedFrames),pageDriver);
    }
    public void clickIFrame(){
        click(getWebElement(pageDriver,linkIFrame),pageDriver);
    }
    public String getTextFromTopLeftFrame(){
        //pageDriver.switchTo().frame(frameTopParent).switchTo().frame(frameTopLeft);
        switchToFrameUsingNameOrId(pageDriver,frameTopParent);
        switchToFrameUsingNameOrId(pageDriver,frameTopLeft);
        String leftFrameText =  getText(getWebElement(pageDriver,lblLeft),pageDriver);
        switchToDefaultFrame(pageDriver);
        return leftFrameText;
    }
    public String getTextFromTopMiddleFrame(){
        switchToFrameUsingNameOrId(pageDriver,frameTopParent);
        switchToFrameUsingWebElement(pageDriver,getWebElement(pageDriver,frameTopMiddle));
        String middleFrameText =  getText(getWebElement(pageDriver,lblMiddle),pageDriver);
        switchToDefaultFrame(pageDriver);
        return middleFrameText;
    }
    public String getTextFromTopRightFrame(){
        switchToFrameUsingNameOrId(pageDriver,frameTopParent);
        switchToFrameUsingNameOrId(pageDriver,frameTopRight);
        String rightFrameText =  getText(getWebElement(pageDriver,lblRight),pageDriver);
        switchToDefaultFrame(pageDriver);
        return rightFrameText;
    }

}
