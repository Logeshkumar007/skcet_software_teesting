package com.example;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// import com.google.common.collect.Table.Cell;;
public class App 
{
    public static void main( String[] args )
    {
        try{

            int k=0;
            FileInputStream fs=new FileInputStream("input.xlsx"); //1.	Fileinputstream object



            //create an workbook
            XSSFWorkbook workbook=new XSSFWorkbook(fs); //2.	Workbook Object



            XSSFSheet sheet=workbook.getSheetAt(0); // 3.	Sheet Object

            int rowCount=sheet.getLastRowNum(); // toget no of rows
            int colCount=sheet.getRow(0).getLastCellNum(); // toget no of columns
    



            Object[][] data=new Object[rowCount][colCount];
            
            
            
            // Reading from excel
            // for(int i=0;i<rowCount;i++)
            // { 

            //     Row row=sheet.getRow(i+1); // to move to particular row from 1st row till last
            //     for(int j=0;j<colCount;j++)
            //     {  
            //         data[i][j]=row.getCell(j).getStringCellValue();
            //         System.out.print(data[i][j]+" ");
            //     }
            //     System.out.println();
            // }
           


             // Wrting into excel
             String[] a ={"Arun", "Bala"};



             
             for(int j=0;j<rowCount;j++)
            { 
             Row row =sheet.getRow(j+1);
              Cell cell= row.createCell(2);
               cell.setCellValue(a[k]);
                k++;
            }
            
            
            
            fs.close();
            FileOutputStream fos= new FileOutputStream("input.xlsx");
            workbook.write(fos);
        
        
        
               
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }
                    
            }
                