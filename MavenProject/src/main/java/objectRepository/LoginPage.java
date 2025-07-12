package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Constructer creator
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;//pointing towards same address
		PageFactory.initElements(driver,this);//initializes @Findby
		
		
	}
	//AutoHealing implementation
	@FindAll({@FindBy(id="username"),@FindBy(name="username")})
	private  WebElement usernamef;
	
	@FindBy (name="password")
	private WebElement passwordf;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement submitb;
	
	
	//accessing webelements using getters
	

	public WebElement getUsernamef() {
		return usernamef;
	}

	public WebElement getPassword() {
		return passwordf;
	}

	public WebElement getSubmitb() {
		return submitb;
	}

	public void LoginAction(String username,String password) {
		//method to  login
		usernamef.sendKeys(username);
		passwordf.sendKeys(password);
		submitb.click();
		
	}
}
