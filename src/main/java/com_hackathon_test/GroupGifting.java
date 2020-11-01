package com_hackathon_test;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_hackathon_base.baseUI;
//import com_hackethon_utils.TestDataProvider;

public class GroupGifting extends baseUI {
	

@Test(dataProvider="testTwoData")
public void testScenarioTwo(String den, String num, String sname, String semail, String sphn, String rname, String rmail, String remail,String rphn) throws Exception {

	logger = report.createTest("Group gifting");

	invokeBrowser("chrome"); // Opening the browser
	openURL(readPropertiesFile("url")); //Opening the site
	selectGift(); //clicking gift
	selectCard();//selecting card
	inputGiftCardDetails(den, num);//Inputing card details and number of people for group gifting
	inputSenderDetails(sname,semail,sphn);//Inputting sender details
	inputReceiverDetails(rname, rmail,remail,rphn);//Inputting receiver detail
	agree();//confirming the input form detail and displaying the message
	quitBrowser();//Quitting browser
}


@DataProvider//for second test scenario
public Object[][] testTwoData()
{
//Rows - Number of times your test has to be repeated.
//Columns - Number of parameters in test data.
Object[][] data = new Object[10][9];

data[0][0]="1000";
data[0][1]="6";
data[0][2]="john gopes";
data[0][3]="john@gmail.com";
data[0][4]="1231231231";
data[0][5]="Suezeka nohara";
data[0][6]="sugdfgdf.com";
data[0][7]="sugdfgdf.com";
data[0][8]="8909876780";

data[1][0]="3000";
data[1][1]="4";
data[1][2]="Shivani Sinha";
data[1][3]="abc@gmail.com";
data[1][4]="6786781231";
data[1][5]="Nobita ghosh";
data[1][6]=".com";
data[1][7]="sugdfgdf.com";
data[1][8]="8909812380";

data[2][0]="5000";
data[2][1]="5";
data[2][2]="james Christopher Loius";
data[2][3]="jamen@gmail.com";
data[2][4]="9997876761";
data[2][5]="Eleana Criuise";
data[2][6]="eele";
data[2][7]="e@g.com";
data[2][8]="8909876780";

data[3][0]="5000";
data[3][1]="5";
data[3][2]="james Christopher Loius";
data[3][3]="jamen@gmail.com";
data[3][4]="9997876761";
data[3][5]="Eleana Criuise";
data[3][6]="eele";
data[3][7]="e@g.com";
data[3][8]="8909876780";

data[4][0]="2000";
data[4][1]="2";
data[4][2]="Mexi Columbus";
data[4][3]="max@gmail.com";
data[4][4]="9831231231";
data[4][5]="Malica jenry";
data[4][6]="..com";
data[4][7]="asgfjom";
data[4][8]="0";

data[5][0]="1000";
data[5][1]="6";
data[5][2]="Brownn gopes";
data[5][3]="gopes@gmail.com";
data[5][4]="9931231231";
data[5][5]="Yuzeka nohara";
data[5][6]="dfgdf.com";
data[5][7]="s";
data[5][8]="8909876780";

data[6][0]="1000";
data[6][1]="6";
data[6][2]="john gopes";
data[6][3]="john@gmail.com";
data[6][4]="1231231231";
data[6][5]="Suezeka nohara";
data[6][6]="sugdfgdf.com";
data[6][7]="sugdfgdf.com";
data[6][8]="8909876780";

data[7][0]="1000";
data[7][1]="6";
data[7][2]="john gopes";
data[7][3]="john@gmail.com";
data[7][4]="1231231231";
data[7][5]="Suezeka nohara";
data[7][6]="sugdfgdf.com";
data[7][7]="sugdfgdf.com";
data[7][8]="8909876780";

data[8][0]="2000";
data[8][1]="6";
data[8][2]="Drohny gopes";
data[8][3]="dnhn@gmail.com";
data[8][4]="2031231231";
data[8][5]="Hazeka Kafin";
data[8][6]="sugd";
data[8][7]="om";
data[8][8]="8909876780";

data[9][0]="1000";
data[9][1]="2";
data[9][2]="Nancy gopes";
data[9][3]="nan@gmail.com";
data[9][4]="9090231231";
data[9][5]="Priya sinha";
data[9][6]="yahoo";
data[9][7]="yahoo";
data[9][8]="8909876780";




return data;
}

@AfterTest
public void endReport() {
	report.flush();
}



}