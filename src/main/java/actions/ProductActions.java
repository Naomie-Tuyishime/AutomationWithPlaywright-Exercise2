package actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.ProductPage;

public class ProductActions {

    private ProductPage productPage;

    public ProductActions(Page page) {
        this.productPage = new ProductPage(page);
    }

    public void navigateToProductPageAsGuest() {
        productPage.clickStartShopping();
        productPage.clickShopNow();
    }

    public void sortProductsBy(String value) {
        productPage.selectSortOption(value);
    }

    public Locator sortDropdown() {
        return productPage.getSortDropdown();
    }


}