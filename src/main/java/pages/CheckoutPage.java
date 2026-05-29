package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import constants.CheckoutConstants;

public class CheckoutPage {

    private final Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }
    public void clickAddNewAddress (){
          page.locator(CheckoutConstants.ADDNEWADDRESS).click();
    }

 public void  DeliveryAddress (String firstName, String lastName, String phoneNumber,
                               String streetAddress, String city, String state, String country) {
        page.fill(CheckoutConstants.FIRSTNAME, firstName);
                page.fill(CheckoutConstants.LASTNAME, lastName);
                page.fill(CheckoutConstants.PHONENUMBER,phoneNumber);
                page.fill(CheckoutConstants.STREETADDRESS, streetAddress);
                page.fill(CheckoutConstants.CITY, city);
                page.fill(CheckoutConstants.STATE, state);
                page.fill(CheckoutConstants.COUNTRY,country);
                page.locator(CheckoutConstants.SAVEADDRESS);
                page.locator(CheckoutConstants.PAYMENTBTN).first().click();



 }
 public void choosePaymentMethod(){
        page.locator(CheckoutConstants.PAYMENT_LABEL).first().click();

 }
 public void clickOrderReview(){
        page.locator(CheckoutConstants.REVIEW_ORDER).first().click();
 }
 public void clickPlaceOrder(){
        page.locator(CheckoutConstants.PLACE_ORDER).first().click();
 }
 public Locator SuccessPlaceOrderMessage (){
     return  page.locator(CheckoutConstants.PLACEORDERMESSAGE);

 }

}