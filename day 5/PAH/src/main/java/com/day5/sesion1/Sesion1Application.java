package com.day5.sesion1;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sesion1Application {

	public static void main(String[] args) {
		try{

			WebDriver driver=new ChromeDriver();
			driver.get("https://magento.softwaretestingboard.com/");
			driver.findElement(By.id("search")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("search")).sendKeys("Shoes");
			Thread.sleep(7000);
			
			Thread.sleep(7000);
			TakesScreenshot ts = (TakesScreenshot)driver;
			Thread.sleep(7000);
			File file = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("./screenshots/shoe-evidence.png"));
		Thread.sleep(3000);
			
		
		
		
		
		
		
		
		
		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2]/div[2]/form/div[2]/button")).click();
			Thread.sleep(7000);
			Actions action=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]/a/span[2]"));
			Thread.sleep(7000);
			action.moveToElement(ele).perform();
			WebElement top=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/nav/ul/li[3]/ul/li[1]/a/span[2]"));
			Thread.sleep(7000);
			action.moveToElement(top).perform();
			WebElement hoodie=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/nav/ul/li[3]/ul/li[1]/ul/li[2]/a/span"));
			Thread.sleep(7000);
			action.moveToElement(hoodie).perform();
			
		

		}
		catch(Exception e)
		{
			
		}
		SpringApplication.run(Sesion1Application.class, args);
	}

}
