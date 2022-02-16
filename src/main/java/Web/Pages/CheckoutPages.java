package Web.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPages extends Page {
    private final By firstname = By.id("first-name");
    private final By lastname = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By checkoutStatus = By.className("title");


    public CheckoutPages(WebDriver driver) {
        super(driver);
    }

    @Step("-enter firstname ")
    private CheckoutPages enterFirstName(String name) {
        sendText(firstname, name);
        return this;
    }

    @Step("-enter lastname ")
    private CheckoutPages enterLastName(String name) {
        sendText(lastname, name);
        return this;
    }

    @Step("-enter postal code ")
    private CheckoutPages enterPostalCode(String code) {
        sendText(postalCode, code);
        return this;
    }

    @Step("-click on continue button ")
    public CheckoutPages clickOnContinueButton() {
        clickElement(continueButton);
        return this;
    }

    @Step("- fill all required information")
    public CheckoutPages fillAllInformation(){
        enterFirstName("first name")
                .enterLastName("last name")
                .enterPostalCode("00000")
                .clickOnContinueButton();
        return this;
    }

    @Step("-click on finish button ")
    public CheckoutPages clickOnFinishButton() {
        clickElement(finishButton);
        return this;
    }

    @Step("-get checkout status ")
    public String getCheckoutStatus() {
        return getElementText(checkoutStatus);
    }

}
