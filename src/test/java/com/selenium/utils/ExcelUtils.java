package com.selenium.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
    private static String path = System.getProperty("user.dir")+"/resources/testdata.xlsx";

    public static int getRow(String sheetname){
        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheet(sheetname);
            book.close();
            return sheet.getLastRowNum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getCellData(String sheetname, int row,int col){
        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheet(sheetname);
            book.close();
            return sheet.getRow(row).getCell(col).toString();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeData(String sheetname,int row,int col,String value){
        try{
             FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheet(sheetname);
            sheet.getRow(row).createCell(col).setCellValue(value);
            FileOutputStream fos = new FileOutputStream(path);
            book.write(fos);
            fos.close();
            book.close();
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


