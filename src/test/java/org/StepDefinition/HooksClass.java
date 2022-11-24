package org.StepDefinition;

import org.BaseClasses.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends BaseClass{
@Before
public void preCondition1(){
	maxWindow();
	System.out.println("Precondition1");
}
@Before
public void  preCondition2() {
	browserLaunch("chrome");
	System.out.println("Precondition2");
}
@Before
public void preCondition3() {
	System.out.println("Precondition3");
}
@After
public void postCondition1() {
	System.out.println("Take Screenshot");
}
@After
public void postCondition2() {
	closeTheBrowser();
}
}
