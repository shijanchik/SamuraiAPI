package uiselenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uiselenium.constants.Constant;

import java.time.Duration;

public class CommonActions {
    public static WebDriver webDriver(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/oshyian/IdeaProjects/MyFirstFramework/driver/chromedriver1");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.IMPLICIT_WAIT));
        return driver;
    }

}
