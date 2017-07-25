import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by sravg on 4/23/2017.
 */
public class Login {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.15.0-win64//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.groupon.com/");

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[@id='nothx']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@id='ls-user-signin']")).click();

        WebDriverWait d = new WebDriverWait(driver, 60);
        Thread.sleep(7000);
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='email-input']")));

        driver.findElement(By.xpath("//label[@for='email-input']")).sendKeys("sravgates@gmail.com");
        driver.findElement(By.xpath("//label[@for='password-input']")).sendKeys("saisra246");

    //   ((JavascriptExecutor)driver).executeScript("document.getElementById('email').setAttribute('value', 'gudumbashankar287@gmail.com')");
    //    ((JavascriptExecutor)driver).executeScript("document.getElementById('pass').setAttribute('value', 'gudumba@287')");


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='recaptcha widget']")));

        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='recaptcha-checkbox-checkmark']")));

        Thread.sleep(6000);
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']")).click();
        Thread.sleep(6000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.switchTo().defaultContent();
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='signin-button']")));
        Thread.sleep(6000);
        driver.findElement(By.xpath("//input[@id='signin-button']")).click();





        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());


    }
}
