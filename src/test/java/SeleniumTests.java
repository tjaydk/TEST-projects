import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumTests {

    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Selenium\\chromedriver.exe");
        System.setProperty("jna.nosys", "true");
        driver = new ChromeDriver();
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
                input.sendKeys("2002");
                input.clear();
                input.sendKeys(" "); // Angular doesn't detect that we clear the input, so we have to send a space.
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

    @Test
    public void testScenario4() {
        driver.get("http://localhost:3000");

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                WebElement sort = driver.findElement(By.id("h_year"));
                sort.click();
                return true;
            }
        });

        Boolean result = (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (webDriver) -> {
            WebElement firstID = driver.findElement(By.xpath("//*[@id=\"tbodycars\"]/tr[1]/td[1]"));
            WebElement secondId = driver.findElement(By.xpath("//*[@id=\"tbodycars\"]/tr[5]/td[1]"));

            return Objects.equals(firstID.getText(), "938")
                    && Objects.equals(secondId.getText(), "940");
        });

        assertThat(result, is(true));

    }

    @Test
    public void testScenario5() {
        driver.get("http://localhost:3000");

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tbodycars\"]/tr[2]/td[8]/a[1]"));
                editButton.click();

                WebElement descriptionInput = driver.findElement(By.id("description"));
                descriptionInput.clear();
                descriptionInput.sendKeys("Cool car");

                WebElement saveButton = driver.findElement(By.id("save"));
                saveButton.click();

                return true;
            }
        });

        Boolean result = (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (webDriver) -> {
            WebElement descriptionField = driver.findElement(By.xpath("//*[@id=\"tbodycars\"]/tr[2]/td[6]"));
            return Objects.equals(descriptionField.getText(), "Cool car");
        });

        assertThat(result, is(true));
    }

    @Test
    public void testScenario6() {
        driver.get("http://localhost:3000");

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                WebElement newButton = driver.findElement(By.id("new"));
                newButton.click();

                WebElement saveButton = driver.findElement(By.id("save"));
                saveButton.click();

                return true;
            }
        });

        Boolean result = (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (webDriver) -> {
            WebElement errorField = driver.findElement(By.id("submiterr"));
            return Objects.equals(errorField.getText(), "All fields are required");
        });

        assertThat(result, is(true));
    }

    @Test
    public void testScenario7() {
        driver.get("http://localhost:3000");

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {

                WebElement newButton = driver.findElement(By.id("new"));
                newButton.click();

                WebElement year = driver.findElement(By.id("year"));
                WebElement registered = driver.findElement(By.id("registered"));
                WebElement make = driver.findElement(By.id("make"));
                WebElement model = driver.findElement(By.id("model"));
                WebElement description = driver.findElement(By.id("description"));
                WebElement price = driver.findElement(By.id("price"));

                year.clear();
                registered.clear();
                make.clear();
                model.clear();
                description.clear();
                price.clear();

                year.sendKeys("2008");
                registered.sendKeys("2002-5-5");
                make.sendKeys("Kia");
                model.sendKeys("Rio");
                description.sendKeys("As new");
                price.sendKeys("31000");

                WebElement saveButton = driver.findElement(By.id("save"));
                saveButton.click();

                return true;
            }
        });

        Boolean result = (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (webDriver) -> {
            WebElement errorField = driver.findElement(By.xpath("//*[@id=\"tbodycars\"]/tr[6]/td[1]"));
            return Objects.equals(errorField.getText(), "942");
        });

        assertThat(result, is(true));
    }



    @AfterClass
    public static void afterClass() {
        driver.get("http://localhost:3000/reset");
        driver.quit();
    }
}