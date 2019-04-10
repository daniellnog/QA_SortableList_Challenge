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

//    public static void main(String[] args) {
//        SortableTest sortableTest = new SortableTest();
//        sortableTest.setupDriver();
//        sortableTest.sortTable();
//        sortableTest.quitBrowser();
//    }

    private WebDriver driver;


    @BeforeTest
    @Parameters({ "ip" })
    public void setupDriver(String ip) throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        this.driver = new RemoteWebDriver(new URL("http://" + ip + ":4444/wd/hub"), dc);
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
