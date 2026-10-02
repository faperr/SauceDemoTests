package pages;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    private final By firstNameInput =
            By.id("first-name");

    private final By lastNameInput =
            By.id("last-name");

    private final By postalCodeInput =
            By.id("postal-code");

    private final By continueButton =
            By.id("continue");

    private final By finishButton =
            By.id("finish");

    private final By completeMessage =
            By.cssSelector("[data-test='complete-header']");

    public CheckoutPage(
            WebDriver driver,
            WebDriverWait wait
    ) {
        super(driver, wait);
    }

    @Step("Заполнить данные для оформления заказа")
    public void fillCheckoutForm(
            String firstName,
            String lastName,
            String postalCode
    ) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
    }

    @Step("Нажать кнопку Continue")
    public void clickContinue() {
        click(continueButton);
    }

    @Step("Нажать кнопку Finish")
    public void clickFinish() {
        click(finishButton);
    }

    @Step("Получить сообщение об успешном оформлении заказа")
    public String getCompleteMessage() {
        return el(completeMessage).getText();
    }
}