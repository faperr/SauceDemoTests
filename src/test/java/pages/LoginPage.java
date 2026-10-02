package pages;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By usernameInput =
            By.id("user-name");

    private final By passwordInput =
            By.id("password");

    private final By loginButton =
            By.id("login-button");

    private final By errorMessage =
            By.cssSelector("h3[data-test='error']");

    public LoginPage(
            WebDriver driver,
            WebDriverWait wait
    ) {
        super(driver, wait);
    }

    @Step("Ввести логин: {username}")
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Нажать кнопку Login")
    public void clickLogin() {
        click(loginButton);
    }

    @Step("Авторизоваться пользователем {username}")
    public void login(
            String username,
            String password
    ) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    @Step("Получить сообщение об ошибке авторизации")
    public String getErrorMessage() {
        return el(errorMessage).getText();
    }
}