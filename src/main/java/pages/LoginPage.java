package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    private String signInBtn = "text=Sign In";
    private String email = "input[type='email']";
    private String password = "input[type='password']";
    private String loginBtn = "button[type='submit']";
    private String userProfileIcon = "button.btn-icon:has(svg.lucide-user)";
    private String errorPopup = ".error";

    public void openLoginForm() {
        page.click(signInBtn);
    }

    public void enterEmail(String value) {
        page.fill(email, value);
    }

    public void enterPassword(String value) {
        page.fill(password, value);
    }

    public void submitLogin() {
        page.click(loginBtn);
    }
    public Locator checkUseProfileIcon(){
        return page.locator(userProfileIcon);
    }
    public Locator getErrorPopupLocator() {
        return page.locator(errorPopup);
    }
}