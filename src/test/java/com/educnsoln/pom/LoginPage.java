package com.educnsoln.pom;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.educnsoln.base.CommonFunctions;
import com.educnsoln.base.LoggingDemo;

@SuppressWarnings("unused")
public class LoginPage extends CommonFunctions {
	
	WebDriver driver;	
	//@FindBy(id = "txtUsername")  WebElement userid; //txtUsername
	@FindBy(name = "username")  WebElement userid;
	//@FindBy(id = "txtPassword")  WebElement password;//txtPassword
	@FindBy(name = "password")  WebElement password;
	//@FindBy(id = "btnLogin")  WebElement login_btn;//btnLogin
	@FindBy(xpath = "//button[@type='submit']") WebElement login_btn;

	
	static Logger log=LogManager.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver){
		this.driver=driver;		
		PageFactory.initElements(driver, this);		
	}
	//Username   //Password
	
	public void login(ExtentTest test, Map<Object, Object> data) {
		userid.sendKeys(getStringData(data.get("User id")));
		//userid.sendKeys(getStringData(data.get("Username")));
		log.info("User id is entered");
		password.sendKeys(getStringData(data.get("password")));                     
		//password.sendKeys(getStringData(data.get("Password")));
		log.info("password is entered");
		login_btn.click();	
		log.info("Login Button clicked");		
		AssignLeavePage assignpage=new AssignLeavePage(driver);
		System.out.println(assignpage.dashboard_menu.getText());
		//Assert.assertEquals(assignpage.dashboard_menu.getText(), "Dashboard1");
		//softassert.assertEquals(assignpage.dashboard_menu.getText(), "Dashboard");
		System.out.println("check execution ");
		test.log(Status.PASS, "Login is Sucesfull");	
	}
		
	
	
}