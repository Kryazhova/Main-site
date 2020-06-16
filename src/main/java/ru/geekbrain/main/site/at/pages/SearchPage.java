package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;
import ru.geekbrain.main.site.at.elementsTestSearch.SearchElement;

public class SearchPage  extends ContentBasePage {
    private SearchElement searchElement;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.searchElement = new SearchElement(driver);
    }

    @Override
    public SearchPage openUrl() {
        driver.get("https://geekbrains.ru/search");
        return this;
    }

    public SearchElement getSearchElement() {
        return searchElement;
    }

}

