package intro;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class CssDemo extends BaseTest{

    @Test
    public void cssTest() throws InterruptedException {

        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Iphone", Keys.ENTER);
        WebElement brandApple = driver.findElement(By.xpath("//li[@id='p_89/Apple']"));
        System.out.println(brandApple.getText());

       List <WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul"));

        WebElement seeMore = driver.findElement(By.xpath("//*[text()='See more'][1]"));
        seeMore.click();

//        WebElement mark = driver.findElement(By.xpath("//li[@id='p_89/Nokia']"));
//        String m2 = mark.getText();
//        WebElement checkBox = driver.findElement(By.xpath("(//*[@id='p_89/OnePlus'])[2]/span/a"));

//       List <WebElement> brandsLi = driver.findElements(By.tagName("li"));

       for (WebElement e: allBrands){
           if(!e.getText().contains("Nokia")){
               System.out.println("false");
           }else {
               WebElement nokiaCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Nokia']/preceding-sibling::div//label")));
               nokiaCheckBox.click();
               System.out.println("true");
               Thread.sleep(3000);

           }
       }
//        WebElement nokiaCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Nokia']/preceding-sibling::div//label")));
//        nokiaCheckBox.click();


//        WebElement seeLess = driver.findElement(By.xpath("//*[text()='See Less']"));
//        seeLess.click();

    }
}
