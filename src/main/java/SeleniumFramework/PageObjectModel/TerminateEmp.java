package SeleniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class TerminateEmp extends AbstractComponents{
	WebDriver driver;
	
	public TerminateEmp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
		
		//WebElement terVerify =driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2'])[1]"));*/
	
	@FindBy(xpath="//button[normalize-space()='Terminate Employment']")
	WebElement termEmpBtn;
	
	@FindBy(xpath="(//input[@placeholder='yyyy-dd-mm'])[2]")
	WebElement EndDate;
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[6]")
	WebElement termReasonDropDown;
	
	@FindBy(xpath="//div[@role='listbox']")
	List<WebElement> Listbox ;
	
	@FindBy(xpath="//textarea[@placeholder='Type here']")
	WebElement TermNote;
	
	@FindBy(xpath="(//button[@type='submit'][normalize-space()='Save'])[2]")
	WebElement submit;
	
	@FindBy(xpath="(//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2'])[1]")
	WebElement terVerify;
	
	public EmployeeList termEmp(String note, String EDate) {
		termEmpBtn.click();
		EndDate.sendKeys(EDate);
		termReasonDropDown.click(); Listbox.get(0).click();
		TermNote.sendKeys(note);
		submit.click();
		
		EmployeeList eList =new EmployeeList(driver);
		return eList;
	}
	
	public String verifyEmpTermination() {
		 
		return terVerify.getText();
	}
}







