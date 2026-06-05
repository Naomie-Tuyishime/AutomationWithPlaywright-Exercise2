package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import constants.FilterLocators;

public class FilterPage {

    private Page page;

    public FilterPage(Page page) {
        this.page = page;
    }

    public void selectCategory(String category) {
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(category).setExact(true)).click();

        page.waitForSelector(FilterLocators.PRODUCT_CARD + ", " + FilterLocators.NO_PRODUCTS);
    }

    public void setPriceRange(int min, int max) {
        page.fill(FilterLocators.MIN_PRICE_INPUT, String.valueOf(min));
        page.fill(FilterLocators.MAX_PRICE_INPUT, String.valueOf(max));
        page.keyboard().press("Enter");

        page.waitForSelector(FilterLocators.PRODUCT_CARD + ", " + FilterLocators.NO_PRODUCTS);
    }

    public void selectPricePreset(String rangeLabel) {
        page.getByText(rangeLabel,
                new Page.GetByTextOptions().setExact(true)).click();

        page.waitForSelector(FilterLocators.PRODUCT_CARD + ", " + FilterLocators.NO_PRODUCTS);
    }

    public void selectSize(String sizeLabel) {
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(sizeLabel).setExact(true)).click();

        page.waitForSelector(FilterLocators.PRODUCT_CARD + ", " + FilterLocators.NO_PRODUCTS);
    }

    public void selectColor(String colorTitle) {
        page.locator("button[title='" + colorTitle + "']").click();

        page.waitForSelector(FilterLocators.PRODUCT_CARD + ", " + FilterLocators.NO_PRODUCTS);
    }

    public void selectSpecial(String specialLabel) {
        page.getByText(specialLabel,
                new Page.GetByTextOptions().setExact(true)).click();

        page.waitForSelector(FilterLocators.PRODUCT_CARD + ", " + FilterLocators.NO_PRODUCTS);
    }

    public void clearAllFilters() {
        page.locator(FilterLocators.ASIDE_PANEL)
                .getByRole(AriaRole.BUTTON,
                        new Locator.GetByRoleOptions().setName("Clear all filters").setExact(true))
                .click();

        page.waitForSelector(FilterLocators.PRODUCT_CARD + ", " + FilterLocators.NO_PRODUCTS);
    }

    public boolean isProductListVisible() {
        return page.locator(FilterLocators.PRODUCT_CARD).count() > 0;
    }

    public boolean isNoProductsMessageVisible() {
        return page.locator(FilterLocators.NO_PRODUCTS).isVisible();
    }

    public int getProductCount() {
        return page.locator(FilterLocators.PRODUCT_CARD).count();
    }

    public Page getPage() {
        return page;
    }
}