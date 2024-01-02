package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepDefs.Hooks.driver;

public class CheckoutPage {
    WebDriver driver;
    LoginPage loginPage;
    CheckoutPage checkoutPage;

    By productItem = By.linkText("Nokia lumia 1520");
    By addToCartButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By cartButton = By.xpath("//*[@id=\"cartur\"]");
    By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    By custNameInput = By.xpath("//*[@id=\"name\"]");
    By custCountryInput = By.id("country");
    By custCityInput = By.id("city");
    By custCardInput = By.id("card");
    By cardMonthInput = By.id("month");
    By cardYearInput = By.id("year");
    By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    By successOrderOk = By.xpath("/html/body/div[10]/div[7]/div/button");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProduct() {
        checkoutPage = new CheckoutPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));

        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,200)", "");

        driver.findElement(productItem).click();
    }
    public void clickAddToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
    }
    public void validateProductAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert addProduct = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(addProduct.getText());
        Assert.assertTrue(addProduct.getText().contains("Product added"));
        addProduct.accept();
    }

    public void initialAddProduct() {
        String username = "Mochi";
        String password = "1";
        loginPage = new LoginPage(driver);
        checkoutPage =new CheckoutPage(driver);

        driver.get("https://www.demoblaze.com/");
        loginPage.clickLoginForm();
        loginPage.inputUserValid(username, password);
        loginPage.clickLoginButton();

        //checkoutPage.clickOnProduct();
        //checkoutPage.clickAddToCartButton();
        //checkoutPage.validateProductAddedToCart();
    }
    public void clickCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));
        driver.findElement(cartButton).click();
    }
    public void clickPlaceOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton));

        driver.findElement(placeOrderButton).click();
    }
    public void inputCustomerDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(custNameInput));

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(custNameInput)).click();
        driver.findElement(custNameInput).sendKeys("customer name");
        driver.findElement(custCountryInput).sendKeys("country");
        driver.findElement(custCityInput).sendKeys("city");
        driver.findElement(custCardInput).sendKeys("123456789");
        driver.findElement(cardMonthInput).sendKeys("10");
        driver.findElement(cardYearInput).sendKeys("2030");
    }
    public void clickPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }
    public void validateSuccessPurchase() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(successOrderOk));

        driver.findElement(successOrderOk).click();
    }
}
