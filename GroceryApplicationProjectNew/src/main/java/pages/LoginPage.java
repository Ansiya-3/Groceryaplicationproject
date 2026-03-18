package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements (driver ,this);
	}
	@FindBy(name="username")WebElement usernametextField;
	@FindBy(name="password") WebElement passwordtextField;
	@FindBy(xpath="//button[text()='Sign In']") WebElement loginButton;
	
	public void enterUserNameField(String username)
	{
		usernametextField.sendKeys(username);
	}
	public void enterPasswordNameOnPasswordTextField(String password)
	{
		passwordtextField.sendKeys(password);
	}
	public void LoginClick()
	{
		loginButton.click();
	}
	}
	
	

		
	
