package intro.screenShot;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScreenShot extends Base3{
    @Test
    public void screen(){
        browserHelper.openUrl("https://www.amazon.com/");

        try{
//            driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Learn Automation");  // ----
//            Utils.CaptureScreenshot(driver, "img2.png");
//            Utils.CaptureScreenshot(driver, "img2");   //+++  we can't save as a photo
            Utils.CaptureScreenshot(driver, "");   //+++  ScreenshotException
        } catch (Exception e) {
            throw new ScreenshotException(e.getMessage());
        }

    }
    @Test
    public void screenContainer(){
        browserHelper.openUrl("https://demoqa.com/upload-download");

        try{
            WebElement el = driver.findElement(By.id("downloadButton"));
            Utils.CaptureWebElementScreenshot(el, "button.png");
        } catch (IOException e) {
            throw new ScreenshotException(e.getMessage());
        }
    }
}
