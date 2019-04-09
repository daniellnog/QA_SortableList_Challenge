package com.qa_sortable_challenge.tests;

import com.qa_sortable_challenge.pages.MinderaQAChallenge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SortableTest {

    private WebDriver driver;


    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
    }

    @Test
    public void sortTable(){
        MinderaQAChallenge minderaQAChallenge = new MinderaQAChallenge(driver);
        minderaQAChallenge.sortTable();
    }

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }


}
