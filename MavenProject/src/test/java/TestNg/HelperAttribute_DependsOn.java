package TestNg;

import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_DependsOn {

	@Test(priority = 1,enabled = true)
	public void createAccount() {
		Reporter.log("Account created sucesssfully", true);

	}
	@Test(dependsOnMethods =createAccount())
	public void EditAccount() {
		Reporter.log("Account created sucesssfully",true);

	}
	@Test(dependsOnMethods = createAccount())
	public void DeleteAcoount(){
		Reporter.log("Account created sucesssfully",true);
	}
	
}
