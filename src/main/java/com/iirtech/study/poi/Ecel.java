package com.iirtech.study.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ecel {
    public static void main(String[] args) {
        String path = "/Users/chs/POI예제/";
        String fileName = "과거버전파일.xls";

        List<Map<Object, Object>> excelData = readExcel(path, fileName);

        // 결과 확인!
        for (int i = 0; i < excelData.size(); i++) {
            System.out.println(excelData.get(i));
        }
    }

    public static boolean debug(){
        return true;
    }

    public static List<Map<Object, Object>> readExcel(String path, String fileName) {
        List<Map<Object, Object>> list = new ArrayList<>();
        if (path == null || fileName == null) {
            return list;
        }

        FileInputStream is = null;
        File excel = new File(path + fileName);
        try {
            is = new FileInputStream(excel);
            Workbook workbook = null;
            if (fileName.endsWith(".xls")) {
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(is);
            }

            if (workbook != null) {
                int sheets = workbook.getNumberOfSheets();
                getSheet(workbook, sheets, list);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public static void getSheet(Workbook workbook, int sheets, List<Map<Object, Object>> list) {
        if(debug())System.out.println("getSheet 내의 sheets:" + sheets);
        for (int z = 0; z < sheets; z++) {
            Sheet sheet = workbook.getSheetAt(z);
            if(debug())System.out.println("for문안의 sheet:" + sheet);
            int rows = sheet.getLastRowNum();
            if(debug())System.out.println("for문안의 rows:" + rows);
            getRow(sheet, rows, list);
        }
    }

    public static void getRow(Sheet sheet, int rows, List<Map<Object, Object>> list) {
        for (int i = 0; i <= rows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                int cells = row.getPhysicalNumberOfCells();
                list.add(getCell(row, cells));
            }
        }
    }

    public static Map<Object, Object> getCell(Row row, int cells) {
        String[] columns = { "column1", "column2", "column3", "column4", "column5", "column6" };
        Map<Object, Object> map = new HashMap<>();
        for (int j = 0; j < cells; j++) {
            if (j >= columns.length) {
                break;
            }

            Cell cell = row.getCell(j);
            if (cell != null) {
                switch (cell.getCellType()) {
                    case BLANK:
                        map.put(columns[j], "");
                        break;
                    case STRING:
                        map.put(columns[j], cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            map.put(columns[j], cell.getDateCellValue());
                        } else {
                            map.put(columns[j], cell.getNumericCellValue());
                        }
                        break;
                    case ERROR:
                        map.put(columns[j], cell.getErrorCellValue());
                        break;
                    default:
                        map.put(columns[j], "");
                        break;
                }
            }
        }

        return map;
    }

}
