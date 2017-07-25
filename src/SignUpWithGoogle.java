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
public class SignUpWithGoogle {

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


        driver.findElement(By.xpath("//span[@class='icon-google-plus']")).click();      // clicking on signup using google button.

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

//        boolean flag= driver.findElement(By.xpath("//input[@id='email']")).isEnabled();
//        System.out.println(flag);

//        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("gudumbashankar287@gmail.com");
//        driver.findElement(By.xpath("//input[@id='next']")).click();

        ((JavascriptExecutor)driver).executeScript("document.getElementById('Email').setAttribute('value', 'gudumbashankar287@gmail.com')");
        driver.findElement(By.xpath("//input[@id='next']")).click();
        //((JavascriptExecutor)driver).executeScript("document.getElementById('Passwd').setAttribute('value', 'gudumba@287')");

        Thread.sleep(4000);
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Passwd']")));

        ((JavascriptExecutor)driver).executeScript("document.getElementById('Passwd').setAttribute('value', 'gudumba@287')");

//        driver.findElement(By.xpath("//input[@name='login']")).click();
//        driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("gudumba@287");
        driver.findElement(By.xpath("//input[@id='signIn']")).click();


//        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submit_approve_access']")));
//
//        String c = driver.getWindowHandle();
//        System.out.println(c);
//        System.out.println(driver.getTitle());
//
//        driver.switchTo().window(c);
//        driver.findElement(By.xpath("//button[@id='submit_approve_access']")).click();
//
//
//        String c2 = driver.getWindowHandle();
//        System.out.println(c2);
//        System.out.println(driver.getTitle());



        driver.switchTo().window(parentID);
        Thread.sleep(4000);
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-arrow-down-large']")));

        Actions a = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[@class='icon-arrow-down-large']"));
        a.moveToElement(element).build().perform();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-arrow-down-large']")));
        WebElement element2 = driver.findElement(By.xpath("//a[@id='sign-out']"));
        a.moveToElement(element2).click().build().perform();


        driver.close();


    }
}
