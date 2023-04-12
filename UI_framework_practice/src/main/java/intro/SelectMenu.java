package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelectMenu extends BaseTest{
    @Test
    public void select(){
        driver.get("https://demoqa.com/select-menu");
        WebElement groupAndOption = driver.findElement(By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[1]"));
        groupAndOption.click();
        Helper.pause(2000);

        WebElement test = driver.findElement(By.xpath("//div[@id='withOptGroup']/div/div/div[contains(.,'Group 1, option 1')]"));
        test.click();

        WebElement selectOne = driver.findElement(By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[2]"));
        selectOne.click();
        Helper.pause(2000);

//        driver.findElement(By.xpath("//div[@id='selectOne']//input")).click();
//        Helper.pause(2000);

        //div[@id='selectOne']/div/div/div
    }
}
