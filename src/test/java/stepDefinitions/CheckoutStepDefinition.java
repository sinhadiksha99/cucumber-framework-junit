package stepDefinitions;


import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutStepDefinition {
    TestContextSetup setup;
    CheckoutPage checkoutPage;

    public CheckoutStepDefinition(TestContextSetup setup) {
        this.setup = setup;
        checkoutPage = setup.pageObjectManager.getCheckoutPage();
    }

    @Then("user proceeds to checkout and validate the {string} items in the checkout page")
    public void user_proceeds_to_checkout_and_validate_the_items_in_the_checkout_page(String prodName){
        checkoutPage.checkout();
        boolean found = checkoutPage.getProductName().stream()
                .anyMatch(product -> product.getText().toLowerCase().contains(prodName));
        Assert.assertTrue(found);
    }

    @Then("verify has ability to enter promo code and place the order")
    public void verify_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
    }

}
