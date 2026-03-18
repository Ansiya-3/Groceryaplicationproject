package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase{
	@Test
	public void verifyUserLoginValidCredentials() throws IOException
	{
		
		String username = ExcelUtility.readStringData(10, 0 );
		String password = ExcelUtility.readStringData(0, 1);
		LoginPage  login = new LoginPage(driver);
		login.enterUserNameField(username);
		login.enterPasswordNameOnPasswordTextField(password);
		login.LoginClick();
		
		
	}
	@Test
	public void verifyUserLoginInvalidCredentials() throws IOException
	{
		{
			String username = ExcelUtility.readStringData(1, 0);
			String password = ExcelUtility.readStringData(1, 1);
			LoginPage  login = new LoginPage(driver);
			login.enterUserNameField(username);
			login.enterPasswordNameOnPasswordTextField(password);
			login.LoginClick();
			
		}
	}
	@Test
	public void verifyUserLoginvalidUserNameInvalidPassword() throws IOException
	{
		{
			String username = ExcelUtility.readStringData(2, 0);
			String password = ExcelUtility.readStringData(2, 1);
			LoginPage  login = new LoginPage(driver);
			login.enterUserNameField(username);
			login.enterPasswordNameOnPasswordTextField(password);
			login.LoginClick();
		}
	}
	@Test
	public void verifyUserLoginInvalidUserNameValidPassword() throws IOException
	{
		{
			String username = ExcelUtility.readStringData(3, 0);
			String password = ExcelUtility.readStringData(3, 1);
			LoginPage  login = new LoginPage(driver);
			login.enterUserNameField(username);
			login.enterPasswordNameOnPasswordTextField(password);
			login.LoginClick();
		}
	}


}