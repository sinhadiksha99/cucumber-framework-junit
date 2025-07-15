package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
    public String landingProdName;
    public String offerProdName;
    PageObjectManager pageObjectManager;
    TestContextSetup setup;

    public OfferPageStepDefinition(TestContextSetup setup) {
        this.setup = setup;
    }

    @Then("user search {string} in offers page")
    public void user_search_in_offers_page(String prodName) throws InterruptedException {
        switchToOffersPage();
        pageObjectManager = setup.pageObjectManager;
        OffersPage offersPage = pageObjectManager.getOffersPage();
        offersPage.searchItem(prodName);
        Thread.sleep(2000);
        offerProdName = offersPage.getProductName();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        System.out.println("Landing Product Name: " + setup.landingProdName);
        System.out.println("Offer Product Name: " + offerProdName);
        Assert.assertEquals(setup.landingProdName, offerProdName);
    }

    public void switchToOffersPage() {
        pageObjectManager = setup.pageObjectManager;
        LandingPage landingPage = pageObjectManager.getLandingPage();
        landingPage.goToTopDealsPage();
        setup.genericUtils.switchWindowToChild();
    }
}