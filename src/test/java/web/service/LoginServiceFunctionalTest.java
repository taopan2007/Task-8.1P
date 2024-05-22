package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class LoginServiceFunctionalTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8082/login.html");
    }

    @Test
    public void testLoginSuccess() {
    	   WebElement usernameField = driver.findElement(By.id("username"));
    	    WebElement passwordField = driver.findElement(By.id("passwd"));
    	    WebElement dobField = driver.findElement(By.id("dob"));
    	    WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

    	    usernameField.sendKeys("admin");
    	    passwordField.sendKeys("admin");
    	    dobField.sendKeys("1990-01-01");
    	    submitButton.click();

    	    String pageTitle = driver.getTitle();
    	    System.out.println("Page Title: " + pageTitle);
    	    assertEquals("success", pageTitle);
    }

    @Test
    public void testLoginFailure() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement dobField = driver.findElement(By.id("dob"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("wrongpassword");
        dobField.sendKeys("1990-01-01");
        submitButton.click();

        assertEquals("fail", driver.getTitle());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
