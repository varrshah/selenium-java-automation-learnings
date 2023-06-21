import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Shopping {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        int j=0;
        Thread.sleep(3000);
        String[] itemsNeeded={"Cucumber","Brocolli","Beetroot"};

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++)
        {
            //format it to get actual vegetable name
            //Brocolli - 1 kg needs to be split to just Brocolli
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            //convert Array into Array List for easy search
            //check whether name extracted is present in the Array List or not
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if(itemsNeededList.contains(formattedName))
            {
                j++;
                //click on add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j==itemsNeeded.length)
                {
                    break;
                }
            }
        }
    }
}
