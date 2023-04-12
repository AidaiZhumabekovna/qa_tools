package browserHelper;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    private WebDriver driver;
    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String URL){
        driver.navigate().to(URL);
    }

    public   void back(){
        driver.navigate().back();
    }

    public void goForward(){
        driver.navigate().forward();
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public Set<String> getWindowHandles(){  // method of driver
      return driver.getWindowHandles();
    }

    public void switchToWindow(int index){
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
        if (index < 0 || index > windowsId.size()){
          throw new IllegalArgumentException("invalid " + index);
        }
        driver.switchTo().window(windowsId.get(index));
    }

    public void switchToParentWindow(){
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
        driver.switchTo().window(windowsId.get(0));
    }

}
