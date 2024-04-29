package com.skcet;

import java.io.File;
import java.util.List;

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
    ExtentReports reports;
    ExtentSparkReporter spark;
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
        reports = new ExtentReports();
        spark = new ExtentSparkReporter(
                "E:\\Software Testing\\Selenium\\skcet_software_teesting\\day 2\\cc2\\src\\test\\java\\com\\skcet\\report.html");

        spark.config().setTheme(Theme.DARK);
        reports.attachReporter(spark);
        workbook = new XSSFWorkbook("E:\\Software Testing\\Selenium\\skcet_software_teesting\\cc2\\src\\input.xlsx");
        sheet = workbook.getSheetAt(0);
        textsearch1 = sheet.getRow(0).getCell(0).toString();
        ts = (TakesScreenshot) driver;
        logger.info("before test ended");
    }

    @Test
    public void Test1() throws Exception {
        logger.info("test1 started");
        ExtentTest test1 = reports.createTest("test1");



        driver.get("https://www.barnesandnoble.com/");

        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]")).click();
        ;
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        ;
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[2]/div/input[1]"))
                .sendKeys(textsearch1);



        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/span")).click();


        String alltext = driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div/div/section[1]/section[1]/div/div[1]/div[1]/h1"))
                .getText();


        if (alltext.contains("Chetan Bhagat")) {
            System.out.println("Text Found");

        }



        test1.log(Status.PASS, "succesfull prescence of text");



        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/test1.png"));

        logger.info("took screenshot");
        
        
        Thread.sleep(3000);
        
        
        reports.flush();
        
        
        logger.info("test1 ended");
    }

    @Test
    public void Test2() throws Exception {

        logger.info("test2 started");

        ExtentTest test2 = reports.createTest("test2");
       
        driver.navigate().to("https://www.barnesandnoble.com/");
        actions.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[4]/div/ul/li[5]/a")))
                .perform();
        Thread.sleep(2000);
       
        
        test2.log(Status.PASS, "test2 success");
        reports.flush();


        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/test2.png"));
        Thread.sleep(3000);


        logger.info("took screenshot");
        logger.info("test2 has ended");
    }

    @Test
    public void test3() throws Exception {
        logger.info("test 3 has started");
        ExtentTest test3 = reports.createTest("Test 3", "Choose BN Membership & Find Sign In Pop Up");
        logger.info("Choosing BN Membership");

        actions
                .scrollToElement(driver.findElement(By.xpath("//*[@id=\"footer\"]/div/dd/div/div")))
                .perform();

        driver.findElement(By.xpath("//*[@id=\"footer\"]/div/dd/div/div/div[1]/div/a[5]")).click();

        actions
                .scrollToElement(driver.findElement(By.xpath("//*[@id=\"mb-landing\"]/div[1]/div[2]/div/div/div[4]")))
                .perform();

        driver.findElement(By.linkText("JOIN REWARDS")).click();
        logger.info("JOIN REWARDS clicked");

        List<WebElement> ele = driver.findElements(By.tagName("iframe"));
        System.out.println("IFRAME displayed " + ele);
        Thread.sleep(5000);
        driver.switchTo().frame(ele.get(0));

        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/test3.png"));
        Thread.sleep(3000);

        // logger.info("took screenshot");
        logger.info("Screenshot taken for evidence");
        logger.warn("Trying to find SIGN IN POP UP will fail");

        test3.log(Status.PASS, "SIGN IN POP-UP found");

        try {
            
            String confirm = driver.findElement(By.tagName("h2")).getText();
            System.out.println(confirm);

            if (confirm.equals("Sign in or Create an Account")) {
                logger.info("SIGN IN POP UP found");
            } else {
                logger.warn("SIGN IN text not found");
            }
        } catch (Exception e) {
            logger.error("SIGN IN POP UP not found");
        }
        reports.flush();
        logger.info("test 3 has ended");
    }

    @AfterTest
    public void afterTest() {
        logger.info("driver has quited");

    }
}
