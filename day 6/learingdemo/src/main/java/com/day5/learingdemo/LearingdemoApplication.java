package com.day5.learingdemo;

import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearingdemoApplication {

	public static void main(String[] args) {
		try{
			WebDriver driver=new ChromeDriver();
			driver.get("https://demo.automationtesting.in/Frames.html");
			Thread.sleep(3000);
			WebElement ele=driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[2]/div[1]/iframe"));
			Thread.sleep(3000);
			driver.switchTo().frame(ele);
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/section/div/div/div/input")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("hadcjsbd");
		}
		catch(Exception e)
		{

		}
	}

}
