package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseTest{
    @Test
    public void testExplicitWait(){
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(enableAfter)).click();
                wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),"class","text-danger"));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter"))).click();

//                WebElement visible = driver.findElement(By.id("visibleAfter"));
//                visible.click();
        Helper.pause(4000);
    }
}
