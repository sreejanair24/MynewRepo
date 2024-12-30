package MavenPack;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	XSSFSheet sh;
	 public Excel() throws IOException {
		 FileInputStream f=new FileInputStream("C:\\Users\\sreej\\OneDrive\\Documents\\ExcelRead.xlsx");
		 XSSFWorkbook wb=new XSSFWorkbook(f);
		 sh=wb.getSheet("Sheet1");
	 }
	 public String read(int i, int j) 
	 {
			XSSFRow r=sh.getRow(i);
			Cell c=r.getCell(j);
			int cell=c.getCellType();
			switch(cell) 
			{
			case Cell.CELL_TYPE_NUMERIC:
			{
				double d=c.getNumericCellValue();
				return String.valueOf(d);
			}
			case Cell.CELL_TYPE_STRING:
			{
				return c.getStringCellValue();
			}
			}
			return null;

		}
	
}
