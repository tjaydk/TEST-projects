import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumTests {

	private static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Selenium\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
	}

	@Before
	public void beforeEach() {
		driver.get("http://localhost:3000/reset");
	}

	@Test
	public void testScenario1() {

		driver.get("http://localhost:3000");

		Boolean result = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				WebElement element = driver.findElement(By.id("tbodycars"));
				List<WebElement> elementList = element.findElements(By.tagName("tr"));
				System.out.println("The initial size of the list is: " + elementList.size());
				return elementList.size() == 5;
			}
		});

		assertThat(result, is(true));
	}

	@Test
	public void testScenario2() {

		driver.get("http://localhost:3000");

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				WebElement input = driver.findElement(By.id("filter"));
				input.clear();
				input.sendKeys("2002");

				return true;
			}
		});

		Boolean result = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				WebElement tbody = driver.findElement(By.id("tbodycars"));
				List<WebElement> list = tbody.findElements(By.tagName("tr"));
				System.out.println("The size of the list after typing 2002 is: " + list.size());
				return list.size() == 2;

			}
		});

		assertThat(result, is(true));
	}

	@Test
	public void testScenario3() {
		driver.get("http://localhost:3000");

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				WebElement input = driver.findElement(By.id("filter"));
				input.clear();
				input.sendKeys("2002");
				input.clear();

				return true;
			}
		});


		Boolean result = (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (webDriver) -> {
			WebElement tbody = driver.findElement(By.id("tbodycars"));
			List<WebElement> list = tbody.findElements(By.tagName("tr"));
			System.out.println("The size of the list after typing 2002 is: " + list.size());
			return list.size() == 5;
		});

		assertThat(result, is(true));
	}


	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
}