package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrain.main.site.at.pages.CoursePage;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;

import static ru.geekbrain.main.site.at.blocks.ContentCourseBlock.Tab.*;

@Feature("Поиск")
@Story("Проверка отображения блоков")
@DisplayName("Страница Курсы")
public class CourseTest extends BeforeAndAfterStep {
    @DisplayName("Проверка работы фильтров")
    @Test
    void checkSingInValidLogin() {
        ((CoursePage)
                new CoursePage(driver)
                        .openUrl()
                        .closedPopUp()
        )
                .getContentNavigationCourseBlock().clickTab(COURSES)
                .configFilter("Бесплатные", "Веб-разработка")
                .checkingDisplayedCourses(COURSES,
                        "Основы ООП", "JavaScript. Уровень 1")

                .getContentNavigationCourseBlock().clickTab(PROFESSIONS)
                .checkingDisplayedCourses(PROFESSIONS,
                        "Искусственного интеллекта","Java-разработки")

                .getContentNavigationCourseBlock().clickTab(FREEINTENSIVE)
                .checkingDisplayedCourses(FREEINTENSIVE,"Интенсив “Веб-разработка для начинающих”")

                .getContentNavigationCourseBlock().clickTab(PROFESSIONS);

    }
}
