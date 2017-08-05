package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {

    public static WebDriver selectBrowserByName(String browserName) {

        String resourcesPath = "\\src\\test\\resources\\";

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + resourcesPath + "chromedriver.exe");
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + resourcesPath + "geckodriver.exe");

                return new FirefoxDriver();

    }


}