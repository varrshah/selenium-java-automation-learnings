import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class selStreams {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all the web elements into a list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all web elements into new (original) list
        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort on the original list of step 3 and store in new (sorted) list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //compare original list with sorted list
        Assert.assertTrue(originalList.equals((sortedList)));

        List<String> price;

        // scan the name column with getText ->Beans->print the price of the Rice
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getVeggiePrice(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while(price.size()<1);
            }

            private static String getVeggiePrice(WebElement s)
            {
                String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
                return priceValue;
        }
    }

