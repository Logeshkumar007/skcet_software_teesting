package com.day4.day4_sesion2;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day4Sesion3Application {

	public static void main(String[] args) {
		WebDriver driverchrome = new ChromeDriver();
		

		driverchrome.get("https://www.shoppersstop.com/");
		
		
		driverchrome.findElement(By.className("user-icon")).click();

		SpringApplication.run(Day4Sesion3Application.class, args);
	}

}
