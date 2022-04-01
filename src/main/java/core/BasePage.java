package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

public class BasePage {

    /**
     * This method waits for the visibility of given WebElement.
     *
     * @param locator       The WebElement which visibility you want to wAit for.
     * @param timeInSeconds The time in seconds that you want to wait for the WebElement.
     * @return The WebElement if found.
     */
    public static WebElement waitForElementVisibility(By locator, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(Browser.driver, timeInSeconds);
        WebElement foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return foundElement;
    }

}
