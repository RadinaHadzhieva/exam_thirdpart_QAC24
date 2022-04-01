package RegistrationAccountPage;

import Pages.RegisterAccountPage;
import core.BaseTest;
import org.testng.annotations.Test;

public class RegistrationAccountPageTest extends BaseTest {

    @Test
    public void RegistrationPage() {
        RegisterAccountPage.goTo();
        RegisterAccountPage.personalDetails(RegisterAccountPage.randomFirstName, RegisterAccountPage.randomLastName, RegisterAccountPage.randomEmail, RegisterAccountPage.randomPhoneNumber, RegisterAccountPage.randomPassword, RegisterAccountPage.randomPassword);
        RegisterAccountPage.agreeCheckBox();
        RegisterAccountPage.continueButton();
        RegisterAccountPage.registerSuccessfully("Your Account Has Been Created!");
    }
}

