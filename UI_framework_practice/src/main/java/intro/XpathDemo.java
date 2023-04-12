package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo {

    //By id
    //name
    //className
    //partialLinkTex
    //linkText
    //tagName
    //xpath
    //cssSelector
    // we start from root and move by tag

    WebDriver driver;   //interface
    //WebElement  interface
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup(); /// Configure chromedriver to connect browser
        driver = new ChromeDriver();    // WebDriver is interface , ChromeDriver - child. Creating instance of Chromedriver
        driver.manage().window().maximize();   //maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //driver will wait 20 seconds
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @AfterClass
    public void tearDown(){
//        driver.close();
//        driver.quit();
    }

    @Test
    public void xpathTest(){
        WebElement firstName = driver.findElement(By.xpath("//label[@id = 'userName-label']"));
        String expectedEmail = "Name";
        Assert.assertEquals(firstName.getText(), expectedEmail);

        WebElement nameText =driver.findElement(By.xpath("//label[@id = 'userName-label']"));
        Assert.assertTrue(expectedEmail.contains(nameText.getText()));
    }

    @Test
    public void xpath2(){
        WebElement inputFieldName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        inputFieldName.sendKeys("Aidai");
        Assert.assertEquals(inputFieldName.getAttribute("value"), "Aidai");

    }
}
