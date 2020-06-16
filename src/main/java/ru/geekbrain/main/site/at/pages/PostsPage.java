package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;

public class PostsPage extends ContentBasePage {

    public PostsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public PostsPage openUrl() {
        driver.get("https://geekbrains.ru/posts");
        return this;
    }
}
