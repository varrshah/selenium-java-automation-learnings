import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class calender {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

//1. Give me the count of links on the page.
        //2. Count of footer section-

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");

        //Scroll the page to make the field visible
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)");
        //wait till the page is scrolled
        Thread.sleep(3000);
        driver.findElement(By.name("form_fields[travel_comp_date]")).click();

        while (!driver.findElement(By.cssSelector("span[title='Scroll to increment']")).getText().contains("May"))
        {
            driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
        }

        List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
        //Grab common attribute and put into list and iterate
        int count = driver.findElements(By.className("flatpickr-day")).size();

        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
            if (text.equalsIgnoreCase("21")) {
                driver.findElements(By.className("flatpickr-day")).get(i).click();
                break;
            }
        }
    }
}
