package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class extraerDatos {
	static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell cell;	
 
	static String datos[][]= new String[4][5];
	
	 public static String[][] llenandoDatos() throws IOException{
		  // Import excel sheet.
		  File src=new File("D:\\test2.xlsx");   
		  // Load the file.
		  FileInputStream fis = new FileInputStream(src);
		  // Load he workbook.
		  workbook = new XSSFWorkbook(fis);
		  // Load the sheet in which data is stored.
		  sheet= workbook.getSheetAt(0);
		  System.out.println("tamaño: "+sheet.getLastRowNum());
		  for(int i=1; i<sheet.getLastRowNum(); i++){		  
			  System.out.println(i);
			  cell = sheet.getRow(i).getCell(0);
			  cell.getCellType();		  
			  datos[i][0]=""+cell.getStringCellValue();
			  System.out.println(datos[i][0]);
			  
			  cell = sheet.getRow(i).getCell(1);
			  cell.getCellType();		  
			  datos[i][1]=""+cell.getStringCellValue();
			  System.out.println(datos[i][1]);
			  
			  cell = sheet.getRow(i).getCell(2);
			  cell.getCellType();		  
			  datos[i][2]=""+cell.getStringCellValue();
			  System.out.println(datos[i][2]);
			  
			  cell = sheet.getRow(i).getCell(3);
			  cell.getCellType();		  
			  datos[i][3]=""+cell.getStringCellValue();
			  System.out.println(datos[i][3]);
			  
			  cell = sheet.getRow(i).getCell(4);
			  cell.getCellType();		  
			  datos[i][4]="ca"+cell.getStringCellValue();
			  System.out.println(datos[i][4]);
			 /*
			  cell = sheet.getRow(i).getCell(5);		  
			  cell.getCellType();		  
			  datos[i][5]=cell.getStringCellValue();
			  System.out.println(datos[i][5]);*/
		  }
		  return datos;
	  }

	
}
