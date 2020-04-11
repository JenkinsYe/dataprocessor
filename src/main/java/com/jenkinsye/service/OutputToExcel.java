package com.jenkinsye.service;

import com.jenkinsye.bean.Result;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author YJJ
 * @Date: Created in 13:12 2020-04-11
 */
public class OutputToExcel {

    public static void writeToFile(List<Result> results) {
        XSSFWorkbook workbook = null;
        workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet();
        XSSFRow titleRow = sheet.createRow(0);
        //标题栏
        titleRow.createCell(0).setCellValue("Stkcd");
        titleRow.createCell(1).setCellValue("Accper");
        titleRow.createCell(2).setCellValue("Cfo");
        titleRow.createCell(3).setCellValue("TA");
        titleRow.createCell(4).setCellValue("Stb");
        titleRow.createCell(5).setCellValue("Ltb");
        titleRow.createCell(6).setCellValue("TL");
        titleRow.createCell(7).setCellValue("OperatingI");
        titleRow.createCell(8).setCellValue("OperatingP");
        titleRow.createCell(9).setCellValue("NetP");

        //数据
        for (int i = 0; i < results.size(); i++) {
            XSSFRow row = sheet.createRow(i+1);
            Result result = results.get(i);
            row.createCell(0).setCellValue(result.stkcd);
            row.createCell(1).setCellValue(result.accper);
            row.createCell(2).setCellValue(result.cfo);
            row.createCell(3).setCellValue(result.ta);
            row.createCell(4).setCellValue(result.stb);
            row.createCell(5).setCellValue(result.ltb);
            row.createCell(6).setCellValue(result.tl);
            row.createCell(7).setCellValue(result.operating1);
            row.createCell(8).setCellValue(result.operating2);
            row.createCell(9).setCellValue(result.netp);
        }

        File file = new File("/Users/YJJ/Desktop/output.xlsx");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
