package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WebTables<T> extends BaseTest {

//    Faker faker = new Faker();
//    String fName = faker.name().name();
//    String lName = faker.name().lastName();
//    String email = faker.internet().emailAddress();
//    int age = faker.number().randomDigit();
//    int salary = faker.number().randomDigit();
//    String department = faker.address().firstName();
//    @Test
//    public void checkData(){
//
//        driver.get("https://demoqa.com/webtables");
//        driver.findElement(By.id("addNewRecordButton")).click();
//        driver.findElement(By.id("firstName")).sendKeys(fName);
//        driver.findElement(By.id("lastName")).sendKeys(lName);
//        driver.findElement(By.id("userEmail")).sendKeys(email);
//        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
//        driver.findElement(By.id("salary")).sendKeys(String.valueOf(salary));
//        driver.findElement(By.id("department")).sendKeys(department);
//        driver.findElement(By.id("submit")).click();
//        Helper.pause(4000);
//
//        List<WebElement> containerOfData = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
//        String first = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[1]")).getText();
//        String second = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[2]")).getText();
//        String third = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[3]")).getText();
//        String four = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[4]")).getText();
//        String five = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[5]")).getText();
//
//        for (WebElement e: containerOfData){
//            String el = e.getText();
//            if (el.contains(first)){
//                System.out.println("true");
//            }else{
//                System.out.println("false");
//            }
//        }
    // }

    @Test
    public void checkData() {
        driver.get("https://demoqa.com/webtables");

        User aidai = new User("Aidai", "Kurmanbekova", "aidai@gmail.com", 24, 3000, "Moscow");

        List<User> data = new ArrayList<>();
        data.add(aidai);

        List<WebElement> containerOfData = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(aidai.name);
        driver.findElement(By.id("lastName")).sendKeys(aidai.lastName);
        driver.findElement(By.id("userEmail")).sendKeys(aidai.email);
        driver.findElement(By.id("age")).sendKeys(String.valueOf(aidai.age));
        driver.findElement(By.id("salary")).sendKeys(String.valueOf(aidai.salary));
        driver.findElement(By.id("department")).sendKeys(aidai.department);
        driver.findElement(By.id("submit")).click();
        Helper.pause(4000);

//        StringBuilder builder = new StringBuilder();
//        for (User u: data){
//            builder.append(u.toString());
//        }
//        String str =  builder.toString();
//
//        for (WebElement e: containerOfData){
//            if (e.getText().contains(str)){
//                System.out.println("true");
//            }else{
//                System.out.println("false");
//            }
//        }


        String userName = driver.findElement(By.xpath("//*[text()='Aidai']")).getText();
        String getAge = driver.findElement(By.xpath("(//div[@class='rt-tr -even'])[2]/div[3]")).getText();

        for (WebElement e : containerOfData) {
            String s = e.getText();
            if (s.contains(aidai.name)) {
                Assert.assertEquals(userName,aidai.name);

            }
            int n = Integer.parseInt(getAge);
            if (n == aidai.age){
                Assert.assertEquals(n, aidai.age);
            }
        }


    }

}
