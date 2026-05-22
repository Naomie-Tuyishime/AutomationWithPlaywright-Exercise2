package tests;

import actions.ProductActions;
import com.microsoft.playwright.Page;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ConfigLoader;
import utils.PlaywrightFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductTest {

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
  public  void guestCanNavigateToProductPage(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigLoader.get("baseUrl"));

        ProductActions product = new ProductActions(page);

        product.navigateToProductPageAsGuest();

        assertThat(page).hasURL(ConfigLoader.get("baseUrl") + "/products");
        assertThat(product.sortDropdown()).isVisible();

        page.context().browser().close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    public void sortDropdownIsVisibleOnProductPage(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigLoader.get("baseUrl"));

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        assertThat(product.sortDropdown()).isVisible();
        assertThat(product.sortDropdown()).isEnabled();

        page.context().browser().close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
   public  void sortByNewest(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigLoader.get("baseUrl"));

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        product.sortProductsBy("newest");

        assertThat(product.sortDropdown()).hasValue("newest");

        page.context().browser().close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    void sortByPriceAscending(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigLoader.get("baseUrl"));

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        product.sortProductsBy("price_asc");
        page.waitForTimeout(3000);

        assertThat(product.sortDropdown()).hasValue("price_asc");

        page.context().browser().close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    public void sortByPriceDescending(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigLoader.get("baseUrl"));

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        product.sortProductsBy("price_desc");
        page.waitForTimeout(3000);

        assertThat(product.sortDropdown()).hasValue("price_desc");

        page.context().browser().close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
   public  void sortByRating(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigLoader.get("baseUrl"));

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        product.sortProductsBy("rating");
        page.waitForTimeout(3000);

        assertThat(product.sortDropdown()).hasValue("rating");

        page.context().browser().close();
    }
}