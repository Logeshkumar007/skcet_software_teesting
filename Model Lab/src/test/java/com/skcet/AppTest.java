package com.skcet;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;
    Actions actions;
    JavascriptExecutor jExecutor;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    String textsearch1;
    Logger logger;
    TakesScreenshot ts;

    @BeforeTest
    public void BeforeTest() throws Exception {
        logger = LogManager.getLogger(getClass());
        logger.info("before test started");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        jExecutor = (JavascriptExecutor) driver;
        workbook = new XSSFWorkbook("E:\\Software Testing\\Selenium\\skcet_software_teesting\\Model Lab\\src\\Bangalore.xlsx");
        sheet = workbook.getSheetAt(0);
        textsearch1 = sheet.getRow(0).getCell(0).toString();
        ts = (TakesScreenshot) driver;
        logger.info("before test ended");
    }

    @Test
    public void Test1() throws Exception {
        logger.info("test1 started");
        
        logger.info("openeing url");
        driver.get("https://www.opentable.com");
        Thread.sleep(3000);
        logger.info("sending keys bangalore");
        driver.findElement(By.id("home-page-autocomplete-input")).sendKeys(textsearch1);;
        
        logger.info("click on button lets go");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/header/div/span/div/div/div[2]/div[2]/button")).click();
        
        logger.info("click on first result");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/a/h6")).click();
        Set<String>list=driver.getWindowHandles();
        logger.warn("changing tabs");
        for(String k:list)
        {
            if(!k.equals(driver.getWindowHandle()))
            {
                driver.switchTo().window(k);
                break;
            }
        }
        logger.info("dropdown selection");
        Select select1=new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[1]/section[2]/div[5]/article[1]/div/div[1]/div/select")));
        select1.selectByValue("4");
        logger.info("selecting 4 people");
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[1]/section[2]/div[5]/article[1]/div/div[3]/div[1]/div/div[1]/div/div")).click();
        Thread.sleep(3000);
        logger.info("selecting date");
        WebElement date=driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[1]/section[2]/div[5]/article[1]/div/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/button[2]"));
        for(int i=0;i<6;i++)
        {
            date.click();
        }
        
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[1]/section[2]/div[5]/article[1]/div/div[3]/div[1]/div/div[2]/div/div/div/table/tbody/tr[3]/td[2]/button")).click();
        
        WebElement dropTime= driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[1]/section[2]/div[5]/article[1]/div/div[3]/div[2]/div/select"));
        
        logger.info("selecting time");
        Select select2=new Select(dropTime);
        select2.selectByValue("2000-02-01T19:00:00");
        
        logger.info("clicking signin");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div[1]/button")).click();
        logger.info("Taking screenshots");
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/test1.png"));

        logger.info("took screenshot");
        
        
        Thread.sleep(3000);
        
        
       
        
        
        logger.info("test1 ended");
    }

  
}
