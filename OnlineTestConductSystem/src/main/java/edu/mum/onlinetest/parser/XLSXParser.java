package edu.mum.onlinetest.parser;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXParser {
	public List<List<String>> getQuestions(String fileName){
		List<List<String>> listOfQues = new ArrayList<List<String>>();
		FileInputStream fis = null;
		try {
			String filePath = System.getProperty("catalina.home") + File.separator + "onlinetestconductsystem"
					+ File.separator + "questions" + File.separator;
			System.out.println("=====================" + filePath);
			 String extension = FilenameUtils.getExtension(fileName);
	           
			File myFile = new File(filePath + fileName);
			if(myFile.exists() && "xlsx".equalsIgnoreCase(extension.trim())){
				fis = new FileInputStream(myFile);
	
				// Finds the workbook instance for XLSX file
				XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
	
				// Return first sheet from the XLSX workbook
				XSSFSheet mySheet = myWorkBook.getSheetAt(0);
	
				// Get iterator to all the rows in current sheet
				Iterator<Row> rowIterator = mySheet.rowIterator();
	
				// Traversing over each row of XLSX file
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					List<String> singleQuesList = new ArrayList<>();
					// For each row, iterate through each columns
					Iterator<Cell> cellIterator = row.cellIterator();
					
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if(cell.getStringCellValue() != null){
							singleQuesList.add(cell.getStringCellValue());
							System.out.println(cell.getStringCellValue() + "\t");
							}
							break;
						case Cell.CELL_TYPE_NUMERIC:
							String str = NumberToTextConverter.toText(cell.getNumericCellValue());
							singleQuesList.add(str);
							System.out.println(str + "\t");
							break;
						case Cell.CELL_TYPE_BOOLEAN:
//							
							String str1 = Boolean.toString(cell.getBooleanCellValue());
							singleQuesList.add(str1);
							System.out.println(cell.getBooleanCellValue() + "\t");
							break;
						default:
						}
					}
					listOfQues.add(singleQuesList);
	
					System.out.println("");
	
				}
				
				
				((Closeable) myWorkBook).close();
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listOfQues;
	}

}