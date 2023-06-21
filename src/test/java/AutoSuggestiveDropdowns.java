import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AutoSuggestiveDropdowns {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //To select a Checkboxes and check if a checkbox 'isSelected' or not
        //To Assert using testng
        //System.out.println(driver.findElement(By.cssSelector("input[id*='chk_StudentDiscount']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='chk_StudentDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='chk_StudentDiscount']")).click();
        //System.out.println(driver.findElement(By.cssSelector("input[id*='chk_StudentDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='chk_StudentDiscount']")).isSelected());

        //Count the number of checkboxes on the website
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        //autosuggest dropdown
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        //above line gives all the list of elements suggested in the dropdown. the option required can be choose from this list

        for(WebElement option :options)
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }

        //the above for loop iterates through the dropdown list in search for 'India'

    }
}
