import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;
import java.net.URLConnection;

public class BrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Step1 is to get all URLs tied up to the links using Selenium
        //Java methods will call URLs and gets you the status code
        //if status code is >400 then the URL is not working->link is broken
        //stores the url of the link to be tested
        //String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
        //String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resCode = conn.getResponseCode();
            //below line prints the response codes of all the links
            //System.out.println(resCode);
            if(resCode>400)
            {
                System.out.println("The link with text "+link.getText()+" is broken with code "+resCode);
                Assert.assertTrue(false);
            }
            //the if loop stops when a broken link is found and does not scan the other remaining links
            //hence we use softassert to solve this problem
            //the above if statement can be simplified and written as below using softassert
            //a.assertTrue(resCode<400, "The link with text " + link.getText() + " is broken with code " + resCode);

        }
    }
}
