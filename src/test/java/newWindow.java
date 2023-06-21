import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class newWindow {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //open new tab or window
        driver.switchTo().newWindow(WindowType.TAB);
        //driver.switchTo().newWindow(WindowType.WINDOW);

        //get the set of window handles opened
        Set<String> handles = driver.getWindowHandles();
        //we need the childtab id so we need to iterate through the set
        Iterator<String> it = handles.iterator();
        String parentWindow =it.next();
        String childWindow = it.next();
        //next need to pass the control from parent window to child window
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        Thread.sleep(3000);

        //scroll down the page using javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)"); //scroll down 1000 pixels

        //get the name of the first course on the page
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                .get(1).getText();
        //switch back to parent window
        driver.switchTo().window(parentWindow);
        //pass the course name to the name  box
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        //screenshot of a web element
        /*File file = name.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File("logo.png"));*/

        //Get the height and width of the element
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());

        //close the window
        driver.quit();


    }
}
