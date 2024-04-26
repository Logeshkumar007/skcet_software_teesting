package com.example;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    String user;
    String pass;
    ChromeOptions options;
    
    
    @BeforeTest
    public void befor() throws Exception {
        options = new ChromeOptions();
        options.setBinary("C:\\Users\\LOGESH\\AppData\\Local\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
        workbook = new XSSFWorkbook("BankingShee.xlsx");
        sheet = workbook.getSheetAt(0);
        user = sheet.getRow(0).getCell(0).getStringCellValue();
        pass = sheet.getRow(1).getCell(0).getStringCellValue();
    }

    @Test
    public void shouldAnswerWithTrue() throws Exception {
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.demoblaze.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.linkText("Laptops")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.linkText("MacBook Pro")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.linkText("Add to cart")).click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Cart")).click();

    }

    @Test
    public void test2() throws Exception {
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.demoblaze.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.linkText("Log in")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div[1]/input")).sendKeys(user);
        ;
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div[2]/input")).sendKeys(pass);
        ;
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).sendKeys("Test@123");
        ;
        Thread.sleep(3000);

    }

    @AfterTest
    public void before() {

    }
}
