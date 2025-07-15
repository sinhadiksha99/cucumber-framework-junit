package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
    public WebDriver driver;
    public String landingProdName;
    public PageObjectManager pageObjectManager;
    public BaseTest baseTest;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.WebDriverManager());
        genericUtils = new GenericUtils(baseTest.WebDriverManager());
    }
}
