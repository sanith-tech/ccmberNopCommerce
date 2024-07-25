import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mongodb.operation.CreateUserOperation;

public class Pracetice {
	
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	FileInputStream fis;
	Properties prop;

	public static void main(String[] args) throws IOException {
		Pracetice pr = new  Pracetice ();
		pr.frames();
	}
  public void frames() throws IOException {
	 
	/* File file = new File(System.getProperty("user.dir")+"src/test/resources/configuration/Config.properties");
	 try {
		fis = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 prop = new Properties();
	 prop.load(fis);
	 
	String brsr = prop.getProperty("browser");
	if(brsr.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if(brsr.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
		 
	 }
	driver.manage().window().maximize();
	driver.get("https.fb.com");
	*/
	// File file = new File(System.getProperty("user.dir")+"src/test/resources/TestData/studentinfo2.xlsx");
	File file = new  File("C:/Users/Welcome/eclipse-workspace/new/ccmberNopCommerce/src/test/resources/TestData/studentinfo2.xlsx");
	  fis = new FileInputStream(file);
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Sheet1");
	  
	  int rowscnt = sheet.getPhysicalNumberOfRows();
	  int columns = sheet.getRow(0).getPhysicalNumberOfCells(); 
	  System.out.println("rowscnt is :" + rowscnt);
	  System.out.println("columnscount is : "+columns);
	  
	  String value = sheet.getRow(0).getCell(0).getStringCellValue();
	  String value6 = sheet.getRow(0).getCell(5).getStringCellValue();
	  System.out.println("1st heading is : " + value);
	  System.out.println("6th heading is : " + value6);
	  String row2value6 = sheet.getRow(1).getCell(5).getStringCellValue();
	  System.out.println("2row6value:" + row2value6);
	  
	  for(int i = 0; i<columns;i++) {
		  System.out.print(sheet.getRow(0).getCell(i).getStringCellValue());
		  System.out.print("\t\t");
	  }
	  System.out.println();
	  for(int i=1;i<columns;i++) {
		  for(int j=0;j<rowscnt;j++) {
			  System.out.print(sheet.getRow(i).getCell(j).getStringCellValue());
			  System.out.print("\t\t");
		  }
		  System.out.println();
		  
	  }
	  
	  
	  
	  
	  
	 
	
	
	  
	  
  }
}
