package com.atcost.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atcost.base.BaseClass;
import com.github.javafaker.Faker;

import actiondriver.Action;
import com.atcost.pageobject.MyAccountPage;

public class RegisterPage extends BaseClass{

	@FindBy(xpath="//h1[normalize-space()='Register Account']")
	WebElement findTitle;
	
	@FindBy(id="input-firstname")
	WebElement firsName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement newemail;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-zone")
	WebElement State;
	
	@FindBy(id="input-city_id")
	WebElement Cityid;
	
	@FindBy(xpath ="//input[@id='input-address-2']")
	WebElement inputaddress;
	
	@FindBy(id="input-address-1")
	WebElement Housno;
	
	@FindBy(id="input-postcode")
	WebElement postcode;
	
	@FindBy(id="input-password")
	WebElement Regpassword;
	
	@FindBy(id="input-confirm")
	WebElement confirmPass;
	
	@FindBy(id="input-referral-code")
	WebElement refecode;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement conti;
	
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	Action action = new Action();
	Faker faker= new Faker();
	public void vilidateAcountCreatePage(String fName, 
			String lName, 
			String email, 
			String number, 
			String stateName, 
			String cityName,
			String location, 
			String Hno, 
			String zip, 
			String newpassowrd, 
			String Cpassword,
			String ref,
			String config) {
		
		
		action.isDisplayed(driver, findTitle);
		action.type(firsName, fName);
		action.type(lastName, lName);
		action.type(newemail, email);
		action.type(telephone, faker.number().digits(10));
		action.selectByVisibleText(stateName, State);
		action.selectByVisibleText(cityName, Cityid);
		action.selectBySendkeys(location, inputaddress);
		action.type(Housno, faker.address().buildingNumber());
		action.type(postcode, faker.address().zipCode());
		action.type(Regpassword, newpassowrd);
		action.type(confirmPass, Cpassword);
		action.type(refecode, ref);
		
	}
	public void ClickContinueButton() {
		action.click(driver, conti);
		
	}
	
	public String titleSuccReg() {
		
		return driver.getTitle();
	}

}

