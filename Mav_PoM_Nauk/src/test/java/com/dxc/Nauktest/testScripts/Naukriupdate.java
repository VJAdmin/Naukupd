package com.dxc.Nauktest.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.dxc.Nauktest.TestBase.TestBase;
import com.dxc.Nauktest.pageLibrary.LoginPage;
import com.dxc.Nauktest.pageLibrary.MyNaukPage;
//import com.dxc.Nauktest.pageLibrary.MyNaukPage;

public class Naukriupdate extends TestBase{
	
	
	
	@BeforeSuite
	public void bfsuite() throws Exception{
		init();
		driver = selectBrowser(Repository.getProperty("browser"));
		impWait(5);
		System.out.println(Repository.getProperty("baseUrl"));
		driver.get(Repository.getProperty("baseUrl"));
	}
	
	@Test
	public void naukriUpdateprof() throws InterruptedException{
		
		LoginPage loginpg = new LoginPage();
		impWait(5);
		loginpg.clickonLoginLink();
		loginpg.enterLoginID("vijay.surineni@outlook.com");
		loginpg.enterPassword("Tools@098");
		loginpg.clickloginbutton();
		impWait(7);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MyNaukPage mnp = new MyNaukPage();
		mnp.changeResumetitle();
		//logout from naukri
		mnp.naukLogout();
		
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
	

}
