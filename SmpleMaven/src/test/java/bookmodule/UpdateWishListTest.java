package bookmodule;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectrepository.AddWishListPage;
import objectrepository.ApperalAndShoesPage;
import objectrepository.HomePage;
import objectrepository.ShoePage;
import objectrepository.WishListPage;
@Listeners(genericutility.Listenerutility.class)
public class UpdateWishListTest extends BaseClass implements  ITestListener{
@Test
public void updateWshLst() throws InterruptedException, EncryptedDocumentException, IOException {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
//	driver.findElement(By.xpath("(//a[contains(text(), 'Apparel & Shoes')])[3]")).click();
	HomePage h= new HomePage(driver);
	h.setApparelAndShoes();
	Thread.sleep(2000);
//	driver.findElement(By.linkText("Blue and green Sneaker")).click();
	ApperalAndShoesPage a= new ApperalAndShoesPage(driver);
	a.setSelectShoe();
//	WebElement size = driver.findElement(By.xpath("//select[contains(@id,'product_attribute')]"));
//	Select s = new Select(size);
//	s.selectByValue("28");
	ShoePage s= new ShoePage(driver);
	s.setSelectSize();
//	driver.findElement(By.xpath("//span[@title='Green']")).click();
	s.SetColor();
//	driver.findElement(By.className("add-to-wishlist-button")).click();
	s.SetAddWishList();
	Thread.sleep(2000);
//	WebElement successmsg = driver.findElement(By.id("bar-notification"));
//	String text = successmsg.getText();
//	System.out.println(text);
	String text = s.getWishListSuccessMsg();
	Reporter.log(text,true);
	String Expectedtext = eu.readExcelData("WishList", 1, 1);
	Reporter.log(text);
	Assert.assertEquals(text, Expectedtext);
	Thread.sleep(2000);
//	driver.findElement(By.className("ico-wishlist")).click();
	s.setClickWishList();
//	driver.findElement(By.name("removefromcart")).click();
	AddWishListPage al= new AddWishListPage(driver);
	al.setRemoveWishList();
	Thread.sleep(2000);
//	driver.findElement(By.className("update-wishlist-button")).click();
	al.setUpdateWishList();
//	WebElement wishLisMsgEle = driver.findElement(By.className("wishlist-content"));
//	String wishListMsg = wishLisMsgEle.getText();
//	System.out.println(wishListMsg);
	WishListPage w= new WishListPage(driver);
	String wishListExp = eu.readExcelData("WishList", 2, 1);
	String wishListAct = w.getWishListMsg();
	Assert.assertEquals(wishListAct, wishListExp);
	
	}

}

