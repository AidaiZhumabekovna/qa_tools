package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ActionsAndSelect extends BaseTest{

    @Test
    public void moveToElement(){
        driver.get("https://www.imoving.com/");
            WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByValue("1080");
        Helper.pause(3000);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);
//        select.selectByIndex(3);
        Helper.pause(3000);
    }

    ///////////// DRESSER
//        WebElement dresser = driver.findElement(By.xpath("(//div[@class='item'])[1]"));
//        actions.moveToElement(dresser).perform();
//        WebElement addToInventorybtn = driver.findElement(By.xpath("(//div[@class='quantity-buttons'])[1]/a"));
//        addToInventorybtn.click();
//        Helper.pause(6000);

    //////////////BED
//        WebElement bed = driver.findElement(By.xpath("(//div[@class='item'])[1]"));
//        actions.moveToElement(bed).perform();
//        Helper.pause(3000);
//        WebElement addToInventorybtn2 = driver.findElement(By.xpath("(//div[@class='quantity-buttons'])[1]"));
//        addToInventorybtn2.click();
//        Helper.pause(3000);


    //////////////TV
//        WebElement tv = driver.findElement(By.xpath("(//div[@class='item'])[1]"));
//        actions.moveToElement(tv).perform();
//        Helper.pause(3000);
//        WebElement add = driver.findElement(By.xpath("(//div[@class='quantity-buttons'])[1]"));
//        add.click();
//        Helper.pause(6000);

}
