package com.skcet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    ExtentReports report;
    ExtentSparkReporter spark;

    @BeforeTest
    public void befor() {
        driver = new ChromeDriver();
        report = new ExtentReports();
        spark = new ExtentSparkReporter(
                "E:\\Software Testing\\Selenium\\skcet_software_teesting\\day 9\\class_ex1\\src\\test\\java\\com\\skcet\\report.html");
        spark.config().setTheme(Theme.DARK);
        report.attachReporter(spark);

    }

    @Test
    public void shouldAnswerWithTrue() {
        try {
            ExtentTest test1 = report.createTest("test1");
            XSSFWorkbook workbook = new XSSFWorkbook("input.xlsx");
            XSSFSheet sheet = workbook.getSheetAt(0);
            String a = sheet.getRow(0).getCell(0).toString();
            String b = sheet.getRow(1).getCell(0).toString();
            String c = sheet.getRow(2).getCell(0).toString();

            driver.get("https://groww.in/");
            Thread.sleep(3000);
            driver.findElement(By.linkText("Calculators")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/a[15]/div")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath(
                    "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div/input"))
                    .clear();
            driver.findElement(By.xpath(
                    "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div/input"))
                    .sendKeys(a);
            Thread.sleep(3000);
            driver.findElement(By.xpath(
                    "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div/input"))
                    .clear();
            driver.findElement(By.xpath(
                    "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div/input"))
                    .sendKeys(b);
            ;
            driver.findElement(By.xpath(
                    "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/input"))
                    .clear();
            driver.findElement(By.xpath(
                    "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/input"))
                    .sendKeys(c);
            String text = driver
                    .findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p"))
                    .getText();
            if (text.contains("Your Amortization Details")) {
                System.out.println("sh");
                System.out.println("lo");
                test1.log(Status.PASS, "success and verified");
                
            }
            report.flush();
            // driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]")).click();
        }

        catch (Exception e) {

        }
    }
}
