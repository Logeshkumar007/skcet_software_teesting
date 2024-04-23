package com.skcet.demo;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main (String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://economictimes.indiatimes.com/mutual-funds");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section/div[4]/nav/div[10]/a")).click();
		Thread.sleep(3000);
		WebElement dropdown=driver.findElement(By.xpath("/html/body/section/main/aside/div[4]/div[2]/select"));
		dropdown.click();
		Select select=new Select(dropdown);
		select.selectByVisibleText("Canara Robeco");
		Thread.sleep(3000);
		WebElement dropdown2=driver.findElement(By.xpath("/html/body/section/main/aside/div[4]/div[3]/div/select"));
		Thread.sleep(3000);
		dropdown2.click();
		Select select2=new Select(dropdown2);
		select2.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
		driver.findElement(By.xpath("/html/body/section/main/aside/div[4]/div[4]/div/a")).click();;
		
		Thread.sleep(3000);
		String cur=driver.getWindowHandle();
		Set<String> all=driver.getWindowHandles();
		// for(String k:all)
		// {
		// 	if(k!=cur)
		// 	{
		// 		driver.switchTo().window(k);
		// 		break;
		// 	}
		// }
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='installment_amt']/li/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]")).click();


	}

}
