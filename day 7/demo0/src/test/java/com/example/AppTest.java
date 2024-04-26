package com.example;

import static org.junit.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
    WebDriver driver;


    @BeforeTest
    public void BeforeTest()
    {
        driver=new ChromeDriver();
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        driver.get("https://www.google.com/search?q=industries+that+use+selenium+in+tamilnadu&rlz=1C1CHBF_enIN1036IN1037&oq=industries+that+use+selenium+in+tami&gs_lcrp=EgZjaHJvbWUqCQgCECEYChigATIGCAAQRRg5MgkIARAhGAoYoAEyCQgCECEYChigATIJCAMQIRgKGKABMgcIBBAhGJ8F0gEKMTIyMDVqMGoxNagCCLACAQ&sourceid=chrome&ie=UTF-8");
        
    }
    @Test(dependsOnMethods = "shouldAnswerWithTrue")
    public void shouldAnswerWithTrue2()
    {
       String p=driver.getCurrentUrl();
        System.out.println(p);
    }
    @AfterTest
    public void AfterTest()
    {
        driver.quit();
    }
}
