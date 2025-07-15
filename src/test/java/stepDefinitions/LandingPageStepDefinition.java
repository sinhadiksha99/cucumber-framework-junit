package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.GenericUtils;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public String landingProdName;
    public String offerProdName;
    TestContextSetup setup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup setup) {
        this.setup = setup;
        landingPage = setup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(setup.genericUtils.getTitle().contains("GreenKart"));
    }

    @When("user search with {string} and extract actual name of product")
    public void user_search_with_and_extract_actual_name_of_product(String key) throws InterruptedException {
        landingPage.searchItem(key);
        Thread.sleep(2000); // Wait for results to load
        setup.landingProdName = landingPage.getProductName().split("-")[0].trim();
        System.out.println("Product Name: " + setup.landingProdName);
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String string) {
        for (int i = 0; i < Integer.parseInt(string); i++) {
            landingPage.addItem();
        }
        landingPage.addItemToCart();
    }

}