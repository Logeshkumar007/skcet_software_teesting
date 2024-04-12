package com.skcet.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumdemoApplication {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://skcet530.examly.io/login");
		try{

			Thread.sleep(1000);
			driver.findElement(By.id("email")).sendKeys("727722euit096@skcet.ac.in");
			driver.findElement(By.tagName("app-button")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.id("password")).sendKeys("mskl2004");
			driver.findElement(By.tagName("app-button")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("body > app-root > div > app-sidebar > div > ul > li:nth-child(7) > a > div")).click();
			SpringApplication.run(SeleniumdemoApplication.class, args);
		}
		catch(Exception e)
		{

		}
	}

}
