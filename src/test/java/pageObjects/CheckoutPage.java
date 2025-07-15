package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckoutPage {

    private WebDriver driver;
    By cartBag = By.cssSelector("img[alt='Cart']");
    By checkoutButton = By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]");
    By promoButton = By.cssSelector("button.promoBtn");
    By promoCodeInput = By.cssSelector("input.promoCode");
    By placeOrder = By.xpath("//button[text()='Place Order']");
    By productName = By.cssSelector("p.product-name");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout(){
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public boolean verifyPromoBtn(){
        return driver.findElement(promoButton).isDisplayed();
    }

    public boolean verifyPlaceOrder(){
        return driver.findElement(placeOrder).isDisplayed();
    }
    
    public List<WebElement> getProductName() {
        return driver.findElements(productName);
    }
}
