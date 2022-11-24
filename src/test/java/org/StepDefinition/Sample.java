package org.StepDefinition;

import org.BaseClasses.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample extends BaseClass{
public static void main(String[]args) {
	String jc=jdbcConnection();
	System.out.println(jc);
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	WebElement em=driver.findElement(By.id("email"));
	em.sendKeys(jc);
}
}

