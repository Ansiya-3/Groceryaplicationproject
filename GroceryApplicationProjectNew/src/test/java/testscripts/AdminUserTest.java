package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends TestNGBase {
	@Test(priority = 1, description = "Validate adding a new User")
	public void VerifyWhetherUserIsAbleToAddANewUser() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUserNameField(userName);
		login.enterPasswordNameOnPasswordTextField(password);
		login.clickLoginButton();
		HomePage clickUsersFile = new HomePage(driver);
		clickUsersFile.clickOnAdminUserTile();

		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnNewButton();
		adminUsersPage.enterNewUserNameOnUserNameField(userName);
		adminUsersPage.enterNewPasswordOnPasswordField(password);
		adminUsersPage.clickOnNewUserTypeDropDown();
		adminUsersPage.selectUserTypeFromUserTypeDropDown();
	}

	@Test(priority = 2, description = "Validate searching for a User")
	public void VerifyWhetherUserIsAbleToSearchForAUser() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterPasswordNameOnPasswordTextField(password);
		login.enterUserNameField(userName);
		login.clickLoginButton();

		HomePage clickUsersOption = new HomePage(driver);
		clickUsersOption.clickOnAdminUserTile();
		String newUserName = ExcelUtility.readStringData(0, 0, "AdminUsersPage");

		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnSearchButton();
		adminUsersPage.searchUsingUserName(newUserName);
		adminUsersPage.clickOnSearchUserTypeDropDown();
		adminUsersPage.selectFromSearchUserTypeDropDown();
	}

	@Test(priority = 3, description = "Validate resetting the data in Admin Users page")
	public void VerifyWhetherUserIsAbleToResetTheData() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUserNameField(userName);
		login.enterPasswordNameOnPasswordTextField(password);
		login.clickLoginButton();

		HomePage clickUsersOption = new HomePage(driver);
		clickUsersOption.clickOnAdminUserTile();

		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.resetAction();

	}
}
