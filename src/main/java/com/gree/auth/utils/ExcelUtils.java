package com.gree.auth.utils;

import com.gree.auth.entity.vo.Excel;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 260152(AWU) on 2018/11/12 14:01.
 */
public class ExcelUtils {
    public static boolean getExcel(Excel excel, OutputStream outputStream) throws IOException {
        XSSFWorkbook sheets = new XSSFWorkbook();
        try {
            String name = excel.getName();
            if (null == name) {
                name = "demo.xlsx";
            }
            XSSFSheet sheet = sheets.createSheet(name);
            sheet.createFreezePane(0, 1);
            sheet.setDefaultRowHeight((short) 400);
            sheet.autoSizeColumn(0);
            writeExcel(sheets, sheet, excel);
            sheets.write(outputStream);
        } finally {
//            sheets.close();
            outputStream.close();
        }
        return true;
    }

    private static void writeExcel(XSSFWorkbook sheets, XSSFSheet sheet, Excel excel) {
        int rowIndex;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        rowIndex = writeTitlesToExcel(sheets, sheet, excel.getTitles(), map);
//        System.out.println(map);
        writeRowsToExcel(sheets, sheet, excel.getRows(), rowIndex, map);
//        System.out.println(map);
        autoSizeColumns(sheet, excel.getTitles().size() + 1);
    }

    private static void setBorder(XSSFCellStyle cellStyle, BorderStyle thin, XSSFColor xssfColor) {
        cellStyle.setBorderTop(thin);
        cellStyle.setBorderLeft(thin);
        cellStyle.setBorderRight(thin);
        cellStyle.setBorderBottom(thin);

        cellStyle.setBorderColor(XSSFCellBorder.BorderSide.TOP, xssfColor);
        cellStyle.setBorderColor(XSSFCellBorder.BorderSide.LEFT, xssfColor);
        cellStyle.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, xssfColor);
        cellStyle.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, xssfColor);

    }

    private static int writeRowsToExcel(XSSFWorkbook sheets, XSSFSheet sheet, List<List<Object>> rows, int rowIndex, Map<Integer, Integer> map) {
        int colIndex = 0;
        Font font = sheets.createFont();
        font.setFontName("demo.xlsx");
        font.setColor(IndexedColors.BLACK.index);
        XSSFCellStyle cellStyle = sheets.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setFont(font);
        setBorder(cellStyle, BorderStyle.THIN, new XSSFColor(new java.awt.Color(230, 165, 255)));
        for (List<Object> row : rows) {
            Row row1 = sheet.createRow(rowIndex);
            colIndex = 0;
            int i = 0;
            for (Object data : row) {
                Cell cell = row1.createCell(colIndex);
                if (cell != null && data != null) {
                    cell.setCellValue(data.toString());
                    cell.setCellStyle(cellStyle);
                    int length = data.toString().length() * 600;
                    if (length > 50000)
                        length = 50000;
                    Integer integer = map.get(i);
                    map.put(i, integer == null ? length : length > integer ? length : integer);
                }
                colIndex++;
                i++;
            }
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            if (entries != null && entries.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : entries) {
                    sheet.setColumnWidth(entry.getKey(), entry.getValue());
                }
            }
            rowIndex++;
        }
        return rowIndex;
    }

    private static void autoSizeColumns(Sheet sheet, int i) {
        for (int i1 = 0; i1 < i; i1++) {
            int columnWidth = sheet.getColumnWidth(i);
            sheet.autoSizeColumn(i, true);
            int i11 = sheet.getColumnWidth(i) + 100;
            if (i11 > columnWidth) {
                sheet.setColumnWidth(i, i11);
            } else {
                sheet.setColumnWidth(i, columnWidth);
            }
        }
    }

    private static int writeTitlesToExcel(XSSFWorkbook sheets, XSSFSheet
            sheet, List<String> titles, Map<Integer, Integer> map) {
        int rowIndex = 0, i = 0;
        int colIndex;
        Font font = sheets.createFont();
        font.setFontName("test");
        font.setColor(IndexedColors.BLACK.index);
        XSSFCellStyle cellStyle = sheets.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
//        cellStyle.setFillForegroundColor(new XSSFColor(new Color(255, 191, 101)));
        cellStyle.setFillBackgroundColor(HSSFColor.LIME.index);
//        cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setFont(font);
        Row row = sheet.createRow(rowIndex);
        colIndex = 0;
        for (String title : titles) {
            Cell cell = row.createCell(colIndex);
            cell.setCellValue(title);
            cell.setCellStyle(cellStyle);
            int length = title.length() * 600;
            if (length > 50000)
                length = 50000;
            Integer integer = map.get(i);
            map.put(i, integer == null ? length : length > integer ? length : integer);
            colIndex++;
            i++;
        }
        rowIndex++;
        return rowIndex;
    }
}
