package intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends BaseTest{

    @Test
    public void testAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(3000);
    }

    @Test
    public void explicitWaitAndAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertBtn5 = driver.findElement(By.id("timerAlertButton"));
        alertBtn5.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void confirmBtn(){
        driver.get("https://demoqa.com/alerts");
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        Helper.pause(3000);
        Alert alert = driver.switchTo().alert();
//        alert.accept();
        alert.dismiss();
        WebElement confirmDismissText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(confirmDismissText.getText(), "You selected Cancel");
        Helper.pause(3000);

//        WebElement prompt = driver.findElement(By.id("promptButton"));
//        prompt.click();
    }

    @Test
    public void promptBtn(){
//        driver.get("https://demoqa.com/alerts");
//        WebElement confirmButton = driver.findElement(By.id("promtButton"));
//        confirmButton.click();
//        Helper.pause(3000);
//        Alert alert = driver.switchTo().alert();
////        alert.accept();
////        alert.dismiss();
//        WebElement promptText = driver.findElement(By.id("confirmResult"));
//        Assert.assertEquals(confirmDismissText.getText(), "You selected Cancel");
//        Helper.pause(3000);
//
////        WebElement prompt = driver.findElement(By.id("promptButton"));
////        prompt.click();
    }



}
