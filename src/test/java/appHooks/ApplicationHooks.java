package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilPacakage.ConfigReader;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader config;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		config = new ConfigReader();
		prop = config.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browsername  = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browsername);
	}
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order = 1)
	public void tearDown(Scenario scenario) {
if 		(scenario.isFailed()) {
	//take screenshot:
	String screenshotName = scenario.getName().replaceAll(" ", "_");
	byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	scenario.attach(sourcePath, "image/png", screenshotName);
}
	}

}
