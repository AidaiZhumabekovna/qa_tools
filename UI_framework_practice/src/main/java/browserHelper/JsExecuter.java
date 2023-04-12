package browserHelper;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JsExecuter extends BaseTest2 {

//    @Test
//    public void test1(){
//        browserHelper.openUrl("");
//        WebElement click = driver.findElement(By.xpath(""));
//        Helper.jsClick(driver, click);
//        Helper.pause(10000);
//        Helper.jsScrollDownThePage(driver, "350");
//        Helper.pause(3000);
//        Helper.jsScrollDownThePage(driver, "500");
//
////        Helper.waitForElementToBeDisplayed(driver,);
//    }


    @Test
    public void test(){
        browserHelper.openUrl("https://www.etsy.com/");
        WebElement careersLink = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/careers?ref=ftr']"));
        Helper.jsClick(driver, careersLink);
        Helper.pause(10000);
        Helper.jsScrollDownThePage(driver, "350");
        Helper.pause(3000);
        Helper.jsScrollDownThePage(driver, "500");
    }

}
