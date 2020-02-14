package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.utility.Xls_Reader;

import pageObjects.LoginValidation;
import resources.Base;

public class LoginTest extends Base {
	
	 @BeforeTest public void initialize() throws IOException {
	  driver=initializeDriver(); }
	 
	@Test
	public void emptyUnamePassword() throws InterruptedException {
		 driver.get(prop.getProperty("url"));
		LoginValidation lv=new LoginValidation(driver);
		Xls_Reader reader = new Xls_Reader(
				"E:\\New Selenium\\DemoFramework\\src\\main\\java\\com\\testData\\LoginVerify.xlsx", 0);
		int rowcount = reader.getRowCount("LoginVerify");
		System.out.println(rowcount);
		for (int i = 2; i <= rowcount; i++) 
		{

			String Username = reader.getCellData("LoginVerify", "UserName", i);
			String password = reader.getCellData("LoginVerify", "Password", i);
			System.out.println(Username + " " + password);
			
			  lv.getPartnerName().clear();
			  lv.getPartnerName().sendKeys(Username);
			  lv.getPartnerPassword().clear();
			  lv.getPartnerPassword().sendKeys(password); 
		      lv.submit().click(); 
			  Thread.sleep(2000);
			  if(Username.isEmpty() && (password.isEmpty())) 
			  {
			  lv.getUserNameAlert(); 
			  lv.getPasswordAlert(); 
			  } 
			  else if(Username.isEmpty()) 
			  {
			  lv.getUserNameAlert(); 
			  } 
			  else if(password.isEmpty()) 
			  {
			  lv.getPasswordAlert(); 
			  }
			  else if((Username.equals("qa")) && (!password.equals("abc@1234"))) 
			  {
			  lv.getBothInvalidAlert(); 
			  }
			  else if((!Username.equals("qa")) && (password.equals("abc@1234"))) 
			  {
			  lv.getBothInvalidAlert();
			  }
			  else if
			  ((!Username.equals("qa")) && (!password.equals("abc@1234"))) 
			  {
			  lv.getBothInvalidAlert();
			  } 
			  else 
			  { 
				  lv.logo().isDisplayed(); 
			}
			  			  
		}
	}
	@AfterTest
	public void close() {
	browserClose();
	}

}
