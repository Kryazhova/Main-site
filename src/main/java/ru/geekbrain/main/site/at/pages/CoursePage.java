package ru.geekbrain.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrain.main.site.at.blocks.ContentCourseBlock;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;

import java.util.List;

public class CoursePage extends ContentBasePage {

    private ContentCourseBlock courseTab;

    @FindBy(xpath = "//form/ul//label")
    private List<WebElement> filterList;

    @FindBy(xpath = "//a/div/div/span")
    private List<WebElement> courseList;

    @FindBy(css = "[class ='gb-gu-card__title']")
    private List<WebElement> professionList;

    @FindBy(css="[class ='gb-intensive-card__title']")
    private List<WebElement> freeList;


    public CoursePage(WebDriver driver) {
        super(driver);
        this.courseTab = new ContentCourseBlock(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка на наличие элементов фильтра")
    public CoursePage configFilter(String... args) {
        for (String test : args) {
            WebElement element = findElement(filterList, test);
            element.click();
        }
        return this;
    }

    @Step("Проверка на найденные элементы с использованием фильтра для таба {tab}")
    public CoursePage checkingDisplayedCourses(ContentCourseBlock.Tab tab, String... args) {
        List<WebElement> list = null;
        switch (tab) {
            case COURSES: {
                list = courseList;
                break;
            }
            case PROFESSIONS:{
                list = professionList;
                break;
            }
            case FREEINTENSIVE:{
                list = freeList;
                break;
            }
            default:  System.out.println("Нет проверки для таба: {tab}");
        }
        for (String test : args) {
            WebElement element = findElement(list, test);
            wait10second.until(ExpectedConditions.visibilityOf(element));
        }
        return this;
    }


    public ContentCourseBlock getContentNavigationCourseBlock() {
        return courseTab;
    }

    @Override
    public CoursePage openUrl() {
        driver.get("https://geekbrains.ru/courses");
        return this;
    }
}
