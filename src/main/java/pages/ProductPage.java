
        package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {

    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }


    private String startShoppingBtn = "a.btn-primary.text-base.py-4.px-8.flex.items-center.gap-2.glow-red";


    private String shopNowLink = "a.btn-primary.py-4.px-8.flex.items-center.gap-2.text-base.glow-red[href='/products']";


    private String sortDropdown = "select.input.py-2.pr-8.pl-3.text-sm.appearance-none.cursor-pointer";

    public void clickStartShopping() {
        page.click(startShoppingBtn);
    }

    public void clickShopNow() {
        page.click(shopNowLink);
    }

    public void selectSortOption(String value) {
        page.selectOption(sortDropdown, value);

    }

    public Locator getSortDropdown() {
        return page.locator(sortDropdown);

    }

    public Page getPage() {
        return page;
    }

}