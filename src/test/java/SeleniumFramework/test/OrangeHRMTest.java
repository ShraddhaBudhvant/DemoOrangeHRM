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


public class OrangeHRMTest extends BaseTest {
	//retryAnalyzer= SeleniumFramework.TestComponent.Retry.class

	String terminationReasonNote ="The process ended due to completion of its task, "
			+ "user interruption, error, or intentional termination by the system or user.";


	@Test (dataProvider="getLoginData")

	public void CheckLoginCredentials(HashMap<String, String> input) {
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication(input.get("username"), input.get("Password"));

	}

	@Test(dataProvider="getData")

	public void addNewEMP(HashMap<String, String> input) throws InterruptedException, IOException {

		
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication(input.get("username"), input.get("Password"));

		PIMPage pim = new PIMPage(driver);
		pim.goToPIMModule();
		pim.goToAddEmp();
		pim.addNewEmployee(input.get("fName"), input.get("mName"), input.get("lName"), input.get("empId"));
		String suceedText=pim.VerifySucceedText();
		Assert.assertTrue( suceedText.contains("Success"));
		
		
	}
	
	@Test 
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
		
		String suceedText=eList.VerifySucceedText();
		Assert.assertTrue( suceedText.contains("Success"));
		
		
		
	}

	@Test
    public void VerifyTerminateEmp() {
    	LandingPage LandingPage= new LandingPage(driver);
		LandingPage.LoginApplication("Admin", "admin123");

		PIMPage pim = new PIMPage(driver);
		pim.goToPIMModule();
		
		EmployeeList eList =new EmployeeList(driver);
		eList.goTOEmpList();
		eList.SearchEmployee("Shraddha");
		eList.EditEmpDetails();
		eList.goToJobDetails();
		eList.scrollPage();
		
		TerminateEmp terminateEmp = new TerminateEmp(driver);
		terminateEmp.termEmp(terminationReasonNote, "2024-01-04");
		
		String suceedText=eList.VerifySucceedText();
		Assert.assertTrue( suceedText.contains("Success"));
		
    }
    
   @Test
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
		return new Object[][]{{data.get(0)},{data.get(1)}};

	}


}
