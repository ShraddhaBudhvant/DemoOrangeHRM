package SeleniumFramework.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.PageObjectModel.EmployeeList;
import SeleniumFramework.PageObjectModel.LandingPage;
import SeleniumFramework.PageObjectModel.PIMPage;
import SeleniumFramework.TestComponent.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test (dataProvider="getLoginData", priority=1)
	public void CheckLoginCredentials(HashMap<String, String> input) {
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication(input.get("username"), input.get("Password"));
		String ErrorMsg= LandingPage.getErrorMassage();
		Assert.assertTrue(ErrorMsg.contains("Invalid credentials"));
}
	
	@Test (priority=2)
	public void VerifyEditEmployeeDetails() throws InterruptedException {
		
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication("Admin", "admin123");

		PIMPage pim = new PIMPage(driver);
		pim.goToPIMModule();
		
		EmployeeList eList =new EmployeeList(driver);
		eList.goTOEmpList();
		eList.SearchEmployee("Shivanjali");
		
		String verText=eList.VerificationText();
		Assert.assertTrue( verText.contains("No Records Found"));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] getLoginData() throws IOException {			

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\data\\LoginCredentials.json");
		return new Object[][]{{data.get(1)}};
	}
}
