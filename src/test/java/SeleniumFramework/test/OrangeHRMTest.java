package SeleniumFramework.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.PageObjectModel.EmployeeList;
import SeleniumFramework.PageObjectModel.PIMPage;
import SeleniumFramework.PageObjectModel.TerminateEmp;
import SeleniumFramework.TestComponent.BaseTest;

public class OrangeHRMTest extends BaseTest {

//	public static void main(String[] args) throws InterruptedException, IOException {
		
		//retryAnalyzer= SeleniumFramework.TestComponent.Retry.class
	
			@Test(dataProvider="getData", groups= "Parches", retryAnalyzer= SeleniumFramework.TestComponent.Retry.class)
			public void addNewEMP(HashMap<String, String> input) throws InterruptedException {
				
			String terminationReasonNote ="\"\\\"The process ended due to completion of its task, user \"\r\n"
						+ "				+ \"interruption, error, or intentional termination by the system or user.\\\"\"";
				
			PIMPage pim= LandingPage.LoginApplication(input.get("username"), input.get("Password"));
			EmployeeList eList = pim.addEmployee(input.get("fName"), input.get("mName"), input.get("lName"), input.get("empId"));// add new employee
			eList.goToJobDetails("2023-01-04");
			
			TerminateEmp terminateEmp = new TerminateEmp(driver);
			terminateEmp.termEmp(terminationReasonNote, "2024-01-04");
			
			pim.logoutEmp();
			
			
			
			}
			
			
			//@Test
		/*	public void modifyEmp () {
				PIMPage pim= LandingPage.LoginApplication("Admin", "admin123");
				ModifyEmpDetails med = new ModifyEmpDetails(driver);
				med.editEmpJobDetails("shraddha1", "2023-01-04");
				
			}*/
			
		
			
			
			
			
			
		
			@DataProvider
			public Object[][] getData() throws IOException {			
				
				List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\data\\employeeInfo.json");
				return new Object[][]{{data.get(0)}};
				
			}
			
	
	
	
	
	
		
			/*WebElement terVerify =driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2'])[1]"));
		
		Assert.assertEquals(terVerify.getText(), "(Past Employee)");
		
	
		
		WebElement logOut= driver.findElement(By.xpath("(//h5[normalize-space()='Login'])[1]"));
		
		Assert.assertEquals(logOut.getText(), "Login");
		
	}*/

	}
