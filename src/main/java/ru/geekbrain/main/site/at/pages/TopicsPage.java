package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;

public class TopicsPage extends ContentBasePage {

     public TopicsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public TopicsPage openUrl() {
        driver.get("https://geekbrains.ru/topics");
        return this;
    }
}
