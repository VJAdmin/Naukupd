package com.dxc.Nauktest.TestBase;

	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

	import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;



	import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dxc.Nauktest.testUtils.Utills;


	public class TestBase extends Utills{
		
		
		public static Properties Repository = new Properties();
		public File f;
		public FileInputStream FI;
		//public XLS_Reader Data;
		
		public void init() throws Exception
		{
			System.out.println("Entering init");
			LoadPropertiesFiles();
			
			
		}
		
		public void LoadPropertiesFiles() throws IOException
		{
			System.out.println("Load Properties");
			f = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\dxc\\Nauktest\\Config\\config.properties");
			FI = new FileInputStream(f);
			Repository.load(FI);
					
			}
		
		public WebElement getWebElement(String locator) throws Exception
		{
			System.out.println(locator);
			String val = Repository.getProperty(locator);
			System.out.println("property value" + val);
			return findLocatorElement(Repository.getProperty(locator));
					
		}
		
		public static WebElement findLocatorElement(String locator) throws Exception
		{
			System.out.println("prop value in find locator element " + locator);
			String[] splitstrng = locator.split("_");
			String locatorType = splitstrng[0];
			String locatorValue = splitstrng[1];
			
			if (locatorType.toLowerCase().equals("id"))
				return driver.findElement(By.id(locatorValue));
			else if(locatorType.toLowerCase().equals("xpath"))
				return driver.findElement(By.xpath(locatorValue));
			else if(locatorType.toLowerCase().equals("name"))
				return driver.findElement(By.name(locatorValue));
			else if(locatorType.toLowerCase().equals("classname")
					|| (locatorType.toLowerCase().equals("class")))
				return driver.findElement(By.className(locatorValue));
			else if(locatorType.toLowerCase().equals("tagname")
					|| (locatorType.toLowerCase().equals("tag")))
				return driver.findElement(By.className(locatorValue));
	 		else if(locatorType.toLowerCase().equals("link")
					|| (locatorType.toLowerCase().equals("linktext")))
				return driver.findElement(By.linkText(locatorValue));
			else if(locatorType.toLowerCase().equals("css")
					|| (locatorType.toLowerCase().equals("cssSelector")))
				return driver.findElement(By.cssSelector(locatorValue));
			else if(locatorType.toLowerCase().equals("partiallinktext"))
				return driver.findElement(By.partialLinkText(locatorValue));		
			
			else throw new Exception("Unknown locator type '" + locatorType + "'");
		}
		
		public List<WebElement> getWebElements(String locator) throws Exception
		{
			System.out.println(locator);
			String val = Repository.getProperty(locator);
			System.out.println("property value" + val);
			return findLocatorElements(Repository.getProperty(locator));
					
		}
		
		public static List<WebElement> findLocatorElements(String locator) throws Exception
		{
			System.out.println("prop value in find locator element " + locator);
			String[] splitstrng = locator.split("_");
			String locatorType = splitstrng[0];
			String locatorValue = splitstrng[1];
			
			if (locatorType.toLowerCase().equals("id"))
				return driver.findElements(By.id(locatorValue));
			else if(locatorType.toLowerCase().equals("xpath"))
				return driver.findElements(By.xpath(locatorValue));
			else if(locatorType.toLowerCase().equals("name"))
				return driver.findElements(By.name(locatorValue));
			else if(locatorType.toLowerCase().equals("classname")
					|| (locatorType.toLowerCase().equals("class")))
				return driver.findElements(By.className(locatorValue));
			else if(locatorType.toLowerCase().equals("tagname")
					|| (locatorType.toLowerCase().equals("tag")))
				return driver.findElements(By.className(locatorValue));
	 		else if(locatorType.toLowerCase().equals("link")
					|| (locatorType.toLowerCase().equals("linktext")))
				return driver.findElements(By.linkText(locatorValue));
			else if(locatorType.toLowerCase().equals("css")
					|| (locatorType.toLowerCase().equals("cssSelector")))
				return driver.findElements(By.cssSelector(locatorValue));
			else if(locatorType.toLowerCase().equals("partiallinktext"))
				return driver.findElements(By.partialLinkText(locatorValue));		
			
			else throw new Exception("Unknown locator type '" + locatorType + "'");
		}
		
		public String takeSnapshot(WebDriver driver, String filename) throws IOException
		{
			String uniquefilenm = new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date());
			String screenshotpath = System.getProperty("user.dir")+ "\\src\\com\\FFQHome\\screenshots\\"+filename+uniquefilenm+".png";
			System.out.println(screenshotpath);
			
			//Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)driver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(screenshotpath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);
	                return screenshotpath;
	                	
		}
		
		public void writetonotepad(String s) throws IOException
		{
			FileWriter fr= new FileWriter("C:\\Users\\vsurineni\\workspace1\\FFQHometest\\src\\com\\FFQHome\\log\\quotes.txt", true);
			BufferedWriter br=new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);

			pr.println(s);
			//br.newLine();
					//br.close();
		}
		
			
		
	}


