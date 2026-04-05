package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v141.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement usernametextField;
	@FindBy(name = "password")
	WebElement passwordtextField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginButton;
	@FindBy(xpath = "//p[text() = 'Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement pageText;
	public void enterUserNameField(String username) {
		usernametextField.sendKeys(username);
	}

	public void enterPasswordNameOnPasswordTextField(String password) {
		passwordtextField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	public String getPageText() { 
		return pageText.getText();
}
}