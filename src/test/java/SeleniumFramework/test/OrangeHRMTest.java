package SeleniumFramework.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.PageObjectModel.EmployeeList;
import SeleniumFramework.PageObjectModel.LandingPage;
import SeleniumFramework.PageObjectModel.LogoutPage;
import SeleniumFramework.PageObjectModel.PIMPage;
import SeleniumFramework.PageObjectModel.TerminateEmp;
import SeleniumFramework.TestComponent.BaseTest;
//retryAnalyzer= SeleniumFramework.TestComponent.Retry.class

public class OrangeHRMTest extends BaseTest {
	
	@Test (dataProvider="getLoginData")
	public void CheckLoginCredentials(HashMap<String, String> input) {
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication(input.get("username"), input.get("Password"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}

	@Test(dataProvider="getData", priority=1)
	public void addNewEMP(HashMap<String, String> input) throws InterruptedException, IOException {

		
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication("Admin", "admin123");

		PIMPage pim = new PIMPage(driver);
		pim.goToPIMModule();
		pim.goToAddEmp();
		pim.addNewEmployee(input.get("fName"), input.get("mName"), input.get("lName"), input.get("empId"));
		String suceedText=pim.VerificationText();
		Assert.assertTrue( suceedText.contains("Success"));
		
		
	}
	
	@Test (priority=2)
	public void VerifyEditEmployeeDetails() throws InterruptedException {
		
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication("Admin", "admin123");

		PIMPage pim = new PIMPage(driver);
		pim.goToPIMModule();
		
		EmployeeList eList =new EmployeeList(driver);
		eList.goTOEmpList();
		eList.SearchEmployee("Shraddha");
		eList.EditEmpDetails();
		eList.goToJobDetails();
		
		eList.AddJobDetails("2023-01-04");
		
		String suceedText=eList.VerificationText();
		Assert.assertTrue( suceedText.contains("Success"));
		
		
		
	}

	@Test (dataProvider="getTermDetails", priority=3)
    public void VerifyTerminateEmp(HashMap<String, String> input) {
    	LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication("Admin", "admin123");

		PIMPage pim = new PIMPage(driver);
		pim.goToPIMModule();
		
		EmployeeList eList =new EmployeeList(driver);
		eList.goTOEmpList();
		eList.SearchEmployee(input.get("empName"));
		eList.EditEmpDetails();
		eList.goToJobDetails();
		eList.scrollPage();
		
		TerminateEmp terminateEmp = new TerminateEmp(driver);
		terminateEmp.termEmp(input.get("terminationDate"),input.get("terminationReasonNote"));
		
		String suceedText=eList.VerificationText();
		Assert.assertTrue( suceedText.contains("Success"));
		
    }
    
   @Test (priority=4)
    public void verifyEmployeeLogout() throws InterruptedException 
    {
    	LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication("Admin", "admin123");
		
		LogoutPage lg = new LogoutPage(driver);
		lg.logoutEmp();
		String loginText= lg.verifyLogout();
		
		Assert.assertTrue( loginText.contains("Login"));
    }

    
    
    
    
    
    
    
    
   
    
    
    
    
    
	@DataProvider
	public Object[][] getData() throws IOException {			

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\data\\employeeInfo.json");
		return new Object[][]{{data.get(0)}};

	}

	@DataProvider
	public Object[][] getLoginData() throws IOException {			

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\data\\LoginCredentials.json");
		return new Object[][]{{data.get(0)}};

	}
	
	@DataProvider
	public Object[][] getTermDetails() throws IOException {			

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\data\\terminationDetails.json");
		return new Object[][]{{data.get(0)}};

	}
}
