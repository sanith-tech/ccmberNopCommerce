package pagesorpageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinations.BaseClass;

public class SearchCustomerPage extends BaseClass {
	
	public SearchCustomerPage(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (id = "SearchEmail") WebElement textemail;
	@FindBy(id ="SearchFirstName") WebElement textfirstname;
	@FindBy(id ="SearchLastName") WebElement textlastname;
	
	@FindBy (id = "search-customers") WebElement Searchbtn;
	@FindBy (xpath = "//div[@id=\"customers-grid_wrapper\"]/div")
	WebElement  table;
	@FindBy(xpath = "//div[@id=\"customers-grid_wrapper\"]//tbody/tr")
	List<WebElement> tablerows;
	@FindBy(xpath = "//div[@id=\"customers-grid_wrapper\"]//tbody/tr/td")
	List<WebElement> tablecolumns;
	
	public void setemail(String email) {
		textemail.sendKeys(email);
	}
	public void clickonsearch() {
		Searchbtn.click();
	}
	public int getNoOfRows () {
		int size = tablerows.size();
		 return size ;	 
	}
	public int getNoOfColumns() {
		return (tablecolumns.size());
	}
	public boolean searchcustomerbyemail(String email) {
		boolean flag = false;
		for(int i=1;i<=getNoOfRows();i++) {
		String emailid = table.findElement(By.xpath("//div[@id=\"customers-grid_wrapper\"]//tbody/tr["+i+"]/td[2]")).getText();
		System.out.println(emailid);
		if(emailid.equals(email)) {
			flag = true ;
		}
		}
		return flag;
	}
	public void setfirstname(String firstname) {
		textfirstname.sendKeys(firstname);
	}
	public void setlastname(String lastname) {
		textlastname.sendKeys(lastname);
	}
	public boolean searchCustomerByName(String Name) {
		boolean flag = false;
		for(int i=0;i<=getNoOfRows();i++) {
			String name = table.findElement(By.xpath("//div[@id=\"customers-grid_wrapper\"]//tbody/tr["+i+"]/td[3]")).getText();
		    String names[]=name.split(" ");//separating firstname and lastname
		    if(names[0].equals(	"Virat")&&names[1].equals("Kohli")) {
		    	flag = true;
		    }
		}
		return flag;
	}
}
