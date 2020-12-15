package pack;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PIP {
	WebDriver driver;
	String url = "http://specsqaap.pg.com/login";
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nandhini\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
	}

	@Test
	public void attributes() throws Exception {
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("Anywheretwo.im");
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("Sa061920");
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
		driver.findElement(By.id("loginButton")).click();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("searchBox")).sendKeys("91567522");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div/div[1]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr/td[1]/a/span")).click();
		Thread.sleep(5000);
		try { 
			if(driver.findElement(By.id("collapseZero")).isDisplayed()) {
				driver.findElement(By.id("collapseZero")).click();
				List<String>attribute=new ArrayList<String>();
				System.out.println("----------------Attributes------------");
				attribute.add("Description");
				attribute.add("Title");
				attribute.add("Type");
				attribute.add("Specification Sub Type");
				attribute.add("Originator");
				attribute.add("Last Update User");
				attribute.add("Revision");
				attribute.add("Originated");
				attribute.add("Phase");
				attribute.add("Owner");
				attribute.add("Brand");
				attribute.add("Segment");
				attribute.add("Structured Release Criteria Required");
				attribute.add("Release Date");
				attribute.add("Effective Date");
				attribute.add("Expiration Date");
				attribute.add("Previous Revision Obsolete Date");
				attribute.add("Manufacturing Status");
				attribute.add("Power Source");
				attribute.add("Legacy Environmental Class");
				attribute.add("Brand");
				attribute.add("Reported Function");
				attribute.add("Battery Type");
				attribute.add("SAP BOM Base QTY");
				attribute.add("Class");
				attribute.add("Sub-Class");
				attribute.add("Packaging Technology");
				attribute.add("Shipping Information");
				attribute.add("Labeling Information");
				attribute.add("Storage Conditions");
				attribute.add("Storage Humidity Limits - %");
				attribute.add("Storage Temperature Limits - °C");
				attribute.add("Base Unit Of Measure");
				attribute.add("Alternative Unit of Measure");
				attribute.add("Reason for Change");
				attribute.add("Other Names");
				attribute.add("Local Description");
				attribute.add("Packaging Size");
				attribute.add("Packaging Size UoM");
				attribute.add("Marketing Size");
				attribute.add("Comments");
				attribute.add("Obsolete Date");
				attribute.add("Obsolete Comment");
				attribute.add("Classification");
				List<WebElement>l=driver.findElements(By.id("pageheaders"));
				for(String s:attribute) 
				{
					int count=0;
					for(WebElement w:l) 
					{
						String s1=w.getText();
						if(s.equalsIgnoreCase(s1)) 
						{
							SoftAssert softAssertion= new SoftAssert();
							softAssertion.assertEquals(s,s1);
							System.out.println(s+" is present on webpage");
							break;

						}
						else
						{
							count+=1;
							if(count>=l.size()) 
							{
								System.out.println("Desc not in webpage");
								SoftAssert softAssertion= new SoftAssert();
								softAssertion.assertFalse(true);

							}

							continue;
						}
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("attributes in template but missing in webpage");
		}
	}

	//Weight Characteristic
	@Test(dependsOnMethods="attributes")
	public void weight_Characteristic() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//*[@id=\"One\"]")).isDisplayed()) {

				driver.findElement(By.xpath("//*[@id=\"One\"]")).click();
				List<String>wc=new ArrayList<String>();
				System.out.println("------------Weight Characteristic----------");
				wc.add("Name:");
				wc.add("Type:");
				wc.add("Gross Weight:");
				wc.add("Legacy Product Weight:");
				wc.add("Net Weight of Product in Consumer Unit:");
				wc.add("Net Weight UoM:");
				wc.add("Comments:");
				wc.add("Weight UoM:");
				wc.add("Legacy Weight Factor:");
				wc.add("Legacy Weight Factor UoM:");
				List<WebElement>l2=driver.findElements(By.id("pageheaders"));
				for(String s2:wc) 
				{
					int count=0;
					for(WebElement w2:l2) 
					{
						String s12=w2.getText();
						if(s2.equalsIgnoreCase(s12)) 
						{
							SoftAssert softAssertion= new SoftAssert();
							softAssertion.assertEquals(s12, s2);
							System.out.println(s2+" is present on webpage");
							break;

						}
						else
						{
							count+=1;
							if(count>=l2.size()) 
							{
								System.out.println("Desc not in webpage");
								SoftAssert softAssertion= new SoftAssert();
								softAssertion.assertFalse(true);
							}

							continue;
						}
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("weight characteristic in template but missing in webpage");
		}
	}	


	//Plants
	@Test(dependsOnMethods="weight_Characteristic")
	public void Plants() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.id("Eleven")).isDisplayed()) {

				List <String> b=new ArrayList();
				System.out.println("----------Plants-----------");
				b.add("Plants");
				b.add("Plants Authorized To Use");
				b.add("Plants Authorized to Produce");
				b.add("Activated");


				WebElement ip=driver.findElement(By.xpath("//*[@id=\"Eleven\"]"));
				List<WebElement> rows=ip.findElements(By.tagName("tr"));
				List<WebElement> cols=rows.get(1).findElements(By.tagName("th"));
				for(String s:b) {
					int count=0;

					for(WebElement c:cols) {
						String s1=c.getText();
						if(s.equalsIgnoreCase(s1)) 
						{
							SoftAssert softAssertion= new SoftAssert();
							softAssertion.assertEquals(s,s1);
							System.out.println(s+" is present on webpage");
							break;

						}
						else
						{
							count+=1;
							if(count>=cols.size()) 
							{
								System.out.println("Desc not in webpage");
								SoftAssert softAssertion= new SoftAssert();
								softAssertion.assertFalse(true);
							}

							continue;
						}
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("lifecycle present in template but missing in webpage");
		}

	}


	//life cycle
	@Test(dependsOnMethods="Plants")
	public void lifecycle() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//*[@id=\"Fourteen\"]/div/div/table")).isDisplayed()) {

				List <String> b=new ArrayList();
				System.out.println("----------Life cycle-----------");
				b.add("Name");
				b.add("Approver");
				b.add("Title");
				b.add("Approval Status");
				b.add("Approval/Due Date");
				b.add("Comments/Instructions");


				WebElement ip=driver.findElement(By.xpath("//*[@id=\"Fourteen\"]/div/div/table"));
				List<WebElement> rows=ip.findElements(By.tagName("tr"));
				List<WebElement> cols=rows.get(1).findElements(By.tagName("th"));
				for(String s:b) {
					int count=0;

					for(WebElement c:cols) {
						String s1=c.getText();
						if(s.equalsIgnoreCase(s1)) 
						{
							SoftAssert softAssertion= new SoftAssert();
							softAssertion.assertEquals(s,s1);
							System.out.println(s+" is present on webpage");
							break;

						}
						else
						{
							count+=1;
							if(count>=cols.size()) 
							{
								System.out.println("Desc not in webpage");
								SoftAssert softAssertion= new SoftAssert();
								softAssertion.assertFalse(true);
							}

							continue;
						}
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("lifecycle present in template but missing in webpage");
		}

	}

	//Ownership
	@Test(dependsOnMethods="lifecycle")
	public void ownership() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.id("Fifteen")).isDisplayed()) {
				driver.findElement(By.id("Fifteen")).click();
				List<String>owner=new ArrayList<String>();
				System.out.println("-----------Ownership----------");
				owner.add("Segment:");
				owner.add("Co-Owners:");
				owner.add("Originator:");
				owner.add("Last Update User:");
				owner.add("Last Update Date:");
				List<WebElement>l2=driver.findElements(By.id("pageheaders"));
				for(String s2:owner) 
				{
					int count=0;
					for(WebElement w2:l2) 
					{
						String s12=w2.getText();
						if(s2.equalsIgnoreCase(s12)) 
						{
							SoftAssert softAssertion= new SoftAssert();
							softAssertion.assertEquals(s12, s2);
							System.out.println(s2+" is present on webpage");
							break;

						}
						else
						{
							count+=1;
							if(count>=l2.size()) 
							{
								System.out.println("Desc not in webpage");
								SoftAssert softAssertion= new SoftAssert();
								softAssertion.assertFalse(true);
							}

							continue;
						}
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("ownership in template but missing in webpage");
		}
	}

	//IP class
	@Test(dependsOnMethods="ownership")
	public void IPCLass() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//*[@id=\"Sixteen\"]/div/div/table")).isDisplayed()) {

				List <String> b=new ArrayList();
				System.out.println("-----------IPCLASS------------------");
				b.add("Name");
				b.add("Type");
				b.add("Has Class Access?");
				b.add("Description");
				b.add("State");


				WebElement ip=driver.findElement(By.xpath("//*[@id=\"Sixteen\"]/div/div/table"));
				List<WebElement> rows=ip.findElements(By.tagName("tr"));
				List<WebElement> cols=rows.get(1).findElements(By.tagName("th"));
				for(String s:b) {
					int count=0;

					for(WebElement c:cols) {
						String s1=c.getText();
						if(s.equalsIgnoreCase(s1)) 
						{
							SoftAssert softAssertion= new SoftAssert();
							softAssertion.assertEquals(s,s1);
							System.out.println(s+" is present on webpage");
							break;

						}
						else
						{
							count+=1;
							if(count>=cols.size()) 
							{
								System.out.println("Desc not in webpage");
								SoftAssert softAssertion= new SoftAssert();
								softAssertion.assertFalse(true);
							}

							continue;
						}
					}
				}
			}
		}

		catch(Exception e) {
			System.out.println("IPCLass in template but missing in webpage");
		}
	}

	//Organization
	@Test(dependsOnMethods="IPCLass")
	public void Organization() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//*[@id=\"Nineteen\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"Nineteen\"]")).click();
				List<String>or=new ArrayList<String>();
				System.out.println("-------------------organisation---------------");
				or.add("Primary Organization:");
				or.add("Secondary Organization:");

				List<WebElement>l1=driver.findElements(By.id("pageheaders"));
				for(String s1:or) 
				{
					int count=0;
					for(WebElement w:l1) 
					{
						String s11=w.getText();
						if(s1.equalsIgnoreCase(s11)) 
						{
							SoftAssert softAssertion= new SoftAssert();
							softAssertion.assertEquals(s11, s1);
							System.out.println(s1+" is present on webpage");
							break;

						}
						else
						{
							count+=1;
							if(count>=l1.size()) 
							{
								System.out.println("Desc not in webpage");
								SoftAssert softAssertion= new SoftAssert();
								softAssertion.assertFalse(true);
							}

							continue;
						}
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("organisation in template but missing in webpage");
		}

	}
	//Reference document

	@Test(dependsOnMethods="Organization")
	public void refernecedocument() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Reference Document")){
			System.out.println("Reference document is  present");

		}

		else {
			System.out.println("Reference document present in template but missing in webpage");
		}
	}

	//related specification

	@Test(dependsOnMethods="refernecedocument")
	 public void relatesSpecification() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Related Specifications")){
			System.out.println("Related Specifications is present");

		}

		else {
			System.out.println("Related Specifications present in template but missing in webpage");
		}
	}


	//Security class
	@Test(dependsOnMethods="relatesSpecification")
	public void securityClasses() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Security Classes")){
			System.out.println("Secuirty class is present");

		}

		else{
			System.out.println("Secuirty class present in template but missing in webpage");
		}
	}

	//File
	@Test(dependsOnMethods="securityClasses")
	public void Files() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Files")){
			System.out.println("Files is  present");

		}

		else {
			System.out.println("Files present in template but missing in webpage");
		}
	}

	//performance characteristic
	@Test(dependsOnMethods="Files")
	public void performancecharacteristic() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.linkText("Performance Characteristic")).isDisplayed()){
				System.out.println("performance characteristic is  present");

			}
		}
		catch(Exception e) {
			System.out.println("perfromance characteristic present in template but missing in webpage");
		}
	}


	//PQR_View_Supplier_Equivalents
	@Test(dependsOnMethods="performancecharacteristic")
	public void PQR_View_Supplier_Equivalents() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.linkText("Performance Characteristic")).isDisplayed()){
				System.out.println("PQR_View_Supplier_Equivalents is  present");

			}
		}
		catch(Exception e) {
			System.out.println("PQR_View_Supplier_Equivalents present in template but missing in webpage");
		}
	}


	//PQR_View_manufacturer_Equivalents
	@Test(dependsOnMethods="PQR_View_Supplier_Equivalents")
	public void PQR_View_manufacturer_Equivalents() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.linkText("Performance Characteristic")).isDisplayed()){
				System.out.println("PQR_View_manufacturer_Equivalents is  present");

			}
		}
		catch(Exception e) {
			System.out.println("PQR_View_manufacturer_Equivalents present in template but missing in webpage");
		}
	}





	@AfterTest
	public void afterTest() {
	}

}
