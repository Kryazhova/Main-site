package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;

public class MainPage  extends ContentBasePage {

    // логика проверки:
    // - открываем стартовую страницу
    // - закрываем поп-ап
    // - проверяем навигацию
    // - проверяем хедер
    // - проверяем футер


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public MainPage openUrl() {
        driver.get("https://geekbrains.ru/");
        return this;
    }

}
