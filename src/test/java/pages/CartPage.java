package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By itemName =
            By.cssSelector("[data-test='inventory-item-name']");

    private final By itemPrice =
            By.cssSelector("[data-test='inventory-item-price']");

    private final By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getItemName() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(itemName)
        ).getText();
    }

    public String getItemPrice() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(itemPrice)
        ).getText();
    }

    public void clickCheckout() {
        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
        ).click();
    }
}