package stepDefinations;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import net.bytebuddy.utility.RandomString;
import pagesorpageobjects.AddCustomersPage;
import pagesorpageobjects.LoginPage;
import tech.grasshopper.excel.report.util.RandomStringGenerator;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	//LoginPage lpage ;
	//AddCustomersPage acpage ;
	
	//created for generating random string for unique email
	public static String randomstring() {
	String randomstring =	RandomString.make(5);
	return randomstring;
	
	}

}
