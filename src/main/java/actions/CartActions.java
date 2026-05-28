package actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.CartPage;

public class CartActions {

    private final CartPage cartPage;

    public CartActions(Page page) {
        this.cartPage = new CartPage(page);
    }

    public void openProductBySlug(String slug) {
        cartPage.clickProductBySlug(slug);
    }



    public void selectColor(String colorSelector) {
        cartPage.selectColorBySelector(colorSelector);
    }

    public void addToCart() {
        cartPage.clickAddToCart();
    }

    public Locator viewCartButton() {
        return cartPage.getViewCartButton();
    }

    public Locator checkoutButton() {
        return cartPage.getCheckoutButton();
    }

    public int productCount() {
        return cartPage.getProductCount();
    }

    public Page getPage() {
        return cartPage.getPage();
    }
}