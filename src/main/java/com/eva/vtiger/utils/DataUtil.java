package com.eva.vtiger.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtil {
	
	
	public Map<String,String> gettestcasedata(String tcID) {
		Workbook wbook=null;
		
		try {
			InputStream fis=new FileInputStream("C:\\Users\\RAMSINGAR YADAV\\Downloads\\vtiger (2) (3)\\vtiger\\src\\main\\resources\\opencart excel.xlsx");
			wbook=new XSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
		}
		Sheet sheetobj=wbook.getSheet("DataSheet");
		int tcRowNumber=getRowNumberByTestCaseID(sheetobj, tcID);
		Row rowTcObj=sheetobj.getRow(tcRowNumber);
		int cellcount=rowTcObj.getLastCellNum();
		Map<String,String> dataMap=new HashMap<String,String>();
		for(int i=2;i<=cellcount-1;i=i+2) {
			String cellDatakey=getcellData(rowTcObj,i);
			String cellDatavalue=getcellData(rowTcObj,i+1);
			dataMap.put(cellDatakey, cellDatavalue);	
		}return dataMap;
	}
	//this method will read data from excell on the basis of row object and cell number 
	// it will manage data wheather it is in string or integer
	public String getcellData(Row rowObj,int cellNumber) {
		String data =null;
		Cell cellObj=rowObj.getCell(cellNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		if(cellObj.getCellType()==CellType.STRING) {
			data=cellObj.getStringCellValue();	
		}else if(cellObj.getCellType()==CellType.NUMERIC) {
			Double dbl=cellObj.getNumericCellValue();
			Integer intData=dbl.intValue();
			data=intData.toString();
		}
		return data;
	}
	
	
	
	public int getRowNumberByTestCaseID(Sheet sheetobj,String tcID) {
		//below lines will search for testcaase id in data sheet
		//and give row number where data exist
		int tcRowNumber=-1;
		int rowcount=sheetobj.getLastRowNum();
		for(int i=1;i<=rowcount;i++) {
			Row rowobj=sheetobj.getRow(i);
			Cell cellobj=rowobj.getCell(1);
			String cellData=cellobj.getStringCellValue();
			System.out.println(cellData);
			if(cellData.trim().equalsIgnoreCase(tcID)) {
				tcRowNumber=i;
				break;	
			}	
		}
		return tcRowNumber;
	}

}
