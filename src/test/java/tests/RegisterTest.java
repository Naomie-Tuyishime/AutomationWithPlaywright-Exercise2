package tests;

import actions.RegistrationActions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;

public class RegisterTest extends BaseTest {

    private RegistrationActions registrationActions;
    @ParameterizedTest
    @ValueSource(strings = {"chromium"})
    public void TestRegisteringFeature(String browserName){
        setUp(browserName);
        this.registrationActions = new RegistrationActions(page);
        registrationActions.navigatingToRegisterPage();
        registrationActions.fillRegistrationForm("abc","tz", "tz@gmail.com","Kigali@123");
        registrationActions.clickRegistration();

    }
}
