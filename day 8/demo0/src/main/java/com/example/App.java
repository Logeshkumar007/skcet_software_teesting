package com.example;
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
    public static void main( String[] args ) throws IOException
    {
        //storing into file
        Map<Integer,Object[]>data=new LinkedHashMap<>();       
        data.put(1, new Object[]{"ID","USER","PASSWORD"}); 
        data.put(1, new Object[]{1,"logesh","mskl"}); 
        data.put(2, new Object[]{2,"nithish","singam"});
        //create a workbook
        // XSSFWorkbook workbook=new XSSFWorkbook("BankingSheet.xlsx");
        // XSSFSheet sheet=workbook.createSheet();
        // //iterate each row
        // for(int k:data.keySet())
        // {
            //     Row row = sheet.createRow(k);
            //     Object obj[]=data.get(k);
            //     int p=0;
            //     //iterate each cells
            //     for(Object objcell:obj)
            //     {
                //         Cell cell=row.createCell(p++);
                //         //set values into cells
                //         cell.setCellValue(objcell.toString());
                //     }
                // }
                // try {
                    //     //crete or open a existing file to write
                    //     FileOutputStream outputStream = new FileOutputStream("BankingSheet.xlsx");
                    //     // write the workbook into file
                    //     workbook.write(outputStream);
                    
                    //     workbook.close();
                    //     outputStream.close();
                    //     System.out.println("Excel file has been created successfully.");
                    // } catch (IOException e) {
                        //     e.printStackTrace();
                        // }







                        //retriving data from excell

                        // XSSFWorkbook workbook=new XSSFWorkbook("BankingSheet.xlsx");
                        // XSSFSheet sheet=workbook.getSheetAt(0);
                        // int n=sheet.getLastRowNum();
                        // for(int i=0;i<=n+1;i++)
                        // {
                        //     Row row=sheet.getRow(i);
                        //     if(row==null)
                        //     {
                        //         continue;
                        //     }
                        //     int m=row.getLastCellNum();
                        //     for(int j=0;j<=m;j++)
                        //     {
                        //         Cell cell=row.getCell(j);
                        //         if(cell==null)
                        //         {
                        //             continue;
                        //         }
                        //         System.out.println(cell.toString());
                        //     }
    // }
                        

                        
                    }
                    
                }
                