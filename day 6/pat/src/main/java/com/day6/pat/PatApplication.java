package com.day6.pat;

import java.time.Duration;

import org.apache.hc.core5.http2.frame.Frame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatApplication {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.moneycontrol.com/");
		Thread.sleep(20000);
		driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/input[5]")).sendKeys("Reliance Industries");;
		Thread.sleep(20000);
		WebDriverWait wiat=new WebDriverWait(driver, Duration.ofSeconds(30));
		wiat.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Reliance Industries INE002A01018, RELIANCE, 500325"))));
		driver.findElement(By.linkText("Reliance Industries INE002A01018, RELIANCE, 500325")).click();;
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
		// driver.switchTo().frame(wb);
		// driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/input[5]")).click();


	}

}
