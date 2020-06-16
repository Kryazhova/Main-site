package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;

public class TestPage extends ContentBasePage {
    public TestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TestPage openUrl() {
        driver.get("https://geekbrains.ru/tests");
        return this;
    }
}
