package pages;

import com.microsoft.playwright.Page;
import constants.AuthenticationConstants;

public class RegisterPage {
    private final Page page;
    public RegisterPage  (Page page){
        this.page = page;
    }
    public void navigateRegistration (){
        page.locator(AuthenticationConstants.REGISTERPAGE).first().click();

    }

    public void  fillCridentials (String firstname , String lastname , String email, String password ){
        page.fill(AuthenticationConstants.FIRSTNAME,firstname);
        page.fill(AuthenticationConstants.LASTNAME,lastname);
        page.fill(AuthenticationConstants.EMAIL, email);
        page.fill(AuthenticationConstants.PASSWORD, password);


    }
    public void  clickRegisterBTN (){
        page.locator(AuthenticationConstants.CREATEACCOUNTBTN).first().click();

    }
}
