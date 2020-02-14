package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginValidation {
	public WebDriver driver;
	By partnername=By.name("dealerinfo.dealername");
	By password=By.name("dealerinfo.dpassword");
	By submit=By.id("CSDLoginAction_submit");
	By delerunamealerttext=By.xpath("//span[contains(text(),'Enter a valid Dealer Name')]");
	By delerpasswordalerttext=By.xpath("//span[contains(text(),'Enter a valid password')]");
	
	//span[contains(text(),'Enter a valid password')]
	By bothinvalid=By.xpath("//span[contains(text(),'Invalid Dealer Name / Password')]");
	By logo=By.xpath("//div[@class='companyLogo']/img");
	public LoginValidation(WebDriver driver)
	{
		this.driver=driver;
	
	}
	public WebElement getPartnerName()
	{
		return driver.findElement(partnername);
	}
	public WebElement getPartnerPassword()
	{
		return driver.findElement(password);
	}
 public void getUserNameAlert()
 {
	 String expected="Enter a valid Dealer Name";
	 String actual=driver.findElement(delerunamealerttext).getText();
	 Assert.assertEquals(actual,expected);
	 
 }
 public void getPasswordAlert()
 {
	String expected="Enter a valid password";
	String actual=driver.findElement(delerpasswordalerttext).getText();
	Assert.assertEquals(actual,expected);
	 
 }
 public void getBothInvalidAlert() {
	 String expected="Invalid Dealer Name / Password";
	 String actual=driver.findElement(bothinvalid).getText();
	 Assert.assertEquals(actual,expected);
 }
 public WebElement submit() {
	 return driver.findElement(submit);
 }
 public WebElement logo() {
	 return driver.findElement(logo);
 }
 
}
