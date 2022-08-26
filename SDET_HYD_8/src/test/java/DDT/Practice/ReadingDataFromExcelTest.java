package DDT.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadingDataFromExcelTest {

	@Test
	public void readDataFromExcel() throws Throwable
	{
		FileInputStream fis=new FileInputStream("./EmpDataBook.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet1");
		Row r = s.getRow(4);
		Cell c = r.getCell(1);
		String value = c.getStringCellValue();
		System.out.println(value);
	}

}
