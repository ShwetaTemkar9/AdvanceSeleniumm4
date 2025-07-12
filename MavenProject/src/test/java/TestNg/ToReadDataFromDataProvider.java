package TestNg;

import java.lang.annotation.Target;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToReadDataFromDataProvider {

	@DataProvider
	public Object[][] getStudentDetails(){
	
		Object[][] objArry = new Object[5][2];
	objArry[0][0]="Sita";
	objArry[0][1]="Chicken";
	objArry[1][0]="Shweta";
	objArry[1][1]="Panner Tikka";
	objArry[2][0]="Sneha";
	objArry[2][1]="GulabJamun";
	objArry[3][0]="Prashant";
	objArry[3][1]="Prawns Curry";
	objArry[4][0]="Umashankar";
	objArry[4][1]="Mutton";
	return objArry;
	
	}
	@Test(dataProvider = "getStudentDetails")
	public void studentDetails(String name ,String food) {
	System.out.println("Name:"+name+"\t"+food);
}
}