package pages.web.herokuapp;

import core.web.selenium.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseWebPage {
    private final By linkJavaScriptAlerts = By.linkText("JavaScript Alerts");
    private final By linkCheckboxes = By.linkText("Checkboxes");
    private final By linkFrames = By.linkText("Frames");
    private final By linkMultipleWindow = By.linkText("Multiple Windows");
    private final By linkHovers = By.linkText("Hovers");
    private final By linkContextMenu = By.linkText("Context Menu");
    private final By linkDragAndDrop = By.linkText("Drag and Drop");
    private final By linkKeyPress = By.linkText("Key Presses");
    private final By linkInfiniteScroll = By.linkText("Infinite Scroll");
    private final By linkForgotPassword = By.linkText("Forgot Password");

    private final WebDriver pageDriver;
    public HomePage(WebDriver driver){
        this.pageDriver = driver;
    }
    public AlertPage getAlertPage(){
        click(getWebElement(pageDriver,linkJavaScriptAlerts),pageDriver);
        return new AlertPage(pageDriver);
    }
    public CheckboxesPage getCheckBoxesPage(){
        click(getWebElement(pageDriver,linkCheckboxes),pageDriver);
        return new CheckboxesPage(pageDriver);
    }
    public FramePage getFramePage(){
        click(getWebElement(pageDriver,linkFrames),pageDriver);
        return new FramePage(pageDriver);
    }
    public WindowPage getWindowPage(){
        click(getWebElement(pageDriver,linkMultipleWindow),pageDriver);
        return new WindowPage(pageDriver);
    }
    public HoversPage getHoversPage(){
        click(getWebElement(pageDriver,linkHovers),pageDriver);
        return new HoversPage(pageDriver);
    }
    public ContextMenuPage getContextMenuPage(){
        click(getWebElement(pageDriver,linkContextMenu),pageDriver);
        return new ContextMenuPage(pageDriver);
    }

    public DragAndDropPage getDragAndDropPage(){
        click(getWebElement(pageDriver,linkDragAndDrop),pageDriver);
        return new DragAndDropPage(pageDriver);
    }
    public ActionSendKeysPage getKeyPressPage(){
        click(getWebElement(pageDriver,linkKeyPress),pageDriver);
        return new ActionSendKeysPage(pageDriver);
    }
    public InfiniteScrollPage getInfiniteScrollPage(){
        click(getWebElement(pageDriver,linkInfiniteScroll),pageDriver);
        return new InfiniteScrollPage(pageDriver);
    }
    public ForgotPasswordPage getForgotPasswordPage(){
        click(getWebElement(pageDriver,linkForgotPassword),pageDriver);
        return new ForgotPasswordPage(pageDriver);
    }
}
