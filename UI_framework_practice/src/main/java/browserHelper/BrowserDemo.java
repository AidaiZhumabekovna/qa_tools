package browserHelper;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserDemo extends BaseTest2 {

    @Test
    public void test1(){
       browserHelper.openUrl("https://demoqa.com/browser-windows");
        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();
        Helper.pause(3000);
        browserHelper.switchToWindow(1);
        Helper.pause(3000);
        browserHelper.switchToParentWindow();
        Helper.pause(3000);

    }
}
