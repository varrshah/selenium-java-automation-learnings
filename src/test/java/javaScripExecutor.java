import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class javaScripExecutor {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Scroll the page to make the table visible
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        //wait till the table becomes visible
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement>values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for (int i=0;i<values.size();i++)
        {
            //add all the numbers in the amount column
            sum = sum + Integer.parseInt(values.get(i).getText());

        }
        System.out.println(sum);
        //get the text written below the table
        driver.findElement(By.cssSelector(".totalAmount")).getText();
        //Extract the total amount written
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        //compare the added value and the value that is displayed
        Assert.assertEquals(sum,total);

        List<WebElement>price = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
        int sum1=0;
        for(int i=0;i<price.size();i++)
        {
            sum1 = sum1 + Integer.parseInt(price.get(i).getText());
        }
        System.out.println(sum1);
    }
}
