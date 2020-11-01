package com_hackathon_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com_hackathon_utils.dateUtils;

import com_hackathon_utils.ExtentReportManager;

public class baseUI {
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	//*********************************** Reading Properties File***********************************************************
	public static String readPropertiesFile(String value) throws IOException {
		  prop = new Properties();
		 String val=null;
		 try {
			InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Object Repository\\config.properties");
		    prop.load(input);
		     val=prop.getProperty(value);
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return val;
		 
	 }
	// ************************************************INVOKE BROWSER************************************************************
		public void invokeBrowser(String browserName) {
			try {
				if (browserName.equalsIgnoreCase("Chrome")) {
					
					String nodeUrl="http://192.168.56.1:5555/wd/hub";
				 	DesiredCapabilities capabilities=DesiredCapabilities.chrome();
				 	driver=new RemoteWebDriver(new URL(nodeUrl),capabilities);
//					System.setProperty("webdriver.chrome.driver",
//							System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
//					driver = new ChromeDriver();
				} else if (browserName.equalsIgnoreCase("Firefox")) {
					
					String nodeUrl="http://192.168.56.1:5555/wd/hub";
				 	DesiredCapabilities capabilities=DesiredCapabilities.firefox();
				 	driver=new RemoteWebDriver(new URL(nodeUrl),capabilities);

//					System.setProperty("webdriver.gecko.driver",
//							System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\geckodriver.exe");
//					driver = new FirefoxDriver();
				}

				else if (browserName.equalsIgnoreCase("Opera")) {

//					System.setProperty("webdriver.opera.driver",
//							System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\operadriver.exe");
//					driver = new OperaDriver();
					String nodeUrl="http://192.168.56.1:5555/wd/hub";
				 	DesiredCapabilities capabilities=DesiredCapabilities.opera();
				 	driver=new RemoteWebDriver(new URL(nodeUrl),capabilities);
				} else {
					System.out.println(
							"Please Invoke the Correct Browser,i.e : Chrome, Opera or Firefox. Thank you! Have a nice day ");
				}
			} catch (Exception e) {
				reportFail(e.getMessage());
			}

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		
		}

		// ********************************************** OPENING URL************************************************************
		public void openURL(String url) {
			try {
				driver.get(url);
				driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				reportPass(url + " Identified Successfully");
			} catch (Exception e) {
				reportFail(e.getMessage());
			}
		}

		
		// **********************************************QUIT BROWSER*****************************************************************************//
		public void quitBrowser() {

			driver.quit();
		}
		
		

		// *********************************************NAVIGATE TO HOME**************************************************
		public void navigateTohome() {
			try {
				driver.navigate().to(readPropertiesFile("url"));
				driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				reportPass("Navigated to Home Page Successfully");
			} catch (Exception e) {
				reportFail(e.getMessage());
			}
		}
		
		//**********************************************SELECTING CAB BUTTON***************************************************
		public void selectCab() 
		{try {
			driver.findElement(By.xpath(readPropertiesFile("cabs"))).click();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportPass("Cab tab clicked successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		}
		
		//***********************************************SELECTING GIFT BUTTON***********************************************
		public void selectGift()
		{try {
			driver.findElement(By.xpath(readPropertiesFile("gift"))).click();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportPass("Gift tab clicked successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		}
		//***********************************************SELECTING HOTEL BUTTON*********************************************
		
		public void selectHotel()
		{try {
			driver.findElement(By.xpath(readPropertiesFile("hotel"))).click();
			reportPass("Hotel clicked successfully");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}catch(IOException e) {
			
			reportFail(e.getMessage());
		}
		}
		//**********************************************SELECTING CARD FOR GROUP GIFTING***************************************************
		public void selectCard()
		{ try {
			driver.findElement(By.xpath(readPropertiesFile("card"))).click();
			Thread.sleep(5000);
			reportPass("EaseMyTrip card clicked successfully");
		}catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		}
		//*********************************************SELECTING CALENDAR********************************************************************
		public void selectCalendar()throws IOException
		{try {
			driver.findElement(By.xpath(readPropertiesFile("calendar"))).click();
			Thread.sleep(1000);
			reportPass("Calendar clicked successfully");
		}catch(Exception e)
		{
			reportFail(e.getMessage());
		}
			
		}
		
		
		//***********************************************SOURCE /DESTINATION DETAILS**************************************************
		public void inputcabDetails(String from, String to){
			try {
			 WebElement src=driver.findElement(By.xpath(readPropertiesFile("frombox_xpath")));
			 //Thread.sleep(1000);
				src.sendKeys(from);
				Thread.sleep(1000);
				WebElement fromplace =driver.findElement(By.xpath("//div[contains(text(),'"+from+"')]"));
				//Thread.sleep(1000);
				fromplace.click();
				Thread.sleep(2000);
				reportPass("Source detail selected");
			}
			catch(Exception e)
			{
				reportFail(e.getMessage());
			}
			try {	
				WebElement destin=driver.findElement(By.xpath(readPropertiesFile("tobox_xpath")));
				//Thread.sleep(1000);
				destin.sendKeys(to);
				Thread.sleep(1000);
				//destin.sendKeys(Keys.ARROW_DOWN);
				WebElement toplace =driver.findElement(By.xpath("//div[contains(text(),'"+to+"')]"));
				//Thread.sleep(1000);
				toplace.click();
				Thread.sleep(2000);
				reportPass("Destination detail selected");
			}
			catch(Exception e)
			{
				reportFail(e.getMessage());
			}
			
			 
			 
		 }
		
		//******************************************DATE PICKER******************************************************
		public void selectDateIncalendar(String date) throws IOException, InterruptedException {

			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date expectedDate = dateFormat.parse(date);

				String day = new SimpleDateFormat("dd").format(expectedDate);
				String month = new SimpleDateFormat("MMMM").format(expectedDate);
				String mon = new SimpleDateFormat("MM").format(expectedDate);
				String year = new SimpleDateFormat("yyyy").format(expectedDate);
	  //System.out.println(day+" "+month+" "+year+""+mon);
	  int mn= Integer.parseInt(mon);
				String expectedMonthYear = month + " " + year;

				while (true) {
					String displayMonth = driver.findElement(By.xpath(readPropertiesFile("month"))).getText();
					String displayYear=driver.findElement(By.xpath(readPropertiesFile("year"))).getText();
					if (year.equalsIgnoreCase(displayYear) && month.equalsIgnoreCase(displayMonth)) {

						driver.findElement(By.xpath("//td[@data-date="+day+" and @data-month="+(mn-1)+" and @data-year="+year+"]//div[contains(text(),"+day+")]")).click();
						Thread.sleep(3000);
						reportPass("Date Selected successfully");
						break;
					} else if (expectedDate.compareTo(currentDate) > 0) {
						driver.findElement(By.xpath("//div[2]//button[3]")).click();
					} 

				}

			} catch (ParseException e) {
				reportFail(e.getMessage());
			}

		}
		//******************************************PICKUP TIME**************************************************************************************************************
		public void Timepicker(String time) throws Exception{
				
			Actions	actions = new Actions(driver); 
			for(int i=0;i<20;i++)
			{
				driver.findElement(By.xpath(readPropertiesFile("pickup"))).click();
			}
			actions.moveToElement(driver.findElement(By.xpath("//div[@data-hour='"+time+"']"))).click();
			actions.perform();
			reportPass("PickUp time "+time+":00 selected successfully");
			Thread.sleep(5000);
			
			
		}
		//****************************************************SEARCH*******************************************************************************
		public void search() {
			try
			{
			driver.findElement(By.className(readPropertiesFile("search"))).click();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			Thread.sleep(2000);
			reportPass("Search for the given input detail is successful");
			}
			catch(Exception e)
			{
				reportFail(e.getMessage());
			}
			
		}
		//*************************************************************SUV CAR LIST DISPLAY*************************************************
		public void suvcarlist() throws Exception{
				 if(driver.findElement(By.xpath("//h3[contains(text(),'SUV')]")) != null)
			{ String car=driver.findElement(By.xpath("//h3[contains(text(),'SUV- Xylo/ Ertiga or Similar')]")).getText();
		   String price=driver.findElement(By.xpath("//div[@class='car-dtl']/h3[contains(text(),'SUV')]/ancestor::div[@class='car-dtl']/ancestor::div/div[@class='fare_sec']/p[@class='b_fare']")).getText();
		 reportPass(car+ " Price: "+price);
			}
				 else
				 {
					 reportPass("No SUV car available");
				 }
		}

		//************************************************************group gifting detail***********************************************************
		public void inputGiftCardDetails(String den, String num) 
		{try {
			JavascriptExecutor js= (JavascriptExecutor)driver;

			WebElement ele=driver.findElement(By.xpath(readPropertiesFile("denomination")));
			js.executeScript("arguments[0].scrollIntoView();", ele);
			driver.findElement(By.xpath(readPropertiesFile("denomination"))).sendKeys(den);
			reportPass("Denomination value filled successfully");
			Select s= new Select(driver.findElement(By.xpath(readPropertiesFile("group-dropdown"))));
			s.selectByVisibleText(num);
			reportPass("Group number selected successfully");
	
			driver.findElement(By.xpath(readPropertiesFile("today"))).click();
			reportPass("Today clicked successfully");
			Thread.sleep(1000);
		}catch(Exception e)
			{
				reportFail(e.getMessage());
			}
		}
		
		//*************************************************SENDER DETAIL*************************************************************
		public void inputSenderDetails(String sname, String smail, String sphn)
		{try {
			driver.findElement(By.xpath(readPropertiesFile("sender-name"))).sendKeys(sname);
			reportPass("Sender name filled successfully");
			driver.findElement(By.xpath(readPropertiesFile("sender-mail"))).sendKeys(smail);
			reportPass("Sender email filled successfully");
			driver.findElement(By.xpath(readPropertiesFile("sender-phone"))).sendKeys(sphn);
			reportPass("Sender phone number filled successfully");
			Thread.sleep(1000);
		}catch(Exception e)
			{
				reportFail(e.getMessage());
			}
		}
		
		//*************************************************RECEIVER DETAIL*********************************************************
		public void inputReceiverDetails(String rname, String rmail,String remail, String rphn)
		{try {
			driver.findElement(By.xpath(readPropertiesFile("receiver-name"))).sendKeys(rname);
			reportPass("Receiver name filled successfully");
		driver.findElement(By.xpath(readPropertiesFile("receiver-mail"))).sendKeys(rmail);
		reportPass("Receiver email filled successfully");
		driver.findElement(By.xpath(readPropertiesFile("receiver-remail"))).sendKeys(remail);
		reportPass("Receiver email confirmation filled successfully");
		driver.findElement(By.xpath(readPropertiesFile("receiver-phone"))).sendKeys(rphn);
		reportPass("Receiver phone filled successfully");
		Thread.sleep(1000);
		}catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		}
		
		//*****************************************************CONFIRM AND MESSAGE DISPLAY*************************************************
		public void agree()
		{
			try {
				driver.findElement(By.xpath(readPropertiesFile("confirm"))).click();
				reportPass("Confirmation box selectd succesfully");
				String msg=driver.findElement(By.xpath(readPropertiesFile("error"))).getText();
				reportPass(msg);
			} catch (IOException e) {
				
				reportFail(e.getMessage());
			}
			
			//Assert.assertEquals(msg,"Invalid receiver email address.");
		}
		
		//*****************************************************LIST OF ADULT*******************************************************
		public void listAdults() throws InterruptedException
		{try {
			driver.findElement(By.xpath(readPropertiesFile("down"))).click();
			driver.findElement(By.xpath(readPropertiesFile("minus"))).click();
		    reportPass("List of Number of adults");
		    for (int i=1; i<=4;i++)
		    {	 String adultnum =driver.findElement(By.xpath(readPropertiesFile("adult"))).getText();
		        reportPass(adultnum);
		     driver.findElement(By.xpath(readPropertiesFile("plus"))).click();
		     Thread.sleep(1000); 
		    }
		    }catch(IOException e) {
				
				reportFail(e.getMessage());
			}

		}
		
		// *******************************************REPORTING FUNCTIONS******************************************************************************

		public void reportFail(String reportString) {
			logger.log(Status.FAIL, reportString);
			takeScreenShotOnFailure();
			Assert.fail(reportString);
		}

		// *********************************************************************************************
		public void reportPass(String reportString) {
			logger.log(Status.PASS, reportString);
		}
		// **********************************************SCREENSHOT ON FAILURE***********************************************
		public void takeScreenShotOnFailure() {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

			File destFile = new File(
					System.getProperty("user.dir") + "//ScreenShots//" + dateUtils.getTimeStamp() + ".png");
			try {
				FileUtils.copyFile(sourceFile, destFile);
				logger.addScreenCaptureFromPath(
						System.getProperty("user.dir") + "//ScreenShots//" + dateUtils.getTimeStamp() + ".png");

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// ****************************************************************************************************************


	

}
