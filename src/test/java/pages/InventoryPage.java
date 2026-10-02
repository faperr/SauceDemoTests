package pages;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage {

    private final By pageTitle =
            By.cssSelector("[data-test='title']");

    private final By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private final By cartBadge =
            By.cssSelector("[data-test='shopping-cart-badge']");

    private final By cartLink =
            By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(
            WebDriver driver,
            WebDriverWait wait
    ) {
        super(driver, wait);
    }

    @Step("Получить заголовок страницы товаров")
    public String getPageTitle() {
        return el(pageTitle).getText();
    }

    @Step("Добавить Sauce Labs Backpack в корзину")
    public void addBackpackToCart() {
        click(backpackAddButton);
    }

    @Step("Получить количество товаров в корзине")
    public String getCartCount() {
        return el(cartBadge).getText();
    }

    @Step("Открыть корзину")
    public void openCart() {
        click(cartLink);
    }
}