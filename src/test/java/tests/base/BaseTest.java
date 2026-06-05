package tests.base;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import utils.ConfigLoader;
import utils.PlaywrightFactory;

public class BaseTest {

    protected Page page;

    protected void setUp(String browserName) {
        page = PlaywrightFactory.createPage(browserName);
        page.navigate(
                ConfigLoader.get("baseUrl"),
                new Page.NavigateOptions().setTimeout(90000)
        );
    }

    @AfterEach
    void tearDown() {
        if (page != null) {
            page.context().browser().close();
        }
    }
}