import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpAlert {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajayp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String text = "Varrsha";
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click(); //click on Alert button
        System.out.println(driver.switchTo().alert().getText()); //print the text displayed on the pop-up
        driver.switchTo().alert().accept(); //click on OK on the pop-up
        driver.findElement(By.cssSelector("[id='confirmbtn']")).click(); //click on Confirm button
        System.out.println(driver.switchTo().alert().getText()); //print text displayed
        driver.switchTo().alert().dismiss(); //click on cancel on the pop-up
    }
}
