package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadAndDownload extends BaseTest{

    @Test
    public void test1(){
         driver.navigate().to("https://demoqa.com/upload-download");
        WebElement el = driver.findElement(By.id("uploadFile"));
        el.sendKeys("/Users/aidai/Downloads/photo_5341636614444663468_y.jpg");
//        WebElement n =
        Helper.pause(3000);
    }
}
