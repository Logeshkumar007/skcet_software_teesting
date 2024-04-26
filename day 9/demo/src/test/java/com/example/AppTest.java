package com.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AppTest 
{
    ExtentReports report;
    @BeforeTest
    public void getreport()
    {
       report=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("E:\\Software Testing\\Selenium\\skcet_software_teesting\\day 9\\demo\\src\\test\\java\\com\\example\\report.html");
        report.attachReporter(spark);
        spark.config().setDocumentTitle("onelinguOneMotor");
        spark.config().setTheme(Theme.DARK);
    }   
    @org.testng.annotations.Test
    public void test1()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.co");
        ExtentTest test2=report.createTest("foodtest3");
        test2.log(Status.FAIL, "food testing failed");
        report.flush();
    }
    @org.testng.annotations.Test
    public void test_report()
    {
    }
}
