package com.skcet;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
public class AppTest 
{
    WebDriver driver;
    Actions actions;
    JavascriptExecutor jExecutor;
    ExtentReports reports;
    ExtentSparkReporter spark;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    String textsearch1;
    Logger logger;
    @BeforeTest
    public void BeforeTest() throws Exception
    {
        logger=LogManager.getLogger(getClass());
        logger.info("before test started");
        driver=new ChromeDriver();
        actions=new Actions(driver);
        jExecutor=(JavascriptExecutor)driver;
        reports=new ExtentReports();
        spark=new ExtentSparkReporter("E:\\Software Testing\\Selenium\\skcet_software_teesting\\day 2\\cc2\\src\\test\\java\\com\\skcet\\report.html");
        
        spark.config().setTheme(Theme.DARK);
        reports.attachReporter(spark);
        workbook=new XSSFWorkbook("E:\\Software Testing\\Selenium\\skcet_software_teesting\\cc2\\src\\input.xlsx");
        sheet =workbook.getSheetAt(0);
        textsearch1=sheet.getRow(0).getCell(0).toString();
        logger.info("before test ended");
    }
    @Test
    public void Test1()
    {
    logger.info("test1 started");
    ExtentTest test1=reports.createTest("test1");
    driver.get("https://www.barnesandnoble.com/");
    driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]")).click();;
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();;
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys(textsearch1);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/span")).click();
        String alltext=driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div/div/section[1]/section[1]/div/div[1]/div[1]/h1")).getText();
        if(alltext.contains("Chetan Bhagat"))
        {
            System.out.println("Text Found");
            
            }
            test1.log(Status.PASS, "succesfull prescence of text");
            reports.flush();
            logger.info("test1 ended");
        }
        @Test
        public void Test2() throws Exception
        {
            
            logger.info("test2 started");
            
            
            ExtentTest test2=reports.createTest("test2");
            driver.navigate().to("https://www.barnesandnoble.com/");
            actions.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[4]/div/ul/li[5]/a"))).perform();
            Thread.sleep(2000);
        // driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[4]/div/ul/li[5]/div/div/div[1]/div/div[2]/div[1]/dd/a[1]")).click();;
        
        test2.log(Status.PASS, "test2 success");
        reports.flush();
        logger.info("test1 started");
    }
    
    @Test
    public void Test3() throws Exception
    {
        logger.info("test3 started");
        
        
        ExtentTest test3=reports.createTest("test2");
        
        
    driver.navigate().to("https://www.barnesandnoble.com/");
    Thread.sleep(10000);
    WebElement bnm=driver.findElement(By.xpath("/html/body/main/div[3]/div[3]/div/section/div/div/div/a[1]/div"));
    actions.scrollToElement(bnm);
    bnm.click();



    // driver.findElement(By.xpath("/html/body/main/div[3]/div[3]/div/section/div/div/div/a[1]")).click();;
    // driver.findElement(By.xpath("/html/body/main/section/div[1]/div[2]/div/div/div[2]/div/div[73]/div/div[1]/a")).click();;
    test3.log(Status.PASS, "test2 success");
    reports.flush();
    logger.info("test3 ended");
}

@AfterTest
public void afterTest()
{
    logger.info("driver has quited");
    driver.quit();
    }    
}
