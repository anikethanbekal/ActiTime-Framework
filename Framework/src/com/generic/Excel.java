package com.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static int getRow(String path, String sheet) {
		FileInputStream fis;
		int rc=-1;
		try {
			fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			rc = w.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rc;
	}
	public static int getColumn(String path, String sheet) {
		FileInputStream fis;
		int cc =-1;
		try {
			fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			cc = w.getSheet(sheet).getRow(0).getLastCellNum();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cc;
	}
	public static String getData(String path, String sheet,int row , int col) {
		String value ="";
		Workbook w;
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			w = WorkbookFactory.create(fis);
			value = w.getSheet(sheet).getRow(row).getCell(col).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return value;
		
	}
}
