package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;

    /**
     * This method sets the Browser up and then maximizes the window .
     */
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "\\radina_qa\\Programs\\BrowseDriver\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * This method quits the Browser
     */
    public static void tearDown() {
        driver.quit();
    }
}
