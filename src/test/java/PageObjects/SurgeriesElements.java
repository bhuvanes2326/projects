package PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurgeriesElements extends BasePage{
	
	public SurgeriesElements(WebDriver driver)
	{
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	//Locators for Surgeries Function elements
	@FindBy(xpath="//div[text()='Surgeries']")
	WebElement surgeries_element;
	
	@FindBy(xpath="//div[@class='flex items-center gap-12px']/h1")
	WebElement care_no;
	
	@FindBy(xpath="//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> surgeries_list;
	
	@FindBy(xpath="//h1[@class='text-module_base__1vdUh text-16px font-bold text-black']")
	List<WebElement> departments;
	
	@FindBy(xpath="//h1[@class='list-module_sizeSmallItemContentTitle__kaSwM list-module_itemContentTitle__XreVD text-gray-2']")
	List<WebElement> benifits_element;
	
	
	
	public void surgeriesAction()
	{
		surgeries_element.click();
	}
	
	public String practoCare()
	{
		return care_no.getText();
	}
	
	public List<WebElement> popularSurgeries()
	{
		js.executeScript("window.scrollBy(0,600);","");
		return surgeries_list;
	}
	
	public List<WebElement> ourDepartments()
	{
		return departments;
	}
	
	public List<WebElement> practoCareBenifits()
	{
		return benifits_element;
	}
	
}
