package com.day5.sesion1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sesion1Application {

	public static void main(String[] args) {
		try{

			WebDriver driver=new ChromeDriver();
			driver.get("https://www.demoblaze.com/");
			driver.findElement(By.linkText("Laptops")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("MacBook air")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Add to cart")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Cart")).click();
		}
		catch(Exception e)
		{
			
		}
		SpringApplication.run(Sesion1Application.class, args);
	}

}
