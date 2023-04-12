package intro.screenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Utils {

    // Это исключение вызывается веб-драйвером селена,
    // когда селену не удается сделать снимок экрана или захватить текущий экран.

    //Решения
    //Проверьте сбои процесса Java
    //Выделить больше памяти для Selenium при инициализации сетки
    //Обновите страницу перед тем, как сделать снимок экрана.

    public static void CaptureScreenshot(WebDriver driver, String fileName) throws IOException {
        TakesScreenshot sc = (TakesScreenshot) driver;
        File file = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/java/ScreenShot/" + fileName + ""));  //dependency Apache Commons IO » 2.11.0

        // FileUtils.copyFile(file, new File("src/main/java/ScreenShot" + fileName + ""));  //++++
        ////+++it doesn't save into the ScreenShot package, /

        // String fileName1 = "";   // ++++++++
        // FileUtils.copyFile(file, new File("src/main/java/ScreenShot" + fileName1 + ""));

        //File saveInProject = new File("src/main/java/ScreenShot");  //+++++++
        // FileUtils.copyFile( saveInProject, file );
        // FileUtils.copyFile(file, saveInProject );
    }

    public static void CaptureWebElementScreenshot(WebElement el, String fileName) throws IOException {
        File fileForWebEl = el.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fileForWebEl, new File("src/main/java/ScreenShot" + fileName + ""));
    }
}
