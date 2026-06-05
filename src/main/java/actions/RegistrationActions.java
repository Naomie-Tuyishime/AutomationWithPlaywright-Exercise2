package actions;

import com.microsoft.playwright.Page;
import pages.RegisterPage;

public class RegistrationActions {
    private Page page;
    private RegisterPage registerPage;
    public RegistrationActions (Page page ){
        this.registerPage = new RegisterPage(page);
    }
     public void  navigatingToRegisterPage (){
        registerPage.navigateRegistration();
     }
    public void fillRegistrationForm (String firstname, String lastname, String email, String password){
        registerPage.fillCridentials(firstname, lastname, email, password);

    }
    public void  clickRegistration (){
        registerPage.clickRegisterBTN();
    }

}
