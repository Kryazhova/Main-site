package ru.geekbrain.main.site.at.elementsTestSearch;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchElement  extends BasePageObject {

    @FindBy(css = "[class='search-page-tabs'] [data-tab='all']")
    private WebElement everyWhere;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='professions']")
    private WebElement profession;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='courses']")
    private WebElement course;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='webinars']")
    private WebElement event;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='blogs']")
    private WebElement blog;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='forums']")
    private WebElement forums;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='tests']")
    private WebElement test;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='companies']")
    private WebElement projectAndCompanies;

    public SearchElement(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка, что найдено нужнок количество элементов для блока {searchTab}")
    public SearchElement checkCount(SearchTab searchTab, Matcher<Integer> matcher) {
        String actualCount = testSearchElement(searchTab).findElement(By.cssSelector("span")).getText();
        assertThat(Integer.parseInt(actualCount), matcher);
        return this;
    }

    @Step("Проверка блока {searchTab}")
    private WebElement testSearchElement (SearchTab searchTab) {
            switch (searchTab) {
                case Everywhere: {
                    return everyWhere;
                }
                case Professions: {
                    return profession;
                }
                case Courses: {
                   return course;
                }
                case Enents:{
                    return event;
                }
                case Blogs: {
                    return blog;
                }
                case Forums: {
                   return forums;
                }
                case Tests: {
                    return test;
                }
                case Companies: {
                    return projectAndCompanies;
                }
                default: {
                    throw new IllegalStateException("Нет блока: " + searchTab);
                }
        }
    }

    public enum SearchTab {
        Everywhere("Везде"),
        Professions("Профессии"),
        Courses("Курсы"),
        Enents("Вебинары"),
        Blogs("Блоги"),
        Forums("Форумы"),
        Tests("Тесты"),
        Companies("Компании");

        private String text;

        SearchTab(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
