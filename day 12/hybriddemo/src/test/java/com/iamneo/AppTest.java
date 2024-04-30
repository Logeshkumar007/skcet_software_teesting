// package com.iamneo;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;

// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.ss.usermodel.Sheet;
// import org.apache.poi.ss.usermodel.Workbook;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.Test;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class AppTest {
//     @Test
//     public void executeTest() throws IOException {
//         WebDriverManager.chromedriver().setup();
        
//         // Specify the path of the Excel file
//         String excelFilePath = "C:\\Users\\NithyaT\\Desktop\\keyword.xlsx";
//         FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
//         Workbook workbook = new XSSFWorkbook(inputStream);
//         Sheet sheet = workbook.getSheetAt(0);

//         // Initialize WebDriver
//         WebDriver driver = new ChromeDriver(); // You can use any browser here

//         // Iterate over the rows in the Excel sheet
//         for (Row row : sheet) {
//             String keyword = row.getCell(0) != null ? row.getCell(0).getStringCellValue() : "";
//             String locator = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "";
//             String value = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "";

//             // Perform action based on the keyword
//             switch (keyword) {
//                 case "openUrl":
//                     driver.get(value);
//                     break;
//                 case "searchBox":
//                     WebElement searchBox = driver.findElement(By.name(locator));
//                     searchBox.sendKeys(value);
//                     try {
//                         Thread.sleep(5000);
//                     } catch (InterruptedException e) {
//                         // TODO Auto-generated catch block
//                         e.printStackTrace();
//                     }
//                     //searchBox.submit();
//                     break;
               
//             }
//         }
        

//         // Close the workbook and quit the WebDriver
//         workbook.close();
//         driver.quit();
//     }
// }


// // public class AppTest
 

// // {

    
// //     @Test

// //     public void shouldAnswerWithTrue() throws InterruptedException,IOException

// //     {

// //         File file= new File("C:\\Users\\NithyaT\\Desktop\\keyword.xlsx");

// //         FileInputStream fis = new FileInputStream(file);

// //         Workbook wb = new XSSFWorkbook(fis);

// //         Sheet sh= wb.getSheet("Sheet1");



// //         WebDriverManager.chromedriver().setup();

// //         WebDriver driver=new ChromeDriver();

// //         int rowcount=sh.getLastRowNum()-sh.getFirstRowNum()+1;

// //         for(int i=1;i<rowcount;i++){

// //            Row r=sh.getRow(i);

        
// //            if(r.getCell(0).getStringCellValue().equals("open_url")){

// //               driver.get("https://www.google.com");

// //               driver.manage().window().maximize();

// //               Thread.sleep(3000);

// //            }

// //           else if(r.getCell(0).getStringCellValue().equals("get_title")){

// //               driver.get("https://www.google.com");

// //               String str=driver.getTitle();

// //               Thread.sleep(3000);

// //               System.out.println(str);

// //            }

           

            

// //         }

// //         wb.close();

// //         fis.close();

// //         driver.quit();

// //     }

// // }

 


