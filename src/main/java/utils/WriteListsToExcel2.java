package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteListsToExcel2 {

    public void writeExcel(List<String> Company, List<String> JobTitle, List<String> JobExp) throws IOException {
    	// Example dynamic lists (can be of different sizes)
        List<String> list1 = Company; //= Arrays.asList("Data1", "Data2", "Data3", "Data4","test1","test1");
        List<String> list2 = JobTitle; //= Arrays.asList("Info1", "Info2", "Info3","test1","test1","test1","test1","test1","test1");
        List<String> list3 = JobExp;
        // Path to the existing Excel file
        String filePath = "output.xlsx";

        // Open the existing Excel file
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        // Get the sheet to write to (use first sheet in this case)
        Sheet sheet = workbook.getSheetAt(0);

        // Find the last row number that is being used in the sheet
        int lastRowNum = sheet.getLastRowNum();

        // Loop through the new lists and append data after the last used row
        for (int i = 0; i < list1.size(); i++) {
            // Create a new row after the last used row
            Row row = sheet.createRow(lastRowNum + 1 + i);

            // Create cells for each list
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(list1.get(i));

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(list2.get(i));
            
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(list3.get(i));
        }

        // Close the file input stream after reading
        fileInputStream.close();

        // Create a file output stream to save the updated workbook
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        
        // Write the updated workbook to the file
        workbook.write(fileOutputStream);

        // Close the output stream and workbook
        fileOutputStream.close();
        workbook.close();

        System.out.println("Data has been appended to the Excel file successfully.");
    }
}
