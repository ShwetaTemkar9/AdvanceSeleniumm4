package TestNg;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_Enabled {

	@Test(priority=1)
	public void Myntra() {
		Reporter.log("Myntra executed",true);
	}
	
	
	@Test(priority=8)
	public void Flipkart() {
		Reporter.log("Flipkart executed",true);
	}
	
	@Test(enabled = false)
	public void Meshoo() {
		Reporter.log("Meshoo executed",true);
	}
	
	@Test(enabled =false)
	public void Amazon() {
		Reporter.log("Amazon executed",true);
	}
	
	@Test(enabled = false,priority=7)
	public void Ajio() {
		Reporter.log("Ajio executed",true);
	}
	
}
