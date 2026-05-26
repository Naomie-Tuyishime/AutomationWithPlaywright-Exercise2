package tests;

import actions.FilterActions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;
import utils.ConfigLoader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterTest extends BaseTest {

    private FilterActions setup(String browserName) {
        setUp(browserName);
        page.navigate(ConfigLoader.get("baseUrl") + "/products");
        return new FilterActions(page);
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void filterByElectronics(String browserName) {
        FilterActions filter = setup(browserName);

        filter.filterByCategory("Electronics");

        assertProductsOrNoResults(filter, "category: Electronics");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void filterByClothing(String browserName) {
        FilterActions filter = setup(browserName);

        filter.filterByCategory("Clothing");

        assertProductsOrNoResults(filter, "category: Clothing");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void filterByCustomPriceRange(String browserName) {
        FilterActions filter = setup(browserName);

        filter.filterByPriceRange(10, 100);

        assertProductsOrNoResults(filter, "price range: 10–100");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void filterByPricePreset(String browserName) {
        FilterActions filter = setup(browserName);

        filter.filterByPricePreset("Under $50");

        assertProductsOrNoResults(filter, "price preset: Under $50");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void filterBySize(String browserName) {
        FilterActions filter = setup(browserName);

        filter.filterBySize("M");

        assertProductsOrNoResults(filter, "size: M");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void filterByColor(String browserName) {
        FilterActions filter = setup(browserName);

        filter.filterByColor("Black");

        assertProductsOrNoResults(filter, "color: Black");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void filterBySpecial(String browserName) {
        FilterActions filter = setup(browserName);

        filter.filterBySpecial("On Sale");

        assertProductsOrNoResults(filter, "special: On Sale");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium"})
    void clearAllFiltersRestoresProducts(String browserName) {
        FilterActions filter = setup(browserName);

        filter.filterByCategory("Electronics");
        filter.clearAllFilters();

        assertTrue(filter.hasProducts(),
                "Products should be visible after clearing all filters");

        assertTrue(filter.productCount() > 0,
                "Product count should be greater than 0 after clearing all filters");
    }

    private void assertProductsOrNoResults(FilterActions filter, String context) {
        boolean productsVisible = filter.hasProducts();
        boolean noResultsVisible = filter.hasNoProductsMessage();

        assertTrue(productsVisible || noResultsVisible,
                "Expected either product cards or a no-products message for: " + context);

        if (productsVisible) {
            assertTrue(filter.productCount() > 0,
                    "Product count should be greater than 0 for: " + context);
        }
    }
}