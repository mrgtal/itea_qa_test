package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {



    public static WebDriver selectBrowserByName(String browserName) {

        String resourcesPath = "\\src\\test\\resources\\";

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + resourcesPath + "chromedriver.exe");
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + resourcesPath + "geckodriver.exe");

 //       switch (browserName.toLowerCase()) {
//            case "firefox":
                return new FirefoxDriver();
//            case "chrome":
 //               return new ChromeDriver();
  //          case "ie":
 //               return new InternetExplorerDriver();
 //           default:
 //               return null;
 //       }

    }


}