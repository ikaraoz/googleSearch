package com.example;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class MyStepdefs {

    WebDriver driver;
    String url = "https://www.google.com";
    SearchPage sp;
    ResultsPage rp;
    //String searchTerm= "cheese";

    @Given("I am on the Google search page")
    public void I_visit_google() {
        driver = Browser.startBrowser("chrome", url);

//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver81");
//        driver = new ChromeDriver();
//        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void search_for(String query) {
        sp = new SearchPage(driver);
        sp.SearchTerm(query);

//        WebElement element = driver.findElement(By.name("q"));
//        // Enter something to search for
//        element.sendKeys(query);
//        // Now submit the form. WebDriver will find the form for us from the element
//        element.submit();
    }

    @Then("the page title should start with {string}")
    public void checkTitle(String titleStartsWith) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds

        rp = new ResultsPage(driver);
        rp.verifyTitle(titleStartsWith);
//        new WebDriverWait(driver, 10L).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith(titleStartsWith);
//            }
//        });
        List<WebElement> cities = driver.findElements(By.id("typeaheadList"));
        for (WebElement e : cities) {
            System.out.println(e);

        }

    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}