package intro;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Etsy extends BaseTest {

    @Test
    public void signIn(){
        driver.get("https://www.etsy.com/");
        WebElement signin = driver.findElement(By.xpath("//button[contains(.,' Sign in')]"));
        signin.click();

        Helper.pause(6000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,' Sign in')]")));
//        wait.until(ExpectedConditions.)
    }
}
