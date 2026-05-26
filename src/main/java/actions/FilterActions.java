package actions;

import com.microsoft.playwright.Page;
import pages.FilterPage;

public class FilterActions {

    private FilterPage filterPage;

    public FilterActions(Page page) {
        this.filterPage = new FilterPage(page);
    }

    public void filterByCategory(String category) {
        filterPage.selectCategory(category);
    }

    public void filterByPriceRange(int min, int max) {
        filterPage.setPriceRange(min, max);
    }

    public void filterByPricePreset(String rangeLabel) {
        filterPage.selectPricePreset(rangeLabel);
    }

    public void filterBySize(String size) {
        filterPage.selectSize(size);
    }

    public void filterByColor(String colorTitle) {
        filterPage.selectColor(colorTitle);
    }

    public void filterBySpecial(String specialLabel) {
        filterPage.selectSpecial(specialLabel);
    }

    public void clearAllFilters() {
        filterPage.clearAllFilters();
    }

    public boolean hasProducts() {
        return filterPage.isProductListVisible();
    }

    public boolean hasNoProductsMessage() {
        return filterPage.isNoProductsMessageVisible();
    }

    public int productCount() {
        return filterPage.getProductCount();
    }

    public Page getPage() {
        return filterPage.getPage();
    }
}