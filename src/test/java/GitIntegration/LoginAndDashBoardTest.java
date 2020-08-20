package GitIntegration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;


public class LoginAndDashBoardTest {

	WebDriver wdriver;
	String baseUrl = "http://www.techfios.com/ibilling/?ng=admin/";
	String loginEmailAddress = "demo@techfios.com";
	String loginPassword = "abc123";

	@Before
	public void lunchWebSiteOne() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		wdriver = new ChromeDriver();
		wdriver.get(baseUrl);
		wdriver.manage().deleteAllCookies();
		wdriver.manage().window().maximize();
		wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void techFiosLoginOne() throws InterruptedException {
		wdriver.findElement(By.xpath("//input[@id='username']")).sendKeys(loginEmailAddress);
		wdriver.findElement(By.xpath("//input[@id='password']")).sendKeys(loginPassword);
		wdriver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(5000);  
		printDisplayPageTitle();
	}
	
	public void printDisplayPageTitle() {
		String ActualTitle = wdriver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]")).getText();
		String ExpectedTitle = "Dashboard";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println(ActualTitle);
	}
	
	@After
	public void tearDownOne() {
		wdriver.quit();
	}
}
