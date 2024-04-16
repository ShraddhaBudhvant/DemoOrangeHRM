package SeleniumFramework.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import SeleniumFramework.PageObjectModel.CartPage;
//import SeleniumFramework.PageObjectModel.OrdersPage;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {

		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	

	
	public void waitForElementToAppear (By findBy){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
