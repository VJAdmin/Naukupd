package com.dxc.Nauktest.pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.dxc.Nauktest.TestBase.TestBase;

public class MyNaukPage extends TestBase {
	
	
	public void changeResumetitle(){
		driver.findElement(By.cssSelector(".w205")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".f12.ml8")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector("#title")).clear();
		driver.findElement(By.cssSelector("#title")).sendKeys("QA Lead with expertise in functional, Regression, Webservices (SoapUI), Database and Automation(Selenium) testing.");
		driver.findElement(By.cssSelector(".w150bt.fl")).sendKeys(Keys.ENTER);
		
		
	}
	
	public void naukLogout(){
		
		Actions act = new Actions(driver);
		WebElement mynaukri = driver.findElement(By.cssSelector(".topIcon.user>span"));
		WebElement logout = driver.findElement(By.xpath(".//*[@id='mainHeader']/div/div/ul[2]/li[2]/div/ul/li[5]/a"));
		act.moveToElement(mynaukri).moveToElement(logout).click(logout).build().perform();
	}
	

}
