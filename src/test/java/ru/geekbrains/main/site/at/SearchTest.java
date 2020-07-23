package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrain.main.site.at.elementsTestSearch.SearchElement;
import ru.geekbrain.main.site.at.pages.StartPage;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

//    Перейти на сайт https://geekbrains.ru/courses
//            Нажать на кнопку Поиск
//            В поле Поиск ввести текст: java
//            Проверить что отобразились блоки и в них:
//            Профессий не менее чем 2
//            Курсов более 15
//            Вебинаров больше чем 180, но меньше 300
//
//            Блогов более 300
//            Форумов не 350
//            Тестов не 0
//            Проверить, что найдены нужные элементы, например:
//            В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
//            В Проектах и компаниях отображается GeekBrains

@Feature("Поиск по сайту")
@Story("Проверка поиска")
@DisplayName("Проверка поиска")
public class SearchTest extends BeforeAndAfterStep {

    @BeforeEach
    void beforeSearchTest() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @DisplayName("Проверка поиска")
    @Description("Проверка поиска по слову \"Java\"")
    @Test
     void events(){
        new StartPage(driver)
                .openUrl()
                .closedPopUp()
                .getHeader()
                .searchText("java")

                .getSearchElement()
                .checkCount(SearchElement.SearchTab.PROFESSIONS, greaterThanOrEqualTo(2))
                .checkCount(SearchElement.SearchTab.COURSES, greaterThan(15))
                .checkCount(SearchElement.SearchTab.EVENTS, allOf(
                        greaterThan(180),
                        lessThan(300)))
                .checkCount(SearchElement.SearchTab.BLOGS, greaterThan(300))
                .checkCount(SearchElement.SearchTab.FORUMS, not(350))
                .checkCount(SearchElement.SearchTab.TESTS, not(0));

    }
}

