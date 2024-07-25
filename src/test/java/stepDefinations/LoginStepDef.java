package stepDefinations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesorpageobjects.AddCustomersPage;
import pagesorpageobjects.LoginPage;
import pagesorpageobjects.SearchCustomerPage;

public class LoginStepDef extends BaseClass {
	LoginPage lpage;
	AddCustomersPage acpage;
	SearchCustomerPage scpage;
	 
	@Before
	public void setup()
	{
				File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\new\\ccmberNopCommerce\\src\\test\\resources\\configuration\\Config.properties");
				try {
					fis = new FileInputStream(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("config file not found please check the path of the file");
					e.printStackTrace();
				}
				prop = new Properties();
				try {
					prop.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String browser = prop.getProperty("Browser");
				if(browser.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} else if(browser.equalsIgnoreCase("edge")) {
						driver = new EdgeDriver();
				} else if(browser.equalsIgnoreCase("firefox")) {
							driver = new FirefoxDriver();
						}
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
					//driver.get(prop.getProperty("url"));
	}
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
	   // driver = new ChromeDriver(); 
	    lpage = new LoginPage(driver);
	}

	@When("user opens url {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String name, String password) {
	    lpage.setusername(name);
	    lpage.setpassword(password);
	}

	@When("click on login")
	public void click_on_login()  {
		 lpage.clickloginbtn();
		 
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	assertTrue(false);
	    }else{
	    	assertEquals(title, driver.getTitle());
	    }
	}

	@When("user click o logout link")
	public void user_click_o_logout_link() {
	    lpage.clicklogoutbtn();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	}

	//customer feature stepdefinations***********************
    
	@Then("user can view dashboard")
	public void user_can_view_dashboard() {
	
		//acpage = new AddCustomersPage(driver);
	   assertTrue(acpage.DashbdVerify().contains("nopCommerce"));
		System.out.println("dashboard title validation failed");
	    
	}

	@Then("user click on customer menu")
	public void user_click_on_customer_menu() {
		System.out.println(driver);
		System.out.println("--> addto---------> customer");
		acpage= new AddCustomersPage(driver);
		System.out.println("---> before click");
		acpage.clickoncustmenu();
		System.out.println("---> after click");
	   
	}

	@Then("user click on customers")
	public void user_click_on_customers() {
		//acpage= new AddCustomersPage(driver);
		acpage.clickoncustomers();
	    
	}

	@Then("user click on add new button")
	public void user_click_on_add_new_button() {
	   acpage.clickonaddbtn();
	}

	@Then("user can view add customer details page")
	public void user_can_view_add_customer_details_page() {
	    assertEquals("Add a new customer / nopCommerce administration", acpage.getpagetitle());
	}

	@When("user enters customer info")
	public void user_enters_customer_info() {
		String email = randomstring()+"@gmail.com";
		acpage.setemail(email);
		acpage.setpassword("admi58525");
		acpage.setfname("hary");
		acpage.setlname("poter");
		acpage.setgender("Female");
		acpage.setdob("10101999");
	//	acpage.settesttxtbox("test123");
		acpage.setcustomerroles("Guests");
		acpage.setmanagerofvendor("Vendor 1");
		acpage.setcomname("accenture");
		acpage.setadmincomment("applying for testing......");
		
		
	   	}

	@When("click on save button")
	public void click_on_save_button() {
		acpage.clickonsave();
	    
	}
	@Then("user can view conformation message")
	public void user_can_view_conformation_message() {
		assertTrue(acpage.verifytext1().contains("The new customer has been added successfully."));
	}
	
		//assertTrue(driver.findElement(By.className("alert alert-success alert-dismissable")).getText()
				//  .contains("The new customer has been added successfully."));
	
	
	//******************************************************************************************
	//steps for searching customer using email id 
	
	@Then("enter customer email id")
	public void enter_customer_email_id() {
		scpage = new SearchCustomerPage(driver);
		scpage.setemail("victoria_victoria@nopCommerce.com");   
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
	    scpage.clickonsearch();
	    Thread.sleep(5000);
	}

	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
	    boolean result = scpage.searchcustomerbyemail("victoria_victoria@nopCommerce.com");
	    assertEquals(true, result);
	}

	//***********************************************************************************
	//steps for searching a customer by using firstname and lastname
	@Then("enter customer firstname")
	public void enter_customer_firstname() {
		scpage = new SearchCustomerPage(driver);
		scpage.setfirstname("Virat");
	   
	}

	@Then("enter customer lastname")
	public void enter_customer_lastname() {
		scpage.setlastname("Kohli");
	    
	}
	@Then("user should found name in the search table")
	public void user_should_found_name_in_the_search_table(){
		boolean status = scpage.searchCustomerByName("Virat Kohli");
		assertEquals(true, status);
	}
}
