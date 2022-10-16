package testamzn;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static dev.failsafe.internal.util.Assert.*;


public class testAmazon {
    public static void main(String[] args) {


        //System.out.println("Hello World");
        System.setProperty("webdriver.chrome.driver", "/home/flora/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys("hats for men");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        searchButton.click();

        WebElement searchHat = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div"));
        searchHat.click();

        Select quantity =new Select(driver.findElement(By.xpath("//*[@id=\"quantity\"]")));
        quantity.selectByIndex(1);


        WebElement addCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        addCartButton.click();

        WebElement cartTotal = driver.findElement(By.id("sw-subtotal"));
        String ActualSubtotal = String.valueOf(cartTotal);
        String ExpectedSubTotal = "25,60";
        assertEquals(ExpectedSubTotal,ActualSubtotal);

        Select changeQuantity =new Select(driver.findElement(By.xpath("//*[@id=\"sc-item-4a3bbd97-a47a-426f-8e2e-31fbc133552f\"]/div[3]/div[7]/div[1]/span")));
        changeQuantity.selectByIndex(0);
        //driver.wait(2);

       // driver.quit();
    }

    private static void assertEquals(String expectedSubTotal, String actualSubtotal) {
        WebDriver driver = null;
        WebElement cartTotal = driver.findElement(By.id("sw-subtotal"));
        String ActualSubtotal = String.valueOf(cartTotal);
        String ExpectedSubTotal = String.valueOf(cartTotal);
        assertEquals(ExpectedSubTotal,ActualSubtotal);
        
    }



}