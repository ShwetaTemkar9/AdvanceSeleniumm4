package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}

	@FindBy(xpath = "//span[text() = 'Create Campaign']") // span[text() = 'Create Campaign']
	private WebElement CreateCampaign;

	public WebElement getCreateCampaign() {
		return CreateCampaign;
	}

	public void CreateACampaignBtn() {
		CreateCampaign.click();
	}

	@FindBy(linkText = "Leads")
	private WebElement leads;

	public WebElement getLeads() {
		return leads;
	}
	
	public void LeadsTab() {
		leads.click();
	}
	
}
