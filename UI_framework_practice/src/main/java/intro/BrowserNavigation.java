package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigation extends BaseTest{

    @Test
    public void test1(){
        driver.navigate().to("https://www.imoving.com/");
        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);

        WebElement moveSizeButton = driver.findElement(By.xpath("//span[text()='Move Size']/parent::button"));
        moveSizeButton.click();
        WebElement justAfewItems = driver.findElement(By.xpath("//span[text()='Just a few Items']"));
        justAfewItems.click();

        WebElement compareQuotesButton = driver.findElement(By.xpath("//button[text()='Compare Quotes']"));
        compareQuotesButton.click();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/full-inventory/#!/");
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/");
        driver.navigate().refresh();
        driver.navigate().forward();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/full-inventory/#!/");

    }
}
