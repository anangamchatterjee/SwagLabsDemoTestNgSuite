package com.swagLabs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swagLabs.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user-name")
	WebElement userName;
	@FindBy(id = "password")
	WebElement pwd;
	@FindBy(id = "login-button")
	WebElement login;
	@FindBy(xpath = "//button[@class='error-button']")
	WebElement loginError;
	@FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
	WebElement loginErrorMsg;
	@FindBy(xpath = "//div[@class='error-message-container']")
	WebElement errorMsgContainer;
	// @FindBy(xpath = "//div[@class='form_group']//*[local-name()='svg' and
	// @data-icon='times-circle']")
	// By incorrectPasswordCross;

	public boolean checkUrl() {
		if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
			return true;
		} else
			return false;
	}

	public boolean checkTitle() {
		if (driver.getTitle().equals("Swag Labs")) {
			return true;
		} else
			return false;
	}

	public boolean checkLoginButton() {
		if (login.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean LoginSuccess() {

		userName.sendKeys(prop.getProperty("username"));
		pwd.sendKeys(prop.getProperty("password"));
		login.click();
		if (driver.getCurrentUrl().contains("/inventory.html")) {
			return true;
		} else
			return false;

	}

	public Dashboard Login() {
		userName.sendKeys(prop.getProperty("username"));
		pwd.sendKeys(prop.getProperty("password"));
		login.click();
		return new Dashboard();
	}

	public boolean LoginFail() {

		boolean flag = false;
		userName.sendKeys(prop.getProperty("username"));
		pwd.sendKeys("abc");
		login.click();
		if (loginError.isDisplayed()) {
			flag = true;
		}
		loginError.click();
		userName.sendKeys("abc");
		pwd.sendKeys(prop.getProperty("password"));
		login.click();
		if (loginError.isDisplayed()) {
			flag = true;
		} else
			flag = false;
		return flag;

	}

	public boolean ClosingErrorMsg() {
		userName.sendKeys(prop.getProperty("username"));
		pwd.sendKeys("abc");
		login.click();
		loginError.click();
		if (errorMsgContainer.isEnabled()) {
			return true;
		} else
			return false;
	}

	public boolean ClosingIncorrectUsernamePwdCross() {
		userName.sendKeys(prop.getProperty("username"));
		pwd.sendKeys("abc");
		login.click();
		loginError.click();
		boolean flag = false;
		try {
			driver.findElement(
					By.xpath("//div[@class='form_group']//*[local-name()='svg' and @data-icon='times-circle']"));
		} catch (NoSuchElementException e) {
			flag = true;
		}
		return flag;
	}

}
