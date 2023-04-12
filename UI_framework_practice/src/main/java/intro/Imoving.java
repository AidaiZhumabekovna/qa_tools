package intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Imoving extends BaseTest {

    @Test
    public void fullTesting(){
        driver.get("https://www.imoving.com/");
        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);

        Actions actions = new Actions(driver);

        WebElement moveSizeButton = driver.findElement(By.xpath("//span[text()='Move Size']/parent::button"));
        moveSizeButton.click();
        WebElement justAfewItems = driver.findElement(By.xpath("//span[text()='Just a few Items']"));
        justAfewItems.click();

        WebElement compareQuotesButton = driver.findElement(By.xpath("//button[text()='Compare Quotes']"));
        compareQuotesButton.click();
        Helper.pause(6000);

        WebElement continueButton = driver.findElement(By.xpath("//span[contains(.,'Continue')]/parent::a"));
        continueButton.click();

        driver.findElement(By.xpath("//a[text()='GOT IT']")).click();

//        Helper.pause(5000);


        WebElement okBtn = driver.findElement(By.xpath("(//a[contains(.,'Ok!')])[1]"));
        okBtn.click();
        Helper.pause(6000);

        List<WebElement> allItems = driver.findElements(By.xpath("//div[@class='items-list items-view clearfix fgf']"));

        //DRESSER
        WebElement dresser = driver.findElement(By.xpath("(//div[@class='item'])[1]"));
        String dr = dresser.getText();

        //
        WebElement nightStand = driver.findElement(By.xpath("(//img[@title='Night Stand'])[1]"));
        String nS = dresser.getText();

        for (WebElement items: allItems){
            String i = items.getText();
            if (i.contains(dr) && i.contains(nS)){
                actions.moveToElement(dresser).perform();
                driver.findElement(By.xpath("(//div[@class='quantity-buttons'])[1]/a")).click();
                Helper.pause(6000);
                actions.moveToElement(nightStand).perform();
                driver.findElement(By.xpath("(//*[contains(text(),'Add to Inventory')])[9]")).click();
                Helper.pause(3000);
            }
            System.out.println(items.getText());
        }

       driver.findElement(By.xpath("(//div[@class='arrowOpenRightNavigation leftArrowNavi'])[2]")).click();
       driver.findElement(By.xpath("(//span[@class='roomPanelIcon quantity-plus1'])[1]")).click();
       WebElement expItems = driver.findElement(By.xpath("(//span[@class='room-counter withItems'])[1]"));
       WebElement actItems = driver.findElement(By.xpath("(//span[@class='room-counter'])[1]"));
       Assert.assertEquals(actItems.getText(),expItems.getText());

       driver.findElement(By.xpath("//*[@class='saveButton btn btn-blue']")).click();
       driver.findElement(By.xpath("(//*[@class='quantity-plus'])[1]")).click();
       driver.findElement(By.xpath("(//*[@class='quantity-plus'])[2]")).click();
       driver.findElement(By.xpath("(//*[@class='quantity-plus'])[3]")).click();
       driver.findElement(By.xpath("//*[text()='Add and Continue']")).click();


       //PICK UP FORM
       Helper.pause(3000);
       WebElement pickUpForm = driver.findElement(By.xpath("(//div[@class='address-selection firstTime ng-pristine ng-invalid ng-invalid-required'])[1]"));
       pickUpForm.click();
       WebElement enterZip = driver.findElement(By.xpath("(//input[@placeholder='Enter Zip Code or Full Address'])[1]"));
       enterZip.sendKeys("Chicago");
        Helper.pause(2000);
        enterZip.sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("((//div[@class='pickup-point'])[1]//button[text()='Approve'])[1]")).click();
        Helper.pause(5000);

        //DROP OFF AT
        WebElement dropOffAt = driver.findElement(By.xpath("(//*[@name='googleAddress'])[2]"));
        dropOffAt.click();
        WebElement enterZip2 = driver.findElement(By.xpath("(//input[@placeholder='Enter Zip Code or Full Address'])[2]"));
        enterZip2.sendKeys("Los");
        Helper.pause(2000);
        enterZip2.sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("((//div[@class='pickup-point'])[2]//button[text()='Approve'])[1]")).click();
        Helper.pause(5000);

        //CHOOSE MOVERS BUTTON
        driver.findElement(By.xpath("//button[text()='Confirm']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath("//button[contains(.,'Choose Movers')]")).click();
        Helper.pause(6000);

//        BOOK APART
        driver.findElement(By.xpath("(//button[text()='Book Now'])[4]")).click();
        Helper.pause(5000);

        //checkbox
        driver.findElement(By.xpath("//label[contains(.,'I have read and agreed to the ')]/preceding-sibling::input")).click();
        //CONTINUE TO PAYMENT
        driver.findElement(By.xpath("//button[contains(.,'Continue to payment')]")).click();

        //next button
        driver.findElement(By.xpath("//*[text()='Next']")).click();



        Faker faker = new Faker();
        String fName = faker.name().name();
        String lName = faker.name().lastName();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String secondaryPhone = faker.dog().age();
        String email = faker.internet().emailAddress();
        String cardNumber = faker.finance().creditCard();
        //firstname
        driver.findElement(By.xpath("//*[@placeholder='Enter Your First Name']")).sendKeys(fName);
        driver.findElement(By.xpath("//*[@placeholder='Enter Your Last Name']")).sendKeys(lName);
        driver.findElement(By.xpath("//*[@placeholder='Enter your Phone']")).sendKeys(phoneNumber);
        driver.findElement(By.xpath("//*[@placeholder='Enter your Secondary Phone']")).sendKeys(secondaryPhone);
        driver.findElement(By.xpath("//*[@placeholder='Enter Your Email']")).sendKeys(email);
        driver.findElement(By.xpath("(//*[@placeholder='Enter Card Number'])[1]")).sendKeys(cardNumber);
        driver.findElement(By.xpath("//input[@class='confirmBillingAddress  false']")).click();





    }
}
