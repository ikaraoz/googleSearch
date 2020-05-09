package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;
    WebElement element;
    By search = By.name("q");
    By Submit = By.name("btnK");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void SearchTerm(String term) {
        this.enterSearchTerm(term);
        this.clickSubmit();

    }

    public void enterSearchTerm(String term) {
        driver.findElement(search).sendKeys(term);
    }

    public void clickSubmit() {
       driver.findElement(Submit).submit();
    }
}
