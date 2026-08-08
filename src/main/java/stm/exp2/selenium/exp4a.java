package stm.exp2.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class exp4a {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");

            // Locate object
            WebElement searchBox = driver.findElement(By.name("q"));

            // Create Screenshots folder
            File folder = new File("Screenshots");
            if (!folder.exists()) {
                folder.mkdir();
            }

            // Capture current screenshot
            File currentImage = searchBox.getScreenshotAs(OutputType.FILE);
            File currentFile = new File("Screenshots/current_searchbox.png");
            FileHandler.copy(currentImage, currentFile);

            System.out.println("Current screenshot saved:");
            System.out.println(currentFile.getAbsolutePath());

            // Baseline image
            File baselineFile = new File("Screenshots/baseline_searchbox.png");

            if (!baselineFile.exists()) {
                System.out.println("Baseline image not found.");
                System.out.println("Rename current_searchbox.png as baseline_searchbox.png");
            } else {

                boolean result = compareImages(baselineFile, currentFile);

                if (result) {
                    System.out.println("BITMAP CHECKPOINT : TEST PASS");
                    System.out.println("Images are identical.");
                } else {
                    System.out.println("BITMAP CHECKPOINT : TEST FAIL");
                    System.out.println("Images are different.");
                }
            }

        } catch (Exception e) {
            System.out.println("Execution Failed");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    // Method to compare image pixels
    public static boolean compareImages(File img1, File img2) throws Exception {

        BufferedImage image1 = ImageIO.read(img1);
        BufferedImage image2 = ImageIO.read(img2);

        if (image1.getWidth() != image2.getWidth() ||
            image1.getHeight() != image2.getHeight()) {
            return false;
        }

        for (int x = 0; x < image1.getWidth(); x++) {
            for (int y = 0; y < image1.getHeight(); y++) {
                if (image1.getRGB(x, y) != image2.getRGB(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }
}