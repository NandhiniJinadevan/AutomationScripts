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

public class IP {
	WebDriver driver;
	String url = "http://specsqaap.pg.com/login";
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nandhini\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();   
	}

	@Test
	public void attributes() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("Anywheretwo.im");
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("Sa061920");
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
		driver.findElement(By.id("loginButton")).click();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("searchBox")).sendKeys("IP");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div/div[1]/div/button")).click();
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[1]/a/span")).click();
		Thread.sleep(1000);
		if (driver.findElement(By.linkText("IP-00000001")).isDisplayed()) {
			Thread.sleep(10000);
			driver.findElement(By.linkText("IP-00000001")).click();
		} else {
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[3]/td[1]/a/span"))
					.click();
		}
		try { 
			if(driver.findElement(By.id("zero")).isDisplayed()) {
				driver.findElement(By.id("zero")).click();
				List<String>attribute=new ArrayList<String>();
				attribute.add("Description");
				attribute.add("Title");
				attribute.add("Type");
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
		try {
			if(driver.findElement(By.xpath("//*[@id=\"one\"]")).isDisplayed()) {

				driver.findElement(By.xpath("//*[@id=\"one\"]")).click();
				List<String>wc=new ArrayList<String>();
				wc.add("Gross Weight:");
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
	//Bill of materials
	@Test(dependsOnMethods="weight_Characteristic")
	public void bill_of_materials() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/table")).isDisplayed()) 
			{
				List<String> pc=new ArrayList<String>();
				pc.add("Name(N) Rev(R)");
				pc.add("Chg");
				pc.add("F/N");
				pc.add("Title");
				pc.add("Type");
				pc.add("Substitute Parts (SP) Alternate (Alt)");
				pc.add("Qty");
				pc.add("Base Unit Of Measure");
				pc.add("EBOM Comments");
				pc.add("State");
				pc.add("Phase");
				pc.add("Ref Des");
				pc.add("On-shelf Product Density(OSPD) Density Unit of Measure(DUOM)");
				pc.add("Optional Components");
				pc.add("N");
				pc.add("R");
				pc.add("SP");
				pc.add("Alt");
				pc.add("OSPD");
				pc.add("DUOM");



				List<String> perfol=new ArrayList<String>();
				WebElement tab=driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/table/thead"));
				List<WebElement> rows=tab.findElements(By.tagName("tr"));
				List<WebElement> cols=rows.get(0).findElements(By.tagName("th"));
				for(WebElement col:cols)
				{
					String ss=col.getText();
					perfol.add(ss);
				}

				List<String> p=new ArrayList<String>();
				WebElement tab1=driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/table/tbody"));
				List<WebElement> rows1=tab1.findElements(By.tagName("tr"));
				List<WebElement> cols1=rows1.get(0).findElements(By.className("bomFontClass"));
				for(WebElement col:cols1)
				{
					String ss=col.getText();
					p.add(ss);
				}
				for(String s:p) {
					for(String ss:s.split(":")) {
						perfol.add(ss);
					}
				}
				for(String s:pc) {
					int count=0;
					for(String s1:perfol) {

						if(s.equalsIgnoreCase(s1)) {
							SoftAssert softAssertion= new SoftAssert();
							softAssertion.assertEquals(s,s1);
							System.out.println(s+" is present on webpage");
							break;

						}

						else {
							count+=1;
							if(count>=perfol.size()) 
							{
								System.out.println(s+"Desc not in webpage");
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
			System.out.println("Bill of materials in template but missing in webpage");
		}
	}
	//ownership
	@Test(dependsOnMethods="bill_of_materials")
	public void ownership() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.id("elevan")).isDisplayed()) {

				driver.findElement(By.id("elevan")).click();
				List<String>owner=new ArrayList<String>();
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
		public void IPCLass() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//*[@id=\"twelve\"]/div/div/table")).isDisplayed()){

				List <String> b=new ArrayList();
				b.add("Name");
				b.add("Type");
				b.add("Has Class Access?");
				b.add("Description");
				b.add("State");


				WebElement ip=driver.findElement(By.xpath("//*[@id=\"twelve\"]/div/div/table"));
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
			System.out.println("IPClass in template but missing in webpage");
		}


	}

	//life cycle
	@Test(dependsOnMethods="IPCLass")
	public void lifecycle() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.id("ten")).isDisplayed()) {

				List <String> b=new ArrayList();
				b.add("Name");
				b.add("Approver");
				b.add("Title");
				b.add("Approval Status");
				b.add("Approval/Due Date");
				b.add("Comments/Instructions");


				WebElement ip=driver.findElement(By.xpath("//*[@id=\"ten\"]/div/div/table"));
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

	//Security class
	@Test(dependsOnMethods="lifecycle")
	public void securityClasses() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.linkText("Security Classes")).isDisplayed()){
				System.out.println("Secuirty class is present");

			}
		}
		catch(Exception e) {
			System.out.println("Secuirty class present in template but missing in webpage");
		}
	}


	//performance characteristic
	@Test(dependsOnMethods="securityClasses")
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

	//File
	@Test(dependsOnMethods="performancecharacteristic")
	public void Files() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Files")){
			System.out.println("Files is present");

		}

		else {
			System.out.println("files present in template but missing in webpage");
		}
	}


	//related specification

	@Test(dependsOnMethods="Files")
	public void relatesSpecification() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Related Specifications")){
			System.out.println("Related Specifications is present");

		}

		else {
			System.out.println("Related Specifications present in template but missing in webpage");
		}
	}

	//master specifications
	@Test(dependsOnMethods="relatesSpecification")
	public void masterSpecification() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Master Specifications")){
			System.out.println("Master Specifications is present");

		}

		else {
			System.out.println("Master Specifications present in template but missing in webpage");
		}
	}
	//organization
	@Test(dependsOnMethods="masterSpecification")
	public void organization() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//*[@id=\"fifteen\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"fifteen\"]")).click();
				List<String>or=new ArrayList<String>();
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
			System.out.println("Organization present in template but missing in webpage");
		}

	}

	//Related ATS

	@Test(dependsOnMethods="organization")
	public void Realtedats() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Related ATS")){
			System.out.println("Related ATS is  present");

		}

		else {
			System.out.println("Related ATS present in template but missing in webpage");
		}
	}


	//Reference document

	@Test(dependsOnMethods="Realtedats")
	public void refernecedocument() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Reference Document")){
			System.out.println("Reference document is  present");

		}

		else {
			System.out.println("Reference document present in template but missing in webpage");
		}
	}
    
	//Substitutes

		@Test(dependsOnMethods="refernecedocument")
		public void subtitutes() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if(driver.getPageSource().contains("Substitutes")){
				System.out.println("Substitutes is  present");

			}

			else {
				System.out.println("Substitutes present in template but missing in webpage");
			}
		}
		
		@Test(dependsOnMethods="subtitutes")
		public void note() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if(driver.getPageSource().contains("Notes")){
				System.out.println("Notes is  present");

			}

			else {
				System.out.println("Notes present in template but missing in webpage");
			}
		}

	@AfterTest
	public void afterTest() 
	{
		driver.close();
		driver.quit();
	}

}
