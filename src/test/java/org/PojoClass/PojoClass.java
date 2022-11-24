package org.PojoClass;

import org.BaseClasses.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass {
	//private final SearchContext driver = null;
     
	public  PojoClass() {
	PageFactory.initElements(driver,this);
	}
	//WebElement email=driver.findElement(By.id("attribute value"));
	@FindBy(id="email")
	private WebElement emailTxt;
	@FindBy(id="pass")
	private WebElement passwordTxt;
	@FindBy(name="login")
	private WebElement loginBtn;

	public SearchContext getDriver() {
		return driver;
	}
	public WebElement getEmailTxt() {
		return emailTxt;
	}
	public WebElement getPasswordTxt() {
		return passwordTxt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	
}
