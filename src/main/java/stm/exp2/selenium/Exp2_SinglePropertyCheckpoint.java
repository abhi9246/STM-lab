package stm.exp2.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exp2_SinglePropertyCheckpoint {

    public static void main(String[] args) throws InterruptedException {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Google
        driver.get("https://www.google.com");

        // Expected title
        String expectedTitle = "Google";

        // Actual title
        String actualTitle = driver.getTitle();

        System.out.println("Actual Title   : " + actualTitle);
        System.out.println("Expected Title : " + expectedTitle);

        if(actualTitle.equals(expectedTitle))
        {
            System.out.println("PASS: Title is correct");
        }
        else
        {
            System.out.println("FAIL: Title is incorrect");
        }

        Thread.sleep(2000);

        driver.quit();
    }
}
