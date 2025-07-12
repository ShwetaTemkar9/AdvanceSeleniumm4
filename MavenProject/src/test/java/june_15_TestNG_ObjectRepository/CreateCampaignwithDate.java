package june_15_TestNG_ObjectRepository;

import java.io.IOException;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
//import baseClass.BaseClass;
//import genericUtilities.ExcelUtilities;
//import genericUtilities.JavaUtilities;
import objectRepository.CampaignPage;
import objectRepository.HomePage;

public class CreateCampaignwithDate extends baseClass {
	@Test
	public void CreateCampaign_ORImplementation() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.CreateACampaignBtn();
		Thread.sleep(2000);

		ExcelUtility ExUtil = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
//		String campId = ExUtil.getDataFromExcel("Sheet1", 1, 0);
		String campName = ExUtil.getdataFromExcel("Sheet1", 1, 1);
		campName += ju.getRandomNumber();
		String campStatus = ExUtil.getdataFromExcel("Sheet1", 1, 2);
		String targetsize = ExUtil.getdataFromExcel("Sheet1", 1, 3);
		String expectedCloseDate = ExUtil.getdataFromExcel("Sheet1", 1, 4);
		String targetAudience = ExUtil.getdataFromExcel("Sheet1", 1, 5);
		String description = ExUtil.getdataFromExcel("Sheet1", 1, 6);
//		String status = ExUtil.getDataFromExcel("Sheet1", 1, 7);

		CampaignPage Cg = new CampaignPage(driver);
		Cg.CreateACampaignwithDate(campName, campStatus, targetsize, expectedCloseDate, targetAudience, description);

	}
}
