package stepDefs;

import io.cucumber.java.en.*;
import pages.CheckoutPage;
import pages.LoginPage;

import static stepDefs.Hooks.*;

public class loginStepDef {
    LoginPage loginPage;
    CheckoutPage checkoutPage;

    @And("User click on the Login button")
    public void userClickOnTheLoginButton() {
        loginPage = new LoginPage(driver);
        loginPage.clickLoginForm();
    }

    @When("User input login {string} and {string}")
    public void userInputLoginAnd(String userLogin, String passLogin) {
        loginPage.inputUserValid(userLogin, passLogin);
    }

    @And("Click on the Login button")
    public void clickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("The user is redirected to the user homepage")
    public void theUserIsRedirectedToTheUserHomepage() {
    }

    @Then("Validate that the credential are invalid")
    public void validateThatTheCredentialAreInvalid() {
        loginPage.validateInvalidLogin();
    }
}
