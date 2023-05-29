package com.atcost.pageobject;

import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atcost.base.BaseClass;

import actiondriver.Action;

public class MyAccountPage extends BaseClass{

	@FindBy(xpath = "//div[@class='menu_cell']//img")
	WebElement Atcostlogo;
	
	@FindBy(xpath = "//div[@class='bottom_buttons']//a[1]")
	WebElement seeAllbutton;
	
	@FindBy(xpath = "//div[@class='bordered_content products_holder box']//button")
	WebElement AddtoCart;
	
	public MyAccountPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	Action action =new Action();
	
	public void Clickonlogo() {
		action.click(driver, Atcostlogo);
	}
	public void ClicksellButton() {
		action.click(driver, seeAllbutton);
	}
	
	public void ClickonAddtoCartButton() {
		
		int count=1;
		List<WebElement>list=driver.findElements(By.xpath("/div[@class='bordered_content products_holder box']//button"));
		if(list.size()!=0)
		{
			for(int i=0; i<list.size(); i++) {
				
				WebElement ele=list.get(i);
				String add=ele.getText();
				driver.findElement(By.xpath("/div[@class='bordered_content products_holder box']//button")).click();
				count++;
				if (count <=5) {
					break;
			}
			
			}
		
		}
		
	}
}
