package Pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;

public class HomePage extends BasePage {

    @FindBy(className = "fa-user")
    private static WebElement myAccountButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private static WebElement myAccountButtonOptionRegister;

    @FindBy(css = "#content > h1")
    private static WebElement register;

    private static final By MY_ACCOUNT_BUTTON_OPTIONS = By.className("dropdown-menu-right");
    private static final By CONTINUE_BUTTON = By.className("btn-primary");

    static {
        PageFactory.initElements(Browser.driver, HomePage.class);
    }

    /**
     * This method redirects you to the 'Home' page.
     */
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg");
    }

    /**
     * This method clicks the 'MyAccount' button.
     */
    public static void myAccountButton() {
        myAccountButton.click();
    }

    /**
     * This method clicks the option 'Register' on 'MyAccount' button.
     */
    public static void myAccountButtonOption() {
        waitForElementVisibility(MY_ACCOUNT_BUTTON_OPTIONS, 3);
        myAccountButtonOptionRegister.click();
    }

    /**
     * This method verifies that
     * the user is on 'Registration account' page.
     *
     * @param expectedMessageText The expected visible text.
     */
    public static void registerAccountPage(String expectedMessageText){
        waitForElementVisibility(CONTINUE_BUTTON, 3);
        Assert.assertEquals(register.getText(), expectedMessageText);
    }
}
