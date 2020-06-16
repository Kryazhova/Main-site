package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrain.main.site.at.blocks.NavigationElements;
import ru.geekbrain.main.site.at.pages.AuthorizationPage;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;

@Feature("Авторизация")
@Story("Проверка авторизации")
@DisplayName("Проверка авторизации")
public class AuthorizationTest  extends BeforeAndAfterStep {

    @DisplayName("Проверка авторизации с корректными данными")
    @Test
    void events() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";
        new AuthorizationPage(driver)
                .openUrl()
                .authorization(login, password)
                .testHeaderAndFooterAuthorized(NavigationElements.Button.ICON);
    }
}
