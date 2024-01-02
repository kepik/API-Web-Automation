package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.Utility.*;

public class SignupPage {
    WebDriver driver;
    SignupPage signupPage;
    LoginPage loginPage;
    String signupUsername, signupPassword;

    By signupForm = By.id("signin2");
    By signupUserInput = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/input");
    By signupPassInput = By.id("sign-password");
    By signupButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void accessThePage () {
        signupPage = new SignupPage(driver);
        driver.get("https://www.demoblaze.com/");
    }

    public void clickSignUp() {
        driver.findElement(signupForm).click();
    }
    public void inputNewUserData(String username, String password) {
        signupUsername = generateRandomUsername();
        signupPassword = "1";

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(signupUserInput)).click();
        driver.findElement(signupUserInput).sendKeys(signupUsername);
        driver.findElement(signupPassInput).sendKeys(signupPassword);
    }
    public void clickSignUpButton() {
        driver.findElement(signupButton).click();
    }
    public void validateUserCreated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert newalert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(newalert.getText());
        Assert.assertTrue(newalert.getText().contains("Sign up successful"));

        newalert.accept();
    }
    public void validateLoginNewUser() {
        loginPage = new LoginPage(driver);
        loginPage.clickLoginForm();
        loginPage.inputUserValid(signupUsername,signupPassword);
        loginPage.clickLoginButton();
    }
}
