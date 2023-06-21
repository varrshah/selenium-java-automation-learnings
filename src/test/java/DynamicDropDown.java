import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropDown {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //  //a[@value='MAA']  - Xpath for Chennai
        //  //a[@value='BLR']  - Xpath for Bengaluru

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
       Thread.sleep(2000);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        // //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']
        //above is the parent-child xpath instead of using the 2nd index for Chennai i.e.[2]

        //select date of travel
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        //isEnabled method doesn't work as the return date button is clickable even if it's not highlighted
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("is enabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }



    }
}
