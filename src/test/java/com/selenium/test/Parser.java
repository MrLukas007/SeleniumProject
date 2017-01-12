package com.selenium.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Parser {
    public static ArrayList<SheetNote> parse(String name) {

        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream(name);
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<SheetNote> noteList = new ArrayList<SheetNote>();
        Sheet sheet = wb.getSheetAt(0);
        int shiitSize  = sheet.getLastRowNum();

        for (int i = 1; i <= shiitSize; i++) {
            Row row = sheet.getRow(i);

            String cell1 = row.getCell(0).getStringCellValue();
            String cell2 = row.getCell(1).getStringCellValue();
            String cell3 = row.getCell(2).getStringCellValue();
            String cell4 = row.getCell(3).getStringCellValue();

            noteList.add(new SheetNote(cell1, cell2, cell3, cell4));
        }


        return noteList;
    }
}
