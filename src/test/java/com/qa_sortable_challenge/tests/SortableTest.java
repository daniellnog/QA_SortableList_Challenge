package com.qa_sortable_challenge.tests;

import com.qa_sortable_challenge.pages.MinderaQAChallenge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SortableTest {

    private WebDriver driver;

    // Método para configurar o driver do navegador antes de iniciar a execução do teste
    @BeforeTest
    @Parameters({ "ip" })
    public void setupDriver(String ip) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        this.driver = new RemoteWebDriver(new URL("http://" + ip + ":4444/wd/hub"), dc);
    }

    // Método para executar a ordenação da tabela de maneira crescente
    @Test
    public void sortTable(){
        MinderaQAChallenge minderaQAChallenge = new MinderaQAChallenge(driver);
        minderaQAChallenge.sortTable();
    }

    // Método para fechar o browser
    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }
}
