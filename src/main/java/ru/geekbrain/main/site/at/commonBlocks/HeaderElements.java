package ru.geekbrain.main.site.at.commonBlocks;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrain.main.site.at.pages.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class HeaderElements extends BasePageObject {

    @FindBy(css = "[id='top-menu']")
    private WebElement topMenu;

    @FindBy(css = "[class='gb-header__title']")
    private WebElement titleHeader;

    @FindBy(css = "[class='gb-top-menu__item']>[class='show-search-form']")
    private WebElement searchItem;

    @FindBy(css = "input[class='search-panel__search-field']")
    protected WebElement inputSearch;

    /*
    Поля доступные только неавторизованному пользователю
    * */
    @FindBy(css = "[class='gb-top-menu__item']>[href='/login']")
    private WebElement loginItem;

    @FindBy(css = "[href='/register']")
    private WebElement registerHeader;

      /*
    Поля доступные только авторизованному пользователю
    * */

    @FindBy(css = "[class='js-notices-link']")
    private WebElement buttonNotify;

    @FindBy(css = "header [href='/thanks']")
    private WebElement buttonLike;

    @FindBy(css = "[id='menu-messages']")
    private WebElement buttonMessages;

    @FindBy(css = "[class='gb-top-menu__item dropdown']")
    private WebElement buttonAvatar;

    public HeaderElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("проверка что на странице открыт нужный хедер для неавторизованного пользователя")
    public HeaderElements testHeaderUnauthorized() {
        wait10second.until(ExpectedConditions.visibilityOfAllElements(
                        topMenu,
                        titleHeader,
                        searchItem,
                        loginItem,
                        registerHeader));
        return this;
    }

    @Step("проверка что на странице открыт нужный хедер для авторизованного пользователя")
    public HeaderElements testHeaderAuthorized() {
        wait10second.until(ExpectedConditions.visibilityOfAllElements(
                        topMenu,
                        titleHeader,
                        searchItem,
                        buttonNotify,
                        buttonLike,
                        buttonMessages,
                        buttonAvatar
                        ));
        return this;
    }

    @Step("проверка, что имя страницы: {realNamePage}")
    public HeaderElements checkNamePage(String realNamePage) {
        wait10second.until(ExpectedConditions.textToBePresentInElement(titleHeader, realNamePage));

        String headerPageText = titleHeader.getText();
        assertThat(headerPageText, equalToCompressingWhiteSpace(realNamePage));
        return this;
    }

    @Step("поиск на сайте по тексту: {text}")
    public SearchPage searchText(String text) {
        searchItem.click();
        inputSearch.sendKeys(text);
        return new SearchPage(driver);
    }
}


