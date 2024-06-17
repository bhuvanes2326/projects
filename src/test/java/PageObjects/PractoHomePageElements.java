package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PractoHomePageElements extends BasePage{
	
	public PractoHomePageElements(WebDriver driver)
	{
		super(driver);
	}
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	//Locators for HomePage Elements
	@FindBy(xpath="//span[@class='practo-logo']//i[@class='practo_logo_new']")
	WebElement logo_icon;
	
	@FindBy(xpath="//a[@class='btn-border nav-login nav-interact ']")
	WebElement login_button;
	
	@FindBy(xpath="//div[@class='downloads']")
	WebElement download_option;
	
	@FindBy(xpath="//span[text()='Wellness Plans']")
	WebElement wellness_plan;
	
	@FindBy(xpath="//header[@id='header']//input[@id='name']")
	WebElement user_name;
	
	@FindBy(xpath="//header[@id='header']//input[@id='organizationName']")
	WebElement organization_name;
	
	@FindBy(xpath="//header[@id='header']//input[@id='contactNumber']")
	WebElement contact_no;
	
	@FindBy(xpath="//header[@id='header']//input[@id='officialEmailId']")
	WebElement official_emailId;
	
	@FindBy(xpath="//header[@id='header']//select[@id='organizationSize']")
	WebElement organization_size;
	
	@FindBy(xpath="//header[@id='header']//select[@id='interestedIn']")
	WebElement InterestedIn;
	
	@FindBy(xpath="//header[@id='header']//button[@type='submit']")
	WebElement submit_button;
	
	@FindBy(xpath="//div[@class='ReactModalPortal'][1]/div/div/div/div[1]")
	WebElement txt_confirm;
	
	public boolean isLogoPresent()
	{
		BasePage.highlightElement(jse, logo_icon);
		return logo_icon.isDisplayed();
	}
	
	public boolean isLoginButtonPresent()
	{
		BasePage.highlightElement(jse, login_button);
		return login_button.isDisplayed();
	}
	
	public boolean isDownloadPresent()
	{
		
		jse.executeScript("arguments[0].scrollIntoView(true);",download_option);
		WebElement dwnld=wait.until(ExpectedConditions.visibilityOf(download_option));
		BasePage.highlightElement(jse, dwnld);
		return dwnld.isDisplayed();
	}
	public void corporateWellnessAction()
	{
		wellness_plan.click();
		Set<String>windows=driver.getWindowHandles();
		List<String> windowId=new ArrayList<>(windows);
		driver.switchTo().window(windowId.get(1));
	
	}
	public void user_name(String Name)
	{
		user_name.sendKeys(Name);
	}
	public void orga_Name(String org_Name)
	{
		organization_name.sendKeys(org_Name);
	}
	public void phone_no(String pno)
	{
		contact_no.sendKeys(pno);
	}
	public void email_id(String email)
	{
		official_emailId.sendKeys(email);
	}
	public void orga_size(String org_size)
	{
		Select orgs_size=new Select(organization_size);
		orgs_size.selectByVisibleText(org_size);
	}
	public void user_Interest(String interest)
	{
		Select sl_interest=new Select(InterestedIn);
		sl_interest.selectByVisibleText(interest);
	}
	public WebElement submit_element()
	{
		WebElement submit_button_wait=wait.until(ExpectedConditions.visibilityOf(submit_button));
		return submit_button_wait;
	}
	public void submitAction()
	{
		submit_button.click();
	}
	
	public String confirmMessage()
	{
		WebElement confirm_msg=wait.until(ExpectedConditions.visibilityOf(txt_confirm));
		return confirm_msg.getText();
	}
	
}
