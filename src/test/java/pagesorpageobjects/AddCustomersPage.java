package pagesorpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinations.BaseClass;

public class AddCustomersPage extends BaseClass  {
	//WebDriver driver;
	public AddCustomersPage(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p/i") WebElement customermenu;
	@FindBy (xpath="//p[text()=\" Customers\"]") WebElement customers;
//	@FindBy (className = "btn btn-primary") WebElement addnewbtn;
	@FindBy (xpath = "//button[@name=\"importexcel\"]/../a/i") WebElement addnewbtn;
	@FindBy (id = "Email") WebElement emaile;
	@FindBy (id = "Password") WebElement password;
	@FindBy (id = "Gender_Male")WebElement gendermale;
	@FindBy (id="Gender_Female")WebElement genderfemale;
	@FindBy(name = "DateOfBirth")WebElement DOB;
	
	
	By custroles = By.xpath("//li[@title=\"Registered\"]/..");
	By listitemAdministrators = By.xpath("//li[text()=\"Administrators\"]");
	By listitemforummoderators = By.xpath("//li[text()=\"Forum Moderators\"]");
	By listitemregistered = By.xpath("//li[text()=\"Forum Moderators\"]/following-sibling::li[1]");
	By deleteregister = By.xpath("//span[@role=\"presentation\"]");
	By listitemguests= By.xpath("//li[text()=\"Guests\"]");
	By listitemvendors = By.xpath("//li[text()=\"Vendors\"]");
	//@FindBy (xpath = "//input[@type=\"search\"][1]") WebElement custroles;
	//@FindBy(id = "VendorId")WebElement mgrofvendor;	
	By managerofvendor = By.name("VendorId");
	
	By rbgendermale =By.id("Gender_Male");
	By rbgenderfemale = By.id("Gender_Female");
	By firstname = By.id("FirstName");
	By lastname = By.id("LastName");
	By companyname = By.id("Company");
	By admincomment = By.id("AdminComment");
	By savebtn = By.name("save");
	//By testtxtbox = By.className("form-control");
	By verifytxt = By.xpath("//button[@data-dismiss=\"alert\"]/..");
	By dashbdtitle = By.xpath("//a[@id=\"nopSideBarPusher\"]/../../../following-sibling::aside//img[1]");
	public String getpagetitle() {
		return driver.getTitle();
	}
	
	public String DashbdVerify() {
		String dbtext =driver.findElement(dashbdtitle).getText();
		return dbtext;
	}
	
	public void clickoncustmenu() {
		customermenu.click();
	}
    public void clickoncustomers() {
    	customers.click();
    }
    public void clickonaddbtn() {
    	addnewbtn.click();
    }
    public void setemail(String email) {
    	
    	emaile.sendKeys(email);
    }
    public void setpassword(String pword) {
    	password.sendKeys(pword);
    }
    public void setcustomerroles(String role) {
    	driver.findElement(deleteregister).click();
    	//driver.findElement(custroles).click();
    	WebElement listitem;
    	
    	if(role.equals("Administators")) {
    		listitem = driver.findElement(listitemAdministrators);
    	}
    	else if(role.equals("Forum Moderators")) {
    		listitem = driver.findElement(listitemforummoderators);
    	}
    	else if(role.equals("Guests")) {
    		listitem = driver.findElement(listitemguests);
    	}
    	else if(role.equals("Vendors")) {
    		listitem = driver.findElement(listitemvendors);
    	}
    	else if(role.equals("Registered")) {
    		listitem = driver.findElement(listitemregistered);
    	}
    	else {
    		listitem = driver.findElement(listitemAdministrators);//default
    	}
    	listitem.click();
    }
    
    public void setmanagerofvendor(String value) {
    	Select drp =new Select(driver.findElement(managerofvendor)); 
    	drp.selectByVisibleText(value);
    }
    public void setgender(String gender) {
    	if(gender.equals("Male")) {
    		driver.findElement(rbgendermale).click();
    	}
    	else if(gender.equals("Female")) {
    		driver.findElement(rbgenderfemale);
    	}
    	else {
    		driver.findElement(rbgendermale);//default
    	}
    }
    public void setfname(String fname) {
    	driver.findElement(firstname).sendKeys(fname);
    }
    public void setlname(String lname) {
    	driver.findElement(lastname).sendKeys(lname);
    }
    public void setdob(String dofb) {
    	DOB.sendKeys(dofb);
    }
    public void setcomname(String cname) {
    	driver.findElement(companyname).sendKeys(cname);
    }
    public void setadmincomment(String admncmnt) {
    	driver.findElement(admincomment).sendKeys(admncmnt);
    }
//    public void settesttxtbox(String test) {
//    	driver.findElement(testtxtbox).sendKeys(test);
//    }
    public void clickonsave() {
    	driver.findElement(savebtn).click();
    }
    public String verifytext1() {
    	String txt = driver.findElement(verifytxt).getText();
    	return txt;
    }
	
}
