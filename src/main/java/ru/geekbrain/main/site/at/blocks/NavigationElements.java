package ru.geekbrain.main.site.at.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.BasePageObject;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;
import ru.geekbrain.main.site.at.pages.*;

public class NavigationElements extends BasePageObject {

    @FindBy(css = "[class='svg-icon icon-logo']")
    private WebElement icon;

    @FindBy(css = "[id='nav'] [href='/courses']")
    private WebElement buttonCourses;

    @FindBy(css = "[id='nav'] [href='/events']")
    private WebElement buttonEvents;

    @FindBy(css = "[id='nav'] [href='/topics']")
    private WebElement buttonTopics;

    @FindBy(css = "[id='nav'] [href='/posts']")
    private WebElement buttonPosts;

    @FindBy(css = "[id='nav'] [href='/tests']")
    private WebElement buttonTests;

    @FindBy(css = "[id='nav'] [href='/career']")
    private WebElement buttonCareer;

    public NavigationElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Нажатие кнопки {nameButton}")
    public ContentBasePage clickButton(Button nameButton) {
        ContentBasePage contentBasePage;

        switch (nameButton) {
            case ICON:
                icon.click();
                contentBasePage = new MainPage(driver);
                break;
            case COURSES:
                buttonCourses.click();
                contentBasePage = new CoursePage(driver);
                break;
            case EVENTS:
                buttonEvents.click();
                contentBasePage = new EventsPage(driver);
                break;
            case TOPICS:
                buttonTopics.click();
                contentBasePage = new TopicsPage(driver);
                break;
            case POSTS:
                buttonPosts.click();
                contentBasePage = new PostsPage(driver);
                break;
            case TESTS:
                buttonTests.click();
                contentBasePage = new TestPage(driver);
                break;
            case CAREER:
                buttonCareer.click();
                contentBasePage = new CareerPage(driver);
                break;
            default:
                contentBasePage = new MainPage(driver);
        }


        return contentBasePage;
    }

    public enum Button{
        ICON("Главная"),
        COURSES("Курсы"),
        EVENTS("Вебинары"),
        TOPICS("Форум"),
        POSTS("Блог"),
        TESTS("Тесты"),
        CAREER("Карьера");

        private String text;

        Button(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
