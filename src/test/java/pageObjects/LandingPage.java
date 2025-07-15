package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    By search = By.className("search-keyword");
    By prodName = By.cssSelector("h4.product-name");
    By topDeals = By.linkText("Top Deals");
    By addItem = By.cssSelector("a.increment");
    By addToCart = By.xpath("//button[text()='ADD TO CART']");
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String name) {
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName() {
        return driver.findElement(prodName).getText();
    }

    public void goToTopDealsPage() {
        driver.findElement(topDeals).click();
    }

    public void addItem() {
        driver.findElement(addItem).click();
    }
    
     public void addItemToCart() {
        driver.findElement(addToCart).click();
     }
}
