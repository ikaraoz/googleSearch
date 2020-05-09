package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyTitle(String titleToVerify) {
        new WebDriverWait(driver, 10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(titleToVerify);
            }

        });

    }
}