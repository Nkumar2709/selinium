package com.atcost.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atcost.base.BaseClass;
import com.atcost.pageobject.LoginPage;
import com.atcost.pageobject.MyAccountPage;
import com.atcost.pageobject.RegisterPage;
import com.github.javafaker.Faker;

public class TC_RegisterPage_002 extends BaseClass{

	RegisterPage register;
	LoginPage login;
	MyAccountPage myaccount;
	@BeforeMethod
	public void loingTesT() throws Throwable {
		setup();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	@Test
	public void NewuserRegister() throws InterruptedException {
		
		login = new LoginPage();
		login.ClickGotoLogin();
		login.Registerbutton();
		register = new RegisterPage();
		String Newpass="Admin@123";
		Faker faker= new Faker();
		String fname=faker.name().firstName();
		String lanme=faker.name().lastName();
		register.vilidateAcountCreatePage(fname, lanme, fname+lanme+"@gmail.com", null, "Haryana", "Gurgaon", "Sector 46", null, null, Newpass, Newpass, null, null);
		register.ClickContinueButton();
		String titl=register.titleSuccReg();
		Assert.assertEquals(titl, "Your Account Has Been Created On www.atcost.in!");
		Thread.sleep(2000);
		
	}
	
	
}
