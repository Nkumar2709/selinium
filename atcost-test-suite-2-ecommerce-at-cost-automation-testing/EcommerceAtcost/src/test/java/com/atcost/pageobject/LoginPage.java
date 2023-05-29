package com.atcost.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atcost.base.BaseClass;

import actiondriver.Action;

public class LoginPage extends BaseClass{
	
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbutton;
	
	@FindBy(id="login_button")
	WebElement gotologin;
	
	@FindBy(xpath = "//a[normalize-space()='Register Account']")
	WebElement RegisterAccotun;
	
	@FindBy(xpath ="//a[normalize-space()='Log out']" )
	WebElement logout;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement warningMeg;
	
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	Action action =new Action();
	
	public void ClickGotoLogin() {
		
		
		action.click(driver, gotologin);
		
	}
	
	public void EnterUserDetails(String id, String pass) {
		
		action.type(Email, id);
		action.type(password, pass);
		
	}
	public void ClickLogin() {
		
		action.click(driver, loginbutton);
	}
	
	public String warnignmeg() {
		
		String war=warningMeg.getText();
		return war;
		
	}
	
	public void logout() {
		
		action.click(driver, logout);
	}
	
	public void Registerbutton() {
		
		action.click(driver, RegisterAccotun);
		
	}

}
