package ru.geekbrain.main.site.at.commonBlocks;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrain.main.site.at.blocks.NavigationElements;
import ru.geekbrain.main.site.at.utilities.OpenUrl;

public abstract class ContentBasePage extends BasePageObject implements OpenUrl {
    protected NavigationElements leftNavigation;
    protected HeaderElements headerElements;
    protected FooterElements footerElements;

    @FindBy(css ="button>[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement popupClose;

    public ContentBasePage(WebDriver driver) {
        super(driver);
        this.headerElements = new HeaderElements(driver);
        this.leftNavigation = new NavigationElements(driver);
        this.footerElements = new FooterElements(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Закрытие поп-апа")
    public ContentBasePage closedPopUp() {
        wait10second.until(ExpectedConditions.visibilityOf(popupClose));
        if (popupClose.isDisplayed()) {
            this.popupClose.click();
        }
        return this;
    }

    public NavigationElements getLeftNavigation() {
        return leftNavigation;
    }

    public ContentBasePage testHeaderAndFooter(NavigationElements.Button nameButton){
        this.getHeader().testHeaderUnauthorized();
        this.getFooter().testFooter();
        this.getHeader().checkNamePage(nameButton.getText());
        return this;
    }


    public ContentBasePage testHeaderAndFooterAuthorized(NavigationElements.Button nameButton){
        this.getHeader().testHeaderAuthorized();
        this.getFooter().testFooter();
        this.getHeader().checkNamePage(nameButton.getText());
        return this;
    }
    public HeaderElements getHeader() {
        return headerElements;
    }
    public FooterElements getFooter() {
        return footerElements;
    }


}
