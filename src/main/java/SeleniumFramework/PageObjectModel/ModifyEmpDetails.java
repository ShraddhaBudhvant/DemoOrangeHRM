package SeleniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class ModifyEmpDetails extends AbstractComponents {

	WebDriver driver;
	public ModifyEmpDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	/*driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("Hinakshi");
	driver.findElement(By.cssSelector("button[type='submit']")).click();//search
	
	Thread.sleep(1000);
	WebElement editbutton=  driver.findElement(By.cssSelector(".oxd-icon.bi-pencil-fill"));
	editbutton.click();
	
	driver.findElement(By.cssSelector("div:nth-child(6) a:nth-child(1)")).click();//job
	Thread.sleep(1000);
	
	//Joined Date
	driver.findElement(By.xpath("//input[@placeholder='yyyy-dd-mm']")).sendKeys("2023-01-04");
	Thread.sleep(1000);
	
	//jobTitle
	driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[1]")).click();
	Thread.sleep(1000);
	List<WebElement> jobTitle = driver.findElements(By.xpath("//div[@role='listbox']"));
	jobTitle.get(0).click();
	Thread.sleep(1000);
	
	//jobCatagery
	driver.findElement(By.xpath("//div[4]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
	List<WebElement> jobCat = driver.findElements(By.xpath("//div[@role='listbox']"));
	jobCat.get(0).click();
	Thread.sleep(1000);
	
	//Sub Unit
	driver.findElement(By.xpath("(//div)[73]")).click();
	List<WebElement> subUnit = driver.findElements(By.xpath("//div[@role='listbox']"));
	subUnit.get(0).click();
	Thread.sleep(1000);
	
	//Location
	driver.findElement(By.xpath("(//div)[81]")).click();
	List<WebElement> location = driver.findElements(By.xpath("//div[@role='listbox']"));
	location.get(0).click();
	Thread.sleep(1000);
	
	//Employee status
	driver.findElement(By.xpath("(//div)[89]")).click();
	List<WebElement> empStatus = driver.findElements(By.xpath("//div[@role='listbox']"));
	empStatus.get(0).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();*/
	
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement employeeName;
	
	@FindBy(css="button[type='submit']")
	WebElement empSearchBtn;
	
	@FindBy(css=".oxd-icon.bi-pencil-fill")
	WebElement empDetailEditBtn;
	
	@FindBy(css="div:nth-child(6) a:nth-child(1)")
	WebElement JobInfo;
	
	@FindBy(xpath="//input[@placeholder='yyyy-dd-mm']")
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
	
	@FindBy(xpath="//div[@role='listbox']")
	List<WebElement> Listbox;
	
	@FindBy(xpath="//div[@role='listbox']")
	WebElement SaveModifiedInfo;
	
	
	public void editEmpJobDetails(String fName, String JDate) {
		employeeName.sendKeys(fName);
		empSearchBtn.click();
		scrollPage();
		
		waitForWebElementToAppear(empDetailEditBtn);
		empDetailEditBtn.click();
		JobInfo.click();
		JoinedDate.sendKeys(JDate);
		
		waitForWebElementToAppear(Listbox);
		jobTitle.click(); Listbox.get(0).click();
		
		waitForWebElementToAppear(Listbox);
		jobCategery.click(); Listbox.get(0).click();
		
		waitForWebElementToAppear(Listbox);
		subUnit.click(); Listbox.get(0).click();
		
		waitForWebElementToAppear(Listbox);
		jobLocation.click(); Listbox.get(0).click();
		
		waitForWebElementToAppear(Listbox);
		EmpStatus.click(); Listbox.get(0).click();
		
		SaveModifiedInfo.click();
		
	}
}






