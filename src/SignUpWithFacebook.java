import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by sravg on 4/22/2017.
 */
public class SignUpWithFacebook {


    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.15.0-win64//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.groupon.com/");

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@id='nothx']")).click();       // closing the initial popup
        Thread.sleep(6000);
        driver.findElement(By.xpath("//a[@id='ls-user-signup']")).click();      //clicking on SignUp.

        WebDriverWait d = new WebDriverWait(driver, 40);
        Thread.sleep(6000);
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='facebook-login-button']")));      // adding wait clause

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());      // getting parent window title.


        driver.findElement(By.xpath("//button[@class='facebook-login-button']")).click();      // clicking on signup using google button.
        Thread.sleep(6000);
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> it = windowIds.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
        System.out.println(driver.getTitle());      // getting child window title.
        System.out.println(driver.getWindowHandle());

        Thread.sleep(9000);
        // d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));      // adding wait clause

        boolean flag = driver.findElement(By.xpath("//input[@id='email']")).isEnabled();
        System.out.println(flag);

        ((JavascriptExecutor) driver).executeScript("document.getElementById('email').setAttribute('value', 'gudumbashankar287@gmail.com')");
        ((JavascriptExecutor) driver).executeScript("document.getElementById('pass').setAttribute('value', 'gudumba@287')");

//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gudumbashankar287@gmail.com");       // facebook login credentials.
//        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("gudumba@287");
        driver.findElement(By.xpath("//input[@name='login']")).click();


        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        System.out.println(driver.getTitle());      // getting child window title.
        System.out.println(driver.getWindowHandle());

//        Thread.sleep(5000);
//        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='1']")));
//        driver.findElement(By.xpath("//button[@value='1']")).click();
//
//        driver.switchTo().window(parentID);
//
////        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='create_groupon_account_button']")));
////        System.out.println(driver.getTitle());
////        System.out.println(driver.getWindowHandle());
////        driver.findElement(By.xpath("//button[@id='create_groupon_account_button']")).click();
//
//        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-arrow-down-large']")));
//
//        Thread.sleep(5000);
//        Actions a = new Actions(driver);
//        WebElement element = driver.findElement(By.xpath("//span[@class='icon-arrow-down-large']"));
//        a.moveToElement(element).build().perform();
//        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-arrow-down-large']")));
//        Thread.sleep(5000);
//        WebElement element2 = driver.findElement(By.xpath("//a[@id='sign-out']"));
//        Thread.sleep(3000);
//        a.moveToElement(element2).click().build().perform();


        driver.close();

    }
}