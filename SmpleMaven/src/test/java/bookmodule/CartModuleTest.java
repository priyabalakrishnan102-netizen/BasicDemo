package bookmodule;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectrepository.AddCartPage;
import objectrepository.AddWishListPage;
import objectrepository.HomePage;
public class CartModuleTest extends genericutility.BaseClass implements ITestListener{
@Test
	public void AddToCart() throws InterruptedException, EncryptedDocumentException, IOException {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
//	driver.findElement(By.id("small-searchterms")).sendKeys("smartphone"+Keys.ENTER);
	Assert.fail();
	HomePage h= new HomePage(driver);
	String searchMsg = eu.readExcelData("AddToCart", 1, 1);
	h.setSearch(searchMsg);
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
	h.setAddToCart();
	Thread.sleep(2000);
//	WebElement ele = driver.findElement(By.className("success"));
	AddCartPage a= new AddCartPage(driver);
	String actualMsg = a.getSuccessMsg();
//	String text = ele.getText();
//	System.out.println(text);
	Reporter.log(actualMsg, true);
	String expectedRes = eu.readExcelData("AddToCart", 2, 1);
//	SoftAssert s= new SoftAssert();
//	s.assertEquals(actualMsg, expectedRes);
	Assert.assertEquals(actualMsg, expectedRes);
	//s.assertAll();
	
}
}

