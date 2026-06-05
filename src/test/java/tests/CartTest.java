package tests;

import actions.CartActions;
import constants.AddToCartConstants;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;
import utils.ConfigLoader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"chromium"})
    void productGridIsVisibleOnProductsPage(String browserName) {
        setUp(browserName);
        page.navigate(ConfigLoader.get("baseUrl") + AddToCartConstants.PRODUCTS_ENDPOINT);

        CartActions cart = new CartActions(page);
        assertTrue(cart.productCount() > 0, "Product grid should display items.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium"})
    void clickingProductNavigatesToItsDetailPage(String browserName) {
        setUp(browserName);
        page.navigate(ConfigLoader.get("baseUrl") + AddToCartConstants.PRODUCTS_ENDPOINT);

        CartActions cart = new CartActions(page);
        cart.openProductBySlug(AddToCartConstants.PRODUCT_SLUG);

        String expectedUrl = ConfigLoader.get("baseUrl") + AddToCartConstants.PRODUCT_SLUG;
        assertEquals(expectedUrl, page.url(), "Expected to navigate to product detail view.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium"})
    void addToCartWithSizeLAndColorBlack(String browserName) {
        setUp(browserName);
        page.navigate(ConfigLoader.get("baseUrl") + AddToCartConstants.PRODUCT_SLUG);

        CartActions cart = new CartActions(page);
        cart.selectColor(AddToCartConstants.COLOR_BLACK);
        cart.addToCart();

        assertThat(cart.viewCartButton()).isVisible();
        assertThat(cart.checkoutButton()).isVisible();
    }
}