import Web.Pages.HomePage;
import Web.Pages.LoginPage;
import Web.Pages.CheckoutPages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("sauce lab - Add order")
public class sauceDemo extends BaseTestClass {
    //region Pages Declaration
    LoginPage login;
    HomePage home;
    CheckoutPages checkoutPages;
    //endregion

    @Feature("Add Order to cart")
    @Test(priority = 1, description = "login and add a product then checkout and check it was a successful operation")
    public void AddOrder() throws InterruptedException {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        checkoutPages = new CheckoutPages(driver);

        /************** Login *************/
        login.navigateToSauceDemoLoginPage()
                .login()
                /**************  select Lowest price products *************/
                .selectSortType(HomePage.Sorts.LOWEST_PRICE)
                /**************  add product to cart and checkout *************/
                .addProductToMyCart()
                .goToMyCart()
                .clickOnCheckout()
                .fillAllInformation()
                .clickOnFinishButton();

        /**************  Verify that completion of order *************/
        doAssertEqual(getCheckoutStatus(), "COMPLETE", "checkout status");
        softAssert.assertAll();

        Thread.sleep(2000);
    }

    String getCheckoutStatus() {
        /* this method will take the string and return the expected result
            input: CHECKOUT: COMPLETE!
            output: COMPLETE */

        String[] checkoutStatus = checkoutPages.getCheckoutStatus().split("[,: !]+"); // split the string and return the expected value only
        checkoutPages.scrollUpByPixel();
        return checkoutStatus[1];
    }

}
