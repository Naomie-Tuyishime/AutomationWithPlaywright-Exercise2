package tests;

import actions.AuthActions;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import utils.ConfigLoader;
import utils.PlaywrightFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void validLoginTest() {
        Page page = PlaywrightFactory.createPage();
        page.navigate(ConfigLoader.get("baseUrl"));



        AuthActions auth = new AuthActions(page);

        auth.login(
                ConfigLoader.get("email"),
                ConfigLoader.get("password")
        );

        assertThat(page).hasURL(ConfigLoader.get("baseUrl")+"/home");
        assertThat(auth.userProfileIcon()).isVisible();
    }

    @Test
    void invalidLoginTest() {
        Page page = PlaywrightFactory.createPage();
        page.navigate(ConfigLoader.get("baseUrl"));

        AuthActions auth = new AuthActions(page);

        auth.login(ConfigLoader.get("invalidEmail"), ConfigLoader.get("invalidPassword"));

        assertThat(page).hasURL(ConfigLoader.get("baseUrl")+"/login");

    }
}