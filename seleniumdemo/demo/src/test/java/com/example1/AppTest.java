package com.example1;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;




public class AppTest 
{
    
    @Test
    public void shouldAnswerWithTrue() throws IOException
    {
        WebDriver driver=new ChromeDriver();
        XSSFWorkbook workbook=new XSSFWorkbook("input.xlsx");
        XSSFSheet sheet=workbook.getSheetAt(0);
        Row row2=sheet.getRow(1);
        Cell cell1=row2.getCell(0);
        cell1.setCellValue("whsgdc");
    }
}
