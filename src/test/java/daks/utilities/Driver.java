package daks.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {

    static WebDriver driver;

   // public static WebDriverWait wait;

    public static WebDriver getDriver(){

        if(driver == null){

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){

                case  "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }

       // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  wait = new WebDriverWait(driver, 10);

        return driver;
    }

    public static void closeDriver(){

        if(driver!= null){
            driver.quit();
            driver =null;
        }
    }


}
