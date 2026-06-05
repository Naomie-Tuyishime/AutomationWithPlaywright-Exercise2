package actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.CheckoutPage;

public class CheckoutActions {

    private final CheckoutPage checkoutPage;

    public CheckoutActions(Page page) {
        this.checkoutPage = new CheckoutPage(page);
    }
public void fillDetailsAndProceed (String firstName, String lastName, String phone, String street ,  String city ,String state , String country ){
checkoutPage.clickAddNewAddress();
checkoutPage.DeliveryAddress(firstName, lastName, phone, street, city, state, country);
}
public void  selectPaymentMethod (){
        checkoutPage.choosePaymentMethod();

}
public void ReviewOrder(){
        checkoutPage.clickOrderReview();
}
public void PlaceOrder(){
        checkoutPage.clickPlaceOrder();
}
public Locator SuccessFullPlaceOrder (){
       return  checkoutPage.SuccessPlaceOrderMessage();
}

}