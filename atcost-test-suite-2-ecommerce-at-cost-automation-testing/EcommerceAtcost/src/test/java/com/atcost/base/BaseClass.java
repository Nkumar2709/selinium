package com.atcost.base;


import java.io.FileReader;

import java.util.Properties;


import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.j2objc.annotations.Property;

import actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;


public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	
	
	public void setup() throws Throwable{
		
			WebDriverManager.chromedriver().setup();
			
			
			if(driver==null) {
				FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
				prop.load(fr);
			}
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless");
				option.addArguments("windows-size=1920,1080");
				driver = new ChromeDriver(option);
				driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
			}
			
			else if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(prop.getProperty("url"));
			}
			Action action = new Action();
			action.implicitWait(driver, 10);
			action.pageLoadTimeOut(driver, 30);
			
	}
	

}
