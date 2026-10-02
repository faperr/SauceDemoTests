package pages;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private final By itemName =
            By.cssSelector(
                    "[data-test='inventory-item-name']"
            );

    private final By itemPrice =
            By.cssSelector(
                    "[data-test='inventory-item-price']"
            );

    private final By checkoutButton =
            By.id("checkout");

    public CartPage(
            WebDriver driver,
            WebDriverWait wait
    ) {
        super(driver, wait);
    }

    @Step("Получить название товара в корзине")
    public String getItemName() {
        return text(itemName);
    }

    @Step("Получить цену товара в корзине")
    public String getItemPrice() {
        return text(itemPrice);
    }

    @Step("Нажать кнопку Checkout")
    public void clickCheckout() {
        click(checkoutButton);
    }
}