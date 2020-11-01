package com_hackathon_test;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_hackathon_base.baseUI;
//import com_hackethon_utils.TestDataProvider;

public class HotelBooking extends baseUI {
	

@Test()
public void TestScenarioThree()throws Exception
{
	logger = report.createTest("Hotel booking");
	invokeBrowser("Firefox"); // Opening the browser
	openURL(readPropertiesFile("url"));//Opening the site
	selectHotel();//Clicking hotel
	listAdults();//extracting the number of adults list and displaying it
	quitBrowser();//Quitting the browser
	
}
@AfterTest
public void endReport() {
	report.flush();
}



}