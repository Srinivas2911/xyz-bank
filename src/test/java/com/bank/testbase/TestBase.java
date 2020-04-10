package com.bank.testbase;

import com.bank.basepage.BasePage;
import com.bank.browserselector.BrowserSelector;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase extends BasePage {


    BrowserSelector browserSelector = new BrowserSelector();
    String baseUrl = "http://www.way2automation.com/angularjs-protractor/banking/#/login";

    @BeforeClass
    public void openBrowser() {
        browserSelector.selectBrowser("chrome");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-2000, 0));//display 2

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
