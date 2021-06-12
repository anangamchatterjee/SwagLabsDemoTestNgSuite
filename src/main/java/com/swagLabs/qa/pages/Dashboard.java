package com.swagLabs.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

import com.swagLabs.qa.base.TestBase;

public class Dashboard extends TestBase {

	public Dashboard() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='peek']")
	WebElement cartoonIcon;
	@FindBy(xpath = "//span[@class='title']")
	WebElement productIcon;
	@FindBy(id = "react-burger-menu-btn")
	WebElement menuButton;
	@FindBy(className = "bm-item-list")
	WebElement menuItemList;
	@FindBy(id = "inventory_sidebar_link")
	WebElement allItemsMenu;

	public boolean checkUrl() {
		if (driver.getCurrentUrl().contains("inventory.html")) {
			return true;
		}
		return false;
	}

	public boolean checkIcon() {
		boolean flag = false;
		if (cartoonIcon.isDisplayed()) {
			flag = true;
		}

		if (productIcon.isDisplayed()) {
			flag = true;
		}

		return flag;
	}

	public boolean checkMenuButton() {
		boolean flag = false;
		if (menuButton.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void clickMenuButton() {
		menuButton.click();
	}

	public boolean checkMenuItemList() {
		clickMenuButton();
		boolean flag = false;
		if (menuItemList.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean colorChangeOnHoveringMenuList() {
		clickMenuButton();
		// create utillity for explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(menuItemList));
		Actions a = new Actions(driver);
		boolean flag = false;
		List<WebElement> itemList = driver.findElements(By.xpath("//nav[@class='bm-item-list']/a"));
		for (int i = 0; i < itemList.size(); i++) {
			a.moveToElement(itemList.get(i)).build().perform();
			for (int j = 0; j < itemList.size(); j++) {
				System.out.println(itemList.get(j).getCssValue("color"));
				if (i != j) {
					if (itemList.get(j).getCssValue("color").contains(prop.getProperty("No_Color"))) {
						flag = true;
					}
				} else {
					if (itemList.get(j).getCssValue("color").contains(prop.getProperty("Red_Color"))) {
						flag = true;
					}
				}
			}
		}
		return flag;

	}

	public boolean clickOnAllItems(){
		clickMenuButton();
		// create utillity for explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(menuItemList));

		List<WebElement> itemList = driver.findElements(By.xpath("//div/nav[@class='bm-item-list']/a"));
		List<WebElement> itemListFinal=new ArrayList<WebElement>();
		for(int i=0;i<itemList.size();i++) {
			itemListFinal.add(driver.findElement(By.xpath("//div/nav[@class='bm-item-list']/a["+(i+1)+"]")));
			System.out.println(itemListFinal.get(i));
			System.out.println(itemListFinal.get(i).getText());
		}
		for (int i = 0; i<=itemListFinal.size(); i++) {
			System.out.println("********************");
			System.out.println(i);
			System.out.println(itemListFinal.get(i).getText());
			if (itemListFinal.get(i).getText().equalsIgnoreCase("ALL ITEMS")) {
				itemListFinal.get(i).click();
				if (driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html")) {
					continue;
				}
			} else if (itemListFinal.get(i).getText().equalsIgnoreCase("ABOUT")) {
				itemListFinal.get(i).click();
				if (driver.getCurrentUrl().equalsIgnoreCase("https://saucelabs.com/")) {
					driver.navigate().back();
					clickMenuButton();
					continue;
				}
			} else if (itemListFinal.get(i).getText().equalsIgnoreCase("LOGOUT")) {
				System.out.println(itemListFinal.get(i));
				itemListFinal.get(i).click();
				if (driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/")) {
					LoginPage login1 = new LoginPage();
					login1.Login();
					clickMenuButton();
					continue;
				}
			} else if (itemListFinal.get(i).getText().equalsIgnoreCase("RESET APP STATE")) {
				System.out.println(itemList.get(i).getText());
				itemListFinal.get(i).click();
				if (driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html")) {
					continue;
				}
			}
		}
		return true;
	}

}
