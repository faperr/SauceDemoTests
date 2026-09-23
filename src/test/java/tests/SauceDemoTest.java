package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class SauceDemoTest extends BaseTest {

    @Test
    public void successfulLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver, wait);

        InventoryPage inventoryPage =
                new InventoryPage(driver, wait);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Ошибка: после входа не открылась страница товаров"
        );

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products",
                "Ошибка: заголовок Products не найден"
        );
    }

    @Test
    public void lockedUserLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver, wait);

        loginPage.login(
                "locked_out_user",
                "secret_sauce"
        );

        String error =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                error.toLowerCase().contains("locked out"),
                "Ошибка: сообщение о блокировке пользователя не появилось"
        );
    }

    @Test
    public void addBackpackToCartTest() {

        LoginPage loginPage =
                new LoginPage(driver, wait);

        InventoryPage inventoryPage =
                new InventoryPage(driver, wait);

        CartPage cartPage =
                new CartPage(driver, wait);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        inventoryPage.addBackpackToCart();

        Assert.assertEquals(
                inventoryPage.getCartCount(),
                "1",
                "Ошибка: в корзине должен быть один товар"
        );

        inventoryPage.openCart();

        Assert.assertEquals(
                cartPage.getItemName(),
                "Sauce Labs Backpack",
                "Ошибка: в корзине находится другой товар"
        );

        Assert.assertTrue(
                cartPage.getItemPrice().startsWith("$"),
                "Ошибка: цена товара не отображается"
        );
    }

    @Test
    public void completeCheckoutTest() {

        LoginPage loginPage =
                new LoginPage(driver, wait);

        InventoryPage inventoryPage =
                new InventoryPage(driver, wait);

        CartPage cartPage =
                new CartPage(driver, wait);

        CheckoutPage checkoutPage =
                new CheckoutPage(driver, wait);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        inventoryPage.addBackpackToCart();

        inventoryPage.openCart();

        Assert.assertEquals(
                cartPage.getItemName(),
                "Sauce Labs Backpack",
                "Ошибка: товар отсутствует в корзине"
        );

        cartPage.clickCheckout();

        checkoutPage.fillCheckoutForm(
                "Alex",
                "Ilyin",
                "12345"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getCompleteMessage(),
                "Thank you for your order!",
                "Ошибка: заказ не был успешно оформлен"
        );
    }
}