package ru.geekbrain.main.site.at.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.BasePageObject;
import ru.geekbrain.main.site.at.pages.CoursePage;
import ru.geekbrain.main.site.at.utilities.ButtonNotFoundException;

public class ContentCourseBlock extends BasePageObject {
    @FindBy(css = "[class*='nav nav-tabs'] [id='prof-link']")
    private WebElement tabProfessions;

    @FindBy(css = "[class*='nav nav-tabs'] [id='free-link']")
    private WebElement tabFreeIntensive;

    @FindBy(css = "[class*='nav nav-tabs'] [id='cour-link']")
    private WebElement tabCourses;

    @FindBy(css = "[class*='nav nav-tabs'] [href*='https://forbusiness']")
    private WebElement tabCompanies;

    public ContentCourseBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Нажатие на таб {tab}")
    public CoursePage clickTab(Tab tab) {
        switch (tab) {
            case PROFESSIONS: {
                tabProfessions.click();
                return new CoursePage(driver);
            }
            case FREEINTENSIVE: {
                tabFreeIntensive.click();
                return new CoursePage(driver);
            }
            case COURSES: {
                tabCourses.click();
                return new CoursePage(driver);
            }
            case COMPANIES: {
                tabCompanies.click();
                return new CoursePage(driver);
            }
        }
        throw new ButtonNotFoundException();
    }

    public enum Tab {
        PROFESSIONS,
        FREEINTENSIVE,
        COURSES,
        COMPANIES;
    }
}
