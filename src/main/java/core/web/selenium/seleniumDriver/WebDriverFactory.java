package core.web.selenium.seleniumDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    private static final WebDriverFactory instance = new WebDriverFactory();

    private WebDriverFactory(){}

    public static WebDriverFactory getInstance(){
        return instance;
    }

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public WebDriver getDriver(BrowserType type){
        if(threadLocal.get() == null) {
            switch (type) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    threadLocal.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    threadLocal.set(new FirefoxDriver());
                    break;
                case SAFARI:
                    threadLocal.set(new SafariDriver());
                default:
                    break;
            }
        }
        return threadLocal.get();
    }
    public void releaseDriver(){
        threadLocal.remove();
    }
}