package browserHelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest2 {
    WebDriver driver;
    BrowserHelper browserHelper;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup(); /// Configure chromedriver to connect browser
        driver = new ChromeDriver();    // WebDriver is interface , ChromeDriver - child. Creating instance of Chromedriver
        driver.manage().window().maximize();   //maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //driver will wait 20 seconds
        browserHelper = new BrowserHelper(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
