package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageElements extends BasePage{
	
	public SearchPageElements(WebDriver driver)
	{
		super(driver);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	//Locators for SearchPage Elements
	@FindBy(xpath="//input[@placeholder='Search location']")
	WebElement txt_searchCity;
	
	@FindBy(xpath="//i[@class='icon-ic_cross_solid']")
	WebElement clear_txt;
	
	@FindBy(xpath="//div[contains(text(),'Bangalore')]")
	WebElement city_element;
	
	@FindBy(xpath="//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
	WebElement txt_searchUserOptions;
	
	@FindBy(xpath="//div[@class='c-omni-suggestion-item']//span//div[text()='Hospital']")
	WebElement click_hospital;
	
	@FindBy(xpath="//h1[@class='title']")
	WebElement city_title;
	
	@FindBy(xpath="//span[@class='uv2-spacer--lg-left']")
	List<WebElement> hospitalsTimeDetails;
	
	@FindBy(xpath="//div[@class='c-estb-card']/descendant::a[1]")
	List<WebElement> hsptl_ttle;
	
	@FindBy(xpath="//div[@class='text-1']/span[@class='u-bold']")
	List<WebElement> ratingDetails;
	
	@FindBy(xpath="//div[@class='u-grey_3-text']/div/a/h3[starts-with(text(),'Hospitals in')]")
	List<WebElement> top_cities;
	
	public void searchActionCity(String city) throws InterruptedException
	{
		txt_searchCity.click();
		clear_txt.click();
		txt_searchCity.sendKeys(city);
		Thread.sleep(2000);
		city_element.click();
	}
	public void searchActionOption(String option) throws InterruptedException
	{
		txt_searchUserOptions.sendKeys(option);
		click_hospital.click();
		Thread.sleep(2000);
	}
	public String cityHospitalsTitle()
	{
		return city_title.getText();
	}
	
	public List<Integer> timeDetails() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,1600)", "");
		Thread.sleep(4000);
		
		int hsptl_size=hospitalsTimeDetails.size();
		List<Integer> hsptls_index=new ArrayList<>();
		
		System.out.println("Total hospitals: "+hsptl_size);
		int j=0;
		for(int i=0;i<hsptl_size;i++)
		{
			String openTime=hospitalsTimeDetails.get(i).getText();
			if(openTime.equals("MON - SUN 00:00AM - 11:59PM"))
				hsptls_index.add(i);
		}
		return hsptls_index;
	}
	public List<WebElement> hospitalName()
	{
		List<WebElement> hsptl_ttles=wait.until(ExpectedConditions.visibilityOfAllElements(hsptl_ttle));
		return hsptl_ttles;
	}
	
	public List<Integer> ratingDetails()
	{
		
		List<WebElement> ratingDetails_wait=wait.until(ExpectedConditions.visibilityOfAllElements(ratingDetails));
		
		int rating_size=ratingDetails_wait.size();
		List<Integer> rating_index=new ArrayList<>();
		
		for(int i=0;i<rating_size;i++)
		{
			Double rating_value=Double.parseDouble(ratingDetails_wait.get(i).getText());
			if(rating_value>3.5)
			{
				rating_index.add(i);
			}
		}
		return rating_index;
	}
	
	public List<WebElement> topCities()
	{
		return top_cities;
	}

}
