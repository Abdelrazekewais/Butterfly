package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BFTestBase {
	public static WebDriver driver;
	WebDriverManager manager;

	@BeforeSuite
	@Parameters({ "browser" })
	/*
	 * public void StartDriver(@Optional("chrome") String browsername) { if
	 * (browsername.equalsIgnoreCase("chrome")) {
	 * System.setProperty("webdriver.chorme.driver", System.getProperty("user.dir")
	 * + "/drivers/chrome.exe"); driver = new ChromeDriver(); }
	 * 
	 * else if (browsername.equalsIgnoreCase("edge")) {
	 * System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +
	 * "/drivers/msedgedriver.exe"); driver = new EdgeDriver(); }
	 * 
	 * driver.manage().window().maximize(); }
	 */

	public void StartDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void StopDriver() {
		driver.quit();
	}

}
