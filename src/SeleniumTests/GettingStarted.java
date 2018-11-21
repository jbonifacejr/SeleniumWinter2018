package SeleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GettingStarted 
{
	
	public static void main(String[] args) throws InterruptedException
	{
		
		//FirefoxOptions options = new FirefoxOptions();
		//options.setCapability("marionette", true);
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\jboni\\teachingworkspace\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		FirefoxOptions newOptions = new FirefoxOptions()
			    .setProfile(new FirefoxProfile());
		WebDriver driver = new FirefoxDriver(newOptions);
		driver.navigate().to("https://www.amazon.com");
			 
		try
		{
			WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search'][@aria-label='Search']"));
			searchBox.click();
			searchBox.sendKeys("Dynamite");
			List<WebElement> searchSubmitButtons = 
					driver.findElements(By.xpath("//div[@class='UUbT9']//div[@class='VlcLAe']//input[@name='btnK'][@type='submit'][@aria-label='Google Search'][@value='Google Search']"));
			
			WebElement searchSubmitButton = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='UUbT9']//div[@class='VlcLAe']//input[@name='btnK'][@type='submit'][@aria-label='Google Search'][@value='Google Search']")));
			searchSubmitButton.click();
			Thread.sleep(5000);
			driver.quit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			driver.quit();
		}
	}	
}
