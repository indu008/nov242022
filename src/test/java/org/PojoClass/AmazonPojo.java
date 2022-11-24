package org.PojoClass;

import org.BaseClasses.BaseClass;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPojo extends BaseClass{
	public  AmazonPojo() {
		PageFactory.initElements(driver,this);
		}
		
		@FindBy(id="ap_email")
		private WebElement emailTxt;
		
		@FindBy(id="continue")
		private WebElement conBtn;
		@FindBy(name="ap_password")
		private WebElement passTxt;
		@FindBy(name="signInSubmit")
		private WebElement signTxt;

		public SearchContext getDriver() {
			return driver;
		}
		public WebElement getEmailTxt() {
			return emailTxt;
		}
		public WebElement getLoginBtn() {
			return conBtn;
		}
		public WebElement getPassTxt() {
			return passTxt;
		}
		public WebElement getSignTxt() {
			return signTxt;
		}
}
