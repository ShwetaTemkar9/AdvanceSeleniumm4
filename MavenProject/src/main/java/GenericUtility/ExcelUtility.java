package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	 public String getdataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException   {
		FileInputStream fis = new FileInputStream("./ConfigFiles/CampaignDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
       }

	public int getRowCount(String sheet) throws IOException {
		FileInputStream fis = new FileInputStream("./ConfigFiles/CampaignDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownum = wb.getSheet(sheet).getLastRowNum();
		return rownum;
		
		public String GetLeads (int row,int col) {
			FileInputStream fis1 = new FileInputStream("C:\\Users\\siddh\\Desktop\\DDT\\CRMdetails.xlsx");
			Workbook wb1 = WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("Leads");
			int rownum1= sh.getLastRowNum();
			int column= sh.getRow(row).getLastCellNum();
			
			String data=sh.getRow(row).getCell(col).getStringCellValue();
			return data;
		/*	//for (int i = 0; i< column ; i++) {
				String leadname= sh.getRow(1).getCell(0).getStringCellValue()
			*/
		}

		//Excel utility for read and write

	}

}
