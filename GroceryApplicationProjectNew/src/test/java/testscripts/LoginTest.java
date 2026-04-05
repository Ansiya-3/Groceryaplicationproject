package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {

	@Test(priority = 1, description = "Validating user login with valid credentials", groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameField(userName);
		login.enterPasswordNameOnPasswordTextField(password);
		login.clickLoginButton();
		boolean dashboardDisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Constant.ValidCredsError);
	}

	@Test(priority = 2, description = "Validating user login with invalid username")
	public void verifyUserLoginWithInvalidUserName() throws IOException {
		String userName = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameField(userName);
		login.enterPasswordNameOnPasswordTextField(password);
		login.clickLoginButton();
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.InvalidUsernameError);
	}

	@Test(priority = 3, description = "Validating user login with invalid password")
	public void verifyUserLoginWithInvalidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameField(userName);
		login.enterPasswordNameOnPasswordTextField(password);
		login.clickLoginButton();
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.InvalidPasswordError);
	}

	@Test(priority = 4, description = "Validating user login with invalid credentials", 
			groups = {"smoke"}, dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidCredentials(String userName, String password) {
		//Direct Read from Excel not used now as we are getting data from DataProvider
				//String userName = ExcelUtility.readStringData(3, 0, "LoginPage");
				//String password = ExcelUtility.readStringData(3, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUserNameField(userName);
		login.enterPasswordNameOnPasswordTextField(password);
		login.clickLoginButton();

		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.InvalidCredsError);
	}


@DataProvider(name = "loginProvider") 
public Object[][] getDataFromDataProvider() throws IOException 
{	 
	 //Data provider input values shared by user
	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }}; 
	//Data provider input values taken from excel sheet
	//return new Object[][] { new Object[] {ExcelUtility.readStringData(3, 0, "LoginPage"),ExcelUtility.readStringData(3, 1, "LoginPage")}}; 		
}
}