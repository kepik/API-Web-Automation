package stepDefs;

import io.cucumber.java.en.*;
import pages.SignupPage;

import static stepDefs.Hooks.*;

public class signupStepDef {
    SignupPage signupPage;

    @Given("User access the website")
    public void userAccessTheWebsite() {
        signupPage = new SignupPage(driver);
        signupPage.accessThePage();
    }

    @And("User click on the Sign up button")
    public void userClickOnTheSignUpButton() {
        signupPage.clickSignUp();
    }

    @When("User input {string} and {string}")
    public void userInputAnd(String username, String password) {
        signupPage.inputNewUserData(username,password);
    }

    @And("Click on the Sign up button")
    public void clickOnTheSignUpButton() {
        signupPage.clickSignUpButton();
    }

    @Then("A new user is created")
    public void aNewUserIsCreated() {
        signupPage.validateUserCreated();
    }

    @And("Validate the signed up user with login")
    public void validateTheSignedUpUserWithLogin() {
        signupPage.validateLoginNewUser();
    }
}
