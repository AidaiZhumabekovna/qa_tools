package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.target.model.SessionID;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumException extends BaseTest{

    @Test
    public void NoSuchElementException(){
        browserHelper.openUrl("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("hello");
    }

    @Test
    public void noSuchWindowException(){
        browserHelper.openUrl("https://demoqa.com/text-box");
        driver.switchTo().window("Hello");
    }

    @Test
    public void noSuchFrameException(){
        browserHelper.openUrl("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noAlertPresentException(){
        browserHelper.openUrl("https://demoqa.com/alerts");
//        WebElement alertButton = driver.findElement(By.id("alertButton"));
//        alertButton.click();
        alertHelper.acceptAlert();
    }

    @Test
    public void invalidSelectorException(){
       //when we make a syntax error
        browserHelper.openUrl("https://demoqa.com/alerts");
        driver.findElement(By.xpath("//button[@@type='button']"));
//        driver.findElement(By.xpath("@user"));


        // to get session id
//        SessionId s = ((RemoteWebDriver) driver).getSessionId();
//        System.out.println("session id is: " + s);
    }

    @Test
    public void noSuchSessionException(){
      //  It's very clear , In your afterScenario() Mehtod you calling quit but when the second scenario runs it doesnt find any intialized driver . You need to intialize your driver everytime inside your voidBefore()
      //  so call that getWebDriver() inside your voidBefore() .
        driver.quit();
        browserHelper.openUrl("https://demoqa.com/text-box");
    }

    @Test
    public void staleElementReferenceException(){
        // Исключение означает, что элемент, который ранее присутствовал, больше не существует на странице.
        //Когда мы можем ожидать StaleElementReferenceException?
        //Ссылочный элемент больше не привязан к DOM.
        //Ссылочный элемент был удален навсегда.

        //Как избежать исключения StaleElementReferenceException?

        // Решение 1. Обновите веб-страницу
        // driver.navigate().refresh();
        // driver.findElement(By.cssSelector("web element locator")).click();

        //Решение 2. Используйте явное ожидание
        //wait.until(ExpectedConditions.presenceOfElementLocated("web element locator"));
        ////Applying explicit wait to the desired web element which would ignore stale element reference exception
        //		//and wait until the web element is ready to be clickable
        //		new WebDriverWait(driver, Duration.ofSeconds(10))
        //		.ignoring(StaleElementReferenceException.class)
        //		.until(ExpectedConditions.elementToBeClickable(By.xpath("element locator")));
        //		driver.findElement(By.xpath("element locator")).click();

        //https://www.toolsqa.com/selenium-webdriver/what-is-stale-element
        browserHelper.openUrl("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
                break;  // if we take away break than we get staleElementReferenceException exception
            }
        }

    }

    @Test
    public void timeOutException(){
        //В Selenium исключение TimeOut возникает, когда команда занимает больше времени, чем время ожидания
        browserHelper.openUrl("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();

    }

























//    @Test
//    public void noSuchElementExceptionTest(){
//        // NoSuchElementException:
//
//        browserHelper.openUrl("https://demoqa.com/text-box");
//        driver.findElement(By.xpath("userName")).sendKeys("Hello World");
//    }
//
//    @Test
//    public void noSuchWindowExceptionTest(){
//        // NoSuchWindowException
//        browserHelper.openUrl("https://demoqa.com/text-box");
//        driver.switchTo().window("Hello");
//    }
//
//    @Test
//    public void noSuchFrameExceptionTest(){
//        // NoSuchFrameException
//        browserHelper.openUrl("https://demoqa.com/text-box");
//        driver.switchTo().frame(123);
//    }
//
//    @Test
//    public void noSuchAlertExceptionTest(){
//        // NoSuchAlertException
//        browserHelper.openUrl("https://demoqa.com/text-box");
//        alertHelper.acceptAlert();
//    }
//
//    @Test
//    public void noSuchSessionException(){
//        driver.quit();
//    }

}
