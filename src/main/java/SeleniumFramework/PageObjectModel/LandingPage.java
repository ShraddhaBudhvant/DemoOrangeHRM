package SeleniumFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class LandingPage extends AbstractComponents {
     
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passwordEle;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement sumit;
	
	@FindBy(xpath="(//span[normalize-space()='PIM'])[1]")
	WebElement PimModule;
	
	@FindBy(css=".oxd-alert--error")
	WebElement ErrorMsg;

	public PIMPage LoginApplication(String username, String Password)  {
		userName.sendKeys(username);
		passwordEle.sendKeys(Password);
		sumit.click();
		PimModule.click();
		
		PIMPage pim = new PIMPage (driver);
		return pim;
	
		
		
		
	}
	
	public String getErrorMassage() {
		waitForWebElementToAppear(ErrorMsg);
		
		return ErrorMsg.getText();
	}
	
	public void goTo(){
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
}







