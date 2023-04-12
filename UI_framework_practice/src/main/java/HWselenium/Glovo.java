package HWselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.time.Duration;

public class Glovo {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://glovoapp.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void test(){
        WebElement getStartedButton = driver.findElement(By.xpath("(//button[contains(.,'started')])[2]"));
        getStartedButton.click();

        WebElement firstName = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[2]"));
        firstName.sendKeys("Aidai");

        WebElement email = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[3]"));
        email.sendKeys("aidaiKurmanbekova54@gmail.com");

        WebElement password = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[4]"));
        password.sendKeys("aidaiKurmanbekova6565");

        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(.,'Sign up')]"));
        signUpButton.click();

        WebElement street = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[2]"));
        street.sendKeys("Rus");

//      Actions action = new Actions(driver);
//      action.sendKeys("London").keyDown(Keys.RETURN).perform();
//        System.out.println(action);
    }

}
