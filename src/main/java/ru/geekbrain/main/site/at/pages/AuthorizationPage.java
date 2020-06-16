package ru.geekbrain.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.BasePageObject;
import ru.geekbrain.main.site.at.utilities.OpenUrl;

public class AuthorizationPage extends BasePageObject implements OpenUrl {
    @FindBy(css = "[data-testid='login-email']")
    private WebElement inputLogin;

    @FindBy(css = "[data-testid='login-password']")
    private WebElement inputPassword;

    @FindBy(css = "[data-testid='login-submit'")
    private WebElement buttonSingInd;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("авторизация с логин: {login} и пароль: {password}")
    public MainPage authorization(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSingInd.click();
        return new MainPage(driver);
    }

    @Override
    public AuthorizationPage openUrl() {
        driver.get("https://geekbrains.ru/login");
        return this;
    }
}
