package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    LoginPage loginPage;

    By loginForm = By.cssSelector("#login2");
    By loginUsername = By.id("loginusername");
    By loginPassword = By.id("loginpassword");
    By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginForm() {
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginForm));
        driver.findElement(loginForm).click();
    }
    public void inputUserValid(String username, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(loginUsername)).click();
        driver.findElement(loginUsername).sendKeys(username);
        driver.findElement(loginPassword).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void validateInvalidLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert invalidLogin = wait.until(ExpectedConditions.alertIsPresent());
        invalidLogin.accept();
    }
}
