package intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

    private WebDriver driver;
    private Alert alert;

    public void acceptAlert(){
        alert = driver.switchTo().alert();
        alert.accept();
    }


    public void dismissAlert(){
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void promptAlert(String str){
        alert = driver.switchTo().alert();
        alert.sendKeys(str);
        alert.accept();
    }

}
