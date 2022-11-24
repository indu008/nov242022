package org.StepDefinition;

import org.BaseClasses.BaseClass;
import org.PojoClass.PojoClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookTask extends BaseClass {
	PojoClass l;
	@Given("User has to launch the chrome Browser and max the window")
	public void user_has_to_launch_the_chrome_Browser_and_max_the_window() {
	    browserLaunch("chrome");
	}

	@When("User has to launch the fb application in browser")
	public void user_has_to_launch_the_fb_application_in_browser() {
	    launchUrl("https://www.facebook.com/");
	}

	@When("User has to pass invalid username in emailfield")
	public void user_has_to_pass_invalid_username_in_emailfield() throws Exception {
		
	    l=new PojoClass();
	    Thread.sleep(1000);
	    passText(l.getEmailTxt(), "selenium@gmail.com");
	}

	@When("User has to pass invalid password in password field")
	public void user_has_to_pass_invalid_password_in_password_field() throws InterruptedException {
		l=new PojoClass();
		Thread.sleep(2000);
		 clickWebElement(l.getLoginBtn());
		 
	    	}

	@Then("User has to close the browser")
	public void user_has_to_close_the_browser() {
	  // closeTheBrowser();
	}


}
