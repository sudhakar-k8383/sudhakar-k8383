package com.omrbranch.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.omrbranch.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BaseClass{

	@Given("user is on the omrbranch page")
	public void user_is_on_the_omrbranch_page() {
	    // Write code here that turns the phrase above into concrete actions
		browserLaunch();
		maximizeWindow();
		enterApplicationUrl("https://www.omrbranch.com/");
		implicitWait();
		
	}
	@When("user enter the {string} and {string}")
	public void user_enter_the_and(String eMail, String password) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement txtUserName = findLocatorById("email");
		sendKeysElement(txtUserName, eMail);
		WebElement txtPassword = findLocatorById("pass");
		sendKeysElement(txtPassword, password);
	}
	@When("user click the login button")
	public void user_click_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement btnLogin = findLocatorByXpath("//button[@value='login']");
		clickElement(btnLogin);
	}
	@Then("user should verify success message after login")
	public void user_should_verify_success_message_after_login() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement welcome = driver.findElement(By.xpath("//a[contains(@class,'icoTwitter mr-2')]"));
		String Text1 = getTextFromText(welcome);
		WebElement Explore = driver.findElement(By.xpath("//h5[contains(text(),'Explore Hotels')]"));
		String Text2 = getTextFromText(Explore);
		System.out.println(Text1);
		System.out.println(Text2);
	}

}
