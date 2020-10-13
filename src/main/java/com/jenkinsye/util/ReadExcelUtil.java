package com.jenkinsye.util;

import com.jenkinsye.bean.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
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

    public static List<KeyVariable> readKeyVaraiblesFromFile(String fileName) {
        List<KeyVariable> result = new ArrayList<>();
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

                KeyVariable  keyVariable = new KeyVariable();
                keyVariable.stkcd = row.getCell(0).toString();
                keyVariable.accper = row.getCell(1).toString();
                keyVariable.cfo = row.getCell(2).getNumericCellValue();
                keyVariable.ta = row.getCell(3).getNumericCellValue();
                keyVariable.stb = row.getCell(4).getNumericCellValue();
                keyVariable.ltb = row.getCell(5).getNumericCellValue();
                keyVariable.tl = row.getCell(6).getNumericCellValue();
                keyVariable.operating1 = row.getCell(7).getNumericCellValue();
                keyVariable.operating2 = row.getCell(8).getNumericCellValue();
                keyVariable.netp = row.getCell(9).getNumericCellValue();
                keyVariable.loan = row.getCell(10).getNumericCellValue();
                keyVariable.stloan = row.getCell(11).getNumericCellValue();
                keyVariable.ltloan = row.getCell(12).getNumericCellValue();
                keyVariable.ros = row.getCell(13).getNumericCellValue();
                keyVariable.size = row.getCell(14).getNumericCellValue();
                keyVariable.liquidity = row.getCell(15).getNumericCellValue();
                keyVariable.leverage = row.getCell(16).getNumericCellValue();
                keyVariable.roa = row.getCell(17).getNumericCellValue();

                result.add(keyVariable);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static List<Shanxifusheng> readShanxifushengFromFile(String fileName) {
        List<Shanxifusheng> result = new ArrayList<>();
        File excelFile = new File(fileName);
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            Workbook workbook = getWorkbok(in, excelFile);
            //第一页sheet
            for(int i = 0; i <=4; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                int count = 0;
                for (Row row : sheet) {
                    if (count < 8) {
                        count++;
                        continue;
                    }
                    count++;
                    if (row.getCell(0).toString().equals("")) {
                        break;
                    }

                    Shanxifusheng shanxifusheng = new Shanxifusheng();
                    shanxifusheng.ztzb = row.getCell(0).getStringCellValue();
                    shanxifusheng.date = row.getCell(1).getStringCellValue();
                    shanxifusheng.pzh = row.getCell(2).getStringCellValue();
                    shanxifusheng.digest = row.getCell(3).getStringCellValue();
                    row.getCell(4).setCellType(CellType.STRING);
                    shanxifusheng.kmbm = row.getCell(4).getStringCellValue();
                    shanxifusheng.kmmc = row.getCell(5).getStringCellValue();
                    shanxifusheng.bz = row.getCell(6).getStringCellValue();
                    row.getCell(7).setCellType(CellType.STRING);
                    String temp1 = row.getCell(7).getStringCellValue();
                    if (temp1 != null && temp1.length() > 0)
                        shanxifusheng.jf = Double.parseDouble(temp1);


                    row.getCell(8).setCellType(CellType.STRING);
                    String temp2 = row.getCell(8).getStringCellValue();
                    if (temp2 != null && temp2.length() > 0)
                        shanxifusheng.df = Double.parseDouble(temp2);

                    result.add(shanxifusheng);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
