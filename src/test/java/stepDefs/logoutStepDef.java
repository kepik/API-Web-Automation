package stepDefs;

import io.cucumber.java.en.*;
import pages.LogoutPage;

import static stepDefs.Hooks.*;

public class logoutStepDef {
    LogoutPage logoutPage;
    @When("Click on the Logout button")
    public void clickOnTheLogoutButton() {
        logoutPage = new LogoutPage(driver);
        logoutPage.clickLogoutButton();
    }

    @Then("The user is logged out")
    public void theUserIsLoggedOut() {
    }
}
