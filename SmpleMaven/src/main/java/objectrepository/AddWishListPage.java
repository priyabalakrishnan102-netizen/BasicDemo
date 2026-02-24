package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddWishListPage {
	@FindBy(name="removefromcart")
	private WebElement removeChBx;
	@FindBy(className = "update-wishlist-button")
	private WebElement updateWsLtBtn;
	
	public AddWishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setRemoveWishList() {
		removeChBx.click();
	}
	
	public void setUpdateWishList() {
		updateWsLtBtn.click();
	}


	

}
