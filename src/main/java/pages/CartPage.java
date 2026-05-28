package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import constants.AddToCartConstants;

public class CartPage {

    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public void waitForProductCards() {
        page.waitForSelector(
                AddToCartConstants.PRODUCT_CARD,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000)
        );
    }

    public void clickProductBySlug(String slug) {
        waitForProductCards();

        Locator explicitItemCard = page.locator("a[href*='" + slug + "']").first();

        explicitItemCard.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        explicitItemCard.click();

        page.locator(AddToCartConstants.ADD_TO_CART_BTN).waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(15000)
        );
    }



    public void selectColorBySelector(String colorSelector) {
        Locator colorBtn = page.locator(colorSelector).first();
        colorBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        colorBtn.click();
    }

    public void clickAddToCart() {
        page.locator(AddToCartConstants.ADD_TO_CART_BTN).click();
    }

    public Locator getViewCartButton() {
        return page.locator(AddToCartConstants.VIEW_CART_BTN).first();
    }

    public Locator getCheckoutButton() {
        return page.locator(AddToCartConstants.CHECKOUT_BTN).first();
    }

    public int getProductCount() {
        waitForProductCards();
        return page.locator(AddToCartConstants.PRODUCT_CARD).count();
    }

    public Page getPage() {
        return this.page;
    }
}