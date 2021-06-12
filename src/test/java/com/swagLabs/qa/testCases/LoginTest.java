package com.swagLabs.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swagLabs.qa.base.TestBase;
import com.swagLabs.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage loginPage;
	
	LoginTest(){
		super();	
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginPage=new LoginPage();		
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();	
	}
	
	@Test(enabled=false)
	public void validateUrl() {
		Assert.assertTrue(loginPage.checkUrl());
	}
	
	@Test(enabled=false)
	public void validateTitle() {
		Assert.assertTrue(loginPage.checkTitle());
	}
	
	@Test(enabled=false)
	public void validateLoginButtonDisplayed() {
		Assert.assertTrue(loginPage.checkLoginButton());
	}
	
	@Test(enabled=false)
	public void validateLoginSuccess() {
		Assert.assertTrue(loginPage.LoginSuccess());
	}
	
	@Test(enabled=false)
	public void validateLoginFail() {
		Assert.assertTrue(loginPage.LoginFail());
	}
	
	@Test(enabled=false)
	public void validateClosingLoginErrorMsg() {
		Assert.assertTrue(loginPage.ClosingErrorMsg());
	}
	
	@Test
	public void validateClosingIncorrectUsernamePwdCross(){
		Assert.assertTrue(loginPage.ClosingIncorrectUsernamePwdCross());
	}


}
