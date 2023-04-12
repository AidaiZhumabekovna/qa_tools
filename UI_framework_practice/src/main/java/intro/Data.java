package intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Data {
        WebDriver driver;

        @BeforeClass
        public void setup() {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/text-box");

        }

        @Test
        public void textBoxTest() throws InterruptedException {

            Faker faker = new Faker();

            String name = faker.name().fullName(); // Yrysbek
//            System.out.println(name);


            WebElement fullNameInput = driver.findElement(By.id("userName"));
//            System.out.println(fullNameInput);

            fullNameInput.sendKeys(name);

            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            String actualNameElement = driver.findElement(By.id("name")).getText();
            System.out.println("actualNameElement"+actualNameElement);

//            String actualNameText = actualNameElement.getText(); // Name:Yrysbek
//            System.out.println("actualNameText" +actualNameText);

            Assert.assertEquals(actualNameElement, "Name:" + name); //Name:Yrysbek - Name:Yrysbek
            Assert.assertTrue(actualNameElement.contains(name));

        }

        @AfterClass
        public void close() {
            driver.close();
            driver.quit();
        }

    }
