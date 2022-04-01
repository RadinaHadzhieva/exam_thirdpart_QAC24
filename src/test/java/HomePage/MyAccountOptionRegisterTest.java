package HomePage;

import Pages.HomePage;
import core.BaseTest;
import org.testng.annotations.Test;

public class MyAccountOptionRegisterTest extends BaseTest {

    @Test
    public void myAccountOptionRegister() {
        HomePage.goTo();
        HomePage.myAccountButton();
        HomePage.myAccountButtonOption();
        HomePage.registerAccountPage("Register Account");
        }
}
