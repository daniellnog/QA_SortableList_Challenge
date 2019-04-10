package com.qa_sortable_challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinderaQAChallenge {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "app")
    private WebElement app;

    public MinderaQAChallenge(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void sortTable(String ip){
        driver.get("http://" + ip + ":3000/");

        this.wait.until(ExpectedConditions.visibilityOf(this.app));

        WebElement ul = app.findElement(By.tagName("ul"));
        //Criando a lista de webelements
        List<WebElement> orderedList = new ArrayList<WebElement>();
        //Criando uma lista de webelements secundaria
        List<WebElement> originalList = new ArrayList<WebElement>();

        //verificando se a lista de UL's é diferente de null
        if (ul != null) {
            // procurando elementos dentro da lista ul pela tag li
            orderedList = ul.findElements(By.tagName("li"));
            // procurando elementos dentro da lista ul pela tag li
            originalList = ul.findElements(By.tagName("li"));
            // ordenando a lista de acordo com o conteúdo do elemento HTML
            orderedList.sort(Comparator.comparing(a -> a.getAttribute("textContent")));

            for (int i = 0; i < orderedList.size(); i++) {
                // criando uma nova ação
                Actions act = new Actions(driver);
                // buscando na lista original o index atual do elemento
                int of = originalList.indexOf(orderedList.get(i));
                // movendo o elemento para a posição correta
                act.dragAndDrop(originalList.get(of), originalList.get(i)).build().perform();
                // ordenando novamente a lista
                orderedList.sort(Comparator.comparing(a -> a.getAttribute("textContent")));
            }
            //closing the browser
            driver.close();
        }
    }

}
