package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;

public class StartPage extends ContentBasePage {

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public StartPage openUrl() {
        driver.get("https://geekbrains.ru/courses");
        return this;
    }


}
