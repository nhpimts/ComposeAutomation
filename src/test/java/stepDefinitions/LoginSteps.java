package stepDefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;

public class LoginSteps {
	private static String title;
	private Login login = new Login(DriverFactory.getDriver());
	
	@Given("user is on Gmail")
	public void user_is_on_gmail() {
		DriverFactory.getDriver().get("https://gmail.com");

	}

	@When("user clicks  on Sign in")
	public void user_clicks_on_sign_in() {
	   login.clickSignIn();
	}

	@Then("user clicks on email")
	public void user_clicks_on_email() {
	    login.clickEmail();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().getTitle();
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		login.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		login.enterpwd(pwd);
	}

	@When("user clicks on Next button")
	public void user_clicks_on_login_button() {
	    login.clickNext();
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = login.getLoginPageTitle();
		 System.out.println(title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedName) {
		Assert.assertTrue(title.contains(expectedName));
	}
}
