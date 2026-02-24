package bookmodule;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectrepository.ContactUsPage;
import objectrepository.HomePage;

@Listeners(genericutility.Listenerutility.class)

public class ContactUsModuleTest extends  BaseClass implements ITestListener
{
	@Test
	public void contactUs() throws EncryptedDocumentException, IOException, InterruptedException {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
//	driver.findElement(By.linkText("Contact us")).click();
	HomePage h= new HomePage(driver);
	h.setContactUsLink();
//	driver.findElement(By.id("Enquiry")).sendKeys("Is the product is available");
//	driver.findElement(By.className("contact-us-button")).click();
	ContactUsPage c= new ContactUsPage(driver);
	Thread.sleep(2000);
	String msg = eu.readExcelData("ContactUs", 1, 1);
	c.enquiryMsg(msg);
	Thread.sleep(2000);
//	String text = driver.findElement(By.xpath("//div[@class='result']")).getText();
	String text = c.getResultmsg();
//	System.out.println(text);
	Reporter.log(text, true);
	
	}
}
