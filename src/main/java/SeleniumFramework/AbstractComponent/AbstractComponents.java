package SeleniumFramework.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFramework.PageObjectModel.EmployeeList;
import SeleniumFramework.PageObjectModel.PIMPage;

//import SeleniumFramework.PageObjectModel.CartPage;
//import SeleniumFramework.PageObjectModel.OrdersPage;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {

		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	//div.oxd-form-loader

	@FindBy(id="oxd-toaster_1")
	WebElement toaster;

	@FindBy(css="div.oxd-form-loader")
	WebElement loader;

	@FindBy(xpath="(//span[normalize-space()='PIM'])[1]")
	WebElement PimModule;

	@FindBy(xpath="//a[normalize-space()='Employee List']")
	WebElement EmpList;

	@FindBy(xpath="//header[@class='oxd-topbar']//li[3]")
	WebElement AddEmpBtn;

	

	public PIMPage goToPIMModule() {
		PimModule.click();
		PIMPage pim = new PIMPage(driver);
		return pim;
	}

	public EmployeeList goTOEmpList() {
		EmpList.click();
		EmployeeList eList =new EmployeeList(driver);
		return eList;
	}

	public void goToAddEmp() {
		waitForElementToDisappear(loader);
		waitForWebElementToAppear(AddEmpBtn);

		AddEmpBtn.click();

	}

	

	public String VerificationText() {

		waitForWebElementToAppear(toaster);
		return toaster.getText();

	}


	public void waitForWebElementToClick(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}


	public void waitForElementToAppear (By findBy){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToAppear (WebElement ele){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void waitForWebElementToAppear (List<WebElement> list){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));

	}

	public void scrollPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

	}



	public void waitForElementToDisappear(WebElement ele){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void waitForloaderToDisappear(){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.oxd-form-loader")));
	}
}
