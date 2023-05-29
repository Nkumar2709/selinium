package com.atcost.testCases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atcost.base.BaseClass;
import com.atcost.pageobject.LoginPage;

public class TC_Login_001 extends BaseClass{
	
	LoginPage login;
	
	@BeforeMethod
	public void loingTesT() throws Throwable {
		setup();
		
	}
	

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	@Test(priority=1)
	public void loginwithVaildData() {
		
		
		login = new LoginPage();
		login.ClickGotoLogin();
		login.EnterUserDetails(prop.getProperty("username"), prop.getProperty("password"));
		login.ClickLogin();
		if(driver.getTitle().equals("My Account"))
		{
		Assert.assertTrue(true);
		System.out.println("Title Matched");
		}
		else
		{	System.out.println("Title not Matched");
		}
		login.logout();
	}
	
	@Test(priority=2, dataProvider = "login-Data")
	public void loginwithInVaildData(String id, String Pass) {
		
		
		login = new LoginPage();
		login.ClickGotoLogin();
		login.EnterUserDetails(id, Pass);
		login.ClickLogin();
		String mes=login.warnignmeg();
		String act="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(mes, act);
	}
	@DataProvider(name="login-Data")
	public Object[][] userData(){
		
		Object[][] data = new Object[2][2];
		data[0][0]="ashishdewal@gmail.com";
		data[0][1]="Admin@123";
		
		data[1][0]="";
		data[1][1]="";
		
		return data;
	}
	

}
