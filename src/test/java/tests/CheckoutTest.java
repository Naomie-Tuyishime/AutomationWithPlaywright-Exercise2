package tests;

import actions.CartActions;
import actions.AuthActions;
import actions.CheckoutActions;
import constants.AddToCartConstants;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;
import utils.ConfigLoader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"chromium"})
    void loginFirstThenAddProductToCartAndCheckout(String browserName) {
        setUp(browserName);


        AuthActions auth = new AuthActions(page);
        auth.login(
                ConfigLoader.get("email"),
                ConfigLoader.get("password")
        );


        assertThat(auth.userProfileIcon()).isVisible();

        page.navigate(ConfigLoader.get("baseUrl") + AddToCartConstants.PRODUCT_SLUG);


        CartActions cart = new CartActions(page);
        cart.selectColor(AddToCartConstants.COLOR_BLACK);
        cart.addToCart();

        assertThat(cart.checkoutButton()).isVisible();
        cart.checkoutButton().click();

        assertThat(page).hasURL(ConfigLoader.get("baseUrl") + "/checkout");

        CheckoutActions checkout = new CheckoutActions(page);
        checkout.fillDetailsAndProceed("niz", "reponse", "078247473839","kk402","kigali","bbb","Rwanda");
        checkout.selectPaymentMethod();
        checkout.ReviewOrder();
        checkout.PlaceOrder();
        assertThat(checkout.SuccessFullPlaceOrder()).isVisible();


    }
}