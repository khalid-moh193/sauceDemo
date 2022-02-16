package Web.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Page {
    private final By filterContainer = By.className("product_sort_container");
    private final By addProductToCart = By.id("add-to-cart-sauce-labs-onesie");
    private final By myCart = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("-select sort type from drop down list ")
    public HomePage selectSortType(Sorts sortType) {
        Select dropdownElement = new Select(driver.findElement(filterContainer));
        dropdownElement.selectByVisibleText(sortType.getValue());
        return this;
    }

    @Step("-Add product to my cart ")
    public HomePage addProductToMyCart() {
        clickElement(addProductToCart);
        return this;
    }

    @Step("-go to my cart ")
    public MyCart goToMyCart() {
        clickElement(myCart);
        return new MyCart(driver);
    }

    public enum Sorts {
        NAME_A_Z ("Name (A to Z)"),
        NAME_Z_A("Name (Z to A)"),
        LOWEST_PRICE("Price (low to high)"),
        HIGHEST_PRICE("Price (high to low)");

        private String value;
        Sorts(String value) {
            this.setValue(value);
        }
        public String getValue() {
            return value;
        }
        private void setValue(String value) {
            this.value = value;
        }
    }

}
