package SeleniumFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class PIMPage extends AbstractComponents {
    
	WebDriver driver;
	
	public PIMPage(WebDriver driver){
		//Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="middleName")
	WebElement middlename;
	
	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement empID;
	
	@FindBy(css="button[type='submit']")
	WebElement Save;
	
	
	public   EmployeeList addNewEmployee(String fName, String mName, String lName, String empId) {
		
				
		waitForloaderToDisappear();
		
		firstname.sendKeys(fName);
		middlename.sendKeys(mName);
		lastname.sendKeys(lName);
		empID.sendKeys(empId);
		
		//waitForloaderToDisappear();
		Save.click();
		
		
		return new EmployeeList(driver);
		
		
	}
	
	
}
