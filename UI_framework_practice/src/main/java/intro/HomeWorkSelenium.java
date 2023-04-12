package intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import java.time.Duration;

public class HomeWorkSelenium {

    WebDriver driver = new ChromeDriver();
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String current = faker.address().city();
    String perAddress = faker.address().country();

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void fullAllFields() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");

//        SoftAssert softassert = new SoftAssert();
//        Data datas = new Data();
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


        String e2 = driver.findElement(By.xpath("//*[@id='email']")).getText();
        String a2 = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String p2 = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();



//
//        Assert.assertEquals(expectedEmail,e2);
//        Assert.assertEquals(expectedAddress,a2);
//        Assert.assertEquals(expectedPermanent,p2);

//        Thread.sleep(5000);
    }

    @Test
    public void checkName(){
        String expectedName = "Aidai";
        String n2 = driver.findElement(By.xpath("//*[@id='name']")).getText();
        Assert.assertEquals( expectedName, n2);
    }

//
//    @Test
//    public void checkEmail(String expectedEmail, String e2){
//        Assert.assertEquals(expectedEmail, e2);
//    }
//
//
//    @Test
//    public void checkAddress(String expectedAddress, String a2){
//        Assert.assertEquals(expectedAddress, a2);
//    }
//
//
//    @Test
//    public void checkPer(String expectedPermanent, String p2){
//        Assert.assertEquals(expectedPermanent, p2);
//    }
//
//    @AfterClass
//    public void tearDown(){
//        driver.close();
//    }


}
