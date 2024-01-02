package stepDefs;

import io.cucumber.java.en.*;
import pages.CheckoutPage;

import static stepDefs.Hooks.*;

public class checkoutStepDef {
    CheckoutPage checkoutPage;
    @When("User click on a product")
    public void userClickOnAProduct() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickOnProduct();
    }

    @And("Click on the Add to Cart button")
    public void clickOnTheAddToCartButton() {
        checkoutPage.clickAddToCartButton();
    }

    @Then("Validate the product is added into Cart")
    public void validateTheProductIsAddedIntoCart() {
        checkoutPage.validateProductAddedToCart();
    }


    @Given("User login and add a product to cart")
    public void userLoginAndAddAProductToCart() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.initialAddProduct();
    }

    @And("User click on the Cart button")
    public void userClickOnTheCartButton() {
        checkoutPage.clickCartPage();
    }

    @When("Click on the Place Order button")
    public void clickOnThePlaceOrderButton() {
        checkoutPage.clickPlaceOrderButton();
    }

    @And("Input customer details")
    public void inputCustomerDetails() {
        checkoutPage.inputCustomerDetails();
    }

    @Then("Validate the purchase is success")
    public void validateThePurchaseIsSuccess() {
        checkoutPage.clickPurchaseButton();
        checkoutPage.validateSuccessPurchase();
    }
}
