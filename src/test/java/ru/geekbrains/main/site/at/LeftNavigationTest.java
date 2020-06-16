package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrain.main.site.at.pages.StartPage;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;

import java.util.stream.Stream;

import static ru.geekbrain.main.site.at.blocks.NavigationElements.Button;


@Feature("Навигация по сайту")
@Story("Переход на страницы через навигацию")
@DisplayName("Переход на страницы через навигацию")
public class LeftNavigationTest extends BeforeAndAfterStep {

//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Вебинары
//    Форум
//    Блог
//    Тесты
//    Карьера

    public static Stream<Button> stringProvider() {
        return Stream.of(
                Button.COURSES,
                Button.EVENTS,
                Button.TOPICS,
                Button.POSTS,
                Button.TESTS,
                Button.CAREER
        );

    }
    @DisplayName("Улучшенная проверка с Page Factory для каждой страницы навигации")
    @Description("Проверка навигации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProvider")
    void testPagesWithPopUp(Button nameButton){
        new StartPage(driver)
                .openUrl()
                .closedPopUp()
                .getLeftNavigation().clickButton(nameButton)
                .testHeaderAndFooter(nameButton);
    }
}





