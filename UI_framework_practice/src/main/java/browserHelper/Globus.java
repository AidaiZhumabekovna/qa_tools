package browserHelper;

import browserHelper.BaseTest2;
import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Globus extends BaseTest2 {
    @Test
    public void auto(){
        driver.navigate().to("https://globus-online.kg/");

        //vegetables
        WebElement veg = driver.findElement(By.xpath("//*[@title='Овощи, фрукты, орехи, зелень']"));

        //greenery
        WebElement greenery = driver.findElement(By.xpath("//*[@title='Зелень']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(veg).perform();
        actions.moveToElement(greenery).perform();
        greenery.click();
        Helper.pause(6000);

        //list of greenery btn
        driver.findElement(By.xpath("//*[@title='Список']")).click();

        Helper.pause(3000);
        //plus btn
       WebElement plusBtn =  driver.findElement(By.xpath("(//a[@class='c-quantity__plus js-plus'])[1]"));

        //dill
//        WebElement dill = driver.findElement(By.xpath("//*[text()='Укроп']"));

        //list of greenery
        List<WebElement> listOfGreen = driver.findElements(By.xpath("//*[@id='ajaxpages_gmci']"));

        for (WebElement e: listOfGreen){
            if (e.getText().contains("Укроп")){
                System.out.println("Dill");
                plusBtn.click();
            }
        }

        Helper.pause(5000);

    }
}
