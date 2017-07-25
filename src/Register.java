import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sravg on 4/22/2017.
 */
public class Register {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.15.0-win64//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.groupon.com/");
        //driver.switchTo().frame("boomr-frame");
        //driver.switchTo().frame(0);
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[@id='nothx']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@id='ls-user-signup']")).click();

        WebDriverWait d = new WebDriverWait(driver, 20);
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='full-name-input']")));

        Thread.sleep(4000);
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
        Thread.sleep(4000);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@for='full-name-input']")).sendKeys("sai1");
        driver.findElement(By.xpath("//*[@for='email-input']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@for='password-input']")).sendKeys("test@123");
        driver.findElement(By.xpath("//*[@for='password-confirmation-input']")).sendKeys("test@123");
        driver.findElement(By.xpath("//label[@for='terms-checkbox']")).click();
        driver.findElement(By.xpath("//input[@class='btn-cta btn-large signup-btn']")).click();


    }






}
