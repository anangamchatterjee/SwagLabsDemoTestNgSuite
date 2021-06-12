package com.swagLabs.qa.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.swagLabs.qa.base.TestBase;
import com.swagLabs.qa.pages.Dashboard;
import com.swagLabs.qa.pages.LoginPage;
import com.swagLabs.qa.util.TestUtil;

public class DashboardTest extends TestBase{
	LoginPage loginPage;
	Dashboard dashboard=new Dashboard();
	DashboardTest(){
		super();	
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialize();
		loginPage=new LoginPage();
		dashboard=loginPage.Login();
		//driver.manage().timeouts().implicitlyWait(TestUtil.page_implicit_wait, TimeUnit.SECONDS);
//		Thread.sleep(5000);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test(enabled=false)
	public void validateUrl() {
		Assert.assertTrue(dashboard.checkUrl());
	}
	
	@Test(enabled=false)
	public void validateIcon() {
		Assert.assertTrue(dashboard.checkIcon());
	}
	
	@Test(enabled=false)
	public void validateMenuButton() {
		Assert.assertTrue(dashboard.checkMenuButton());
	}
	
	@Test(enabled=false)
	public void validateMenuItemList() {
		Assert.assertTrue(dashboard.checkMenuItemList());
	}
	
	@Test(enabled=false)
	public void validateMenuItemColorOnHover(){
		Assert.assertTrue(dashboard.colorChangeOnHoveringMenuList());
	}
	
	@Test
	public void validateClickOnAllItems(){
		dashboard.clickOnAllItems();
	}
	
	

}
