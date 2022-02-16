package Web.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCart extends Page {
    public final  By checkoutButton = By.id("checkout");

    public MyCart(WebDriver driver) {
        super(driver);
    }

    @Step("-Add to cart ")
    public CheckoutPages clickOnCheckout() {
        clickElement(checkoutButton);
        return new CheckoutPages(driver);
    }

}
