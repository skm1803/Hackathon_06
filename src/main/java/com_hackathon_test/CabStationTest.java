package com_hackathon_test;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_hackathon_base.baseUI;
//import com_hackethon_utils.TestDataProvider;

public class CabStationTest extends baseUI {
	
@Test(dataProvider="testOneData")
	
	public void testScenarioOne(String from, String to, String date, String time) throws Exception {

		logger = report.createTest("Cab booking Outstation");

		invokeBrowser("Chrome"); // Opening the browser
		openURL(readPropertiesFile("url")); //opening the site
		selectCab();//clicking cab
		inputcabDetails(from,to);//entering source and destination
		selectCalendar();//clicking calendar
		selectDateIncalendar(date);//entering date
		Timepicker(time);//entering pickup time
		search();//clicking search
		suvcarlist();//displaying suv car available with lowest price
		quitBrowser();//Quitting browser
}

@DataProvider //for first test scenario
public Object[][] testOneData()
{
//Rows - Number of times your test has to be repeated.
//Columns - Number of parameters in test data.
Object[][] data = new Object[9][4];

data[0][0]="Delhi";
data[0][1]="Manali";
data[0][2]="23/12/2020";
data[0][3]="17";	

data[1][0]="Mumbai";
data[1][1]="Goa";
data[1][2]="23/12/2020";
data[1][3]="5";	

data[2][0]="Kolkata";
data[2][1]="Durgapur";
data[2][2]="12/11/2020";
data[2][3]="7";	

data[3][0]="Kolkata";
data[3][1]="Durgapur";
data[3][2]="22/11/2020";
data[3][3]="8";	

data[4][0]="Chennai";
data[4][1]="Coimbatore";
data[4][2]="3/12/2020";
data[4][3]="18";	

data[5][0]="Kerala";
data[5][1]="Coimbatore";
data[5][2]="27/12/2020";
data[5][3]="3";	

data[6][0]="Delhi";
data[6][1]="Haryana";
data[6][2]="2/1/2021";
data[6][3]="9";	

data[7][0]="Kodaikanal";
data[7][1]="Chennai";
data[7][2]="23/12/2020";
data[7][3]="9";	

data[8][0]="Kolkata";
data[8][1]="Delhi";
data[8][2]="4/11/2020";
data[8][3]="8";	


return data;
}
@AfterTest
public void endReport() {
	report.flush();
}



}