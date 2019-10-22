package uitests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowerFactory {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static void initWebDriver() {
        String path = System.getProperty("user.dir");   // return project folder path
        String driverpath = path + "\\drivers\\chromedriver.exe";   // return driver folder path
        System.setProperty("webdriver.chrome.driver",driverpath );
        webDriver = new ChromeDriver();
    }

    public static void closeWebdriver() {
        webDriver.quit();
    }
}
