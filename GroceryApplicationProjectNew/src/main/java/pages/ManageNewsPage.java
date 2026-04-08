package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class ManageNewsPage {
    public WebDriver driver;
   

    public ManageNewsPage (WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
 }
    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @onclick='click_button(1)']")
	static
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newNewsField;
	@FindBy(xpath = "//button[@name='create' and @class='btn btn-danger']")
	WebElement newNewsSaveButton;

	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement searchNewsField;
	@FindBy(xpath = "//button[@name='Search' and @class='btn btn-danger btn-fix']")
	WebElement searchNewsSubmitButton;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='btn btn-rounded btn-warning']")
	WebElement resetButton;
  
	
	public ManageNewsPage clickOnNewButton() 
	{
		newButton.click();
		return this;
	}

	public ManageNewsPage enterNewNewsOnManageNewsField(String newNewsText) 
	{
		newNewsField.sendKeys(newNewsText);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() 
	{
		newNewsSaveButton.click();
		return this;
	}

	public ManageNewsPage clickOnSearchButton() 
	{
		searchButton.click();
		return this;
	}

	public ManageNewsPage searchForANews(String searchNewsText) 
	{
		searchNewsField.sendKeys(searchNewsText);
		return this;
	}

	public ManageNewsPage clickOnSearchSubmitButton() 
	{
		searchNewsSubmitButton.click();
		return this;
	}

	public ManageNewsPage resetAction() 
	{
		resetButton.click();
		return this;
	}
	
	public boolean isNewManageNewsPageDisplayed() 
	{
		return newNewsSaveButton.isDisplayed();
	}

	public boolean isSearchManageNewsPagePageDisplayed() 
	{
		return searchNewsSubmitButton.isDisplayed();
	}
	
	
}