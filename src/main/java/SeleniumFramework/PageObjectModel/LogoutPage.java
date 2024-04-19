package SeleniumFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class LogoutPage extends AbstractComponents {
	
	
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".orangehrm-dialog-modal")
	WebElement terminationModalBox;

	@FindBy(css=".oxd-userdropdown")
	WebElement profileHeader;

	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logoutBtn;
	
	@FindBy(css=".orangehrm-login-title")
	WebElement LoginTitle;
	
	public void logoutEmp() throws InterruptedException {

		waitForElementToDisappear(terminationModalBox);
		profileHeader.click();
		waitForWebElementToAppear(logoutBtn);
		logoutBtn.click();
	}
	
	public String verifyLogout() {
		return LoginTitle.getText();
	}
	
	
}
