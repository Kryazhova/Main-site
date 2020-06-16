package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;

public class EventsPage extends ContentBasePage {

    public EventsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public EventsPage openUrl() {
        driver.get("https://geekbrains.ru/events");
        return this;
    }

}
