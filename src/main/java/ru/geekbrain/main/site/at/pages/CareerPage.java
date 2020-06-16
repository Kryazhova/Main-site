package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;

public class CareerPage extends ContentBasePage {

    public CareerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public CareerPage openUrl() {
        driver.get("https://geekbrains.ru/career");
        return this;
    }
}
