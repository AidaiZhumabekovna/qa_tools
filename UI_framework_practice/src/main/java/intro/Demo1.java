package intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Demo1 {

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String current = faker.address().city();
    String perAddress = faker.address().country();

    @Test
    public void testDemo1() throws InterruptedException {
            WebDriverManager.chromedriver().setup(); /// Configure chromedriver to connect browser
            WebDriver driver = new ChromeDriver();    // WebDriver is interface , ChromeDriver - child. Creating instance of Chromedriver
            driver.manage().window().maximize();   //maximizing window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //driver will wait 20 seconds
            driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys(name);

        WebElement userEmail= driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(email);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(current);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(perAddress);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String n2 = driver.findElement(By.xpath("//*[@id='name']")).getText();
        String e2 = driver.findElement(By.xpath("//*[@id='email']")).getText();
        String a2 = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String p2 = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();

        Assert.assertEquals("Name:"+name, n2);
        Assert.assertEquals("Email:"+email,e2);
        Assert.assertEquals("Current Address :"+current,a2);
        Assert.assertEquals("Permananet Address :"+perAddress,p2);


//        System.out.println(n2);
//        System.out.println(e2);
//        System.out.println(a2);
//        System.out.println(p2);


        Thread.sleep(5000);
//        driver.close();
//        driver.quit();
    }
}
