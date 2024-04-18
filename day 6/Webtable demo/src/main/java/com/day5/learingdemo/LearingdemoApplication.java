package com.day5.learingdemo;

import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class LearingdemoApplication {

	public static void main(String[] args) {
		try {
			WebDriver driver = new ChromeDriver();

			// Navigate to the webpage with the table
			driver.get("https://cosmocode.io/automation-practice-webtable/");

			// Locate the table element
			WebElement table = driver.findElement(By.xpath("//table[@id='countries']")); // Replace 'table_id' with the
																							// actual ID of the table

			// Get all rows of the table
			List<WebElement> rows = table.findElements(By.tagName("tr"));

			// Iterate through rows and print cell data
			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells) {
					System.out.print(cell.getText() + "\t");
				}
				System.out.println();
			}

			// Close the browser
			driver.quit();

		} catch (Exception e) {

		}
	}

}
