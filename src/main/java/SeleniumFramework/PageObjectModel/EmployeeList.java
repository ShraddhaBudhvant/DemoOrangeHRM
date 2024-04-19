package SeleniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class EmployeeList extends AbstractComponents {
	WebDriver driver;
	public EmployeeList(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement employeeName;
	
	@FindBy(css="button[type='submit']")
	WebElement empSearchBtn;
	
	@FindBy(css=".oxd-icon.bi-pencil-fill")
	WebElement empDetailEditBtn;
	
	@FindBy(xpath="//a[normalize-space()='Job']")
	WebElement jobBtn;
	
	@FindBy(css="input[placeholder='yyyy-dd-mm']")
	WebElement JoinedDate;
	
	@FindBy(xpath="(//div[contains(text(),'-- Select --')])[1]")
	WebElement jobTitle;
	
	@FindBy(xpath="//div[4]//div[1]//div[2]//div[1]//div[1]//div[1]")
	WebElement jobCategery;
	
	@FindBy(xpath="(//div)[73]")
	WebElement subUnit;
	
	@FindBy(xpath="(//div)[81]")
	WebElement jobLocation;
	
	@FindBy(xpath="(//div)[89]")
	WebElement EmpStatus;
	
	@FindBy(css=".oxd-select-dropdown")
	List<WebElement> Listbox;
	////div[@role='listbox']
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement SaveModifiedInfo;
	
	
	public void SearchEmployee(String empName) {
		employeeName.sendKeys(empName);
		empSearchBtn.click();
		waitForloaderToDisappear();
		scrollPage();
	}
	
	public void EditEmpDetails() {
		waitForWebElementToAppear(empDetailEditBtn);
		empDetailEditBtn.click();
	}
	
	
	public void goToJobDetails() {
		
		waitForloaderToDisappear();
		jobBtn.click();
	}
	
	public void AddJobDetails(String JDate) {
		waitForWebElementToAppear(JoinedDate);
		JoinedDate.sendKeys(JDate);
		
		jobTitle.click(); Listbox.get(0).click();
		jobCategery.click(); Listbox.get(0).click();
		subUnit.click(); Listbox.get(0).click();
		jobLocation.click(); Listbox.get(0).click();
		EmpStatus.click(); Listbox.get(0).click();
		
		SaveModifiedInfo.click();
		
	}
	
	
}
