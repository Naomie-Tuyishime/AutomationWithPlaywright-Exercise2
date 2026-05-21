package actions;

import com.microsoft.playwright.Locator;
import pages.LoginPage;
import com.microsoft.playwright.Page;

public class AuthActions {

    private LoginPage loginPage;

    public AuthActions(Page page) {
        this.loginPage = new LoginPage(page);
    }

    public void login(String email, String password) {

        loginPage.openLoginForm();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        loginPage.submitLogin();
    }
    public Locator userProfileIcon (){
        return loginPage.checkUseProfileIcon();
    }

}