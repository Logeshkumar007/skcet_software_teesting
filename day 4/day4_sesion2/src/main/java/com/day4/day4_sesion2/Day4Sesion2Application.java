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
public class Day4Sesion2Application {

	public static void main(String[] args) {
		WebDriver driverchrome = new ChromeDriver();
		// WebDriver driveredge = new EdgeDriver();
		// WebDriver driverfirefox = new FirefoxDriver();

		// driverchrome.get("https://www.google.com");
		// driverchrome.close();
		// driveredge.get("https://www.google.com");
		// driveredge.close();
		// driverfirefox.get("https://www.google.com");
		// driverfirefox.close();

		driverchrome.get("https://www.shoppersstop.com/");
		System.out.println();
		System.out.println(driverchrome.getTitle());
		System.out.println(driverchrome.getCurrentUrl());
		// System.out.println(driverchrome.getPageSource());
		
		driverchrome.findElement(By.className("user-icon")).click();

		SpringApplication.run(Day4Sesion2Application.class, args);
	}

}
