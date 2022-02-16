package Web.Pages;

import Web.Util.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("-Navigate SauceDemo Login Page ")
    public LoginPage navigateToSauceDemoLoginPage() {
        openURL(URLs.SAUCE_DEMO_LOGIN.getValue());
        return this;
    }

    @Step("-enter username ")
    private LoginPage enterUsername(String username) {
        sendText(usernameField, username);
        return this;
    }

    @Step("-enter Password ")
    private LoginPage enterPassword(String password) {
        sendText(passwordField, password);
        return this;
    }

    @Step("-click on Login button ")
    public LoginPage clickOnLoginButton() {
        clickElement(loginButton);
        return this;
    }

    @Step("- Login")
    public HomePage login(){
        enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();
        return new HomePage(driver);
    }

}
