package tests;

import actions.ProductActions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    public void guestCanNavigateToProductPage(String browserName) {
        setUp(browserName);

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        assertThat(page).hasURL("https://think-and-get-it-frontend.onrender.com/products");
        assertThat(product.sortDropdown()).isVisible();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    public void sortDropdownIsVisibleOnProductPage(String browserName) {
        setUp(browserName);

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        assertThat(product.sortDropdown()).isVisible();
        assertThat(product.sortDropdown()).isEnabled();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    public void sortByNewest(String browserName) {
        setUp(browserName);

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        product.sortProductsBy("newest");

        assertThat(product.sortDropdown()).hasValue("newest");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    void sortByPriceAscending(String browserName) {
        setUp(browserName);

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        product.sortProductsBy("price_asc");

        assertThat(product.sortDropdown()).hasValue("price_asc");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    public void sortByPriceDescending(String browserName) {
        setUp(browserName);

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        product.sortProductsBy("price_desc");

        assertThat(product.sortDropdown()).hasValue("price_desc");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    public void sortByRating(String browserName) {
        setUp(browserName);

        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsGuest();

        product.sortProductsBy("rating");

        assertThat(product.sortDropdown()).hasValue("rating");
    }
}