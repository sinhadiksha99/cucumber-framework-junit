package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
/*
 * Single Responsibility Principle (SRP) is handled here by separating the
 * LandingPageStepDefinition from OfferPageStepDefinition.
 * Each class has its own responsibility, making the code cleaner and easier to
 * maintain.
 * 
 * Dependency Injection is used to share the WebDriver instance and
 * landingProdName between LandingPageStepDefinition and
 * OfferPageStepDefinition.
 * This allows OfferPageStepDefinition to access the same driver and product
 * name without needing to create a new instance.
 * Loosely Coupled Design is also achieved as the OfferPageStepDefinition does
 * not depend on the LandingPageStepDefinition directly.
 * Loosely coupled thing is handled by using TestContextSetup class which holds
 * the WebDriver and product name. i.e Dependency Injection
 * 
 * Loosely couple no interdependency
 */