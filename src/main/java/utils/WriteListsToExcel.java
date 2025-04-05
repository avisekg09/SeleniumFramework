package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteListsToExcel {

    public void writeExcel(List<String> Company, List<String> JobTitle, List<String> JobExp) throws IOException {

        // Example dynamic lists (can be of different sizes)
        List<String> list1 = Company; //= Arrays.asList("Data1", "Data2", "Data3", "Data4","test1","test1");
        List<String> list2 = JobTitle; //= Arrays.asList("Info1", "Info2", "Info3","test1","test1","test1","test1","test1","test1");
        List<String> list3 = JobExp;
        // Create a new Workbook and a sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // Get the maximum size of the two lists
        int maxSize = Math.max(list1.size(), list2.size());

        // Write data from both lists side by side
        for (int i = 0; i < maxSize; i++) {
            // Create a row for each pair of data
            Row row = sheet.createRow(i);

            // Write the first list to the first column (index 0), handle index out of bounds
            Cell cell1 = row.createCell(0);
            if (i < list1.size()) {
                cell1.setCellValue(list1.get(i));
            } else {
                cell1.setCellValue(""); // Or a placeholder if list1 is shorter
            }

            // Write the second list to the second column (index 1), handle index out of bounds
            Cell cell2 = row.createCell(1);
            if (i < list2.size()) {
                cell2.setCellValue(list2.get(i));
            } else {
                cell2.setCellValue(""); // Or a placeholder if list2 is shorter
            }
         // Write the third list to the third column (index 2), handle index out of bounds
            Cell cell3 = row.createCell(2);
            if (i < list3.size()) {
                cell3.setCellValue(list3.get(i));
            } else {
                cell3.setCellValue(""); // Or a placeholder if list2 is shorter
            }
        }

        // Create a file output stream to save the workbook
        FileOutputStream fileOut = new FileOutputStream(new File("output.xlsx"));

        // Write the workbook to the file
        workbook.write(fileOut);

        // Close resources
        fileOut.close();
        workbook.close();

        System.out.println("Data has been written to the Excel file successfully.");
    }
}
