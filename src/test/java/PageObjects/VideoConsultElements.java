package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoConsultElements extends BasePage{
	
	public VideoConsultElements(WebDriver driver)
	{
		super(driver);
	}
		
	//Locators for Video Consult Function Elements
	@FindBy(xpath="//div[text()='Video Consult']")
	WebElement videoCon_element;
		
	@FindBy(xpath="//div[@class='content']//a[@class='link primary-button cta'][normalize-space()='Consult Now']")
	WebElement consult_button;
		
	@FindBy(xpath="//div[@id='TopSpecialityCardsContainer']/descendant::div[@class='content']/h4")
	List<WebElement> specialities_element;
		
	@FindBy(xpath="//div[@id='HealthProblemCardsContainer']/descendant::div[@class='content']/h4")
	List<WebElement> commonHealthConcerns;
		
	@FindBy(xpath="//div[@id='HealthProblemCardsContainer']/descendant::div[@class='content']/p")
	List<WebElement> healthConcernPrice;
		
	@FindBy(xpath="//div[@id='OfferCardsContainer']/descendant::div[@class='content']/h4")
	List<WebElement>offers;
		
	public void videoConsultAction()
	{
		videoCon_element.click();
	}
		
	public boolean isConsultEnabled()
	{
		return consult_button.isEnabled();
	}
	
	public List<WebElement> specialities()
	{
		return specialities_element;
	}
	public List<WebElement> commonHealthConcern()
	{
		return commonHealthConcerns;
	}
	 
	public List<WebElement> concernPrice()
	{
		return healthConcernPrice;
	}
	public List<WebElement> consultOffers()
	{
		return offers;
	}
}
