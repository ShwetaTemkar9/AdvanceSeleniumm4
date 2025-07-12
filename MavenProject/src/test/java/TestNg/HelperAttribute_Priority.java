package TestNg;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_Priority {

	
	//@Test to execute each test case in TestNG'
	//Make all methods to public in TestNG //Reporter.log is used as a print statement
	//return type of method should be void
	//PRIORITY is used to set the priority  of each test

	
	@Test(priority=1)
	public void Myntra() {
		Reporter.log("Myntra executed",true);
	}
	
	
	@Test(priority=8)
	public void Flipkart() {
		Reporter.log("Flipkart executed",true);
	}
	
	@Test(priority=2)
	public void Meshoo() {
		Reporter.log("Meshoo executed",true);
	}
	
	@Test(priority=6)
	public void Amazon() {
		Reporter.log("Amazon executed",true);
	}
	
	@Test(priority=-1)
	public void Ajio() {
		Reporter.log("Ajio executed",true);
	}
	
}
