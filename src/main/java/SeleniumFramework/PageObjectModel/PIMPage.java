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
	
	
	
	@FindBy(xpath="(//button[normalize-space()='Add'])[1]")
	WebElement AddBtn;
	
	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="middleName")
	WebElement middlename;
	
	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement empID;
	
	@FindBy(css="button[type='submit']")
	WebElement Add;
	// .orangehrm-dialog-modal
	
	@FindBy(css=".orangehrm-dialog-modal")
	WebElement terminationModalBox;
	
	@FindBy(css=".oxd-userdropdown")
	WebElement profileHeader;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logoutBtn;
	
	
	
	public EmployeeList addEmployee(String fName, String mName, String lName, String empId) {
		AddBtn.click();
		firstname.sendKeys(fName);
		middlename.sendKeys(mName);
		lastname.sendKeys(lName);
		empID.sendKeys(empId);
		
		Add.click();
		
		EmployeeList eList =new EmployeeList(driver);
				return eList;
	}
	
	public void logoutEmp() throws InterruptedException {
		
		waitForElementToDisappear(terminationModalBox);
		
		profileHeader.click();
		
		waitForWebElementToAppear(logoutBtn);
		
		logoutBtn.click();
	}
}
