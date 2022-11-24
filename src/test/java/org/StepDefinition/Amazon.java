package org.StepDefinition;

import org.BaseClasses.BaseClass;
import org.PojoClass.AmazonPojo;
import org.PojoClass.PojoClass;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Amazon extends BaseClass{
	AmazonPojo l;
	@Given("To launch the browser and maximize the window")
	public void to_launch_the_browser_and_maximize_the_window() {
	    browserLaunch("chrome");
	}

	@Given("To launch the amazon application")
	public void to_launch_the_amazon_application() {
	    launchUrl("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fcss%2Fhomepage.html%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	}

	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field(io.cucumber.datatable.DataTable d) throws InterruptedException {
	    //WebElement emTxt=driver.findElement(By.id("ap_email"));
		l=new AmazonPojo();
	    java.util.List<String> l1=d.asList();
	    Thread.sleep(1000);
	   passText(l.getEmailTxt(),l1.get(2));
	}

	@When("To click the continue button")
	public void to_click_the_continue_button() {
		l=new AmazonPojo();
	   // WebElement conBtn=driver.findElement(By.id("continue"));
	    clickWebElement(l.getLoginBtn());
	}

	@When("To enter the invalid password in password field")
	public void to_enter_the_invalid_password_in_password_field(io.cucumber.datatable.DataTable d) throws InterruptedException {
	    WebElement passTxt=driver.findElement(By.id("ap_password"));
		l=new AmazonPojo();
	    java.util.List<java.util.List<String>> l2=d.asLists();
	    Thread.sleep(1000);
	    passText(passTxt,l2.get(2).get(1));
	}

	@When("To click the signin button")
	public void to_click_the_signin_button() {
		 WebElement signBtn=driver.findElement(By.id("signInSubmit"));
		//l=new AmazonPojo();
		    clickWebElement(signBtn);
	}

	@Then("close the browser")
	public void close_the_browser() {
	   // closeTheBrowser();
	}


}
