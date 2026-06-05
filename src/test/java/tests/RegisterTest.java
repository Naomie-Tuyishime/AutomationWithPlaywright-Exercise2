package tests;

import actions.RegistrationActions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;
import utils.ConfigLoader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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
        assertThat(page).hasURL(ConfigLoader.get("baseUrl") + "/home");


    }
    @ParameterizedTest
    @ValueSource(strings = {"chromium"})
    public void TestRegisteringWithEmptyPasswordInput(String browserName) {
        setUp(browserName);
        this.registrationActions = new RegistrationActions(page);

        registrationActions.navigatingToRegisterPage();

        registrationActions.fillRegistrationForm(
                "nnn",
                "nn",
                "bbb@gmail.com",""

        );

        registrationActions.clickRegistration();

        assertThat(page).hasURL(ConfigLoader.get("baseUrl") + "/register");
    }

}
