package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    WebDriver driver;
    LogoutPage logoutPage;

    By logoutButton = By.id("logout2");

    public LogoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLogoutButton() {
        logoutPage = new LogoutPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(logoutButton));

        driver.findElement(logoutButton).click();
    }
}
