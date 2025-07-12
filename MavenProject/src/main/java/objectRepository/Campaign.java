package objectRepository;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Campaign {
	
	WebDriver driver;
	public Campaign(WebDriver driver) {
		this.driver= driver;//pointing towards same address
		PageFactory.initElements(driver,this); }//initializes @Findby
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement Createcampaign;
	
	@FindBy(name ="campaignName")
	private WebElement Cname;
	
	@FindBy(name="targetSize")
	private WebElement Ctargetsize;
	@FindBy (name="expectedCloseDate")
	private WebElement Cdate;
	
	public WebElement getCreatecampaign() {
		return Createcampaign;
	}


	@FindBy(name="campaignStatus") 
	private WebElement Cstatus;
	
	@FindBy(xpath= "//button[@type='submit']")
	private WebElement Submitcampaign;
	
	public WebElement getSubmitcreatecampaig() {
		return Submitcampaign;
	}
	
	public WebElement getCstatus() {
		return Cstatus;
	}

	public WebElement getCname() {
		return Cname;
	}


	public WebElement getCtargetsize() {
		return Ctargetsize;
	}


	public WebElement getCdate() {
		return Cdate;
	}
   
	
	public void createCam() {
		Createcampaign.click();
	}
	
	public void CreateACampaign(String CAMname, String Targetsize,int randomnumder,String date) {
	
		Cname.sendKeys(CAMname+randomnumder);
		
        Ctargetsize.sendKeys(Targetsize);
        
       Cdate.sendKeys(date);
       
	   Submitcampaign.click();
		
		
	}
	
	public String validation() {
	
	WebElement toastmsg= driver.findElement(By.xpath("//div[@role='alert']")); 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(toastmsg));
	String msg= toastmsg.getText();
	 return msg;
	
	
	}
	

}
