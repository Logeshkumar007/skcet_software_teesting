package com.day6.dropdownsesion1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Dropdownsesion1Application {

	public static void main(String[] args) {
		try{

			WebDriver driver=new ChromeDriver();
			driver.get("https://economictimes.indiatimes.com/mutual-funds");
			Thread.sleep(20000);
		
			WebElement dropdown=driver.findElement(By.xpath("/html/body/section/main/aside/div[4]/div[2]/select"));
			dropdown.click();
			Thread.sleep(20000);
			Select select_drop=new Select(dropdown);
			select_drop.selectByIndex(9);

			Thread.sleep(20000);
		
			WebElement dropdown2=driver.findElement(By.xpath("/html/body/section/main/aside/div[4]/div[3]/div/select"));
			dropdown.click();
			Thread.sleep(20000);
			Select select_drop2=new Select(dropdown2);
			select_drop2.selectByIndex(5);




			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/section/main/aside/div[4]/div[4]/div/a/span"));
		}
		catch(Exception e)
		{

		}
		
	}

}
