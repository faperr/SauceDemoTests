package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

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

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void fillCheckoutForm(
            String firstName,
            String lastName,
            String postalCode
    ) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameInput)
        ).sendKeys(firstName);

        driver.findElement(lastNameInput)
                .sendKeys(lastName);

        driver.findElement(postalCodeInput)
                .sendKeys(postalCode);
    }

    public void clickContinue() {
        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }

    public void clickFinish() {
        wait.until(
                ExpectedConditions.elementToBeClickable(finishButton)
        ).click();
    }

    public String getCompleteMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(completeMessage)
        ).getText();
    }
}