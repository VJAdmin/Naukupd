package com.dxc.Nauktest.pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dxc.Nauktest.TestBase.TestBase;

public class LoginPage extends TestBase{

	
	By loginlink = By.id("login_Layer");
	By logintext = By.id("eLogin");
	By pwdtext = By.id("pLogin");
	By loginbutton = By.xpath("//button[@value=\"Login\"]");
	
	public void launchNaukri(){
		driver.get("https://www.naukri.com/");
	}
	
	public void clickonLoginLink()
	{
		driver.findElement(loginlink).click();
	}
	
	public void enterLoginID(String loginid)
	{
		driver.findElement(logintext).sendKeys(loginid);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(pwdtext).sendKeys(pwd);
	}
	
	public void clickloginbutton()
	{
		driver.findElement(loginbutton).click();
	}
	
	
	
	
}
