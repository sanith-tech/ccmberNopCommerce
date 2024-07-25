package pagesorpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//public WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (id = "Email") WebElement Email;
	@FindBy (id = "Password") WebElement Pword;
	@FindBy (xpath = "//button[text()=\"Log in\"]") WebElement loginbtn;
	@FindBy (xpath = "//a[text()=\"Logout\"]") WebElement logoutbtn;
	@FindBy (xpath = "//div[text()=\"Login was unsuccessful. Please correct the errors and try again.\"]") WebElement unsucfllgn;
    //**********
	@FindBy (xpath = "//a[@href='#']/p[contains(text(),'Customers')]") WebElement customermenu;
	@FindBy (xpath="//p[text()=\" Customers\"]") WebElement customers;
	public void setusername(String name) {
		Email.clear();
		Email.sendKeys(name);
	}
	public void setpassword(String password) {
		Pword.clear();
		Pword.sendKeys(password);
	}
	public void clickloginbtn() {
		loginbtn.click();
	}
	public void clicklogoutbtn() {
		logoutbtn.click();
	}
//	public void clickoncustmenu() {
//		customermenu.click();
//	}

}
