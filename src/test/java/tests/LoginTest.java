package tests;

import actions.AuthActions;
import com.microsoft.playwright.Page;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ConfigLoader;
import utils.PlaywrightFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class LoginTest {

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void validLoginTest(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigLoader.get("baseUrl"));



        AuthActions auth = new AuthActions(page);

        auth.login(
                ConfigLoader.get("email"),
                ConfigLoader.get("password")
        );

        assertThat(page).hasURL(ConfigLoader.get("baseUrl") + "/home");
        assertThat(auth.userProfileIcon()).isVisible();

        page.context().browser().close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void invalidLoginTest(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigLoader.get("baseUrl"));

        AuthActions auth = new AuthActions(page);

        auth.login(ConfigLoader.get("invalidEmail"), ConfigLoader.get("invalidPassword"));

        assertThat(page).hasURL(ConfigLoader.get("baseUrl") + "/login");

        page.context().browser().close();
    }
}