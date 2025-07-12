package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreatecellinExcel {
	public static void main(String[] args) throws IOException {

		// creating new cell in excel and writing in a new cell

		FileInputStream fis = new FileInputStream("C:\\Users\\siddh\\Desktop\\DDT\\CampaignDetails.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet("Sheet1");
		Row r = s1.getRow(1);

		Cell newcell = r.createCell(2);
		newcell.setCellType(CellType.STRING);

		FileOutputStream fos = new FileOutputStream("C:\\Users\\siddh\\Desktop\\DDT\\CampaignDetails.xlsx");

		newcell.setCellValue("PASS");
		Cell cell = r.createCell(3);
		cell.setCellValue("You are here");

		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();

		System.out.println("code executed");

	}
}
