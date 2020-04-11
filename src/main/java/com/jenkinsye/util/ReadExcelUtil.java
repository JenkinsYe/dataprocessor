package com.jenkinsye.util;

import com.jenkinsye.bean.Asset;
import com.jenkinsye.bean.Ins;
import com.jenkinsye.bean.Scfd;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YJJ
 * @Date: Created in 12:31 2020-04-11
 */
public class ReadExcelUtil {

    /**
     * 判断Excel的版本,获取Workbook
     * @param in
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in, File file) throws IOException, IOException {
        Workbook wb = null;
        if(file.getName().endsWith("xls")){  //Excel 2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith("xlsx")){  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    public static List<Asset> readAssetFromFile(String fileName) {
        List<Asset> result = new ArrayList<>();
        File excelFile = new File(fileName);
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            Workbook workbook = getWorkbok(in, excelFile);
            //第一页sheet
            Sheet sheet = workbook.getSheetAt(0);
            int count = 0;
            for (Row row : sheet) {
                if (count < 1) {
                    count++;
                    continue;
                }

                if (row.getCell(0).toString().equals("")) {
                    break;
                }

                Asset asset = new Asset();
                asset.stkcd = row.getCell(0).toString();
                asset.accper = row.getCell(1).toString();
                asset.ta = row.getCell(2).getNumericCellValue();
                asset.stb = row.getCell(3).getNumericCellValue();
                asset.ltb = row.getCell(4).getNumericCellValue();
                asset.tl = row.getCell(5).getNumericCellValue();

                result.add(asset);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Ins> readInsFromFile(String fileName) {
        List<Ins> result = new ArrayList<>();
        File excelFile = new File(fileName);
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            Workbook workbook = getWorkbok(in, excelFile);
            //第一页sheet
            Sheet sheet = workbook.getSheetAt(0);
            int count = 0;
            for (Row row : sheet) {
                if (count < 1) {
                    count++;
                    continue;
                }

                if (row.getCell(0).toString().equals("")) {
                    break;
                }

                Ins ins = new Ins();
                ins.stkcd = row.getCell(0).toString();
                ins.accper = row.getCell(1).toString();
                ins.operating1 = row.getCell(2).getNumericCellValue();
                ins.operating2 = row.getCell(3).getNumericCellValue();
                ins.netp = row.getCell(4).getNumericCellValue();

                result.add(ins);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Scfd> readScfdFromFile(String fileName) {
        List<Scfd> result = new ArrayList<>();
        File excelFile = new File(fileName);
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            Workbook workbook = getWorkbok(in, excelFile);
            //第一页sheet
            Sheet sheet = workbook.getSheetAt(0);
            int count = 0;
            for (Row row : sheet) {
                if (count < 1) {
                    count++;
                    continue;
                }

                if (row.getCell(0).toString().equals("")) {
                    break;
                }

                Scfd scfd = new Scfd();
                scfd.stkcd = row.getCell(0).toString();
                scfd.accper = row.getCell(1).toString();
                scfd.cfo = row.getCell(2).getNumericCellValue();

                result.add(scfd);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}
