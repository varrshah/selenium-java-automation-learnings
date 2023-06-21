package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelTraining {

    public static void main(String[] args) {

        //Invoking Chrome Browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

       /*
       //Invoking Firefox Browser
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\geckodriver.exe");
        WebDriver driver1 = new FirefoxDriver();

        //Microsoft Edge
        System.setProperty("webdriver.edge.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\msedgedriver.exe");
        WebDriver driver2 = new EdgeDriver();

        */

        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();

    }
}
