package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsDemo extends BaseTest {

//    @Test
//    public  void testRadioButton() throws InterruptedException {
//        driver.get("https://demoqa.com/radio-button");
//        WebElement radioButton = driver.findElement(By.xpath("//*[@class='custom-control-label'][1]"));
//        radioButton.click();
//        Thread.sleep(3000);
//        Assert.assertTrue( radioButton.isEnabled());
//    }

    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://demoqa.com/checkbox");
        WebElement checkBox = driver.findElement(By.xpath("//*[@class='rct-text']/button"));
        checkBox.click();
        Helper.pause(3000);
        WebElement desctopChecBox = driver.findElement(By.xpath("(//*[@class='rct-text'])[2]/button"));
        desctopChecBox.click();
        Helper.pause(3000);

        WebElement commandsCheckBox = driver.findElement(By.xpath("//*[@id='tree-node-commands']/parent::label"));
        commandsCheckBox.click();

        Assert.assertTrue(commandsCheckBox.isEnabled());
    }

    @Test
    public void testRightClick() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);
        WebElement doubleClickButton = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
        actions.doubleClick(doubleClickButton).perform();
        Helper.pause(3000);
        String exp = "You have done a double click";
        String doubleClickText = driver.findElement(By.id("doubleClickMessage")).getText();
//        Assert.assertTrue(doubleText.isDisplayed());
        Assert.assertEquals(exp,doubleClickText);
        Helper.pause(3000);

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClick).perform();
    }

    @Test
    public void clickMe() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();
        WebElement messClickMe = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(clickMeButton.isDisplayed());
    }
}
