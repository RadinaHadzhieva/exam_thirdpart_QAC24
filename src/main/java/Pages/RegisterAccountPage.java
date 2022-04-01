package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static core.BasePage.waitForElementVisibility;
import static utils.Browser.driver;

public class RegisterAccountPage {

    private static final By FIRST_NAME_INPUT_FIELD = By.id("input-firstname");
    private static final By LAST_NAME_INPUT_FIELD = By.id("input-lastname");
    private static final By EMAIL_INPUT_FIELD = By.id("input-email");
    private static final By PHONE_NUMBER_INPUT_FIELD = By.id("input-telephone");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By PASSWORD_CONFIRM_INPUT_FIELD = By.id("input-confirm");
    private static final By CONTINUE_BUTTON = By.className("btn-primary");

    @FindBy(name = "agree")
    private static WebElement agreeCheckBox;

    @FindBy(className = "btn-primary")
    private static WebElement continueButton;

    @FindBy(css = "#content > h1")
    private static WebElement success;

    static {
        PageFactory.initElements(driver, RegisterAccountPage.class);
    }

    /**
     * This method redirects you to the 'Registration account' page.
     */
    public static void goTo() {
        driver.get("https://shop.pragmatic.bg/index.php?route=account/register");
    }

    /**
     * This method inputs your personal details into
     * the registration page to be register.
     *
     * @param firstName the first name you would like to register with
     * @param lastName the last name you would like to register with
     * @param eMail the e-mail you would like to register with
     * @param phoneNumber the phonenumber you would like to register with
     * @param password the password you would like to register with
     * @param confirmPassword confirm your password you would like to register with
     */
    public static String randomFirstName = RandomStringUtils.randomAlphabetic(6);
    public static String randomLastName = RandomStringUtils.randomAlphabetic(7);
    public static String randomEmail = RandomStringUtils.randomAlphanumeric(8) + "@" + RandomStringUtils.randomAlphanumeric(5) + "."
            + RandomStringUtils.randomAlphabetic(3);
    public static String randomPhoneNumber = "+359" + RandomStringUtils.randomNumeric(9);
    public static String randomPassword = RandomStringUtils.randomAlphanumeric(8);

    public static void personalDetails(String firstName, String lastName, String eMail, String phoneNumber, String password, String confirmPassword) {
        driver.findElement(FIRST_NAME_INPUT_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT_FIELD).sendKeys(lastName);
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys(eMail);
        driver.findElement(PHONE_NUMBER_INPUT_FIELD).sendKeys(phoneNumber);
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
        driver.findElement(PASSWORD_CONFIRM_INPUT_FIELD).sendKeys(confirmPassword);
    }

    /**
     * This method ensures that
     * you agree to the Privacy Policy.
     */
    public static void agreeCheckBox() {
        if (!agreeCheckBox.isSelected()) {
            agreeCheckBox.click();
        }
    }

    /**
     * This method clicks the 'Continue' button.
     */
    public static void continueButton() {
        continueButton.click();
    }

    /**
     * This method verifies that the user is register.
     *
     * @param expectedMessageText The expected visible text.
     */
    public static void registerSuccessfully(String expectedMessageText) {
        waitForElementVisibility(CONTINUE_BUTTON, 3);
        Assert.assertEquals(success.getText(), expectedMessageText);
    }
}
