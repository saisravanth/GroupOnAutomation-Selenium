import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by sravg on 4/24/2017.
 */
public class Cart {

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




       // boolean email = driver.findElement(By.xpath("//input[@id='Email']")).isDisplayed();
//
//        if(email){
//            ((JavascriptExecutor)driver).executeScript("document.getElementById('Email').setAttribute('value', 'gudumbashankar287@gmail.com')");
//            driver.findElement(By.xpath("//input[@id='next']")).click();
//        }
//        //((JavascriptExecutor)driver).executeScript("document.getElementById('Passwd').setAttribute('value', 'gudumba@287')");
//
//        Thread.sleep(4000);
//        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Passwd']")));
//        boolean password = driver.findElement(By.xpath("//input[@id='Passwd']")).isDisplayed();
//        if(password){
//            ((JavascriptExecutor)driver).executeScript("document.getElementById('Passwd').setAttribute('value', 'gudumba@287')");
//            driver.findElement(By.xpath("//input[@id='signIn']")).click();
//        }

        boolean email2 = driver.findElement(By.xpath("//input[@id='identifierId']")).isDisplayed();
        if(email2){
            //driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("gudumbashankar287@gmail.com");
            ((JavascriptExecutor)driver).executeScript("document.getElementById('identifierId').setAttribute('value', 'gudumbashankar287@gmail.com')");
            driver.findElement(By.xpath("//content[@class='CwaK9']")).click();
        }

        Thread.sleep(4000);
        boolean password2 = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).isDisplayed();
        if(password2){
            System.out.println(password2);
           // ((JavascriptExecutor)driver).executeScript("document.getElementsByName('Password').setAttribute('value', 'gudumba@287')");
            ((JavascriptExecutor)driver).executeScript("document.getElementsByName('password')[0].value='gudumba@287'");
            driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
        }


//        driver.findElement(By.xpath("//input[@name='login']")).click();
//        driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("gudumba@287");
      //  driver.findElement(By.xpath("//input[@id='signIn']")).click();


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

        add1ItemToCartAndIncreaing(driver, d);
        addAnotherToCart(driver, d);
        clickOnAnItemInsideCartAndEmpty(driver,d);




        driver.close();

//
    }



    public static void add1ItemToCartAndIncreaing(WebDriver driver, WebDriverWait d ) throws InterruptedException {


        System.out.println("Starting add1ItemToCart method");

        // clicking on Electronics section.
        Thread.sleep(5000);
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='//img.grouponcdn.com/sparta/GPLEtS8n6nsdd12hoscNixTdJ87/GP-96x96/v1/c64x64.png']")));
        driver.findElement(By.xpath("//img[@src='//img.grouponcdn.com/sparta/GPLEtS8n6nsdd12hoscNixTdJ87/GP-96x96/v1/c64x64.png']")).click();
        //driver.findElement(By.xpath("//img[@alt='image for Electronics']")).click();


        //clicking on Cell phones and accessories(hard coding the location)
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/section[2]/div/section/div/div[3]/div[3]/div[1]/div/div[3]/div/ul/li[2]/ul/li[1]/span/span/label/a")));
        driver.findElement(By.xpath("html/body/div[1]/div[2]/section[2]/div/section/div/div[3]/div[3]/div[1]/div/div[3]/div/ul/li[2]/ul/li[1]/span/span/label/a")).click();

        //clicking on cable, charger and adapters sections.
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/goods/cables-chargers-and-adapters']")));
        driver.findElement(By.xpath("//a[@href='/goods/cables-chargers-and-adapters']")).click();

        // adding filter iphone 6
        driver.findElement(By.xpath("//label[@for='ref-ui-checkbox-166a0509-927a-4912-966f-e72dd4a16553']")).click();

        Thread.sleep(7000);


        List<WebElement> pageItems = driver.findElements(By.xpath("//div[@style='overflow-wrap: break-word;']"));
        System.out.println(pageItems);
        WebElement oneElement = pageItems.get(0);
        oneElement.click();


        Thread.sleep(7000);
        // clicking on Buy button to add 1 item to cart.
        driver.findElement(By.xpath("//a[@id='buy-link']")).click();
        // clicking on GroupOn to go back.
        Thread.sleep(7000);
        driver.findElement(By.xpath("//img[@src='//www2.grouponcdn.com/layout/assets/grpn_logo_white-b8a7246dbd.svg']")).click();

        // clicking on cart button to modify the cart items in next step.
        Thread.sleep(7000);
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='variation-trait']")));
        driver.findElement(By.xpath("//a[@href='/cart']")).click();

        // Increasing count of items in cart.
        Thread.sleep(7000);
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='variation-trait']")));
        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@aria-label='quantity']")));
        dropdown2.selectByIndex(1);   //starts from 0.


        // clicking on GroupOn to go back.
        Thread.sleep(7000);
        driver.findElement(By.xpath("//img[@src='//www2.grouponcdn.com/layout/assets/grpn_logo_white-b8a7246dbd.svg']")).click();

    }

    public static void addAnotherToCart(WebDriver driver, WebDriverWait d) throws InterruptedException {

        System.out.println("Starting addAnotherToCart method");
        // clicking on Electronics section.
        Thread.sleep(5000);
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='//img.grouponcdn.com/sparta/GPLEtS8n6nsdd12hoscNixTdJ87/GP-96x96/v1/c64x64.png']")));
        driver.findElement(By.xpath("//img[@src='//img.grouponcdn.com/sparta/GPLEtS8n6nsdd12hoscNixTdJ87/GP-96x96/v1/c64x64.png']")).click();
        //driver.findElement(By.xpath("//img[@alt='image for Electronics']")).click();


        //clicking on Cell phones and accessories(hard coding the location)
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/section[2]/div/section/div/div[3]/div[3]/div[1]/div/div[3]/div/ul/li[2]/ul/li[1]/span/span/label/a")));
        driver.findElement(By.xpath("html/body/div[1]/div[2]/section[2]/div/section/div/div[3]/div[3]/div[1]/div/div[3]/div/ul/li[2]/ul/li[1]/span/span/label/a")).click();

        //clicking on cable, charger and adapters sections.
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/goods/cables-chargers-and-adapters']")));
        driver.findElement(By.xpath("//a[@href='/goods/cables-chargers-and-adapters']")).click();

        // Clicking on 3rd Element in the list
        Thread.sleep(7000);
        List<WebElement> pageItems = driver.findElements(By.xpath("//div[@style='overflow-wrap: break-word;']"));
        System.out.println(pageItems);
        WebElement oneElement = pageItems.get(2);
        oneElement.click();

        Thread.sleep(7000);
        // clicking on Buy button to add 1 item to cart.
        driver.findElement(By.xpath("//a[@id='buy-link']")).click();
        // clicking on GroupOn to go back.
        Thread.sleep(7000);
        driver.findElement(By.xpath("//img[@src='//www2.grouponcdn.com/layout/assets/grpn_logo_white-b8a7246dbd.svg']")).click();

    }

    public static void clickOnAnItemInsideCartAndEmpty(WebDriver driver, WebDriverWait d) throws InterruptedException {

        System.out.println("Starting clickOnAnItemInsideCart method");

        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@href='/cart']")).click();

        Thread.sleep(7000);

        // Getting list of items in cart to navigate to details page of first cart item.
        List<WebElement> pageItems = driver.findElements(By.xpath("//a[@data-bhw='CartDealTitle']"));
        System.out.println(pageItems);
        WebElement oneElement = pageItems.get(0);
        oneElement.click();

        Thread.sleep(7000);
        driver.findElement(By.xpath("//a[@href='/cart']")).click();

        // Getting list of items in cart and remove items 1 by 1 to empty cart completely.
        Thread.sleep(7000);
        List<WebElement> removeList = driver.findElements(By.xpath("//a[@class='remove']"));
        System.out.println(removeList);
        Thread.sleep(3000);
        WebElement removeElement1 = removeList.get(0);
        Thread.sleep(3000);
        removeElement1.click();

        Thread.sleep(7000);
        List<WebElement> removeList2 = driver.findElements(By.xpath("//a[@class='remove']"));
        System.out.println(removeList2);
        Thread.sleep(3000);
        WebElement removeElement2 = removeList2.get(0);
        Thread.sleep(3000);
        removeElement2.click();


        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@data-bhw='EmptyContinue']")).click();

        Thread.sleep(4000);

        Actions a = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[@class='icon-arrow-down-large']"));
        a.moveToElement(element).build().perform();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-arrow-down-large']")));
        WebElement element2 = driver.findElement(By.xpath("//a[@id='sign-out']"));
        a.moveToElement(element2).click().build().perform();


    }

}
