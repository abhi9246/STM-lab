package stm.exp2.selenium;
import org.openqa.selenium.*; 
import org.openqa.selenium.chrome.ChromeDriver; 
public class exp3
{

    public static void main(String[] args) throws InterruptedException 
    { 
        WebDriver driver = new ChromeDriver(); 
        driver.get("https://www.google.com"); 
        WebElement searchBox = driver.findElement(By.name("q")); 
        System.out.println("Displayed: " + searchBox.isDisplayed()); 
        System.out.println("Enabled  : " + searchBox.isEnabled()); 
        System.out.println(searchBox.isDisplayed() && searchBox.isEnabled() 
        ? "PASS: Search box is ready" 
        : "FAIL: Search box is not ready"); 
        Thread.sleep(2000); 
        driver.quit(); 
    } 
} 
