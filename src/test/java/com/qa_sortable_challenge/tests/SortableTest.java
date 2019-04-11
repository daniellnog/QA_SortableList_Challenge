package com.qa_sortable_challenge.tests;

import com.qa_sortable_challenge.pages.MinderaQAChallenge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SortableTest {

    private WebDriver driver;
    private String ip = "localhost";

    // Método para configurar o driver do navegador antes de iniciar a execução do teste
    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.firefox();

        if(System.getProperty("BROWSER") != null){
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HOST") != null){
            this.ip = "http://" + System.getProperty("HOST");
        }
        dc.setCapability("name", ctx.getCurrentXmlTest().getName());
        this.driver = new RemoteWebDriver(new URL("http://" + this.ip + ":4444/wd/hub"), dc);
        this.driver.manage().window().maximize();

//        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    // Método para executar a ordenação da tabela de maneira crescente
    @Test
    @Parameters( {"ip"})
    public void sortTable(String ip) throws InterruptedException {
        MinderaQAChallenge minderaQAChallenge = new MinderaQAChallenge(driver);
        minderaQAChallenge.sortTable(ip);
    }

    // Método para fechar o browser
    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }
}
