package com.calibroz.page.landing.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFieldsPOM {
	private WebDriver driver;

	@FindBy(how = How.CSS, using = "#Email")
	private WebElement email;
	
	@FindBy(how = How.CSS, using = "#phone")
	private WebElement phone;

	@FindBy(how = How.CSS, using = "#fname")
	private WebElement firstName;
	
	@FindBy(how = How.CSS, using = "#password")
	private WebElement password;

	@FindBy(how = How.CSS, using = "#confirmpassword")
	private WebElement confirmPassword;
	@FindBy(how = How.CSS, using = "#header > div > div > div.popup-overlay > div > div > form > input")
	private WebElement signUpBtn;
	
	public RegistrationFieldsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPhone() {
		return phone;
	}

	public void setPhone(WebElement phone) {
		this.phone = phone;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(WebElement firstName) {
		this.firstName = firstName;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(WebElement confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public WebElement getSignUpBtn() {
		return signUpBtn;
	}

	public void setSignUpBtn(WebElement signUpBtn) {
		this.signUpBtn = signUpBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}
	
	

}
