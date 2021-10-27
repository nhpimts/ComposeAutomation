package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	private WebDriver driver;
	
	// 1. By Locators
	private By signIn = By.xpath("//*[text()='Sign in']");
	private By emailId = By.id("identifierId");
	private By password = By.name("password");
	private By Next = By.xpath("//*[text()='Next']");
	
	//2. Constructor of the page class:
	public Login(WebDriver driver) {
		this.driver = driver;		
	}
	
	//3. Page Actions
	public void clickEmail() {
		driver.findElement(emailId).click();
	}
	public void clickSignIn() {
		driver.findElement(signIn).click();
	}
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);	
	}
	
	public void enterpwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);	
	}
	public void clickNext() {
		driver.findElement(Next).click();	
	}
	
	public String getLoginPageTitle() {
	return	driver.getTitle();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
