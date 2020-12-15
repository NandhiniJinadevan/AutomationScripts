package pack;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MRMP {
	WebDriver driver;
	String url = "http://specsqaap.pg.com/login";
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nandhini\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
	}
	@Test
	public void atrributes() throws Exception{
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("Anywheretwo.im");
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("Sa061920");
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
		driver.findElement(By.id("loginButton")).click();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("searchBox")).sendKeys("MRMP");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div/div[1]/div/button")).click();
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[1]/a/span")).click();
		Thread.sleep(1000);
		if (driver.findElement(By.linkText("MRMP-00000019")).isDisplayed()) {
			Thread.sleep(10000);
			driver.findElement(By.linkText("MRMP-00000019")).click();
		} else {
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[3]/td[1]/a/span"))
					.click();
		}
		try {
			if(driver.findElement(By.id("zero")).isDisplayed())
			{
				driver.findElement(By.id("zero")).click();
				List<String>attribute=new ArrayList<String>();
				attribute.add("Description");
				attribute.add("Title");
				attribute.add("Originator");
				attribute.add("Last Update User");
				attribute.add("Type");
				attribute.add("Revision");
				attribute.add("Originated");
				attribute.add("Phase");
				attribute.add("Owner");
				attribute.add("Segment");
				attribute.add("Structured Release Criteria Required");
				attribute.add("Release Date");
				attribute.add("Effective Date");
				attribute.add("Expiration Date");
				attribute.add("Previous Revision Obsolete Date");
				attribute.add("Manufacturing Status");
				attribute.add("Reason for Change");
				attribute.add("Other Names");
				attribute.add("Local Description");
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

		//related specification
	    @Test(dependsOnMethods="atrributes")
	    public void relatedSpecification() {
		try {
			if(driver.findElement(By.xpath("//*[@id=\"two\"]/div/div/div/table")).isDisplayed()){

				List <String> r=new ArrayList();
				r.add("Name");
				r.add("Originator");
				r.add("Source");
				r.add("Title");
				r.add("Type");
				r.add("Revision");
				r.add("Description");
				r.add("State");
				r.add("Specification SubType");
				r.add("Inheritance Type");


				WebElement rel=driver.findElement(By.xpath("//*[@id=\"two\"]/div/div/div/table"));
				List<WebElement> row=rel.findElements(By.tagName("tr"));
				List<WebElement> col=row.get(0).findElements(By.tagName("th"));
				for(String s:r) {
					int count=0;

					for(WebElement c:col) {
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
							if(count>=col.size()) 
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
			System.out.println("related specification in template but missing in webpage");
		}
	    }


		//reference document
	    @Test(dependsOnMethods="relatedSpecification")
	    public void refernceDocument() {
		try {
			if(driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/div/table")).isDisplayed()) {
				List <String> b=new ArrayList();
				b.add("Name");
				b.add("Language");
				b.add("Source");
				b.add("Title");
				b.add("Type");
				b.add("Rev");
				b.add("Description");
				b.add("State");


				WebElement ref=driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/div/table"));
				List<WebElement> rows=ref.findElements(By.tagName("tr"));
				List<WebElement> cols=rows.get(0).findElements(By.tagName("th"));
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
			System.out.println("reference document in template but missing in webpage");
		}

	}






	//Ownership
	@Test(dependsOnMethods="refernceDocument")
	public void ownership() throws Exception 
	{
		try {
			if(driver.findElement(By.id("six")).isDisplayed()) {
				driver.findElement(By.id("six")).click();
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
		 public void IPCLass() {
		try {
			if(driver.findElement(By.xpath("//*[@id=\"seven\"]/div/div/table")).isDisplayed()) {

				List <String> b=new ArrayList();
				b.add("Name");
				b.add("Type");
				b.add("Has Class Access?");
				b.add("Description");
				b.add("State");


				WebElement ip=driver.findElement(By.xpath("//*[@id=\"seven\"]/div/div/table"));
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
		public void Organization() {
		try {
			if(driver.findElement(By.xpath("//*[@id=\"nine\"]/div")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"nine\"]/div")).click();
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
			System.out.println("organisation in template but missing in webpage");
		}

	}

	//performance characteristic
	@Test(dependsOnMethods="Organization")
	public void performance_Characteristic() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//*[@id=\"four\"]/div/div/table")).isDisplayed()) 
			{

				List<String> pc=new ArrayList<String>();
				pc.add("Chg");
				pc.add("Characteristic(Ch) Characteristic Specifics(CS)");
				pc.add("Test Method (Name) Test Method Logic (TML) Test method Origin     (TMO) Other Test Method Number (TM#) Test Method Specifics (Sp) Test Method Reference Document Name(TMRDN)");
				pc.add("Sampling(SM) Subgroup(SG)");
				pc.add("Plant Testing Level(LVL) Plant Testing:Retesting(RT) Retesting Unit Of Measure(UoM)");
				pc.add("Lower Specification Limit(LSL) Lower Target(LTGT) Target(TGT) Upper Target(UTGT) Upper Specification Limit(USL)");
				pc.add("Unit of Measure(UoM) Report to Nearest(RTN) Report Type(RT)");
				pc.add("Unit of Measure(UoM) Report to Nearest(RTN) Report Type(RT)");
				pc.add("Release Criteria(RC)");
				pc.add("Action Required(AC) Criticality Factor(CR) Basis(BA)");
				pc.add("Test Group(TG) Application(AP)");
				pc.add("CS");
				pc.add("CH");
				pc.add("NAME");
				pc.add("TML");
				pc.add("TMO");
				pc.add("TM#");
				pc.add("SM");
				pc.add("SG");
				pc.add("SP");
				pc.add("LVL");
				pc.add("RT");
				pc.add("UOM");
				pc.add("LSL");
				pc.add("TMRDN");
				pc.add("LTGT");
				pc.add("TGT");
				pc.add("UTGT");
				pc.add("USL");
				pc.add("RT");
				pc.add("RTN");
				pc.add("RC");
				pc.add("AC");
				pc.add("CR");
				pc.add("BA");
				pc.add("TG"); 
				pc.add("AP");


				List<String> perfol=new ArrayList<String>();
				WebElement tab=driver.findElement(By.xpath("//*[@id=\"four\"]/div/div/table/thead"));
				List<WebElement> rows=tab.findElements(By.tagName("tr"));
				List<WebElement> cols=rows.get(0).findElements(By.tagName("th"));
				for(WebElement col:cols)
				{
					String ss=col.getText();
					perfol.add(ss);
				}

				List<String> p=new ArrayList<String>();
				WebElement tab1=driver.findElement(By.xpath("//*[@id=\"four\"]/div/div/table/tbody"));
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
			System.out.println("Performance Characteristic present in template but missing in webpage");
		}
	}

	//life cycle
	@Test(dependsOnMethods="performance_Characteristic")
	public void lifecycle() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.id("five")).isDisplayed()) {

				List <String> b=new ArrayList();
				b.add("Name");
				b.add("Approver");
				b.add("Title");
				b.add("Approval Status");
				b.add("Approval/Due Date");
				b.add("Comments/Instructions");


				WebElement ip=driver.findElement(By.xpath("//*[@id=\"five\"]/div/div/table"));
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
			System.out.println("life cycle present in template but missing in webpage");
		}

	}

	//Security class
	@Test(dependsOnMethods="lifecycle")
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
	void Files() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.getPageSource().contains("Files")){
			System.out.println("Files is  present");

		}

		else {
			System.out.println("Files present in template but missing in webpage");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}
}
