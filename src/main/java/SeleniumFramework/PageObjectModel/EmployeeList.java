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

	//  //a[normalize-space()='Job']
	
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
	
	public void goToJobDetails(String JDate) {
		
		jobBtn.click();
		
		waitForWebElementToAppear(JoinedDate);
		JoinedDate.sendKeys(JDate);
		
		//waitForWebElementToAppear(Listbox);
		jobTitle.click(); Listbox.get(0).click();
		
		//waitForWebElementToAppear(Listbox);
		jobCategery.click(); Listbox.get(0).click();
		
		//waitForWebElementToAppear(Listbox);
		subUnit.click(); Listbox.get(0).click();
		
		//waitForWebElementToAppear(Listbox);
		jobLocation.click(); Listbox.get(0).click();
		
		//waitForWebElementToAppear(Listbox);
		EmpStatus.click(); Listbox.get(0).click();
		
		SaveModifiedInfo.click();
		
		
	}
	
	
}
