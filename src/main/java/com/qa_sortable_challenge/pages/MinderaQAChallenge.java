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

    public void sortTable(){
        driver.get("http://172.21.207.49:3000/");

        this.wait.until(ExpectedConditions.visibilityOf(this.app));

        WebElement ul = app.findElement(By.tagName("ul"));
        //creating a list of WebElement's
        List<WebElement> orderedList = new ArrayList<WebElement>();
        //creating a secundary list of WebElement's
        List<WebElement> originalList = new ArrayList<WebElement>();

        //verifying if the WebElement ul isn't null
        if (ul != null) {
            // searching within the UL a list of WebElements
            orderedList = ul.findElements(By.tagName("li"));
            // searching within the UL a list of WebElements
            originalList = ul.findElements(By.tagName("li"));
            // sorting the list through the HTML's attribute textContent
            orderedList.sort(Comparator.comparing(a -> a.getAttribute("textContent")));

            for (int i = 0; i < orderedList.size(); i++) {
                // creating a new Action
                Actions act = new Actions(driver);
                // searching in the originalList, the index of the actual element
                int of = originalList.indexOf(orderedList.get(i));
                // moving the element to the correct position
                act.dragAndDrop(originalList.get(of), originalList.get(i)).build().perform();
                // sorting the orderedList again
                orderedList.sort(Comparator.comparing(a -> a.getAttribute("textContent")));
            }
            //closing the browser
            driver.close();
        }
    }

}
