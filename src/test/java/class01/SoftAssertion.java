package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    @BeforeMethod
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test
    public void VerifyCredentials() {

        SoftAssert soft= new SoftAssert();
        String expectedText = "Invalid credentials 123456";
        WebElement Username = driver.findElement(By.id("txtUsername"));
        Username.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        soft.assertEquals(Text,expectedText);
        
        boolean displayed=Username.isDisplayed();
        System.out.println("hello world");
        soft.assertTrue(displayed);

    }
    @AfterMethod
    public void CloseBrowser(){

    }
}
